package ua.foxminded.skarb.tests;

import com.codeborne.selenide.Configuration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.WebDriverRunner.isChrome;

public class BaseTest {

    protected WebDriver driver;
    protected Logger log;

    @BeforeEach
    public void setUp() {
        log = LogManager.getLogger(getClass());
        Configuration.browser = "chrome";
        WebDriver driver = getWebDriver();
        log.info("Create driver: Chrome");
        driver.manage().window().maximize();// Configuration.startMaximized = true;
    }

    @AfterEach
    public void tearDown() {
        log.info("Close driver");
        closeWebDriver();
    }

    public void implicitWait(int seconds) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
    }

    public void sleep(long m) {
        try {
            Thread.sleep(m);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}