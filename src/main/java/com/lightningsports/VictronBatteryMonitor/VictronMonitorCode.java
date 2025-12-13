package com.lightningsports.VictronBatteryMonitor;

/**
 * Created by r_koller on 10/28/2025.
 */
public enum VictronMonitorCode {
    SOLAR_CHARGER(-9),
    WIND_TURBINE(-8),
    SHAFT_GENERATOR(-7),
    ALTERNATOR(-6),
    FUEL_CELL(-5),
    WATER_GENERATOR(-4),
    DC_DC_CHARGER(-3),
    AC_CHARGER(-2),
    GENERIC_SOURCE(-1),
    BATTERY_MONITOR(0),
    GENERIC_LOAD(1),
    ELECTRIC_DRIVE(2),
    FRIDGE(3),
    WATER_PUMP(4),
    BILGE_PUMP(5),
    DC_SYSTEM(6),
    INVERTER(7),
    WATER_HEATER(8);

    private final int code;

    VictronMonitorCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static VictronMonitorCode fromCode(int code) {
        for (VictronMonitorCode status : VictronMonitorCode.values()) {
            if (status.getCode() == code) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid status code: " + code);
    }

    public static VictronMonitorCode fromValue(String value) {
        for (VictronMonitorCode status: VictronMonitorCode.values()) {
            if (status.name().compareTo(value)==0)
                return status;
        }
        throw new IllegalArgumentException("Invalid status value: " + value);
    }
}
