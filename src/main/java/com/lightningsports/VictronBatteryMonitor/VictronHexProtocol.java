package com.lightningsports.VictronBatteryMonitor;

/**
 * Created by r_koller on 10/25/2025.
 */
public class VictronHexProtocol {

    public static String generateRequestString(String command,String commandId,boolean hasData,int data) throws Exception {
        String request=":";
        byte commandMap=-1;
        int commandIdMap=-1;
        int checksum=0x55;
        try {
            VictronRequestCode requestCode=VictronRequestCode.fromValue(command);
            commandMap=(byte) requestCode.getCode();
            request+=hexToCommand(commandMap);
            checksum-=hexToChecksum(commandMap);
            if (requestCode.name().compareTo("REQUEST_GET") == 0 || requestCode.name().compareTo("REQUEST_SET")==0) {
                commandIdMap=VictronCode.fromValue(commandId).getCode();
                request+=hexToCommand(commandIdMap)+"00";
                checksum-=hexToChecksum(commandIdMap);
                if (hasData) request+=hexToCommand(data);
                checksum-=hexToChecksum(data);
            }
            request+=Integer.toHexString(checksum&0x00FF).toUpperCase()+"\n";
            return request;
        } catch (Exception e) {
            throw new Exception("unknown--"+command+"--"+commandId+"--"+hasData+"--"+data);
        }
    }

    public static String generateRequestString(VictronRequestInfo request) throws Exception {
        try {
            return generateRequestString(request.getCommand(),request.getCommandId(),request.isHasData(),request.getData());
        } catch (Exception e) {
            throw e;
        }
    }

    public static VictronKeyValue processResponseString(String response) {
        String key;
        String value;
        int idHi;
        int idLo;
        int flag;
        int data16Hi=0;
        int data16Lo=0;
        int data32Hi=0;
        int data32Lo=0;
        try {
            String process = response.substring(response.indexOf(':')+1);
            String command = process.substring(0, 1);
            int checksum=Integer.parseInt(process.substring(process.length()-2,process.length()),16);
            process=process.substring(0,process.length()-2);
            VictronResponseCode responseCode=VictronResponseCode.fromCode(Integer.parseInt(command,16));
            if (responseCode.name().compareTo("RESPONSE_DONE")==0) {
                key = responseCode.name();
                data16Lo = Integer.parseInt(process.substring(1, 3), 16);
                data16Hi=Integer.parseInt(process.substring(3, 5), 16);
                if (checksum==((0x55-responseCode.getCode()-data16Lo-data16Hi)&0x00FF))
                    value=process.substring(3,5)+process.substring(1, 3);
                else
                    throw new Exception(key+" Checksum");
            } else if (responseCode.name().compareTo("RESPONSE_UNKNOWN")==0) {
                key = responseCode.name();
                if (checksum==((0x55-responseCode.getCode())&0x00FF))
                    value="Unknown";
                else
                    throw new Exception(key+" Checksum");
            } else if (responseCode.name().compareTo("RESPONSE_PING")==0) {
                key = responseCode.name();
                data16Lo = Integer.parseInt(process.substring(1, 3), 16);
                data16Hi=Integer.parseInt(process.substring(3, 5), 16);
                if (checksum==((0x55-responseCode.getCode()-data16Lo-data16Hi)&0x00FF))
                    value=process.substring(3,5)+process.substring(1, 3);
                else
                    throw new Exception(key+" Checksum");
            } else if (responseCode.name().compareTo("RESPONSE_GET")==0 || responseCode.name().compareTo("RESPONSE_SET")==0) {
                idLo = Integer.parseInt(process.substring(1, 3),16);
                idHi=Integer.parseInt(process.substring(3, 5), 16);
                flag=Integer.parseInt(process.substring(5, 7), 16);
                data16Lo = Integer.parseInt(process.substring(7, 9),16);
                data16Hi=Integer.parseInt(process.substring(9, 11), 16);
                if (process.length()==15) {
                    data32Lo = Integer.parseInt(process.substring(11, 13),16);
                    data32Hi=Integer.parseInt(process.substring(13, 15), 16);
                }
                if (checksum==((0x55-responseCode.getCode()-idHi-idLo-flag-data16Lo-data16Hi-data32Lo-data32Hi)&0x00FF)) {
                    key = VictronCode.fromCode(256 * idHi + idLo).name();
                    if (VictronErrorCode.fromCode(flag).name().compareTo("SUCCESS")!=0)
                        key += "--"+VictronErrorCode.fromCode(flag).name();
                    value = Long.toString(data16Lo + 256 * data16Hi+4096*data32Lo+65536*data32Hi);
                } else
                    throw new Exception(responseCode.name()+" Checksum");
            } else {
                throw new Exception("Unknown command");
            }
        } catch (Exception e) {
            key="Error";
            value=e.getMessage();
        }
        return new VictronKeyValue(key,value);
    }

    private static String hexToCommand(int command) {
        String hi=Integer.toHexString((command&0xFF00)/256).toUpperCase();
        if (hi.length()==1) hi="0"+hi;
        String lo=Integer.toHexString((command&0x00FF)).toUpperCase();
        if (lo.length()==1) lo="0"+lo;

        return lo+hi;
    }

    private static String hexToCommand(byte command) {
        return Byte.toString(command).toUpperCase();
    }

    private static int hexToChecksum(int command) {
        int hi=(command&0xFF00)/256;
        int lo=(command&0x00FF);
        return hi+lo;
    }

    private static int hexToChecksum(byte command) {
        return Byte.toUnsignedInt(command);
    }
}
