package ua.foxminded.skarb.pages;

import com.codeborne.selenide.SelenideElement;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WindowType;
import java.util.Set;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.switchTo;

public class NewConfirmationPage extends BasePageObject {

    private SelenideElement confirmationMessage = $x("//div[@class='alert alert-success']//h3[@class='display-3 text-center']");

    public NewConfirmationPage(Logger log) {
        super(log);
    }

    public SelenideElement getConfirmationMessage() {
        return confirmationMessage;
    }

    public void waitForConfirmationMessage() {
        waitElementTillVisibility(confirmationMessage, 10);
    }

    public void switchToLastTab() {
        Set<String> allWindows = switchTo().windowHandle();
        for (String currentWindow : allWindows) {
            switchTo().window(currentWindow);
        }
    }

    //Open new tab
    public static LoginPage switchToLogin() {
        String loginHandle = driver.getWindowHandle();
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://skarb.foxminded.ua/login");
        log.info("Log In tab was open");
        return new LoginPage(log);
    }
}
