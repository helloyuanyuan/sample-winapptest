package com.yzhang.page;

import com.yzhang.common.driver.DriverFactory;
import com.yzhang.common.enums.App;
import org.openqa.selenium.By;
import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;

public class CompletionPage {

    public WindowsDriver<WindowsElement> driver = new DriverFactory().getDriver(App.COMPLETION);

    public WindowsElement baseMenu() {
        return driver.findElement(By.xpath("//MenuItem"));
    }

    public WindowsElement toolbar() {
        return driver.findElementByAccessibilityId("toolbar1");
    }

    public WindowsElement toolbarSettingCboCultures() {
        return driver.findElementByAccessibilityId("cboCultures");
    }

    public WindowsElement iCRpilotPopUpConfirmButton() {
        return driver.findElement(
                By.xpath("//Window[@Name=\"ICRpilot\"]/Button[@ClassName=\"Button\"]"));
    }

    public WindowsElement dataArea() {
        return driver.findElementByAccessibilityId("panel1");
    }

    public WindowsElement dataAreaExpertAddressTitle() {
        return driver.findElement(By.name("Expert address"));
    }

    public WindowsElement dataAreaExpertAddress() {
        return driver.findElement(By.className("Edit"));
    }

    public WindowsElement dataAreaExpertAddressSearch() {
        return driver.findElement(
                By.xpath("//ComboBox[@AutomationId=\"comboBoxAddressSearch\"]/Button"));
    }

    public WindowsElement dataAreaExpertAddressSelect(String address) {
        return driver.findElement(By.xpath(
                "//ComboBox[@AutomationId=\"comboBoxAddressSearch\"]/List[@ClassName=\"ComboLBox\"]/ListItem[@Name=\""
                        + address + "\"]"));
    }

    public WindowsElement dataAreaExpertAddressAccept() {
        return driver.findElementByAccessibilityId("buttonAcceptSelection");
    }

    public WindowsElement completingCompletedForm() {
        return driver.findElementByAccessibilityId("CompletedForm");
    }

    public WindowsElement completingSendAndGetNew() {
        return driver.findElementByAccessibilityId("sendAndGetNew");
    }

    public WindowsElement completingSend() {
        return driver.findElementByAccessibilityId("send");
    }

    public WindowsElement completingCancel() {
        return driver.findElementByAccessibilityId("Cancel");
    }

}
