package com.yzhang.pageAction;

import static com.yzhang.common.utils.DateUtils.pause;
import com.yzhang.common.driver.Driver;
import com.yzhang.common.utils.LogUtils;
import com.yzhang.page.CompletionPage;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

public class CompletionAction extends CompletionPage {

    CompletionPage completionPage = null;

    public CompletionAction() {
        this.completionPage = new CompletionPage();
    }

    private void loadDocument() {
        for (int i = 1; i < 6; i++) {
            try {
                Driver.getDriver().findElement(By.name("Expert address"));
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

    public void toolbarClickLoadButton() {
        Actions action = new Actions(Driver.getDriver());
        action.moveToElement(completionPage.toolbar(), 61, 61);
        action.click();
        action.perform();
        loadDocument();
    }

    public void inputExpertAddress(String address) {
        Driver.getDriver().findElement(By.className("Edit")).clear();;
        Driver.getDriver().findElement(By.className("Edit")).sendKeys(address);;
        Driver.getDriver().findElement(By.className("Edit")).click();;
    }

}
