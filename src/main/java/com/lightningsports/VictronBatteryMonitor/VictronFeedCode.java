package com.lightningsports.VictronBatteryMonitor;

/**
 * Created by r_koller on 10/28/2025.
 */
public enum VictronFeedCode {
    ALARM(0xEEFC),
    AR(0x03F1),
    BMV(0x010C),
    CE(0xEEFF),
    CHECKSUM(0x03F4),
    FW(0x0101),
    H1(0x0300),
    H10(0x0309),
    H11(0x030A),
    H12(0x030B),
    H15(0x03F2),
    H16(0x03F3),
    H17(0x0310),
    H18(0x0311),
    H2(0x0301),
    H3(0x0302),
    H4(0x0303),
    H5(0x0304),
    H6(0x0305),
    H7(0x0306),
    H8(0x0307),
    H9(0x0308),
    I(0xED8F),
    MON(0xEEB8),
    P(0xED8E),
    PID(0x0100),
    SOC(0x0FFF),
    TTG(0x0FFE),
    V(0xED8D);

    private final int code;

    VictronFeedCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
    public static VictronFeedCode fromCode(int code) {
        for (VictronFeedCode status : VictronFeedCode.values()) {
            if (status.getCode() == code) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid status code: " + code);
    }

    public static VictronFeedCode fromValue(String value) {
        for (VictronFeedCode status: VictronFeedCode.values()) {
            if (status.name().compareTo(value)==0)
                return status;
        }
        throw new IllegalArgumentException("Invalid status value: " + value);
    }
}
