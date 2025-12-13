package com.lightningsports.VictronBatteryMonitor;

/**
 * Created by r_koller on 10/24/2025.
 */
public class VictronData {
    private static Long PID_SET=(long) 0x00000001;
    private static Long MAIN_VOLTAGE_SET=(long) 0x00000002;
    private static Long MAIN_CURRENT_SET=(long) 0x00000004;
    private static Long INSTANT_POWER_SET=(long) 0x00000008;
    private static Long CONSUMED_AMP_HOURS_SET=(long) 0x00000010;
    private static Long STATE_OF_CHARGE_SET=(long) 0x00000020;
    private static Long TIME_TO_GO_SET=(long) 0x00000040;
    private static Long ALARM_CONDITION_SET=(long) 0x00000080;
    private static Long ALARM_REASON_SET=(long) 0x00000100;
    private static Long MODEL_DESCRIPTION_SET=(long) 0x00000200;
    private static Long MONITOR_MODE_SET=(long) 0x00000400;
    private static Long DEEPEST_DISCHARGE_DEPTH_SET=(long) 0x00000800;
    private static Long LAST_DISCHARGE_DEPTH_SET=(long) 0x00001000;
    private static Long AVERAGE_DISCHARGE_DEPTH_SET=(long) 0x00002000;
    private static Long NUMBER_CHARGE_CYCLES_SET=(long) 0x00004000;
    private static Long NUMBER_FULL_DISCHARGES_SET=(long) 0x00008000;
    private static Long CUMULATIVE_AMP_HOURS_DRAWN_SET=(long) 0x00010000;
    private static Long MINIMUM_VOLTAGE_SET=(long) 0x00020000;
    private static Long MAXIMUM_VOLTAGE_SET=(long) 0x00040000;
    private static Long SECONDS_SINCE_LAST_FULL_CHARGE_SET=(long) 0x00080000;
    private static Long NUMBER_AUTOMATIC_SYNCHRONIZATIONS_SET=(long) 0x00100000;
    private static Long NUMBER_LOW_VOLTAGE_ALARMS_SET=(long) 0x00200000;
    private static Long NUMBER_HIGH_VOLTAGE_ALARMS_SET=(long) 0x00400000;
    private static Long AMOUNT_DISCHARGED_ENERGY_SET=(long) 0x00800000;
    private static Long AMOUNT_CHARGED_ENERGY_SET=(long) 0x01000000;
    private static Long ALL_FIELDS_SET=(long) 0x01FFFFFF;
    private static Long CURRENT_STATUS_FIELDS_SET=(long) 0x000007FF;
    private static Long HISTORIC_FIELDS_SET=(long) 0x01FFF800;

    private String pid;
    private double mainVoltage;
    private double mainCurrent;
    private double instantaneousPower;
    private double consumedAmpHours;
    private double stateOfCharge;
    private int timeToGo;
    private String alarmCondition;
    private long alarmReason;
    private String modelDescription;
    private String monitorMode;
    private double deepestDischargeDepth;
    private double lastDischargeDepth;
    private double averageDischargedepth;
    private long numberChargeCycles;
    private long numberFullDischarges;
    private double cumulativeAmpHoursDrawn;
    private double minimumVoltage;
    private double maximumVoltage;
    private long secondsSinceLastFullCharge;
    private long numberAutomaticSynchronizations;
    private long numberLowVoltageAlarms;
    private long numberHighVoltageAlarms;
    private double amountDischargedEnergy;
    private double amountChargedEnergy;
    private long status;

    public VictronData() {
        status=0;
    }

    public String getPid() {
        return pid;
    }

    public double getMainVoltage() {
        return mainVoltage;
    }

    public double getMainCurrent() {
        return mainCurrent;
    }

    public double getInstantaneousPower() {
        return instantaneousPower;
    }

    public double getConsumedAmpHours() {
        return consumedAmpHours;
    }

