package com.yzhang.common.driver;

import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;

public interface Driver {
    WindowsDriver<WindowsElement> initDriver();
}
