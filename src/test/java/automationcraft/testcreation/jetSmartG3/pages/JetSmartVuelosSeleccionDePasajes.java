package automationcraft.testcreation.jetSmartG3.pages;

import bctsoft.g3.pageobject.base.SeleniumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JetSmartVuelosSeleccionDePasajes extends SeleniumBase {
    public JetSmartVuelosSeleccionDePasajes(WebDriver driver) {
        super(driver);
    }

    //objetos contenidos en la primera carga de vuelos
    private By seleccionTarifaSinDescuento = By.xpath("//*[@class='text-center nowrap']");
    private By seleccionPaqueteVueloLigero = By.xpath("//div[@class='bundle-container ']/div[@class='bundle-footer']");
    private By btnContinuar = By.cssSelector(".flight-button-container .rounded-primary-btn");

    //Keyword Driven
    public void seleccionarTarifa() {
        esperaEnSegundosYClick(30,seleccionTarifaSinDescuento);
    }

    public void seleccionarPaquete() {
        esperaEnSegundosYClick(30,seleccionPaqueteVueloLigero);
    }

    public void clickContinuar() throws InterruptedException{
        Thread.sleep(2000);
        click(btnContinuar);
    }

}