    public double getStateOfCharge() {
        return stateOfCharge;
    }

    public int getTimeToGo() {
        return timeToGo;
    }

    public String isAlarmCondition() {
        return alarmCondition;
    }

    public long getAlarmReason() {
        return alarmReason;
    }

    public boolean isLowVoltageAlarm() {
        return ((alarmReason&1)==1);
    }

    public boolean isHighVoltageAlarm() {
        return ((alarmReason&2)==2);
    }

    public boolean isLowStateOfChargeAlarm() {
        return ((alarmReason&4)==4);
    }

    public boolean isLowStarterVoltageAlarm() {
        return ((alarmReason&8)==8);
    }

    public boolean isHighStarterVoltageAlarm() {
        return ((alarmReason&16)==16);
    }

    public boolean isLowTemperatureAlarm() {
        return ((alarmReason&32)==32);
    }

    public boolean isHighTemperatureAlarm() {
        return ((alarmReason&64)==64);
    }

    public boolean isMidVoltageAlarm() {
        return ((alarmReason&128)==128);
    }

    public String getModelDescription() {
        return modelDescription;
    }

    public String getMonitorMode() {
        return monitorMode;
    }

    public double getDeepestDischargeDepth() {
        return deepestDischargeDepth;
    }

    public double getLastDischargeDepth() {
        return lastDischargeDepth;
    }

    public double getAverageDischargedepth() {
        return averageDischargedepth;
    }

    public long getNumberChargeCycles() {
        return numberChargeCycles;
    }

    public long getNumberFullDischarges() {
        return numberFullDischarges;
    }

    public double getCumulativeAmpHoursDrawn() {
        return cumulativeAmpHoursDrawn;
    }

    public double getMinimumVoltage() {
        return minimumVoltage;
    }

    public double getMaximumVoltage() {
        return maximumVoltage;
    }

    public long getSecondsSinceLastFullCharge() {
        return secondsSinceLastFullCharge;
    }

    public long getNumberAutomaticSynchronizations() {
        return numberAutomaticSynchronizations;
    }

    public long getNumberLowVoltageAlarms() {
        return numberLowVoltageAlarms;
    }

    public long getNumberHighVoltageAlarms() {
        return numberHighVoltageAlarms;
    }

    public double getAmountDischargedEnergy() {
        return amountDischargedEnergy;
    }

    public double getAmountChargedEnergy() {
        return amountChargedEnergy;
    }

    public boolean getIsAllFieldsSet() {
        return ((status&ALL_FIELDS_SET)==ALL_FIELDS_SET);
    }

    public boolean getIsCurrentFieldsSet() {
        return ((status&CURRENT_STATUS_FIELDS_SET)==CURRENT_STATUS_FIELDS_SET);
    }

    public boolean getIsHistoricFieldsSet() {
        return ((status&HISTORIC_FIELDS_SET)==HISTORIC_FIELDS_SET);
    }

    public void setPid(String pid) {
        this.pid = pid;
        status=(status|PID_SET);
    }

    public void setMainVoltage(double mainVoltage) {
        this.mainVoltage = mainVoltage;
        status=(status|MAIN_VOLTAGE_SET);
    }

    public void setMainCurrent(double mainCurrent) {
        this.mainCurrent = mainCurrent;
        status=(status|MAIN_CURRENT_SET);
    }

    public void setInstantaneousPower(double instantaneousPower) {
        this.instantaneousPower = instantaneousPower;
        status=(status|INSTANT_POWER_SET);
    }

    public void setConsumedAmpHours(double consumedAmpHours) {
        this.consumedAmpHours = consumedAmpHours;
        status=(status|CONSUMED_AMP_HOURS_SET);
    }

    public void setStateOfCharge(double stateOfCharge) {
        this.stateOfCharge = stateOfCharge;
        status=(status|STATE_OF_CHARGE_SET);
    }

    public void setTimeToGo(int timeToGo) {
        this.timeToGo = timeToGo;
        status=(status|TIME_TO_GO_SET);
    }

