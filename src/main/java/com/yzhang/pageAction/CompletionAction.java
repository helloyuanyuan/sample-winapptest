package com.yzhang.pageAction;

import static com.yzhang.common.utils.DateUtils.pause;
import com.yzhang.common.driver.Driver;
import com.yzhang.page.CompletionPage;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

public class CompletionAction extends CompletionPage {

    CompletionPage completionPage = null;

    public CompletionAction() {
        this.completionPage = new CompletionPage();
    }

    public void toolbarClickLoadButtonAndWait(int seconds) {
        Actions action = new Actions(Driver.getDriver());
        action.moveToElement(completionPage.toolbar(), 61, 61);
        action.click();
        action.perform();
        pause(seconds);
    }

    public void inputExpertAddress(String address) {
        Driver.getDriver().findElement(By.className("Edit")).clear();;
        Driver.getDriver().findElement(By.className("Edit")).sendKeys(address);;
        Driver.getDriver().findElement(By.className("Edit")).click();;
    }

}
