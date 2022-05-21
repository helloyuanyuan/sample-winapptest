package com.yzhang.cases;

import com.yzhang.common.utils.LogUtils;
import com.yzhang.pageAction.NotepadAction;
import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import io.appium.java_client.windows.WindowsElement;

public class Notepad {

    NotepadAction action = new NotepadAction();

    @Rule
    public TestName testName = new TestName();

    @BeforeClass
    public static void beforeAll() throws Exception {
        LogUtils.startTestSuite(Notepad.class.getSimpleName());
    }

    @Before
    public void beforeEach() throws Exception {
        LogUtils.excuteTestCase(testName.getMethodName());
        action.editArea().clear();
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
    public void testInputAndNotSave() {
        String msg = "Input some text but not save...";
        WindowsElement result = action.input(msg);
        Assertions.assertThat(result.getText()).isEqualTo(msg);
        action.quitWithoutSave();
    }

    @Test
    public void testInputAndSave() {
        String msg = "Input some text and save to a .txt file...";
        String fileName = "TestFile" + System.currentTimeMillis() + ".txt";
        action.inputAndSave(msg, fileName);
    }

}
