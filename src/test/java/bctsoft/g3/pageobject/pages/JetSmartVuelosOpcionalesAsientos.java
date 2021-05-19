package bctsoft.g3.pageobject.pages;

import bctsoft.g3.pageobject.base.SeleniumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JetSmartVuelosOpcionalesAsientos extends SeleniumBase {
    public JetSmartVuelosOpcionalesAsientos(WebDriver driver){
        super(driver);
    }
    //objetos
    private By btnCerrarModalAsientos = By.cssSelector(".modal-content .close");
    private By btnNoQuieroElegirAsientos= By.xpath("//div[@class='seatmap-button-container']/button[contains(text(),'No quiero elegir asientos')]");

    //keyword Driven
    public void cerrarModalDeAsientos(){
        esperaEnSegundosYClick(30,btnCerrarModalAsientos);
    }
    public void clickNoQuieroElegirAsientos() throws InterruptedException{
        Thread.sleep(2000);
        click(btnNoQuieroElegirAsientos);
    }
}
