package com.yzhang.pageAction;

import java.util.Arrays;
import com.yzhang.page.CalculatorPage;
import io.appium.java_client.windows.WindowsElement;

public class CalculatorAction extends CalculatorPage {

    public static String getText(WindowsElement element) {
        return element.getText().replace("Display is", "").trim();
    }

    public WindowsElement plus(String... num) {
        number(Arrays.asList(num).get(0)).click();
        plus().click();
        number(Arrays.asList(num).get(1)).click();
        equals().click();
        return result();
    }

    public WindowsElement minus(String... num) {
        number(Arrays.asList(num).get(0)).click();
        minus().click();
        number(Arrays.asList(num).get(1)).click();
        equals().click();
        return result();
    }

    public WindowsElement multiply(String... num) {
        number(Arrays.asList(num).get(0)).click();
        multiply().click();
        number(Arrays.asList(num).get(1)).click();
        equals().click();
        return result();
    }

    public WindowsElement divide(String... num) {
        number(Arrays.asList(num).get(0)).click();
        number(Arrays.asList(num).get(1)).click();
        divide().click();
        number(Arrays.asList(num).get(2)).click();
        equals().click();
        return result();
    }

}
