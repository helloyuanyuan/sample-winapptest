package com.yzhang.page;

import com.yzhang.common.driver.DriverFactory;
import com.yzhang.common.enums.App;
import org.openqa.selenium.By;
import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;

public class CompletionPage {

    public WindowsDriver<WindowsElement> driver = new DriverFactory().getDriver(App.COMPLETION);

    public WindowsElement toolbar() {
        return driver.findElement(By.xpath("//Pane[starts-with(@AutomationId,\"toolbar\")]"));
    }

    public WindowsElement toolbarSettingCboCultures() {
        return driver.findElementByAccessibilityId("cboCultures");
    }

    public WindowsElement iCRpilotPopUpConfirmButton() {
        return driver.findElement(
                By.xpath("//Window[@Name=\"ICRpilot\"]/Button[@ClassName=\"Button\"]"));
    }

    public WindowsElement dataAreaExpertAddressTitle() {
        return driver.findElement(By.name("Expert address"));
    }

    public WindowsElement dataAreaExpertAddress() {
        return driver.findElement(By.className("Edit"));
    }

}
