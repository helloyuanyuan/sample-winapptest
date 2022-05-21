package com.yzhang.pageAction;

import static com.yzhang.common.utils.DateUtils.pause;
import com.yzhang.common.utils.LogUtils;
import com.yzhang.page.CompletionPage;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

public class CompletionAction extends CompletionPage {

    private void loadDocument() {
        for (int i = 1; i < 6; i++) {
            try {
                driver.findElement(By.name("Expert address"));
                LogUtils.info("Document loaded");
                break;
            } catch (Exception e) {
                if (e != null) {
                    LogUtils.info(
                            "Document not loaded, will retry 6 times, now is retrying # " + i);
                    pause(10);
                }
            }
        }
    }

    public boolean documentsInQueue() {
        boolean hasDocument = false;
        try {
            driver.findElement(By.name("Total: 0 document(s)"));
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

    public void inputExpertAddress(String address) {
        dataAreaExpertAddress().clear();
        dataAreaExpertAddress().sendKeys(address);
        dataAreaExpertAddress().click();
    }

}
