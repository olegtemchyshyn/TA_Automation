package ua.foxminded.skarb.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.Set;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MailHogPage extends BasePageObject {

    public MailHogPage() {
        super();
    }
    private SelenideElement emailConfirmationContentElement = $x("//div[@id='content']//h3[@class='display-3 text-center']");
    private SelenideElement recentEmailMessageElement = $x("//div[@class='msglist-message row ng-scope']//div[contains(text(),'a few seconds ago')]");
    private SelenideElement confirmationLinkElement = $$x("div.tab-pane.ng-binding.active a[target='_blank']").first(); // or .last() depending on the requirement

    public void waitForEmail(String emailToWait) {
        SelenideElement recentEmailMessageElement = null;
        while (recentEmailMessageElement == null) {
            try {
                $x("//div[contains(text(),'" + emailToWait + "')]").shouldBe(visible);
            } catch (org.openqa.selenium.NoSuchElementException e) {
                log.info("Email containing '" + emailToWait + "' was found.");
            }
        }
        recentEmailMessageElement.click();
        log.info("Driver found registration confirmation email");
    }

    //Find recently received email
    public void switchToLastTab() {
        Set<String> allWindows = getWebDriver().getWindowHandles();
        for (String currentWindow : allWindows) {
            Selenide.switchTo().window(currentWindow);
        }
    }

    public void clickConfirmationLink() {
        confirmationLinkElement.shouldBe(visible).click(); // Ensure link is visible before clicking
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

