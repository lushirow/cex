package automationcraft.testcreation.cex.pages;

import automationcraft.engine.selenium.SeleniumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AutomationPacticeSignInPage extends SeleniumBase {
    public AutomationPacticeSignInPage(WebDriver driver) {super(driver);}

    private By inputEmailAddress= By.xpath("//input[@id='email_create']");

    public void fillInputEmail(String email) {

    }
}
