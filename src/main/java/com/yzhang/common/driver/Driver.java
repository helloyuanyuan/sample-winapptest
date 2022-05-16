package com.yzhang.common.driver;

import java.net.URL;
import java.util.concurrent.TimeUnit;
import com.yzhang.common.utils.PropertyUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.windows.WindowsDriver;

public class Driver {

    private static WindowsDriver<WebElement> driver = null;

    public static WindowsDriver<WebElement> getDriver() {
        return driver;
    }

    public static void initDriver(String appPath) {
        String WindowsApplicationDriverUrl =
                PropertyUtils.getInstance().getWindowsApplicationDriverUrl();
        try {
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("app", appPath);
            caps.setCapability("platformVersion", "10");
            caps.setCapability("platformName", "Windows");
            caps.setCapability("deviceName", "WindowsPC");
            driver = new WindowsDriver<WebElement>(new URL(WindowsApplicationDriverUrl), caps);
        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

}
