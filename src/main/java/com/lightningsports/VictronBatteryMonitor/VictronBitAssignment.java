package com.lightningsports.VictronBatteryMonitor;

public enum VictronBitAssignment {
    ID_PRODUCT_ID(0x00000001),
    ID_MAIN_VOLTAGE(0x00000002),
    ID_CURRENT(0x00000004),
    ID_POWER(0x00000008),
    ID_CONSUMED_AH(0x00000010),
    ID_SOC(0x00000020),
    ID_TIME_TO_GO(0x00000040),
    ID_ALARM_BUZZER(0x00000080),
    ID_ALARM_REASON(0x00000100),
    ID_DESCRIPTION(0x00000200),
    ID_MISC_DC_MONITOR_MODE(0x00000400),
    ID_DEPTH_DEEPEST_DISCHARGE(0x00000800),
    ID_DEPTH_LATEST_DISCHARGE(0x00001000),
    ID_DEPTH_AVERAGE_DISCHARGE(0x00002000),
    ID_NUMBER_CYCLES(0x00004000),
    ID_NUMBER_FULL_DISCHARGE(0x00008000),
    ID_CUMULATIVE_AMP_HOURS(0x00010000),
    ID_MINIMUM_VOLTAGE(0x00020000),
    ID_MAXIMUM_VOLTAGE(0x00040000),
    ID_SECONDS_SINCE_FULL_CHARGE(0x00080000),
    ID_NUMBER_AUTOMATIC_SYNCHRONIZATIONS(0x00100000),
    ID_NUMBER_LOW_VOLTAGE_ALARMS(0x00200000),
    ID_NUMBER_HIGH_VOLTAGE_ALARMS(0x00400000),
    ID_CONSUMED_ENERGY(0x00800000),
    ID_PRODUCED_ENERGY(0x01000000);

    private final long code;

    VictronBitAssignment(long code) {this.code=code;}

    public long getCode() { return code;}

    public static VictronBitAssignment fromCode(long code) {
        for (VictronBitAssignment status : VictronBitAssignment.values()) {
            if (status.getCode() == code)
                return status;
        }
        throw new IllegalArgumentException("Invalid status code: " + code);
    }

    public static VictronBitAssignment fromValue(String value) {
        for (VictronBitAssignment status: VictronBitAssignment.values()) {
            if (status.name().compareTo(value)==0)
                return status;
        }
        throw new IllegalArgumentException("Invalid status value: " + value);
    }

    public static boolean bitSetFromValue(String value, long status) {
        for (VictronBitAssignment assignment: VictronBitAssignment.values()) {
            if (assignment.name().compareTo(value)==0)
                return (status&assignment.getCode()) == assignment.getCode();
        }
        return false;
    }
}
