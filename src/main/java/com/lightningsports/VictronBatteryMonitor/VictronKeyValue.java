package com.lightningsports.VictronBatteryMonitor;

/**
 * Created by r_koller on 10/27/2025.
 */
public class VictronKeyValue {
    private String key;
    private String value;

    public VictronKeyValue() {
    }

    public VictronKeyValue(String key, String value) {
        this.value = value;
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
