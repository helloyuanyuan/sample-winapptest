package com.yzhang.helpers;

import org.openqa.selenium.WebElement;

public class CalculatorHelper {

    public static String getResultString(WebElement element) {
        return element.getText().replace("Display is", "").trim();
    }

}
