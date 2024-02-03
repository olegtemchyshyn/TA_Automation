package ua.foxminded.skarb.pages;

import com.codeborne.selenide.SelenideElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.StaleElementReferenceException;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;

public class BasePageObject {

    private static final Logger log = LogManager.getLogger();

    // Wait for given number of seconds for element with given locator to be visible on the page
    protected void waitElementTillVisibility(SelenideElement element, Integer... timeOutInSeconds) {
        int attempts = 0;
        int timeout = timeOutInSeconds.length > 0 ? timeOutInSeconds[0] : 30; // default to 30 seconds if not specified
        while (attempts < 2) {
            try {
                element.shouldBe(visible, Duration.ofSeconds(timeout));
                break; // Exit loop if successful
            } catch (StaleElementReferenceException e) {
            }
            attempts++;
        }
    }
}