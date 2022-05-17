package com.yzhang.page;

import com.yzhang.common.driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class NotepadPage {

    public WebElement editArea() {
        WebElement element = Driver.getDriver().findElement(By.name("RichEdit Control"));
        return element;
    }

    public WebElement editMenu() {
        WebElement element = Driver.getDriver().findElement(By.name("Edit"));
        return element;
    }

    public WebElement fontMenu() {
        WebElement element = Driver.getDriver().findElement(By.name("Font"));
        return element;
    }

    public WebElement fileMenu() {
        WebElement element = Driver.getDriver().findElement(By.name("File"));
        return element;
    }

    public WebElement saveMenu() {
        WebElement element = Driver.getDriver().findElement(By.name("Save"));
        return element;
    }

    public WebElement fileNameInputArea() {
        WebElement element =
                Driver.getDriver().findElement(By.xpath("/Window/Window/Pane[1]/ComboBox[1]/Edit"));
        return element;
    }

    public WebElement saveButton() {
        WebElement element = Driver.getDriver().findElement(By.xpath(
                "//Window[@Name=\"Save as\"]/Button[@ClassName=\"Button\"][@Name=\"Save\"]"));
        return element;
    }

}
