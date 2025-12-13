package com.lightningsports.TaskRunners;

import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;

public class ShutdownCleanup extends Thread {
    private FileHandler fileHandler;

    public ShutdownCleanup(FileHandler fileHandler) {
        this.fileHandler = fileHandler;
    }

    public void run() {
        fileHandler.flush();
        fileHandler.close();
        super.run();    //To change body of overridden methods use File | Settings | File Templates.
    }
}
