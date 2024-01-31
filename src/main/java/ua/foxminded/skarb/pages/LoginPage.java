package ua.foxminded.skarb.pages;

import com.codeborne.selenide.SelenideElement;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class LoginPage extends BasePageObject {
//private WebDriver driver = getWebDriver();

    private SelenideElement inputLoginField = $("login");
    private SelenideElement inputPasswordField = $("password");
    private SelenideElement enterButton = $x("//button[@name='login-button']");

    public LoginPage(Logger log) {
        super(log);
    }

    public void typeLogin(String login) {
        inputLoginField.setValue(login);
        log.info("Login field '" + login + "' email was used");
    }
    public void typePassword(String password) {
        inputPasswordField.setValue(password);
        log.info("Password field '" + password + "' password was used");
    }

    public void clickEnterButton() {
        enterButton.click();
        log.info("Enter button was clicked.");
        new PrivatePage( log);
    }

    public LoginPage switchToLogin() {
        String loginHandle = driver.getWindowHandle();
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://skarb.foxminded.ua/login");
        log.info("Log In tab was open");
        return new LoginPage(log);
    }
}




