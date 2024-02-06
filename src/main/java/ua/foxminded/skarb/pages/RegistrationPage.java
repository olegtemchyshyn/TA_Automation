package ua.foxminded.skarb.pages;

import com.codeborne.selenide.SelenideElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.codeborne.selenide.Selenide.$x;

public class RegistrationPage extends BasePageObject {

    private static final Logger log = LogManager.getLogger();
    private SelenideElement partnerButton = $x("//button[contains(text(),'Partner')]");

    public PartnersSignUpPage clickPartnerButton() {
        partnerButton.click();
        return new PartnersSignUpPage();
    }
}
