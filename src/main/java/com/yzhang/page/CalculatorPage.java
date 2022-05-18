package com.yzhang.page;

import com.yzhang.common.driver.Driver;
import org.openqa.selenium.By;
import io.appium.java_client.windows.WindowsElement;

public class CalculatorPage {

    public WindowsElement result() {
        WindowsElement element =
                Driver.getDriver().findElementByAccessibilityId("CalculatorResults");
        return element;
    }

    public WindowsElement clear() {
        WindowsElement element = Driver.getDriver().findElement(By.name("Clear"));
        return element;
    }

    public WindowsElement equals() {
        WindowsElement element = Driver.getDriver().findElement(By.name("Equals"));
        return element;
    }

    public WindowsElement plus() {
        WindowsElement element = Driver.getDriver().findElement(By.name("Plus"));
        return element;
    }

    public WindowsElement minus() {
        WindowsElement element = Driver.getDriver().findElement(By.name("Minus"));
        return element;
    }

    public WindowsElement multiply() {
        WindowsElement element = Driver.getDriver().findElement(By.name("Multiply by"));
        return element;
    }

    public WindowsElement divide() {
        WindowsElement element = Driver.getDriver().findElement(By.name("Divide by"));
        return element;
    }

    public WindowsElement number(String numberString) {
        WindowsElement element = Driver.getDriver().findElement(By.name(numberString));
        return element;
    }

}
