package com.yzhang.page;

import com.yzhang.common.driver.DriverFactory;
import com.yzhang.common.enums.App;
import org.openqa.selenium.By;
import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;

public class CalculatorPage {

    public WindowsDriver<WindowsElement> driver = new DriverFactory().getDriver(App.CALCULATOR);

    public WindowsElement result() {
        return driver.findElement(By.name("Result"));
    }

    public WindowsElement clear() {
        return driver.findElement(By.name("Clear"));
    }

    public WindowsElement equals() {
        return driver.findElement(By.name("Equals"));
    }

    public WindowsElement plus() {
        return driver.findElement(By.name("Add"));
    }

    public WindowsElement minus() {
        return driver.findElement(By.name("Subtract"));
    }

    public WindowsElement multiply() {
        return driver.findElement(By.name("Multiply"));
    }

    public WindowsElement divide() {
        return driver.findElement(By.name("Divide"));
    }

    public WindowsElement number(String numberString) {
        return driver.findElement(By.name(numberString));
    }

}
