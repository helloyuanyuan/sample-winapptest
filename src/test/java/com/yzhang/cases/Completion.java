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

    @Test
    public void testDocumentCompletionVHV() throws InterruptedException {
        if (action.documentsInQueue()) {

            // Load document
            action.toolbarClickLoadButton();

            // ExpertAddress
            action.selectExpertAddress("Unbekannt");

            // VIN
            action.inputData(90, 440, "TESTVINNUMBER");

            // Residual value (gross)
            action.inputData(90, 665, "1024");

            // First registrayion date
            action.inputData(90, 1075, "01.01.2010");

            // Vehicle type
            action.inputData(90, 1300, "SUV");

            // Platform
            action.inputData(90, 1460, "SUV");

            // Number of doors
            action.inputData(1, "5");

            // Manufacturer
            action.inputData(1, "VOLVO");

            // Model
            action.inputData(1, "XC90");

            // Variant
            action.inputData(1, "TEST Variant");

            // Engine type
            action.inputData(1, "OTTO");

            // Engine volume (ccm)
            action.inputData(1, "2.0");

            // Power (KW)
            action.inputData(1, "235");

            // Color
            action.inputData(1, "Black");

            // Mileage
            action.inputData(1, "5000");

            // Gear type
            action.inputData(4, "AUTOMATIK");

            // Standard equipment
            action.inputData(1, "TEST Standard equipment");

            // Extra equipment
            action.inputData(1, "TEST Extra equipment");

            // Calculation text
            action.inputData(5, "TEST Calculation text");

            // Repair cost (net)
            action.inputData(1, "512");

            // Completion
            action.toolbarClickCompletionButton();

            // Assertions
            Assertions.assertThat(action.completingCompletedForm()).isNotNull();
            Assertions.assertThat(action.completingSendAndGetNew()).isNotNull();
            Assertions.assertThat(action.completingSend()).isNotNull();
            Assertions.assertThat(action.completingCancel()).isNotNull();

            // Send
            action.completingSend().click();

        } else {
            action.toolbarClickLoadButton();
            action.iCRpilotPopUpConfirmButton().click();
        }
    }

}
