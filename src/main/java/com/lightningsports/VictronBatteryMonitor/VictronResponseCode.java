package com.lightningsports.VictronBatteryMonitor;

/**
 * Created by r_koller on 10/27/2025.
 */
public enum VictronResponseCode {
    RESPONSE_DONE(0x01),
    RESPONSE_UNKNOWN(0x03),
    RESPONSE_PING(0x05),
    RESPONSE_GET(0x07),
    RESPONSE_SET(0x08);

    private final int code;

    VictronResponseCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static VictronResponseCode fromCode(int code) {
        for (VictronResponseCode status : VictronResponseCode.values()) {
            if (status.getCode() == code) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid status code: " + code);
    }

    public static VictronResponseCode fromValue(String value) {
        for (VictronResponseCode status: VictronResponseCode.values()) {
            if (status.name().compareTo(value)==0)
                return status;
        }
        throw new IllegalArgumentException("Invalid status value: " + value);
    }

}
