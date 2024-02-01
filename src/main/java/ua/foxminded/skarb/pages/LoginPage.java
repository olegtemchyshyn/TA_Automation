package ua.foxminded.skarb.pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class LoginPage extends BasePageObject {

    public LoginPage() {
        super();
    }
    private SelenideElement inputLoginField = $("login");
    private SelenideElement inputPasswordField = $("password");
    private SelenideElement enterButton = $x("//button[@name='login-button']");

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
        new PrivatePage();
    }

    public LoginPage switchToLogin() {
        String loginHandle = WebDriverRunner.getWebDriver().getWindowHandle();
        switchTo().newWindow(WindowType.TAB);
        open("https://skarb.foxminded.ua/login");
        log.info("Log In tab was open");
        return new LoginPage();
    }
}




