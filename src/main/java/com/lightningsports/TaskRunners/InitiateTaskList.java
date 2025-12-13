package com.lightningsports.TaskRunners;


import com.lightningsports.SettingsReader.AppKey;
import com.lightningsports.VictronBatteryMonitor.VictronBatteryMonitorReadWrite;

import java.util.List;
import java.util.Timer;
import java.util.logging.Logger;

public class InitiateTaskList {
    private Logger logger;
    private AppKey settings;

    public InitiateTaskList(AppKey settings) {
        this.settings = settings;
        this.logger=Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    }

    public void runTasks() {
        Timer checkIt=new Timer();
        List<AppKey> devices=((List<AppKey>)settings.getValues("devices")).get(0).getValues();
        for (AppKey device:devices) {
            if (Integer.parseInt(device.getAttribute("timer"))==0) {
                (new VictronBatteryMonitorReadWrite(device)).readBatteryMonitor();
                System.exit(0);
            } else
                checkIt.scheduleAtFixedRate(new CheckTask(device), 0, Integer.parseInt(device.getAttribute("timer")));
            logger.info("Started Capture for: "+device.getAttribute("link"));
        }
    }
}
