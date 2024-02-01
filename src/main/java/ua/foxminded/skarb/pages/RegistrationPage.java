package ua.foxminded.skarb.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class RegistrationPage extends BasePageObject {

    public RegistrationPage() {
        super();
    }
    private SelenideElement partnerButton = $x("//button[contains(text(),'Partner')]");

    public PartnersSignUpPage clickPartnerButton() {
        partnerButton.click();
        return new PartnersSignUpPage();
    }
}
