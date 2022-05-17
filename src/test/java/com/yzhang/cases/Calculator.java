package com.yzhang.cases;

import static com.yzhang.pageAction.CalculatorAction.getResultString;
import com.yzhang.common.driver.Driver;
import com.yzhang.common.utils.LogUtils;
import com.yzhang.common.utils.ProcessUtils;
import com.yzhang.common.utils.PropertyUtils;
import com.yzhang.pageAction.CalculatorAction;
import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.openqa.selenium.WebElement;

public class Calculator {

    CalculatorAction calculatoraAction = new CalculatorAction();

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
        calculatoraAction.clear().click();
    }

    @AfterClass
    public static void afterAll() throws Exception {
        ProcessUtils.killAllCalculatorProcess();
        LogUtils.endTestSuite();
    }

    @Test
    public void testAddition() {
        WebElement result = calculatoraAction.plus("One", "Four");
        Assertions.assertThat(getResultString(result)).isEqualTo("5");
    }

    @Test
    public void testSubtraction() {
        WebElement result = calculatoraAction.minus("Eight", "Three");
        Assertions.assertThat(getResultString(result)).isEqualTo("5");
    }

    @Test
    public void testMultiplication() {
        WebElement result = calculatoraAction.multiply("Five", "One");
        Assertions.assertThat(getResultString(result)).isEqualTo("5");
    }

    @Test
    public void testDivision() {
        WebElement result = calculatoraAction.divide("Three", "Zero", "Six");
        Assertions.assertThat(getResultString(result)).isEqualTo("5");
    }

}
