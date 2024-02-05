package ua.foxminded.skarb.pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WindowType;

import java.time.Duration;
import java.util.Set;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.open;

public class NewConfirmationPage extends BasePageObject {

    private static final Logger log = LogManager.getLogger();
    private SelenideElement confirmationMessage = $x("//div[@class='alert alert-success']//h3[@class='display-3 text-center']");

    public SelenideElement getConfirmationMessage() {
        return confirmationMessage;
    }

    public void waitForConfirmationMessage() {
        confirmationMessage.shouldBe(visible, Duration.ofSeconds(10));
    }

    public void switchToLastTab() {
        // Selenide doesn't need to iterate over all window handles to switch to the last tab
        var windowHandles = WebDriverRunner.getWebDriver().getWindowHandles();
        switchTo().window(windowHandles.toArray(new String[0])[windowHandles.size() - 1]);
    }

    //Open new tab
    public static LoginPage switchToLogin() {
        String loginHandle = WebDriverRunner.getWebDriver().getWindowHandle();
        switchTo().newWindow(WindowType.TAB);
        open("https://skarb.foxminded.ua/login");
        log.info("Log In tab was open");
        return new LoginPage();
    }
}
