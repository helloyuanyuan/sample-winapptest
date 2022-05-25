package com.yzhang.pageAction;

import com.yzhang.page.NotepadPage;
import io.appium.java_client.windows.WindowsElement;

public class NotepadAction extends NotepadPage {

    public WindowsElement input(String msg) {
        editArea().sendKeys(msg);
        return editArea();
    }

    public void inputAndSave(String msg, String fileName) {
        editArea().sendKeys(msg);
        fileMenu().click();
        saveMenu().click();
        fileNameInputArea().clear();
        fileNameInputArea().sendKeys(fileName);
        saveButton().click();
    }

    public void quitWithoutSave() {
        driver.closeApp();
        popupNotSaveButton().click();
    }

}
