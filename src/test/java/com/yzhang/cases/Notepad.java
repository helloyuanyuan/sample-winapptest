package com.yzhang.cases;

import static com.yzhang.helpers.NotepadHelper.getResultString;
import com.yzhang.common.driver.Driver;
import com.yzhang.common.utils.LogUtils;
import com.yzhang.common.utils.ProcessUtils;
import com.yzhang.common.utils.PropertyUtils;
import com.yzhang.pages.NotepadPage;
import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

public class Notepad {

    NotepadPage notepadPage = new NotepadPage();

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
        notepadPage.editArea().clear();
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
        notepadPage.editArea().sendKeys(msg);
        Assertions.assertThat(getResultString(notepadPage.editArea())).isEqualTo(msg);
    }

    @Test
    public void testInputAndSave() {
        String msg = "Hello World!";
        notepadPage.editArea().sendKeys(msg);
        notepadPage.fileMenu().click();
        notepadPage.saveMenu().click();
        notepadPage.fileNameInputArea().clear();
        notepadPage.fileNameInputArea().sendKeys("TestFile" + System.currentTimeMillis() + ".txt");
        notepadPage.saveButton().click();
    }

}
