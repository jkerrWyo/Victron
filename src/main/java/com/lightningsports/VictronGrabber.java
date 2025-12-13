package com.lightningsports;

import com.lightningsports.SettingsReader.AppKey;
import com.lightningsports.SettingsReader.GetSettings;
import com.lightningsports.TaskRunners.InitiateTaskList;
import com.lightningsports.TaskRunners.ShutdownCleanup;

import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.Calendar;
import java.util.TimeZone;
import java.text.SimpleDateFormat;
import java.io.IOException;
import java.util.logging.Logger;


public class VictronGrabber {
    public static Logger logger;
    public static AppKey settings;

    public static void main(String[] args) {
        System.setProperty("sun.net.client.defaultConnectTimeout", "5000");
        System.setProperty("sun.net.client.defaultReadTimeout",    "5000");

        logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
        GetSettings appSettings=new GetSettings();
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd'.log'");
            FileHandler fh = new FileHandler(sdf.format(Calendar.getInstance(TimeZone.getTimeZone("MST")).getTime()), true);
            fh.setLevel(Level.ALL);
            logger.addHandler(fh);
            settings=appSettings.readSettings("settings.xml");
            Runtime.getRuntime().addShutdownHook(new ShutdownCleanup(fh));
            (new InitiateTaskList(settings)).runTasks();
        } catch (IOException e) {
//            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}
