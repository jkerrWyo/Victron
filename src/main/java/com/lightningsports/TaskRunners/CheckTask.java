package com.lightningsports.TaskRunners;

import com.lightningsports.SettingsReader.AppKey;
import com.lightningsports.VictronBatteryMonitor.VictronBatteryMonitorReadWrite;
import org.joda.time.LocalDateTime;

import java.util.TimerTask;
import java.util.logging.Handler;
import java.util.logging.Logger;

public class CheckTask extends TimerTask {
    private AppKey device;
    private Logger logger;

    public CheckTask(AppKey device) {
        this.device = device;
        this.logger=Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    }

    public void run() {
        if(device.getAttribute("name").contains("Victron")) {
            logger.info("Start Victron Battery Monitor: "+ device.getAttribute("description")+"\n"+(new LocalDateTime()).toString());
            (new VictronBatteryMonitorReadWrite(device)).readBatteryMonitor();
            for (Handler handler: logger.getHandlers())
                handler.flush();
        }
    }

}