    public void setAlarmCondition(String alarmCondition) {
        this.alarmCondition = alarmCondition;
        status=(status|ALARM_CONDITION_SET);
    }

    public void setAlarmReason(long alarmReason) {
        this.alarmReason = alarmReason;
        status=(status|ALARM_REASON_SET);
    }

    public void setModelDescription(String modelDescription) {
        this.modelDescription = modelDescription;
        status=(status|MODEL_DESCRIPTION_SET);
    }

    public void setMonitorMode(String monitorMode) {
        this.monitorMode = monitorMode;
        status=(status|MONITOR_MODE_SET);
    }

    public void setDeepestDischargeDepth(double deepestDischargeDepth) {
        this.deepestDischargeDepth = deepestDischargeDepth;
        status=(status|DEEPEST_DISCHARGE_DEPTH_SET);
    }

    public void setLastDischargeDepth(double lastDischargeDepth) {
        this.lastDischargeDepth = lastDischargeDepth;
        status=(status|LAST_DISCHARGE_DEPTH_SET);
    }

    public void setAverageDischargedepth(double averageDischargedepth) {
        this.averageDischargedepth = averageDischargedepth;
        status=(status|AVERAGE_DISCHARGE_DEPTH_SET);
    }

    public void setNumberChargeCycles(long numberChargeCycles) {
        this.numberChargeCycles = numberChargeCycles;
        status=(status|NUMBER_CHARGE_CYCLES_SET);
    }

    public void setNumberFullDischarges(long numberFullDischarges) {
        this.numberFullDischarges = numberFullDischarges;
        status=(status|NUMBER_FULL_DISCHARGES_SET);
    }

    public void setCumulativeAmpHoursDrawn(double cumulativeAmpHoursDrawn) {
        this.cumulativeAmpHoursDrawn = cumulativeAmpHoursDrawn;
        status=(status|CUMULATIVE_AMP_HOURS_DRAWN_SET);
    }

    public void setMinimumVoltage(double minimumVoltage) {
        this.minimumVoltage = minimumVoltage;
        status=(status|MINIMUM_VOLTAGE_SET);
    }

    public void setMaximumVoltage(double maximumVoltage) {
        this.maximumVoltage = maximumVoltage;
        status=(status|MAXIMUM_VOLTAGE_SET);
    }

    public void setSecondsSinceLastFullCharge(long secondsSinceLastFullCharge) {
        this.secondsSinceLastFullCharge = secondsSinceLastFullCharge;
        status=(status|SECONDS_SINCE_LAST_FULL_CHARGE_SET);
    }

    public void setNumberAutomaticSynchronizations(long numberAutomaticSynchronizations) {
        this.numberAutomaticSynchronizations = numberAutomaticSynchronizations;
        status=(status|NUMBER_AUTOMATIC_SYNCHRONIZATIONS_SET);
    }

    public void setNumberLowVoltageAlarms(long numberLowVoltageAlarms) {
        this.numberLowVoltageAlarms = numberLowVoltageAlarms;
        status=(status|NUMBER_LOW_VOLTAGE_ALARMS_SET);
    }

    public void setNumberHighVoltageAlarms(long numberHighVoltageAlarms) {
        this.numberHighVoltageAlarms = numberHighVoltageAlarms;
        status=(status|NUMBER_HIGH_VOLTAGE_ALARMS_SET);
    }

    public void setAmountDischargedEnergy(double amountDischargedEnergy) {
        this.amountDischargedEnergy = amountDischargedEnergy;
        status=(status|AMOUNT_DISCHARGED_ENERGY_SET);
    }

    public void setAmountChargedEnergy(double amountChargedEnergy) {
        this.amountChargedEnergy = amountChargedEnergy;
        status=(status|AMOUNT_CHARGED_ENERGY_SET);
    }

    public void clearAllStatus() {
        status=0;
    }

