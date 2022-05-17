package com.yzhang.pageAction;

import java.util.Arrays;
import com.yzhang.page.CalculatorPage;
import org.openqa.selenium.WebElement;

public class CalculatorAction extends CalculatorPage {

    CalculatorPage calculatorPage = null;

    public CalculatorAction() {
        this.calculatorPage = new CalculatorPage();
    }

    public static String getResultString(WebElement element) {
        return element.getText().replace("Display is", "").trim();
    }

    public WebElement plus(String... num) {
        calculatorPage.number(Arrays.asList(num).get(0)).click();
        calculatorPage.plus().click();
        calculatorPage.number(Arrays.asList(num).get(1)).click();
        calculatorPage.equals().click();
        return calculatorPage.result();
    }

    public WebElement minus(String... num) {
        calculatorPage.number(Arrays.asList(num).get(0)).click();
        calculatorPage.minus().click();
        calculatorPage.number(Arrays.asList(num).get(1)).click();
        calculatorPage.equals().click();
        return calculatorPage.result();
    }

    public WebElement multiply(String... num) {
        calculatorPage.number(Arrays.asList(num).get(0)).click();
        calculatorPage.multiply().click();
        calculatorPage.number(Arrays.asList(num).get(1)).click();
        calculatorPage.equals().click();
        return calculatorPage.result();
    }

    public WebElement divide(String... num) {
        calculatorPage.number(Arrays.asList(num).get(0)).click();
        calculatorPage.number(Arrays.asList(num).get(1)).click();
        calculatorPage.divide().click();
        calculatorPage.number(Arrays.asList(num).get(2)).click();
        calculatorPage.equals().click();
        return calculatorPage.result();
    }

}
