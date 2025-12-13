package com.lightningsports.VictronBatteryMonitor;

/**
 * Created by r_koller on 10/27/2025.
 */
public enum VictronErrorCode {
    SUCCESS(0x00),
    UNKNOWN_ID(0x01),
    NOT_SUPPORTED(0x02),
    PARAMETER_ERROR(0x04);

    private final int code;

    VictronErrorCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static VictronErrorCode fromCode(int code) {
        for (VictronErrorCode status : VictronErrorCode.values()) {
            if (status.getCode() == code)
                return status;
        }
        throw new IllegalArgumentException("Invalid status code: " + code);
    }

    public static VictronErrorCode fromValue(String value) {
        for (VictronErrorCode status: VictronErrorCode.values()) {
            if (status.name().compareTo(value)==0)
                return status;
        }
        throw new IllegalArgumentException("Invalid status value: " + value);
    }
}
