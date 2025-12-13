package com.lightningsports.VictronBatteryMonitor;

import com.fazecast.jSerialComm.SerialPort;
import com.lightningsports.SettingsReader.AppKey;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

public class VictronBatteryMonitorReadWrite {
    private Logger logger;
    private AppKey victron;
    private boolean hexQueueClear;
    private VictronData victronData=new VictronData();

    public VictronBatteryMonitorReadWrite(AppKey victron) {
        this.logger=Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
        this.logger.setUseParentHandlers(false);
        this.victron = victron;
    }

    private SerialPort findVictronDevice() throws Exception {
        int pid=Integer.parseInt(victron.getAttribute("pid"));
        int vid=Integer.parseInt(victron.getAttribute("vid"));
        String portName=victron.getAttribute("portName");

        try {
            SerialPort[] allPorts=SerialPort.getCommPorts();
            for (SerialPort thePort:allPorts) {
                if (thePort.getVendorID()==vid && thePort.getProductID()==pid || thePort.getDescriptivePortName().equals(portName)) {
                    logger.info("Port found: "+thePort.getPortDescription());
                    thePort.setBaudRate(Integer.parseInt(victron.getAttribute("baudRate")));
                    thePort.setNumDataBits(Integer.parseInt(victron.getAttribute("dataBits")));
                    thePort.setParity(Integer.parseInt(victron.getAttribute("parity")));
                    thePort.setNumStopBits(Integer.parseInt(victron.getAttribute("stopBits")));
                    thePort.setFlowControl(Integer.parseInt(victron.getAttribute("flowControl")));
                    return thePort;
                }
            }
            throw new Exception("No Port Found");
        } catch (Exception e) {
            logger.warning("Error Finding Victron Device: " + e.toString());
            throw e;
        }
    }

    public void readBatteryMonitor() {
        boolean done=false;
        int lastLF;
        hexQueueClear=true;
        try {
            SerialPort victronPort = findVictronDevice();
            victronPort.openPort();
            try {
                if (victronPort.isOpen()) {
                    String request="";
                    logger.info("Port Open");
                    List<VictronRequestInfo> requestList=new ArrayList<VictronRequestInfo>();
                    List<AppKey> victronRequests=victron.getValues();
                    for (AppKey item:victronRequests) {
                        requestList.add(new VictronRequestInfo(item.getAttribute("command"),item.getAttribute("id"),Boolean.parseBoolean(item.getAttribute("hasData")),Integer.parseInt(item.getAttribute("data"))));
                    }
                    Iterator<VictronRequestInfo> requestIterator=requestList.iterator();
                    VictronSerialListener victronListener=new VictronSerialListener(victronPort);
                    victronPort.addDataListener(victronListener);
                    OutputStream output=victronPort.getOutputStream();
                    while (!victronListener.isEndProgram() && !done) {
                        if (hexQueueClear && requestIterator.hasNext()) {
                            try {
                                output.write(VictronHexProtocol.generateRequestString(requestIterator.next()).getBytes());
                                output.flush();
                                hexQueueClear = false;
                            } catch (Exception e) {
                                logger.warning(e.getMessage());
                            }
                        } else if (!requestIterator.hasNext())
                            requestIterator=requestList.iterator();
                        Thread.sleep(100);
                        lastLF=victronListener.getTheMessage().lastIndexOf("\r");
                        lastLF=(lastLF<=0?victronListener.getTheMessage().length():lastLF);
                        if (lastLF>0) {
                            parseVictronData(victronListener.getTheMessage().substring(0, lastLF));
                            victronListener.setTheMessage(lastLF);
                        }
                        if (victronData.getIsAllFieldsSet() && sendDataToUrl(victronData)) {
                            logger.info("Successfully Logged Data");
                            victronData.clearAllStatus();
                            done = true;
                        }
                    }
                } else {
                    throw new Exception("Port not open");
                }
            } finally {
                victronPort.closePort();
                logger.info("Port Closed");
            }
        } catch (Exception e) {
            logger.warning("Error Reading ports: "+e.toString());
        }
    }

    private void parseVictronData(String dataString) throws Exception {
        String dataRow;
        int eol;
        int bol=0;
        VictronKeyValue keyValue=new VictronKeyValue();
        do {
            try {
                eol = dataString.indexOf("\r", bol);
                if (eol < 0) eol = dataString.length();
                dataRow = dataString.substring(bol, eol).replace("\n", "").replace("\r", "");
                if (dataRow.length() > 0) {
                    if (dataRow.indexOf(':') == -1) {
                        keyValue = VictronFeedProtocol.processFeedString(dataRow);
                        victronData.setValue(keyValue);
                    } else {
                        keyValue = VictronHexProtocol.processResponseString(dataRow);
                        victronData.setValue(keyValue,true);
                        hexQueueClear = true;
                    }
                }
                bol = eol + 1;
            } catch (Exception e) {
                logger.warning(e.getMessage());
            }
        } while (bol<dataString.length());
    }

    private boolean sendDataToUrl(VictronData data) throws Exception {
        try {
            BufferedReader in;
            String queryString=data.exportQueryString();
            URL postLink = new URL(victron.getAttribute("postLink")+queryString);
            HttpURLConnection connection=(HttpURLConnection) postLink.openConnection();
            if (connection instanceof HttpsURLConnection) {
                HttpsURLConnection connectionSecure=(HttpsURLConnection)connection;
                connectionSecure.setRequestMethod("GET");
                connectionSecure.setRequestProperty("User-Agent", "Mozilla/5.0");
                connectionSecure.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
                in = new BufferedReader(new InputStreamReader(connectionSecure.getInputStream()));
            } else {
                connection.setRequestMethod("GET");
                connection.setRequestProperty("User-Agent", "Mozilla/5.0");
                connection.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
                in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            }
            String inputLine;
            String response="";
            while ((inputLine = in.readLine()) != null) response+=inputLine;
            in.close();
            connection.disconnect();
            if (response.contains("success")) return true;
            else return false;
        } catch (Exception e) {
            throw e;
        }
    }
}
