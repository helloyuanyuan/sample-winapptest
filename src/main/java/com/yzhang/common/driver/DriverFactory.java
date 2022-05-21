package com.yzhang.common.driver;

import com.yzhang.common.enums.App;
import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;

public class DriverFactory {

    public WindowsDriver<WindowsElement> getDriver(App app) {
        if (app.equals(App.CALCULATOR)) {
            return new DriverCalculator().initDriver();

        } else if (app.equals(App.COMPLETION)) {
            return new DriverCompletion().initDriver();

        } else if (app.equals(App.NOTEPAD)) {
            return new DriverNotepad().initDriver();
        }
        return null;
    }

}
