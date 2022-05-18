package com.yzhang.cases;

import com.yzhang.common.driver.Driver;
import com.yzhang.common.utils.LogUtils;
import com.yzhang.common.utils.ProcessUtils;
import com.yzhang.common.utils.PropertyUtils;
import com.yzhang.pageAction.CompletionAction;
import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import io.appium.java_client.windows.WindowsElement;

public class Completion {

    CompletionAction completionAction = new CompletionAction();

    @Rule
    public TestName testName = new TestName();

    @BeforeClass
    public static void beforeAll() throws Exception {
        LogUtils.startTestSuite(Completion.class.getSimpleName());
    }

    @Before
    public void beforeEach() throws Exception {
        LogUtils.excuteTestCase(testName.getMethodName());
        Driver.initDriver(PropertyUtils.getInstance().getCompletionPath());
    }

    @After
    public void afterEach() throws Exception {
        ProcessUtils.killAllCompletionProcess();
    }

    @AfterClass
    public static void afterAll() throws Exception {
        LogUtils.endTestSuite();
    }

    @Test
    public void testLoadDocument() throws InterruptedException {
        String expectedString = "Expert address";
        completionAction.toolbarClickLoadButtonAndWait(0);
        WindowsElement expertAddressTitle = completionAction.dataAreaExpertAddressTitle();
        Assertions.assertThat(expertAddressTitle.getText()).isNotNull().isEqualTo(expectedString);
    }

    @Test
    public void testDocumentDataAreaInputExpertAddress() throws InterruptedException {
        String expectedString = "This is a test address";
        completionAction.toolbarClickLoadButtonAndWait(0);
        completionAction.inputExpertAddress(expectedString);
        WindowsElement expertAddress = completionAction.dataAreaExpertAddress();
        Assertions.assertThat(expertAddress.getText()).isNotNull().isEqualTo(expectedString);
    }

}
