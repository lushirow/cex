package automationcraft.testcreation.jetSmartG3.pages;

import bctsoft.g3.pageobject.base.SeleniumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JetSmartTrasladosInformacion extends SeleniumBase {
    public JetSmartTrasladosInformacion(WebDriver driver) {
        super(driver);
    }

    //repositorio de objetos que vamos a utilizar de JetSmart
    private By inputNombre = By.id("gt-customer-name");
    private By inputEmail = By.id("gt-customer-email");
    private By inputConfirmEmail = By.id("gt-customer-confirm-email");
    private By inputMobileNumber = By.id("gt-customer-mobile-number");
    private By inputFlightNumber = By.id("gt-pickup-flight-number");
    private By btnIrACaja = By.xpath("//button[contains(text(),'Ir a caja')]");
    private By btnResultados = By.xpath("//*[contains(text(),'Resultados')]");

    //keyword Driven
    public void llenarCampoNombre(String nombre) {
        click(inputNombre);
        type(nombre, inputNombre);
    }
    public void llenarYConfirmarEmail(String email) {
        click(inputEmail);
        type(email, inputEmail);
        click(inputConfirmEmail);
        type(email, inputConfirmEmail);
    }
    public void llenarCampoTelefono(String telefono) {
        click(inputMobileNumber);
        type(telefono, inputMobileNumber);
    }
    public void llenarCampoNumeroDeVuelo(String vuelo) throws InterruptedException{
        click(inputFlightNumber);
        type(vuelo, inputFlightNumber);
        Thread.sleep(5000);
    }

    public void irACaja(){
        click(btnIrACaja);
    }

    public void volverAResultados()throws InterruptedException{
        goBack();
    }
}