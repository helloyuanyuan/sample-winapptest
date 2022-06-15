package com.yzhang.cases;

import static com.yzhang.pageAction.CalculatorAction.getText;
import com.yzhang.common.utils.LogUtils;
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

    static CalculatorAction action = new CalculatorAction();

    @Rule
    public TestName testName = new TestName();

    @BeforeClass
    public static void beforeAll() throws Exception {
        LogUtils.startTestSuite(Calculator.class.getSimpleName());
    }

    @Before
    public void beforeEach() throws Exception {
        LogUtils.excuteTestCase(testName.getMethodName());
    }

    @After
    public void afterEach() throws Exception {
        action.clear().click();
    }

    @AfterClass
    public static void afterAll() throws Exception {
        action.driver.closeApp();
        LogUtils.endTestSuite();
    }

    @Test
    public void testAddition() {
        WindowsElement result = action.plus("1", "4");
        Assertions.assertThat(getText(result)).isEqualTo("5");
    }

    @Test
    public void testSubtraction() {
        WindowsElement result = action.minus("8", "3");
        Assertions.assertThat(getText(result)).isEqualTo("5");
    }

    @Test
    public void testMultiplication() {
        WindowsElement result = action.multiply("5", "1");
        Assertions.assertThat(getText(result)).isEqualTo("5");
    }

    @Test
    public void testDivision() {
        WindowsElement result = action.divide("3", "0", "6");
        Assertions.assertThat(getText(result)).isEqualTo("5");
    }

}
