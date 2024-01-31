package ua.foxminded.skarb.pages;

import com.codeborne.selenide.SelenideElement;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class MailHogPage extends BasePageObject {

    private SelenideElement emailConfirmationContentElement = $x("//div[@id='content']//h3[@class='display-3 text-center']");
    private SelenideElement recentEmailMessageElement = $x("//div[@class='msglist-message row ng-scope']//div[contains(text(),'a few seconds ago')]");
    private SelenideElement confirmationLinkElement = $$x("div.tab-pane.ng-binding.active a[target='_blank']").first(); // or .last() depending on the requirement

    public MailHogPage(Logger log) {
        super(log);
    }

    //Find recently received email
    public void waitForEmail(String emailToWait) {
        WebElement recentEmailMessageElement = null;
        $x("//div[contains(text(),'" + emailToWait + "')]").shouldBe(visible).click();
        log.info("Driver found registration confirmation email");
    }

    public void clickConfirmationLink() {
        confirmationLinkElement.click();
        log.info("Confirmation link was clicked");
    }

    public void sleep(long m) {
        try {
            Thread.sleep(m);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

