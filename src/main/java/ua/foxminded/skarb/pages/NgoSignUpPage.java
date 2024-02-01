package ua.foxminded.skarb.pages;

import com.codeborne.selenide.SelenideElement;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class NgoSignUpPage extends BasePageObject {

    public String randomEmail;
    public String randomPassword;
    public NgoSignUpPage() {
        super();
    }

    private SelenideElement emailElement = $("#email");
    private SelenideElement firstNameElement = $("#firstName");
    private SelenideElement lastNameElement = $("#lastName");
    private SelenideElement passwordElement = $("#password");
    private SelenideElement confirmPasswordElement = $("#confirmPassword");
    private SelenideElement categoryElement = $("#categoryIds");
    private SelenideElement signUpButton = $x("//button[@name='submit']");
    private SelenideElement maleSexRadioButton = $("#male");
    private SelenideElement organizationNameElement = $("#organizationName");
    private SelenideElement positionInOrganizationElement = $("#positionInOrganization");

    // click on "Female" rondo button
    public void clickMaleRondoButon() {
        maleSexRadioButton.click();
        log.info("Sex:Male was chosen.");
    }

    // enter organization random name
    public void inputRandomOrganizationName(String organization) {
        organizationNameElement.setValue(organization);
        log.info("Organization name was written: " + organization);
    }

    //Type partners' occupation
    public NgoSignUpPage inputPosition(String position) {
        positionInOrganizationElement.setValue(position);
        log.info("Position: " + position + " was written.");
        return this;
    }

    // Select category "Programming"
    public void selectProgrammingCategory() {
        Select select = new Select(categoryElement);
        select.selectByIndex(5);
        select.selectByVisibleText("Programming");
        log.info("'Programming' category was chosen");
    }

    // Complete registration. Click Sign Up
    public CongratsNgoPage clickSignUpButton() {
        signUpButton.click();
        log.info("Sign Up button was clicked.");
        return new CongratsNgoPage();
    }

    public void inputEmail(String email) {
        emailElement.setValue(email);
        log.info("Email was written: " + email);
    }

    public void inputFirstName(String firstName) {
        firstNameElement.setValue(firstName);
        log.info("First name was written: " + firstName);
    }

    public void inputLastName(String lastName) {
        lastNameElement.setValue(lastName);
        log.info("Last name was written: " + lastName);
    }

    public void inputPasswords(String password) {
        passwordElement.setValue(password);
        confirmPasswordElement.setValue(password);
        log.info("Password & Confirmation were written");
    }
}
