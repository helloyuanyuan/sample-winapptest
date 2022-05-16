package com.yzhang.helpers;

import org.openqa.selenium.WebElement;

public class NotepadHelper {

    public static String getResultString(WebElement element) {
        return element.getText();
    }

}
