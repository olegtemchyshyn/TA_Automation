package ua.foxminded.skarb.pages;

import com.codeborne.selenide.SelenideElement;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class VolunteersSignUpPage extends BasePageObject {

    private SelenideElement emailElement = $("email");
    private SelenideElement firstNameElement = $("firstName");
    private SelenideElement lastNameElement = $("lastName");
    private SelenideElement passwordElement = $("password");
    private SelenideElement confirmPasswordElement = $("confirmPassword");
    private SelenideElement categoryElement = $("categories");
    private SelenideElement signUpButton = $x("//button[@name='submit']");

    public VolunteersSignUpPage(Logger log) {
        super(log);

    }

    public void inputEmail(String email) {
        emailElement.setValue(email);
        log.info("Email was written: " + email);
    }

    // enter first name
    public void inputFirstName(String firstName) {
        firstNameElement.clear();
        firstNameElement.setValue(firstName);
        log.info("First name was written: " + firstName);
    }

    // enter last name
    public void inputLastName(String lastName) {
        lastNameElement.clear();
        lastNameElement.setValue(lastName);
        log.info("Last name was written: " + lastName);
    }

    // enter password and confirmation
    public void inputPasswords(String password) {
        passwordElement.setValue(password);
        confirmPasswordElement.setValue(password);
        log.info("Password & Confirmation were written");
    }

    // Select category "Programming"
    public void selectProgrammingCategory() {
        Select select = new Select(categoryElement);
        select.selectByIndex(4);
        select.selectByVisibleText("Programming");
        log.info("'Programming' category was chosen");
    }

    // Complete registration. Click Sign Up
    public CongratsNgoPage clickSignUpButton() {
        signUpButton.click();
        log.info("Sign Up button was clicked.");
        return new CongratsNgoPage(log);
    }
}
