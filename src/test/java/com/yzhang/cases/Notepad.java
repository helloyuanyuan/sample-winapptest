package com.yzhang.cases;

import static com.yzhang.pageAction.NotepadAction.getResultString;
import com.yzhang.common.driver.Driver;
import com.yzhang.common.utils.LogUtils;
import com.yzhang.common.utils.ProcessUtils;
import com.yzhang.common.utils.PropertyUtils;
import com.yzhang.pageAction.NotepadAction;
import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.openqa.selenium.WebElement;

public class Notepad {

    NotepadAction notepadAction = new NotepadAction();

    @Rule
    public TestName testName = new TestName();

    @BeforeClass
    public static void beforeAll() throws Exception {
        LogUtils.startTestSuite(Notepad.class.getSimpleName());
    }

    @Before
    public void beforeEach() throws Exception {
        LogUtils.excuteTestCase(testName.getMethodName());
        Driver.initDriver(PropertyUtils.getInstance().getNotepadPath());
        notepadAction.editArea().clear();
    }

    @After
    public void afterEach() throws Exception {
        ProcessUtils.killAllNotepadProcess();
    }

    @AfterClass
    public static void afterAll() throws Exception {
        LogUtils.endTestSuite();
    }

    @Test
    public void testInput() {
        String msg = "Hello World!";
        WebElement result = notepadAction.input(msg);
        Assertions.assertThat(getResultString(result)).isEqualTo(msg);
    }

    @Test
    public void testInputAndSave() {
        String msg = "Hello World!";
        String fileName = "TestFile" + System.currentTimeMillis() + ".txt";
        notepadAction.inputAndSave(msg, fileName);
    }

}
