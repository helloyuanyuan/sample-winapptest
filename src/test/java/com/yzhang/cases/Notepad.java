package com.yzhang.cases;


import static com.yzhang.helpers.NotepadHelper.getResultString;
import com.yzhang.common.driver.Driver;
import com.yzhang.common.utils.ProcessUtils;
import com.yzhang.common.utils.PropertyUtils;
import com.yzhang.pages.NotepadPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Notepad {

    NotepadPage notepadPage = new NotepadPage();

    @Before
    public void setUp() throws Exception {
        Driver.initDriver(PropertyUtils.getInstance().getNotepadPath());
        notepadPage.editArea().clear();
    }

    @After
    public void reset() throws Exception {
        ProcessUtils.killAllNotepadProcess();
    }

    @Test
    public void testInput() {
        String msg = "Hello World!";
        notepadPage.editArea().sendKeys(msg);
        Assert.assertEquals("Assert Equals: ", msg, getResultString(notepadPage.editArea()));
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
