package bctsoft.g3.pageobject.pages;

import bctsoft.g3.pageobject.base.SeleniumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JetSmartVuelosOpcionalesExtras extends SeleniumBase {
    public JetSmartVuelosOpcionalesExtras(WebDriver driver){
        super(driver);
    }
    //objetos
    private By checkBtnLlevareMiTarjetaDeEmbargue = By.xpath("//span[@class='mdl-checkbox__label label cb-amount-label']/span[contains(text(),'Llevaré mi tarjeta de embarque')]");
    private By btnContinuar = By.xpath("//form[@id='extrasForm']/div[@class='flex justify-end']/button[contains(text(),'Continuar')]");
    private By btnCerrarModalSeguroDeViaje = By.cssSelector("*.modal.extras-insurance-covid-modal div.modal-content > button");

    //keyword Driven
    public void seleccionarLlevarTarjetaDeEmbargue(){
        esperaEnSegundosYClick(30,checkBtnLlevareMiTarjetaDeEmbargue);
    }
    public void clickContinuar(){
        click(btnContinuar);
    }
    public void cerrarModalSeguroDeViaje(){
        esperaEnSegundosYClick(30,btnCerrarModalSeguroDeViaje);
    }
}
