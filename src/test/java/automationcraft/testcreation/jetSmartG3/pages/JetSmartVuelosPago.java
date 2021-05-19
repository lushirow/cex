package automationcraft.testcreation.jetSmartG3.pages;

import bctsoft.g3.pageobject.base.SeleniumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JetSmartVuelosPago extends SeleniumBase {
    public JetSmartVuelosPago(WebDriver driver){
        super(driver);
    }
    //objetos
    private By containerPagaTuReserva = By.xpath("//h2[contains(text(),'Paga Tu Reserva')]");

    //keyword Driven
    public boolean existeContainerPagatuReserva() throws InterruptedException{
        Thread.sleep(3000);
        if (isDisplayed(containerPagaTuReserva)){
            return true;
        }else{
            return false;
        }
    }
}
