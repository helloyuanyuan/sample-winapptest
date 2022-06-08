package com.yzhang.pageAction;

import static com.yzhang.common.utils.DateUtils.pause;
import com.yzhang.common.utils.LogUtils;
import com.yzhang.page.CompletionPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

public class CompletionAction extends CompletionPage {

    private void loadDocument() {
        for (int i = 1; i < 6; i++) {
            try {
                driver.findElement(By.name("Gutachteradresse"));
                LogUtils.info("Document loaded");
                break;
            } catch (Exception e) {
                if (e != null) {
                    LogUtils.info(
                            "Document not loaded, will retry 20 times, now is retrying # " + i);
                    pause(3);
                }
            }
        }
    }

    public boolean documentsInQueue() {
        boolean hasDocument = false;
        try {
            driver.findElement(By.name("Gesamt: 0 document(e)"));
            LogUtils.info("No document in queue");
        } catch (Exception e) {
            if (e != null) {
                hasDocument = true;
            }
        }
        return hasDocument;
    }

    public void toolbarClickLoadButton() {
        Actions action = new Actions(driver);
        action.moveToElement(toolbar(), 61, 61);
        action.click();
        action.perform();
        if (documentsInQueue()) {
            loadDocument();
        }
    }

    public void toolbarClickCompletionButton() {
        Actions action = new Actions(driver);
        action.moveToElement(toolbar(), 185, 61);
        action.click();
        action.perform();
    }

    public void inputExpertAddress(String address) {
        dataAreaExpertAddress().clear();
        dataAreaExpertAddress().sendKeys(address);
        dataAreaExpertAddress().click();
    }

    public void selectExpertAddress(String address) {
        dataAreaExpertAddressSearch().click();
        dataAreaExpertAddressSelect(address).click();
        dataAreaExpertAddressAccept().click();
    }

    public void inputData(int xOffset, int yOffset, String value) {
        Actions action = new Actions(driver);
        action.moveToElement(baseMenu(), xOffset, yOffset);
        action.click();
        action.sendKeys(value);
        action.perform();
    }

    public void inputData(int tabs, String value) {
        Actions action = new Actions(driver);
        for (int i = 0; i < tabs; i++) {
            action.sendKeys(Keys.TAB);
        }
        action.sendKeys(value);
        action.perform();
    }

}
