package com.yzhang.cases;

import static com.yzhang.helpers.CalculatorHelper.getResultString;
import com.yzhang.common.driver.Driver;
import com.yzhang.common.utils.ProcessUtils;
import com.yzhang.common.utils.PropertyUtils;
import com.yzhang.pages.CalculatorPage;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class Calculator {

    CalculatorPage calculatorPage = new CalculatorPage();

    @BeforeClass
    public static void setUp() throws Exception {
        Driver.initDriver(PropertyUtils.getInstance().getCalculatorPath());
    }

    @After
    public void reset() throws Exception {
        calculatorPage.clear().click();
    }

    @AfterClass
    public static void tearDown() throws Exception {
        ProcessUtils.killAllCalculatorProcess();
    }

    @Test
    public void testAddition() {
        calculatorPage.number("One").click();
        calculatorPage.plus().click();
        calculatorPage.number("Four").click();
        calculatorPage.equals().click();
        Assert.assertEquals("5", getResultString(calculatorPage.result()));
    }

    @Test
    public void testSubtraction() {
        calculatorPage.number("Eight").click();
        calculatorPage.minus().click();
        calculatorPage.number("Three").click();
        calculatorPage.equals().click();
        Assert.assertEquals("5", getResultString(calculatorPage.result()));
    }

    @Test
    public void testMultiplication() {
        calculatorPage.number("Five").click();
        calculatorPage.multiply().click();
        calculatorPage.number("One").click();
        calculatorPage.equals().click();
        Assert.assertEquals("5", getResultString(calculatorPage.result()));
    }

    @Test
    public void testDivision() {
        calculatorPage.number("Three").click();
        calculatorPage.number("Zero").click();
        calculatorPage.divide().click();
        calculatorPage.number("Six").click();
        calculatorPage.equals().click();
        Assert.assertEquals("5", getResultString(calculatorPage.result()));
    }

}
