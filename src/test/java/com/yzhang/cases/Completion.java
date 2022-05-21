package com.yzhang.cases;

import com.yzhang.common.utils.LogUtils;
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

    CompletionAction action = new CompletionAction();

    @Rule
    public TestName testName = new TestName();

    @BeforeClass
    public static void beforeAll() throws Exception {
        LogUtils.startTestSuite(Completion.class.getSimpleName());
    }

    @Before
    public void beforeEach() throws Exception {
        LogUtils.excuteTestCase(testName.getMethodName());
    }

    @After
    public void afterEach() throws Exception {
        action.driver.closeApp();
    }

    @AfterClass
    public static void afterAll() throws Exception {
        LogUtils.endTestSuite();
    }

    @Test
    public void testLoadDocumentBVT() throws InterruptedException {
        if (action.documentsInQueue()) {
            String expectedString = "Expert address";
            action.toolbarClickLoadButton();
            WindowsElement expertAddressTitle = action.dataAreaExpertAddressTitle();
            Assertions.assertThat(expertAddressTitle.getText()).isNotNull()
                    .isEqualTo(expectedString);
        } else {
            action.toolbarClickLoadButton();
            action.iCRpilotPopUpConfirmButton().click();
        }
    }

    @Test
    public void testLoadDocumentAndInputExpertAddress() throws InterruptedException {
        if (action.documentsInQueue()) {
            String expectedString = "This is a test address";
            action.toolbarClickLoadButton();
            action.inputExpertAddress(expectedString);
            WindowsElement expertAddress = action.dataAreaExpertAddress();
            Assertions.assertThat(expertAddress.getText()).isNotNull().isEqualTo(expectedString);
        } else {
            action.toolbarClickLoadButton();
            action.iCRpilotPopUpConfirmButton().click();
        }
    }

}
