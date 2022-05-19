package com.yzhang.cases;

import static com.yzhang.pageAction.CalculatorAction.getText;
import com.yzhang.common.driver.Driver;
import com.yzhang.common.utils.LogUtils;
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
import io.appium.java_client.windows.WindowsElement;

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
        Driver.getDriver().quit();
        LogUtils.endTestSuite();
    }

    @Test
    public void testAddition() {
        WindowsElement result = calculatoraAction.plus("One", "Four");
        Assertions.assertThat(getText(result)).isEqualTo("5");
    }

    @Test
    public void testSubtraction() {
        WindowsElement result = calculatoraAction.minus("Eight", "Three");
        Assertions.assertThat(getText(result)).isEqualTo("5");
    }

    @Test
    public void testMultiplication() {
        WindowsElement result = calculatoraAction.multiply("Five", "One");
        Assertions.assertThat(getText(result)).isEqualTo("5");
    }

    @Test
    public void testDivision() {
        WindowsElement result = calculatoraAction.divide("Three", "Zero", "Six");
        Assertions.assertThat(getText(result)).isEqualTo("5");
    }

}
