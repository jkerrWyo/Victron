package com.lightningsports.VictronBatteryMonitor;

/**
 * Created by r_koller on 10/24/2025.
 */
public class VictronData {
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
    private long readComplete=0;

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
        return (((readComplete!=0)&&(status&readComplete)==readComplete)||((status&ALL_FIELDS_SET)==ALL_FIELDS_SET));
    }

    public boolean getIsCurrentFieldsSet() {
        return ((status&CURRENT_STATUS_FIELDS_SET)==CURRENT_STATUS_FIELDS_SET);
    }

    public boolean getIsHistoricFieldsSet() {
        return ((status&HISTORIC_FIELDS_SET)==HISTORIC_FIELDS_SET);
    }

    public long getReadComplete() {
        return readComplete;
    }

    public void setPid(String pid) {
        this.pid = pid;
        status=(status|VictronBitAssignment.fromValue("ID_PRODUCT_ID").getCode());
    }

    public void setMainVoltage(double mainVoltage) {
        this.mainVoltage = mainVoltage;
        status=(status|VictronBitAssignment.fromValue("ID_MAIN_VOLTAGE").getCode());
    }

    public void setMainCurrent(double mainCurrent) {
        this.mainCurrent = mainCurrent;
        status=(status|VictronBitAssignment.fromValue("ID_CURRENT").getCode());
    }

    public void setInstantaneousPower(double instantaneousPower) {
        this.instantaneousPower = instantaneousPower;
        status=(status|VictronBitAssignment.fromValue("ID_POWER").getCode());
    }

    public void setConsumedAmpHours(double consumedAmpHours) {
        this.consumedAmpHours = consumedAmpHours;
        status=(status|VictronBitAssignment.fromValue("ID_CONSUMED_AH").getCode());
    }

    public void setStateOfCharge(double stateOfCharge) {
        this.stateOfCharge = stateOfCharge;
        status=(status|VictronBitAssignment.fromValue("ID_SOC").getCode());
    }

    public void setTimeToGo(int timeToGo) {
        this.timeToGo = timeToGo;
        status=(status|VictronBitAssignment.fromValue("ID_TIME_TO_GO").getCode());
    }

    public void setAlarmCondition(String alarmCondition) {
        this.alarmCondition = alarmCondition;
        status=(status|VictronBitAssignment.fromValue("ID_ALARM_BUZZER").getCode());
    }

    public void setAlarmReason(long alarmReason) {
        this.alarmReason = alarmReason;
        status=(status|VictronBitAssignment.fromValue("ID_ALARM_REASON").getCode());
    }

    public void setModelDescription(String modelDescription) {
        this.modelDescription = modelDescription;
        status=(status|VictronBitAssignment.fromValue("ID_DESCRIPTION").getCode());
    }

    public void setMonitorMode(String monitorMode) {
        this.monitorMode = monitorMode;
        status=(status|VictronBitAssignment.fromValue("ID_MISC_DC_MONITOR_MODE").getCode());
    }

    public void setDeepestDischargeDepth(double deepestDischargeDepth) {
        this.deepestDischargeDepth = deepestDischargeDepth;
        status=(status|VictronBitAssignment.fromValue("ID_DEPTH_DEEPEST_DISCHARGE").getCode());
    }

    public void setLastDischargeDepth(double lastDischargeDepth) {
        this.lastDischargeDepth = lastDischargeDepth;
        status=(status|VictronBitAssignment.fromValue("ID_DEPTH_LATEST_DISCHARGE").getCode());
    }

    public void setAverageDischargedepth(double averageDischargedepth) {
        this.averageDischargedepth = averageDischargedepth;
        status=(status|VictronBitAssignment.fromValue("ID_DEPTH_AVERAGE_DISCHARGE").getCode());
    }

    public void setNumberChargeCycles(long numberChargeCycles) {
        this.numberChargeCycles = numberChargeCycles;
        status=(status|VictronBitAssignment.fromValue("ID_NUMBER_CYCLES").getCode());
    }

    public void setNumberFullDischarges(long numberFullDischarges) {
        this.numberFullDischarges = numberFullDischarges;
        status=(status|VictronBitAssignment.fromValue("ID_NUMBER_FULL_DISCHARGE").getCode());
    }

    public void setCumulativeAmpHoursDrawn(double cumulativeAmpHoursDrawn) {
        this.cumulativeAmpHoursDrawn = cumulativeAmpHoursDrawn;
        status=(status|VictronBitAssignment.fromValue("ID_CUMULATIVE_AMP_HOURS").getCode());
    }

    public void setMinimumVoltage(double minimumVoltage) {
        this.minimumVoltage = minimumVoltage;
        status=(status|VictronBitAssignment.fromValue("ID_MINIMUM_VOLTAGE").getCode());
    }

    public void setMaximumVoltage(double maximumVoltage) {
        this.maximumVoltage = maximumVoltage;
        status=(status|VictronBitAssignment.fromValue("ID_MAXIMUM_VOLTAGE").getCode());
    }

    public void setSecondsSinceLastFullCharge(long secondsSinceLastFullCharge) {
        this.secondsSinceLastFullCharge = secondsSinceLastFullCharge;
        status=(status|VictronBitAssignment.fromValue("ID_SECONDS_SINCE_FULL_CHARGE").getCode());
    }

    public void setNumberAutomaticSynchronizations(long numberAutomaticSynchronizations) {
        this.numberAutomaticSynchronizations = numberAutomaticSynchronizations;
        status=(status|VictronBitAssignment.fromValue("ID_NUMBER_AUTOMATIC_SYNCHRONIZATIONS").getCode());
    }

    public void setNumberLowVoltageAlarms(long numberLowVoltageAlarms) {
        this.numberLowVoltageAlarms = numberLowVoltageAlarms;
        status=(status|VictronBitAssignment.fromValue("ID_NUMBER_LOW_VOLTAGE_ALARMS").getCode());
    }

    public void setNumberHighVoltageAlarms(long numberHighVoltageAlarms) {
        this.numberHighVoltageAlarms = numberHighVoltageAlarms;
        status=(status|VictronBitAssignment.fromValue("ID_NUMBER_HIGH_VOLTAGE_ALARMS").getCode());
    }

    public void setAmountDischargedEnergy(double amountDischargedEnergy) {
        this.amountDischargedEnergy = amountDischargedEnergy;
        status=(status|VictronBitAssignment.fromValue("ID_CONSUMED_ENERGY").getCode());
    }

    public void setAmountChargedEnergy(double amountChargedEnergy) {
        this.amountChargedEnergy = amountChargedEnergy;
        status=(status|VictronBitAssignment.fromValue("ID_PRODUCED_ENERGY").getCode());
    }

    public void setReadComplete(long readComplete) {
        this.readComplete = readComplete;
    }

    public void setReadComplete(String field) {
        readComplete=(readComplete|VictronBitAssignment.fromValue(field).getCode());
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
                    + (VictronBitAssignment.bitSetFromValue("ID_PRODUCT_ID",status)?"\t\""+VictronCodeReadable.fromValue(VictronCode.fromCode(0x0100).name())+"\":" + pid + "\r":"")
                    + (VictronBitAssignment.bitSetFromValue("ID_MAIN_VOLTAGE",status)?"\t\""+VictronCodeReadable.fromValue(VictronCode.fromCode(0xED8D).name())+"\":" + mainVoltage + "\r":"")
                    + (VictronBitAssignment.bitSetFromValue("ID_CURRENT",status)?"\t\""+VictronCodeReadable.fromValue(VictronCode.fromCode(0xED8F).name())+"\":" + mainCurrent + "\r":"")
                    + (VictronBitAssignment.bitSetFromValue("ID_POWER",status)?"\t\""+VictronCodeReadable.fromValue(VictronCode.fromCode(0xED8E).name())+"\":" + instantaneousPower + "\r":"")
                    + (VictronBitAssignment.bitSetFromValue("ID_CONSUMED_AH",status)?"\t\""+VictronCodeReadable.fromValue(VictronCode.fromCode(0xEEFF).name())+"\":" + consumedAmpHours + "\r":"")
                    + (VictronBitAssignment.bitSetFromValue("ID_SOC",status)?"\t\""+VictronCodeReadable.fromValue(VictronCode.fromCode(0x0FFF).name())+"\":" + stateOfCharge + "\r":"")
                    + (VictronBitAssignment.bitSetFromValue("ID_TIME_TO_GO",status)?"\t\""+VictronCodeReadable.fromValue(VictronCode.fromCode(0x0FFE).name())+"\":" + timeToGo + "\r":"")
                    + (VictronBitAssignment.bitSetFromValue("ID_ALARM_BUZZER",status)?"\t\""+VictronCodeReadable.fromValue(VictronCode.fromCode(0xEEFC).name())+"\":\"" + alarmCondition + "\"\r":"")
                    + (VictronBitAssignment.bitSetFromValue("ID_ALARM_REASON",status)?"\t\""+VictronCodeReadable.fromValue(VictronCode.fromCode(0x03F1).name())+"\":" + alarmReason + "\r":"")
                    + (VictronBitAssignment.bitSetFromValue("ID_DESCRIPTION",status)?"\t\""+VictronCodeReadable.fromValue(VictronCode.fromCode(0x010C).name())+"\":\"" + modelDescription + "\"\r":"")
                    + (VictronBitAssignment.bitSetFromValue("ID_MISC_DC_MONITOR_MODE",status)?"\t\""+VictronCodeReadable.fromValue(VictronCode.fromCode(0xEEB8).name())+"\":\"" + monitorMode + "\"\r":"")
                    + (VictronBitAssignment.bitSetFromValue("ID_DEPTH_DEEPEST_DISCHARGE",status)?"\t\""+VictronCodeReadable.fromValue(VictronCode.fromCode(0x0300).name())+"\":" + deepestDischargeDepth + "\r":"")
                    + (VictronBitAssignment.bitSetFromValue("ID_DEPTH_LATEST_DISCHARGE",status)?"\t\""+VictronCodeReadable.fromValue(VictronCode.fromCode(0x0301).name())+"\":" + lastDischargeDepth + "\r":"")
                    + (VictronBitAssignment.bitSetFromValue("ID_DEPTH_AVERAGE_DISCHARGE",status)?"\t\""+VictronCodeReadable.fromValue(VictronCode.fromCode(0x0302).name())+"\":" + averageDischargedepth + "\r":"")
                    + (VictronBitAssignment.bitSetFromValue("ID_NUMBER_CYCLES",status)?"\t\""+VictronCodeReadable.fromValue(VictronCode.fromCode(0x0303).name())+"\":" + numberChargeCycles + "\r":"")
                    + (VictronBitAssignment.bitSetFromValue("ID_NUMBER_FULL_DISCHARGE",status)?"\t\""+VictronCodeReadable.fromValue(VictronCode.fromCode(0x0304).name())+"\":" + numberFullDischarges + "\r":"")
                    + (VictronBitAssignment.bitSetFromValue("ID_CUMULATIVE_AMP_HOURS",status)?"\t\""+VictronCodeReadable.fromValue(VictronCode.fromCode(0x0305).name())+"\":" + cumulativeAmpHoursDrawn + "\r":"")
                    + (VictronBitAssignment.bitSetFromValue("ID_MAXIMUM_VOLTAGE",status)?"\t\""+VictronCodeReadable.fromValue(VictronCode.fromCode(0x0307).name())+"\":" + maximumVoltage + "\r":"")
                    + (VictronBitAssignment.bitSetFromValue("ID_MINIMUM_VOLTAGE",status)?"\t\""+VictronCodeReadable.fromValue(VictronCode.fromCode(0x0306).name())+"\":" + minimumVoltage + "\r":"")
                    + (VictronBitAssignment.bitSetFromValue("ID_SECONDS_SINCE_FULL_CHARGE",status)?"\t\""+VictronCodeReadable.fromValue(VictronCode.fromCode(0x0308).name())+"\":" + secondsSinceLastFullCharge + "\r":"")
                    + (VictronBitAssignment.bitSetFromValue("ID_NUMBER_AUTOMATIC_SYNCHRONIZATIONS",status)?"\t\""+VictronCodeReadable.fromValue(VictronCode.fromCode(0x0309).name())+"\":" + numberAutomaticSynchronizations + "\r":"")
                    + (VictronBitAssignment.bitSetFromValue("ID_NUMBER_LOW_VOLTAGE_ALARMS",status)?"\t\""+VictronCodeReadable.fromValue(VictronCode.fromCode(0x030A).name())+"\":" + numberLowVoltageAlarms + "\r":"")
                    + (VictronBitAssignment.bitSetFromValue("ID_NUMBER_HIGH_VOLTAGE_ALARMS",status)?"\t\""+VictronCodeReadable.fromValue(VictronCode.fromCode(0x030B).name())+"\":" + numberHighVoltageAlarms + "\r":"")
                    + (VictronBitAssignment.bitSetFromValue("ID_CONSUMED_ENERGY",status)?"\t\""+VictronCodeReadable.fromValue(VictronCode.fromCode(0x0311).name())+"\":" + amountDischargedEnergy + "\r":"")
                    + (VictronBitAssignment.bitSetFromValue("ID_PRODUCED_ENERGY",status)?"\t\""+VictronCodeReadable.fromValue(VictronCode.fromCode(0x0310).name())+"\":" + amountChargedEnergy + "\r":"")
                    + "}\r";
            return jsonString;
        } catch (Exception e) {
            return "\"Error\":\""+e.getMessage()+"\"\r}\r";
        }
    }
    public String exportQueryString() {
        try {
            String queryString = "?"
                    + (VictronBitAssignment.bitSetFromValue("ID_PRODUCT_ID",status)?VictronCode.fromCode(0x0100).name()+"=" + getPid():"")
                    + (VictronBitAssignment.bitSetFromValue("ID_MAIN_VOLTAGE",status)?"&"+VictronCode.fromCode(0xED8D).name()+"=" + getMainVoltage():"")
                    + (VictronBitAssignment.bitSetFromValue("ID_CURRENT",status)?"&"+VictronCode.fromCode(0xED8F).name()+"=" + getMainCurrent():"")
                    + (VictronBitAssignment.bitSetFromValue("ID_POWER",status)?"&"+VictronCode.fromCode(0xED8E).name()+"=" + getInstantaneousPower():"")
                    + (VictronBitAssignment.bitSetFromValue("ID_CONSUMED_AH",status)?"&"+VictronCode.fromCode(0xEEFF).name()+"=" + getConsumedAmpHours():"")
                    + (VictronBitAssignment.bitSetFromValue("ID_SOC",status)?"&"+VictronCode.fromCode(0x0FFF).name()+"=" + getStateOfCharge():"")
                    + (VictronBitAssignment.bitSetFromValue("ID_TIME_TO_GO",status)?"&"+VictronCode.fromCode(0x0FFE).name()+"=" + getTimeToGo():"")
                    + (VictronBitAssignment.bitSetFromValue("ID_ALARM_BUZZER",status)?"&"+VictronCode.fromCode(0xEEFC).name()+"=" + alarmCondition:"")
                    + (VictronBitAssignment.bitSetFromValue("ID_ALARM_REASON",status)?"&"+VictronCode.fromCode(0x03F1).name()+"=" + getAlarmReason():"")
                    + (VictronBitAssignment.bitSetFromValue("ID_DESCRIPTION",status)?"&"+VictronCode.fromCode(0x010C).name()+"=" + getModelDescription().replace("/","--").replace(" ",""):"")
                    + (VictronBitAssignment.bitSetFromValue("ID_MISC_DC_MONITOR_MODE",status)?"&"+VictronCode.fromCode(0xEEB8).name()+"=" + getMonitorMode():"")
                    + (VictronBitAssignment.bitSetFromValue("ID_DEPTH_DEEPEST_DISCHARGE",status)?"&"+VictronCode.fromCode(0x0300).name()+"=" + getDeepestDischargeDepth():"")
                    + (VictronBitAssignment.bitSetFromValue("ID_DEPTH_LATEST_DISCHARGE",status)?"&"+VictronCode.fromCode(0x0301).name()+"=" + getLastDischargeDepth():"")
                    + (VictronBitAssignment.bitSetFromValue("ID_DEPTH_AVERAGE_DISCHARGE",status)?"&"+VictronCode.fromCode(0x0302).name()+"=" + getAverageDischargedepth():"")
                    + (VictronBitAssignment.bitSetFromValue("ID_NUMBER_CYCLES",status)?"&"+VictronCode.fromCode(0x0303).name()+"=" + getNumberChargeCycles():"")
                    + (VictronBitAssignment.bitSetFromValue("ID_NUMBER_FULL_DISCHARGE",status)?"&"+VictronCode.fromCode(0x0304).name()+"=" + getNumberFullDischarges():"")
                    + (VictronBitAssignment.bitSetFromValue("ID_CUMULATIVE_AMP_HOURS",status)?"&"+VictronCode.fromCode(0x0305).name()+"=" + getCumulativeAmpHoursDrawn():"")
                    + (VictronBitAssignment.bitSetFromValue("ID_MAXIMUM_VOLTAGE",status)?"&"+VictronCode.fromCode(0x0307).name()+"=" + getMaximumVoltage():"")
                    + (VictronBitAssignment.bitSetFromValue("ID_MINIMUM_VOLTAGE",status)?"&"+VictronCode.fromCode(0x0306).name()+"=" + getMinimumVoltage():"")
                    + (VictronBitAssignment.bitSetFromValue("ID_SECONDS_SINCE_FULL_CHARGE",status)?"&"+VictronCode.fromCode(0x0308).name()+"=" + getSecondsSinceLastFullCharge():"")
                    + (VictronBitAssignment.bitSetFromValue("ID_NUMBER_AUTOMATIC_SYNCHRONIZATIONS",status)?"&"+VictronCode.fromCode(0x0309).name()+"=" + getNumberAutomaticSynchronizations():"")
                    + (VictronBitAssignment.bitSetFromValue("ID_NUMBER_LOW_VOLTAGE_ALARMS",status)?"&"+VictronCode.fromCode(0x030A).name()+"=" + getNumberLowVoltageAlarms():"")
                    + (VictronBitAssignment.bitSetFromValue("ID_NUMBER_HIGH_VOLTAGE_ALARMS",status)?"&"+VictronCode.fromCode(0x030B).name()+"=" + getNumberHighVoltageAlarms():"")
                    + (VictronBitAssignment.bitSetFromValue("ID_CONSUMED_ENERGY",status)?"&"+VictronCode.fromCode(0x0311).name()+"=" + getAmountDischargedEnergy():"")
                    + (VictronBitAssignment.bitSetFromValue("ID_PRODUCED_ENERGY",status)?"&"+VictronCode.fromCode(0x0310).name()+"=" + getAmountChargedEnergy():"");
            return queryString;
        } catch (Exception e) {
            return "\"Error\":\""+e.getMessage()+"\"\r}\r";
        }
    }
}
