package bctsoft.g3.pageobject.base;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SeleniumBase {

    //atributos
    protected WebDriver driver;

    //Constructor Base
    public SeleniumBase(WebDriver driver) {
        this.driver = driver;
    }

    //Envoltorios Wrapper
    public WebElement findElement(By locator) {
        return driver.findElement(locator);
    }

    public List<WebElement> findElements(By locator) {
        return driver.findElements(locator);
    }

    public String getText(By locator) {
        return driver.findElement(locator).getText();
    }

    public void type(String inputText, By locator) {
        driver.findElement(locator).sendKeys(inputText);
    }
    public void sendKey(Keys key, By locator) {
        driver.findElement(locator).sendKeys(key);
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public void closeDriver() {
        driver.close();
    }

    public Boolean isDisplayed(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public void goBack() {
        driver.navigate().back();
    }

    public void goToUrl(String url) {
        driver.get(url);
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }


    public String getTitle() {
        return driver.getTitle();
    }

    public void switchToIframe(int i){
        driver.switchTo().frame(i);
    }

    public void switchToParentFrame(){
        driver.switchTo().parentFrame();
    }

    public void switchToWindows(int i){
        ArrayList<String> wid = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(wid.get(i));
    }

    public void clearCampoDeTexto(By locator){
        driver.findElement(locator).clear();
    }

    public void esperaEnSegundosYClick(int i,By locator){
        WebDriverWait espera = new WebDriverWait(driver,i);
        espera.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }
    public void esperaEnSegundosYIsDisplayed(int i,By locator){
        WebDriverWait espera = new WebDriverWait(driver,i);
        espera.until(ExpectedConditions.elementToBeClickable(locator)).isDisplayed();
    }
    public void esperaEnSegundosYSendKeys(int i,By locator,String contenido){
        WebDriverWait espera = new WebDriverWait(driver,i);
        espera.until(ExpectedConditions.elementToBeClickable(locator)).sendKeys(contenido);
    }

}
