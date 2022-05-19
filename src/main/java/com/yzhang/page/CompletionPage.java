package com.yzhang.page;

import com.yzhang.common.driver.Driver;
import org.openqa.selenium.By;
import io.appium.java_client.windows.WindowsElement;

public class CompletionPage {

    public WindowsElement toolbar() {
        WindowsElement element = Driver.getDriver()
                .findElement(By.xpath("//Pane[starts-with(@AutomationId,\"toolbar\")]"));
        return element;
    }

    public WindowsElement toolbarSettingCboCultures() {
        WindowsElement element = Driver.getDriver().findElementByAccessibilityId("cboCultures");
        return element;
    }

    public WindowsElement dataAreaExpertAddressTitle() {
        WindowsElement element = Driver.getDriver().findElement(By.name("Expert address"));
        return element;
    }

    public WindowsElement dataAreaExpertAddress() {
        return Driver.getDriver().findElement(By.className("Edit"));
    }

}
