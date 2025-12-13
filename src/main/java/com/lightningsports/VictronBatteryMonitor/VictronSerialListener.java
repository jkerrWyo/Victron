package com.lightningsports.VictronBatteryMonitor;

import com.fazecast.jSerialComm.SerialPort;
import com.fazecast.jSerialComm.SerialPortDataListener;
import com.fazecast.jSerialComm.SerialPortEvent;

/**
 * Created by r_koller on 10/24/2025.
 */
public class VictronSerialListener  implements SerialPortDataListener {
    private SerialPort serialPort;
    private boolean endProgram=false;
    private String theMessage="";
    private boolean writeSucceeded=false;
    private boolean readDataError=false;
    private String readDataErrorMessage="";

    public VictronSerialListener(SerialPort serialPort) {
        this.serialPort=serialPort;
    }

    public boolean isEndProgram() {
        return endProgram;
    }

    public String getTheMessage() {
        return theMessage;
    }

    public void setTheMessage(String theMessage) {
        this.theMessage = theMessage;
    }

    public void setTheMessage(int length) {
        theMessage=theMessage.substring(length);
    }

    public boolean isWriteSucceeded() {
        return writeSucceeded;
    }

    public boolean isReadDataError() {
        return readDataError;
    }

    public String getReadDataErrorMessage() {
        return readDataErrorMessage;
    }

    @Override
    public int getListeningEvents() {
        return SerialPort.LISTENING_EVENT_DATA_AVAILABLE | SerialPort.LISTENING_EVENT_DATA_RECEIVED | SerialPort.LISTENING_EVENT_DATA_WRITTEN; // Listen for data available events
    }

    @Override
    public void serialEvent(SerialPortEvent event) {
        if (event.getEventType() == SerialPort.LISTENING_EVENT_DATA_AVAILABLE) {
            try {
                byte[] inData = new byte[serialPort.bytesAvailable()];
                int numRead = serialPort.readBytes(inData, inData.length);
                for (int i = 0; i < inData.length; i++)
                    if (inData[i] == (byte) 0x03)
                        endProgram = true;
                    else
                        theMessage += String.valueOf((char) inData[i]);
                readDataError=false;
                readDataErrorMessage="";
            } catch (Exception e) {
                readDataErrorMessage="Error Processing Available: "+e.getMessage();
                readDataError=true;
            }
        } else if (event.getEventType() == SerialPort.LISTENING_EVENT_DATA_RECEIVED) {
            try {
                byte[] inData = event.getReceivedData();
                for (int i=0;i<inData.length;i++)
                    if (inData[i]==(byte) 0x03)
                        endProgram=true;
                    else
                        theMessage += String.valueOf((char) inData[i]);
                readDataError=false;
                readDataErrorMessage="";
            } catch (Exception e) {
                readDataErrorMessage="Error Processing Available: "+e.getMessage();
                readDataError=true;
            }
        } else if (event.getEventType() == SerialPort.LISTENING_EVENT_DATA_WRITTEN) {
            writeSucceeded=true;
        }
    }
}
