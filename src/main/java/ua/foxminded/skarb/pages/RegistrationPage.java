package ua.foxminded.skarb.pages;

import com.codeborne.selenide.SelenideElement;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

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
