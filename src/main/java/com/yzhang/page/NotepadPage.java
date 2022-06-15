package com.yzhang.page;

import com.yzhang.common.driver.DriverFactory;
import com.yzhang.common.enums.App;
import org.openqa.selenium.By;
import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;

public class NotepadPage {

    public WindowsDriver<WindowsElement> driver = new DriverFactory().getDriver(App.NOTEPAD);

    public WindowsElement editArea() {
        return driver.findElement(By.name("Text Editor"));
    }

    public WindowsElement editMenu() {
        return driver.findElement(By.name("Edit"));
    }

    public WindowsElement fontMenu() {
        return driver.findElement(By.name("Font"));
    }

    public WindowsElement fileMenu() {
        return driver.findElement(By.name("File"));
    }

    public WindowsElement saveMenu() {
        return driver.findElement(By.xpath("/Window[1]/Menu/MenuItem[4]"));
    }

    public WindowsElement fileNameInputArea() {
        return driver.findElement(By.xpath("/Window/Window/Pane[1]/ComboBox[1]/Edit"));
    }

    public WindowsElement saveButton() {
        return driver.findElement(By.xpath("//Button[@ClassName=\"Button\"][@Name=\"Save\"]"));
    }

    public WindowsElement popupSaveButton() {
        return driver.findElement(By.name("Save"));
    }

    public WindowsElement popupNotSaveButton() {
        return driver.findElement(By.name("Don't Save"));
    }

}
