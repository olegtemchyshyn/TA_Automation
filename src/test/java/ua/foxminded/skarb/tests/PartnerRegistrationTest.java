package ua.foxminded.skarb.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ua.foxminded.skarb.pages.*;
import ua.foxminded.skarb.testdata.DataGenerator;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PartnerRegistrationTest extends BaseTest {
    @Test
    public void registerPartner() {
        log.info("Starting register a Partner");

        //Open Home page URL. Click Plus Button
        Configuration.baseUrl = "https://skarb.foxminded.ua";
        open("/");
        assertEquals(Configuration.baseUrl, url());
        log.info("Page was opened");

        String organization = DataGenerator.companyNameGenerator(4);
        String firstName = DataGenerator.dataGenerator(5);
        String lastName = DataGenerator.dataGenerator(6);
        String password = DataGenerator.generatePassword();
        String email = firstName + "." + lastName + DataGenerator.domainCorporate();

        new HomePage(log)
                .clickPlusButton()
                .clickPartnerButton();

        new PartnersSignUpPage(log)
                .fillRegistrationForm(email, firstName, lastName, password, organization)
                .inputPosition("Manager")
                .clickSignUpButton();
        log.info("Partners registration form was filled in");

        // Verification
        WebElement successContent = driver.findElement(By.id("content"));
        Assertions.assertTrue(successContent.isDisplayed(), "Success message is not present on the page");
        CongratsNgoPage congratsNgoPage = new CongratsNgoPage(log);
        congratsNgoPage.switchToMailHog();

        //Clicking on confirmation link. Congratulation message!
        MailHogPage mailHogPage = new MailHogPage(log);
        mailHogPage.waitForEmail(email);
        mailHogPage.clickConfirmationLink();
        NewConfirmationPage newConfirmationPage = new NewConfirmationPage(log);
        newConfirmationPage.switchToLastTab();
        newConfirmationPage.waitForConfirmationMessage();

        //Verification
        String pageSource = newConfirmationPage.getConfirmationMessage().getText();
        Assertions.assertTrue(pageSource.contains("Your email confirmed!"), "Email has not been confirmed");
        log.info("Your email was confirmed. Congratulation!");
    }

}

