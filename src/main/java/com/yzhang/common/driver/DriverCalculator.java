package com.yzhang.common.driver;

import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import com.yzhang.common.utils.PropertyUtils;
import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;

public class DriverCalculator implements Driver {

    @Override
    public WindowsDriver<WindowsElement> initDriver() {
        String serverURL = PropertyUtils.getInstance().getServerUrl();
        WindowsDriver<WindowsElement> driver = null;
        try {
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("app", PropertyUtils.getInstance().getCalculatorPath());
            caps.setCapability("platformVersion", "10");
            caps.setCapability("platformName", "Windows");
            caps.setCapability("deviceName", "WindowsPC");
            driver = new WindowsDriver<WindowsElement>(new URL(serverURL), caps);
        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        return driver;
    }

}
