package ua.foxminded.skarb.pages;

import com.codeborne.selenide.SelenideElement;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.Select;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class PartnersSignUpPage extends BasePageObject {

    public PartnersSignUpPage() {
        super();
    }

    private SelenideElement signUpButton = $x("//button[@name='submit']");
    private SelenideElement emailElement = $("#email");
    private SelenideElement firstNameElement = $("#firstName");
    private SelenideElement lastNameElement = $("#lastName");
    private SelenideElement femaleSexRadioButton = $("#female");
    private SelenideElement passwordElement = $("#password");
    private SelenideElement confirmPasswordElement = $("#confirmPassword");
    private SelenideElement organizationNameElement = $("#organizationName");
    private SelenideElement categoryElement = $("select#categoryIds");
    private SelenideElement positionInOrganizationElement = $("#positionInOrganization");

    // Enter random email
    public void inputRandomEmail(String email) {
        emailElement.setValue(email);
        log.info("Email was written: " + email);
    }

    // enter random first name
    public void inputRandomFirstName(String firsName) {
        firstNameElement.setValue(firsName);
        log.info("First name was written: " + firsName);
    }

    // enter random last name
    public void inputRandomLastName(String lastName) {
        lastNameElement.setValue(lastName);
        log.info("Last name was written: " + lastName);
    }

    // click on "Female" rondo button
    public void clickFemaleRondoButon() {
        femaleSexRadioButton.click();
        log.info("Sex:Female was chosen.");
    }

    // enter password and confirmation
    public void inputRandomPasswords(String password) {
        passwordElement.setValue(password);
        confirmPasswordElement.setValue(password);
        log.info("Password & Confirmation were written.");
    }

    // enter organization random name
    public void inputRandomOrganizationName(String organization) {
        organizationNameElement.setValue(organization);
        log.info("Organization name was written: " + organization);
    }

    // Select category "Programming"
    public void selectProgrammingCategory() {
        Select select = new Select(categoryElement);
        select.selectByIndex(5);
        select.selectByVisibleText("Programming");
        log.info("'Programming' category was chosen.");
    }

    //Type partners' occupation
    public PartnersSignUpPage inputPosition(String position) {
        positionInOrganizationElement.setValue(position);
        log.info("Position: " + position + " was written.");
        return this;
    }

    //fill application with one method
    public PartnersSignUpPage fillRegistrationForm(String email, String firstName, String lastName, String password, String organization) {
        inputRandomEmail(email);
        inputRandomFirstName(firstName);
        inputRandomLastName(lastName);
        clickFemaleRondoButon();
        inputRandomPasswords(password);
        inputRandomOrganizationName(organization);
        selectProgrammingCategory();
        return this;
    }

    // Complete registration. Click Sign Up
    public CongratsNgoPage clickSignUpButton() {
        signUpButton.click();
        log.info("Sign Up button was clicked");
        return new CongratsNgoPage();
    }
}
