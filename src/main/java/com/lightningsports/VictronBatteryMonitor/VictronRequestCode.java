package com.lightningsports.VictronBatteryMonitor;

/**
 * Created by r_koller on 10/27/2025.
 */
public enum VictronRequestCode {
    REQUEST_PING(0x01),
    REQUEST_APP_VERSION(0x03),
    REQUEST_PRODUCT_ID(0x04),
    REQUEST_RESTART(0x06),
    REQUEST_GET(0x07),
    REQUEST_SET(0x08),
    REQUEST_ASYNC(0x0A);

    private final int code;

    VictronRequestCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static VictronRequestCode fromCode(int code) {
        for (VictronRequestCode status : VictronRequestCode.values()) {
            if (status.getCode() == code)
                return status;
        }
        throw new IllegalArgumentException("Invalid status code: " + code);
    }

    public static VictronRequestCode fromValue(String value) {
        for (VictronRequestCode status: VictronRequestCode.values()) {
            if (status.name().compareTo(value)==0)
                return status;
        }
        throw new IllegalArgumentException("Invalid status value: " + value);
    }
}
