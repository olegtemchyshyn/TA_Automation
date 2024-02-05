package ua.foxminded.skarb.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.Set;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MailHogPage extends BasePageObject {

    private static final Logger log = LogManager.getLogger();
    private SelenideElement emailConfirmationContentElement = $x("//div[@id='content']//h3[@class='display-3 text-center']");
    private SelenideElement confirmationLinkElement = $x("//div[@class='tab-pane ng-binding active']//a[@target='_blank']");

    public void waitForEmail(String emailToWait) {
        // Wait for the email element containing the specific text to become visible and then click
        SelenideElement recentEmailMessageElement = $x("//div[contains(text(),'" + emailToWait + "')]").shouldBe(visible, Duration.ofSeconds(80));
        recentEmailMessageElement.click();
        log.info("Email containing '" + emailToWait + "' was found and clicked.");
    }

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

