package ua.foxminded.skarb.pages;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.WindowType;
import org.apache.logging.log4j.Logger;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.switchTo;

public class CongratsNgoPage extends BasePageObject {

    public CongratsNgoPage(Logger log) {
        super(log);

    }

    //Open new tab
    public MailHogPage switchToMailHog() {
        String initHandle = switchTo().getWindowHandle();
        switchTo().newWindow(WindowType.TAB);
        open("https://skarbmail.foxminded.ua/");
        log.info("Mail tab was open");
        return new MailHogPage(log);
    }

}
