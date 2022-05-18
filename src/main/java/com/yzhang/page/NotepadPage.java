package com.yzhang.page;

import com.yzhang.common.driver.Driver;
import org.openqa.selenium.By;
import io.appium.java_client.windows.WindowsElement;

public class NotepadPage {

    public WindowsElement editArea() {
        WindowsElement element = Driver.getDriver().findElement(By.name("RichEdit Control"));
        return element;
    }

    public WindowsElement editMenu() {
        WindowsElement element = Driver.getDriver().findElement(By.name("Edit"));
        return element;
    }

    public WindowsElement fontMenu() {
        WindowsElement element = Driver.getDriver().findElement(By.name("Font"));
        return element;
    }

    public WindowsElement fileMenu() {
        WindowsElement element = Driver.getDriver().findElement(By.name("File"));
        return element;
    }

    public WindowsElement saveMenu() {
        WindowsElement element = Driver.getDriver().findElement(By.name("Save"));
        return element;
    }

    public WindowsElement fileNameInputArea() {
        WindowsElement element =
                Driver.getDriver().findElement(By.xpath("/Window/Window/Pane[1]/ComboBox[1]/Edit"));
        return element;
    }

    public WindowsElement saveButton() {
        WindowsElement element = Driver.getDriver().findElement(By.xpath(
                "//Window[@Name=\"Save as\"]/Button[@ClassName=\"Button\"][@Name=\"Save\"]"));
        return element;
    }

    public WindowsElement popupSaveButton() {
        WindowsElement element = Driver.getDriver().findElementByAccessibilityId("PrimaryButton");
        return element;
    }

    public WindowsElement popupNotSaveButton() {
        WindowsElement element = Driver.getDriver().findElementByAccessibilityId("SecondaryButton");
        return element;
    }

}
