package com.lightningsports.VictronBatteryMonitor;

/**
 * Created by r_koller on 10/28/2025.
 */
public class VictronRequestInfo {
    private String command;
    private String commandId;
    private boolean hasData;
    int data;

    public VictronRequestInfo() {
    }

    public VictronRequestInfo(String command, String commandId, boolean hasData, int data) {
        this.command = command;
        this.commandId = commandId;
        this.hasData = hasData;
        this.data = data;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getCommandId() {
        return commandId;
    }

    public void setCommandId(String commandId) {
        this.commandId = commandId;
    }

    public boolean isHasData() {
        return hasData;
    }

    public void setHasData(boolean hasData) {
        this.hasData = hasData;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}
