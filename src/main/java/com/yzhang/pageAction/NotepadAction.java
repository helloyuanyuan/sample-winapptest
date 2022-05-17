package com.yzhang.pageAction;

import com.yzhang.page.NotepadPage;
import org.openqa.selenium.WebElement;

public class NotepadAction extends NotepadPage {

    NotepadPage notepadPage = null;

    public NotepadAction() {
        this.notepadPage = new NotepadPage();
    }

    public static String getResultString(WebElement element) {
        return element.getText();
    }

    public WebElement input(String msg) {
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

}
