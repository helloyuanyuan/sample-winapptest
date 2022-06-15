package com.yzhang.common.utils;

import java.io.IOException;
import java.util.Properties;

public class ProcessUtils {

    public static void killProcess(String processName) throws IOException {
        Properties props = System.getProperties();

        String os = props.getProperty("os.name");
        if (os != null) {
            os = os.toLowerCase();
            if (os.contains("win")) {
                Runtime.getRuntime().exec("taskkill /F /IM " + processName);
            } else {
                Runtime.getRuntime().exec("pkill -f '" + processName + "'");
            }
        }
    }

    public static void killAllNotepadProcess() {
        try {
            killProcess("Notepad.exe");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void killAllCalculatorProcess() {
        try {
            killProcess("CalculatorApp.exe");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

