package automationcraft.testcreation.cex.pages;

import automationcraft.engine.selenium.SeleniumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AutomationPracticeHomePage extends SeleniumBase {
    public AutomationPracticeHomePage(WebDriver driver) {super(driver);}

    private By btnSignIn = By.xpath("//a[contains(text(),'Sign in')]");

    public void clickButtonSignIn() {
        click(btnSignIn);
    }
}

