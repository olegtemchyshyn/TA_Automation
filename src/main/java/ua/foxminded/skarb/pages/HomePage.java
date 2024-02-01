package ua.foxminded.skarb.pages;

import com.codeborne.selenide.SelenideElement;
import org.apache.logging.log4j.Logger;

import static com.codeborne.selenide.Selenide.$x;

public class HomePage extends BasePageObject {

    public HomePage() {
        super();
    }
    private SelenideElement registrationPlusButton = $x("//a[@href='/registration']");

    public RegistrationPage clickPlusButton() {
        registrationPlusButton.click();
        return new RegistrationPage();
    }

}
