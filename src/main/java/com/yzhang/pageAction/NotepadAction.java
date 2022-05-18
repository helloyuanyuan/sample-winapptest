package com.yzhang.pageAction;

import com.yzhang.common.driver.Driver;
import com.yzhang.page.NotepadPage;
import io.appium.java_client.windows.WindowsElement;

public class NotepadAction extends NotepadPage {

    NotepadPage notepadPage = null;

    public NotepadAction() {
        this.notepadPage = new NotepadPage();
    }

    public WindowsElement input(String msg) {
        notepadPage.editArea().sendKeys(msg);
        return notepadPage.editArea();
    }

    public void inputAndSave(String msg, String fileName) {
        notepadPage.editArea().sendKeys(msg);
        notepadPage.fileMenu().click();
        notepadPage.saveMenu().click();
        notepadPage.fileNameInputArea().clear();
        notepadPage.fileNameInputArea().sendKeys(fileName);
        notepadPage.saveButton().click();
    }

    public void quitWithoutSave() {
        Driver.getDriver().closeApp();
        notepadPage.popupNotSaveButton().click();
    }

}