    public void clearCurrentStatus() {
        status=(status&HISTORIC_FIELDS_SET);
    }

    public void clearHistoricStatus() {
        status=(status&CURRENT_STATUS_FIELDS_SET);
    }

    public boolean setValue(VictronKeyValue keyValue) {
        return setValue(keyValue,false);
    }

    public boolean setValue(VictronKeyValue keyValue,boolean fromHex) {
        try {
            if (keyValue.getKey().compareTo(VictronCode.fromCode(0x0100).name()) == 0) {
                setPid(keyValue.getValue());
            } else if (keyValue.getKey().compareTo(VictronCode.fromCode(0xED8D).name()) == 0) {
                setMainVoltage((fromHex ? ((short) Integer.parseInt(keyValue.getValue())) / 100.0 : Integer.parseInt(keyValue.getValue()) / 1000.0));
            } else if (keyValue.getKey().compareTo(VictronCode.fromCode(0xED8F).name()) == 0) {
                setMainCurrent((fromHex ? ((short) Integer.parseInt(keyValue.getValue())) / 100.0 : Integer.parseInt(keyValue.getValue()) / 1000.0));
            } else if (keyValue.getKey().compareTo(VictronCode.fromCode(0xED8E).name()) == 0) {
                setInstantaneousPower((fromHex ? ((short) Integer.parseInt(keyValue.getValue())) : Integer.parseInt(keyValue.getValue())));
            } else if (keyValue.getKey().compareTo(VictronCode.fromCode(0xEEFF).name()) == 0) {
                setConsumedAmpHours((fromHex ? ((int) Long.parseLong(keyValue.getValue())) / 10.0 : Long.parseLong(keyValue.getValue()) / 1000.0));
            } else if (keyValue.getKey().compareTo(VictronCode.fromCode(0x0FFF).name()) == 0) {
                setStateOfCharge((fromHex ? ((short) Integer.parseInt(keyValue.getValue())) / 100.0 : Integer.parseInt(keyValue.getValue()) / 10.0));
            } else if (keyValue.getKey().compareTo(VictronCode.fromCode(0x0FFE).name()) == 0) {
                setTimeToGo(Integer.parseInt(keyValue.getValue()));
            } else if (keyValue.getKey().compareTo(VictronCode.fromCode(0xEEFC).name()) == 0) {
                setAlarmCondition((fromHex ? (keyValue.getValue().compareTo("0") == 0 ? "OFF" : "ON") : keyValue.getValue()));
            } else if (keyValue.getKey().compareTo(VictronCode.fromCode(0x03F1).name()) == 0) {
                setAlarmReason(Long.parseLong(keyValue.getValue()));
            } else if (keyValue.getKey().compareTo(VictronCode.fromCode(0x010C).name()) == 0) {
                setModelDescription(keyValue.getValue());
            } else if (keyValue.getKey().compareTo(VictronCode.fromCode(0xEEB8).name()) == 0) {
                setMonitorMode(VictronMonitorCode.fromCode(fromHex ? ((short) Integer.parseInt(keyValue.getValue())) : Integer.parseInt(keyValue.getValue())).name());
            } else if (keyValue.getKey().compareTo(VictronCode.fromCode(0x0300).name()) == 0) {
                setDeepestDischargeDepth((fromHex ? ((int) Long.parseLong(keyValue.getValue())) / 10.0 : Long.parseLong(keyValue.getValue()) / 1000.0));
            } else if (keyValue.getKey().compareTo(VictronCode.fromCode(0x0301).name()) == 0) {
                setLastDischargeDepth((fromHex ? ((int) Long.parseLong(keyValue.getValue())) / 10.0 : Long.parseLong(keyValue.getValue()) / 1000.0));
            } else if (keyValue.getKey().compareTo(VictronCode.fromCode(0x0302).name()) == 0) {
                setAverageDischargedepth((fromHex ? ((int) Long.parseLong(keyValue.getValue())) / 10.0 : Long.parseLong(keyValue.getValue()) / 1000.0));
            } else if (keyValue.getKey().compareTo(VictronCode.fromCode(0x0303).name()) == 0) {
                setNumberChargeCycles(Long.parseLong(keyValue.getValue()));
            } else if (keyValue.getKey().compareTo(VictronCode.fromCode(0x0304).name()) == 0) {
                setNumberFullDischarges(Long.parseLong(keyValue.getValue()));
            } else if (keyValue.getKey().compareTo(VictronCode.fromCode(0x0305).name()) == 0) {
                setCumulativeAmpHoursDrawn((fromHex ? ((int) Long.parseLong(keyValue.getValue())) / 10.0 : Long.parseLong(keyValue.getValue()) / 1000.0));
            } else if (keyValue.getKey().compareTo(VictronCode.fromCode(0x0307).name()) == 0) {
                setMaximumVoltage((fromHex ? ((int) Long.parseLong(keyValue.getValue())) / 100.0 : Long.parseLong(keyValue.getValue()) / 1000.0));
            } else if (keyValue.getKey().compareTo(VictronCode.fromCode(0x0306).name()) == 0) {
                setMinimumVoltage((fromHex ? ((int) Long.parseLong(keyValue.getValue())) / 100.0 : Long.parseLong(keyValue.getValue()) / 1000.0));
            } else if (keyValue.getKey().compareTo(VictronCode.fromCode(0x0308).name()) == 0) {
                setSecondsSinceLastFullCharge(Long.parseLong(keyValue.getValue()));
            } else if (keyValue.getKey().compareTo(VictronCode.fromCode(0x0309).name()) == 0) {
                setNumberAutomaticSynchronizations(Long.parseLong(keyValue.getValue()));
            } else if (keyValue.getKey().compareTo(VictronCode.fromCode(0x030A).name()) == 0) {
                setNumberLowVoltageAlarms(Long.parseLong(keyValue.getValue()));
            } else if (keyValue.getKey().compareTo(VictronCode.fromCode(0x030B).name()) == 0) {
                setNumberHighVoltageAlarms(Long.parseLong(keyValue.getValue()));
            } else if (keyValue.getKey().compareTo(VictronCode.fromCode(0x0311).name()) == 0) {
                setAmountDischargedEnergy((Long.parseLong(keyValue.getValue())) / 100.0);
            } else if (keyValue.getKey().compareTo(VictronCode.fromCode(0x0310).name()) == 0) {
                setAmountChargedEnergy((Long.parseLong(keyValue.getValue())) / 100.0);
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String exportValues() {
        try {
            String jsonString = "{\r"
                    + (((status&PID_SET)==PID_SET)?"\t\""+VictronCodeReadable.fromValue(VictronCode.fromCode(0x0100).name())+"\":" + pid + "\r":"")
                    + (((status&MAIN_VOLTAGE_SET)==MAIN_VOLTAGE_SET)?"\t\""+VictronCodeReadable.fromValue(VictronCode.fromCode(0xED8D).name())+"\":" + mainVoltage + "\r":"")
                    + (((status&MAIN_CURRENT_SET)==MAIN_CURRENT_SET)?"\t\""+VictronCodeReadable.fromValue(VictronCode.fromCode(0xED8F).name())+"\":" + mainCurrent + "\r":"")
                    + (((status&INSTANT_POWER_SET)==INSTANT_POWER_SET)?"\t\""+VictronCodeReadable.fromValue(VictronCode.fromCode(0xED8E).name())+"\":" + instantaneousPower + "\r":"")
                    + (((status&CONSUMED_AMP_HOURS_SET)==CONSUMED_AMP_HOURS_SET)?"\t\""+VictronCodeReadable.fromValue(VictronCode.fromCode(0xEEFF).name())+"\":" + consumedAmpHours + "\r":"")
                    + (((status&STATE_OF_CHARGE_SET)==STATE_OF_CHARGE_SET)?"\t\""+VictronCodeReadable.fromValue(VictronCode.fromCode(0x0FFF).name())+"\":" + stateOfCharge + "\r":"")
                    + (((status&TIME_TO_GO_SET)==TIME_TO_GO_SET)?"\t\""+VictronCodeReadable.fromValue(VictronCode.fromCode(0x0FFE).name())+"\":" + timeToGo + "\r":"")
                    + (((status&ALARM_CONDITION_SET)==ALARM_CONDITION_SET)?"\t\""+VictronCodeReadable.fromValue(VictronCode.fromCode(0xEEFC).name())+"\":\"" + alarmCondition + "\"\r":"")
                    + (((status&ALARM_REASON_SET)==ALARM_REASON_SET)?"\t\""+VictronCodeReadable.fromValue(VictronCode.fromCode(0x03F1).name())+"\":" + alarmReason + "\r":"")
                    + (((status&MODEL_DESCRIPTION_SET)==MODEL_DESCRIPTION_SET)?"\t\""+VictronCodeReadable.fromValue(VictronCode.fromCode(0x010C).name())+"\":\"" + modelDescription + "\"\r":"")
                    + (((status&MONITOR_MODE_SET)==MONITOR_MODE_SET)?"\t\""+VictronCodeReadable.fromValue(VictronCode.fromCode(0xEEB8).name())+"\":\"" + monitorMode + "\"\r":"")
                    + (((status&DEEPEST_DISCHARGE_DEPTH_SET)==DEEPEST_DISCHARGE_DEPTH_SET)?"\t\""+VictronCodeReadable.fromValue(VictronCode.fromCode(0x0300).name())+"\":" + deepestDischargeDepth + "\r":"")
                    + (((status&LAST_DISCHARGE_DEPTH_SET)==LAST_DISCHARGE_DEPTH_SET)?"\t\""+VictronCodeReadable.fromValue(VictronCode.fromCode(0x0301).name())+"\":" + lastDischargeDepth + "\r":"")
                    + (((status&AVERAGE_DISCHARGE_DEPTH_SET)==AVERAGE_DISCHARGE_DEPTH_SET)?"\t\""+VictronCodeReadable.fromValue(VictronCode.fromCode(0x0302).name())+"\":" + averageDischargedepth + "\r":"")
                    + (((status&NUMBER_CHARGE_CYCLES_SET)==NUMBER_CHARGE_CYCLES_SET)?"\t\""+VictronCodeReadable.fromValue(VictronCode.fromCode(0x0303).name())+"\":" + numberChargeCycles + "\r":"")
                    + (((status&NUMBER_FULL_DISCHARGES_SET)==NUMBER_FULL_DISCHARGES_SET)?"\t\""+VictronCodeReadable.fromValue(VictronCode.fromCode(0x0304).name())+"\":" + numberFullDischarges + "\r":"")
                    + (((status&CUMULATIVE_AMP_HOURS_DRAWN_SET)==CUMULATIVE_AMP_HOURS_DRAWN_SET)?"\t\""+VictronCodeReadable.fromValue(VictronCode.fromCode(0x0305).name())+"\":" + cumulativeAmpHoursDrawn + "\r":"")
                    + (((status&MAXIMUM_VOLTAGE_SET)==MAXIMUM_VOLTAGE_SET)?"\t\""+VictronCodeReadable.fromValue(VictronCode.fromCode(0x0307).name())+"\":" + maximumVoltage + "\r":"")
                    + (((status&MINIMUM_VOLTAGE_SET)==MINIMUM_VOLTAGE_SET)?"\t\""+VictronCodeReadable.fromValue(VictronCode.fromCode(0x0306).name())+"\":" + minimumVoltage + "\r":"")
                    + (((status&SECONDS_SINCE_LAST_FULL_CHARGE_SET)==SECONDS_SINCE_LAST_FULL_CHARGE_SET)?"\t\""+VictronCodeReadable.fromValue(VictronCode.fromCode(0x0308).name())+"\":" + secondsSinceLastFullCharge + "\r":"")
                    + (((status&NUMBER_AUTOMATIC_SYNCHRONIZATIONS_SET)==NUMBER_AUTOMATIC_SYNCHRONIZATIONS_SET)?"\t\""+VictronCodeReadable.fromValue(VictronCode.fromCode(0x0309).name())+"\":" + numberAutomaticSynchronizations + "\r":"")
                    + (((status&NUMBER_LOW_VOLTAGE_ALARMS_SET)==NUMBER_LOW_VOLTAGE_ALARMS_SET)?"\t\""+VictronCodeReadable.fromValue(VictronCode.fromCode(0x030A).name())+"\":" + numberLowVoltageAlarms + "\r":"")
                    + (((status&NUMBER_HIGH_VOLTAGE_ALARMS_SET)==NUMBER_HIGH_VOLTAGE_ALARMS_SET)?"\t\""+VictronCodeReadable.fromValue(VictronCode.fromCode(0x030B).name())+"\":" + numberHighVoltageAlarms + "\r":"")
                    + (((status&AMOUNT_DISCHARGED_ENERGY_SET)==AMOUNT_DISCHARGED_ENERGY_SET)?"\t\""+VictronCodeReadable.fromValue(VictronCode.fromCode(0x0311).name())+"\":" + amountDischargedEnergy + "\r":"")
                    + (((status&AMOUNT_CHARGED_ENERGY_SET)==AMOUNT_CHARGED_ENERGY_SET)?"\t\""+VictronCodeReadable.fromValue(VictronCode.fromCode(0x0310).name())+"\":" + amountChargedEnergy + "\r":"")
                    + "}\r";
            return jsonString;
        } catch (Exception e) {
            return "\"Error\":\""+e.getMessage()+"\"\r}\r";
        }
    }
    public String exportQueryString() {
        try {
            String queryString = "?"
                    + (((status&PID_SET)==PID_SET)?VictronCode.fromCode(0x0100).name()+"=" + getPid():"")
                    + (((status&MAIN_VOLTAGE_SET)==MAIN_VOLTAGE_SET)?"&"+VictronCode.fromCode(0xED8D).name()+"=" + getMainVoltage():"")
                    + (((status&MAIN_CURRENT_SET)==MAIN_CURRENT_SET)?"&"+VictronCode.fromCode(0xED8F).name()+"=" + getMainCurrent():"")
                    + (((status&INSTANT_POWER_SET)==INSTANT_POWER_SET)?"&"+VictronCode.fromCode(0xED8E).name()+"=" + getInstantaneousPower():"")
                    + (((status&CONSUMED_AMP_HOURS_SET)==CONSUMED_AMP_HOURS_SET)?"&"+VictronCode.fromCode(0xEEFF).name()+"=" + getConsumedAmpHours():"")
                    + (((status&STATE_OF_CHARGE_SET)==STATE_OF_CHARGE_SET)?"&"+VictronCode.fromCode(0x0FFF).name()+"=" + getStateOfCharge():"")
                    + (((status&TIME_TO_GO_SET)==TIME_TO_GO_SET)?"&"+VictronCode.fromCode(0x0FFE).name()+"=" + getTimeToGo():"")
                    + (((status&ALARM_CONDITION_SET)==ALARM_CONDITION_SET)?"&"+VictronCode.fromCode(0xEEFC).name()+"=" + alarmCondition:"")
                    + (((status&ALARM_REASON_SET)==ALARM_REASON_SET)?"&"+VictronCode.fromCode(0x03F1).name()+"=" + getAlarmReason():"")
                    + (((status&MODEL_DESCRIPTION_SET)==MODEL_DESCRIPTION_SET)?"&"+VictronCode.fromCode(0x010C).name()+"=" + getModelDescription().replace("/","--").replace(" ",""):"")
                    + (((status&MONITOR_MODE_SET)==MONITOR_MODE_SET)?"&"+VictronCode.fromCode(0xEEB8).name()+"=" + getMonitorMode():"")
                    + (((status&DEEPEST_DISCHARGE_DEPTH_SET)==DEEPEST_DISCHARGE_DEPTH_SET)?"&"+VictronCode.fromCode(0x0300).name()+"=" + getDeepestDischargeDepth():"")
                    + (((status&LAST_DISCHARGE_DEPTH_SET)==LAST_DISCHARGE_DEPTH_SET)?"&"+VictronCode.fromCode(0x0301).name()+"=" + getLastDischargeDepth():"")
                    + (((status&AVERAGE_DISCHARGE_DEPTH_SET)==AVERAGE_DISCHARGE_DEPTH_SET)?"&"+VictronCode.fromCode(0x0302).name()+"=" + getAverageDischargedepth():"")
                    + (((status&NUMBER_CHARGE_CYCLES_SET)==NUMBER_CHARGE_CYCLES_SET)?"&"+VictronCode.fromCode(0x0303).name()+"=" + getNumberChargeCycles():"")
                    + (((status&NUMBER_FULL_DISCHARGES_SET)==NUMBER_FULL_DISCHARGES_SET)?"&"+VictronCode.fromCode(0x0304).name()+"=" + getNumberFullDischarges():"")
                    + (((status&CUMULATIVE_AMP_HOURS_DRAWN_SET)==CUMULATIVE_AMP_HOURS_DRAWN_SET)?"&"+VictronCode.fromCode(0x0305).name()+"=" + getCumulativeAmpHoursDrawn():"")
                    + (((status&MAXIMUM_VOLTAGE_SET)==MAXIMUM_VOLTAGE_SET)?"&"+VictronCode.fromCode(0x0307).name()+"=" + getMaximumVoltage():"")
                    + (((status&MINIMUM_VOLTAGE_SET)==MINIMUM_VOLTAGE_SET)?"&"+VictronCode.fromCode(0x0306).name()+"=" + getMinimumVoltage():"")
                    + (((status&SECONDS_SINCE_LAST_FULL_CHARGE_SET)==SECONDS_SINCE_LAST_FULL_CHARGE_SET)?"&"+VictronCode.fromCode(0x0308).name()+"=" + getSecondsSinceLastFullCharge():"")
                    + (((status&NUMBER_AUTOMATIC_SYNCHRONIZATIONS_SET)==NUMBER_AUTOMATIC_SYNCHRONIZATIONS_SET)?"&"+VictronCode.fromCode(0x0309).name()+"=" + getNumberAutomaticSynchronizations():"")
                    + (((status&NUMBER_LOW_VOLTAGE_ALARMS_SET)==NUMBER_LOW_VOLTAGE_ALARMS_SET)?"&"+VictronCode.fromCode(0x030A).name()+"=" + getNumberLowVoltageAlarms():"")
                    + (((status&NUMBER_HIGH_VOLTAGE_ALARMS_SET)==NUMBER_HIGH_VOLTAGE_ALARMS_SET)?"&"+VictronCode.fromCode(0x030B).name()+"=" + getNumberHighVoltageAlarms():"")
                    + (((status&AMOUNT_DISCHARGED_ENERGY_SET)==AMOUNT_DISCHARGED_ENERGY_SET)?"&"+VictronCode.fromCode(0x0311).name()+"=" + getAmountDischargedEnergy():"")
                    + (((status&AMOUNT_CHARGED_ENERGY_SET)==AMOUNT_CHARGED_ENERGY_SET)?"&"+VictronCode.fromCode(0x0310).name()+"=" + getAmountChargedEnergy():"");
            return queryString;
        } catch (Exception e) {
            return "\"Error\":\""+e.getMessage()+"\"\r}\r";
        }
    }
}
