package com.yzhang.cases;

import static com.yzhang.helpers.CalculatorHelper.getResultString;
import com.yzhang.common.driver.Driver;
import com.yzhang.common.utils.LogUtils;
import com.yzhang.common.utils.ProcessUtils;
import com.yzhang.common.utils.PropertyUtils;
import com.yzhang.pages.CalculatorPage;
import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

public class Calculator {

    CalculatorPage calculatorPage = new CalculatorPage();

    @Rule
    public TestName testName = new TestName();

    @BeforeClass
    public static void beforeAll() throws Exception {
        LogUtils.startTestSuite(Calculator.class.getSimpleName());
        Driver.initDriver(PropertyUtils.getInstance().getCalculatorPath());
    }

    @Before
    public void beforeEach() throws Exception {
        LogUtils.excuteTestCase(testName.getMethodName());
    }

    @After
    public void afterEach() throws Exception {
        calculatorPage.clear().click();
    }

    @AfterClass
    public static void afterAll() throws Exception {
        ProcessUtils.killAllCalculatorProcess();
        LogUtils.endTestSuite();
    }

    @Test
    public void testAddition() {
        calculatorPage.number("One").click();
        calculatorPage.plus().click();
        calculatorPage.number("Four").click();
        calculatorPage.equals().click();
        Assertions.assertThat(getResultString(calculatorPage.result())).isEqualTo("5");
    }

    @Test
    public void testSubtraction() {
        calculatorPage.number("Eight").click();
        calculatorPage.minus().click();
        calculatorPage.number("Three").click();
        calculatorPage.equals().click();
        Assertions.assertThat(getResultString(calculatorPage.result())).isEqualTo("5");
    }

    @Test
    public void testMultiplication() {
        calculatorPage.number("Five").click();
        calculatorPage.multiply().click();
        calculatorPage.number("One").click();
        calculatorPage.equals().click();
        Assertions.assertThat(getResultString(calculatorPage.result())).isEqualTo("5");
    }

    @Test
    public void testDivision() {
        calculatorPage.number("Three").click();
        calculatorPage.number("Zero").click();
        calculatorPage.divide().click();
        calculatorPage.number("Six").click();
        calculatorPage.equals().click();
        Assertions.assertThat(getResultString(calculatorPage.result())).isEqualTo("5");
    }

}
