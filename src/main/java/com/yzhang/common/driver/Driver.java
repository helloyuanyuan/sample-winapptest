package com.yzhang.common.driver;

import java.net.URL;
import java.util.concurrent.TimeUnit;
import com.yzhang.common.utils.PropertyUtils;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;

public class Driver {

    private static WindowsDriver<WindowsElement> driver = null;

    public static WindowsDriver<WindowsElement> getDriver() {
        return driver;
    }

    public static void initDriver(String appPath) {
        String serverURL = PropertyUtils.getInstance().getServerUrl();
        try {
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("app", appPath);
            caps.setCapability("platformVersion", "10");
            caps.setCapability("platformName", "Windows");
            caps.setCapability("deviceName", "WindowsPC");
            driver = new WindowsDriver<WindowsElement>(new URL(serverURL), caps);
        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
    }

}
