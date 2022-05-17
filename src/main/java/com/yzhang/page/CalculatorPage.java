package com.yzhang.page;

import com.yzhang.common.driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CalculatorPage {

    public WebElement result() {
        WebElement element = Driver.getDriver().findElementByAccessibilityId("CalculatorResults");
        return element;
    }

    public WebElement clear() {
        WebElement element = Driver.getDriver().findElement(By.name("Clear"));
        return element;
    }

    public WebElement equals() {
        WebElement element = Driver.getDriver().findElement(By.name("Equals"));
        return element;
    }

    public WebElement plus() {
        WebElement element = Driver.getDriver().findElement(By.name("Plus"));
        return element;
    }

    public WebElement minus() {
        WebElement element = Driver.getDriver().findElement(By.name("Minus"));
        return element;
    }

    public WebElement multiply() {
        WebElement element = Driver.getDriver().findElement(By.name("Multiply by"));
        return element;
    }

    public WebElement divide() {
        WebElement element = Driver.getDriver().findElement(By.name("Divide by"));
        return element;
    }

    public WebElement number(String numberString) {
        WebElement element = Driver.getDriver().findElement(By.name(numberString));
        return element;
    }

}
