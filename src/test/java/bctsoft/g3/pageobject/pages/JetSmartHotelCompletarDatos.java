package bctsoft.g3.pageobject.pages;

import bctsoft.g3.pageobject.base.SeleniumBase;
//import jnr.ffi.annotations.In;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JetSmartHotelCompletarDatos extends SeleniumBase {

    public JetSmartHotelCompletarDatos(WebDriver driver) {
        super(driver);
    }

    WebDriverWait espera = new WebDriverWait(driver, 20);

    private By txtNombre = By.id("firstname");
    private By txtApellido = By.id("lastname");
    private By txtEmail = By.id("email");
    private By txtEmailConfirm = By.id("email_confirm");
    private By rbHuespedPersonal = By.xpath("//span[contains(text(),'Yo soy el huésped principal')]");
    private By btnUltimosDatos = By.xpath("//span[contains(text(),'Siguiente: últimos datos')]");

    public void completarNombreApellido(String nombreApellido)throws InterruptedException{
        String[] nomApe = nombreApellido.split(" ");
        String nombre = nomApe[0]; // Carlos
        String apellido = nomApe[1]; // VanHelsing
        esperaEnSegundosYSendKeys(20,txtNombre,nombre);
        findElement(txtApellido).sendKeys(apellido);
    }
    public void completarEmailYConfirmacion(String email)throws InterruptedException{
        findElement(txtEmail).sendKeys(email);
        findElement(txtEmailConfirm).sendKeys(email);
    }
    public void ClickYoSoyHuespedPrincipalYContinuar()throws InterruptedException{
        findElement(rbHuespedPersonal).click();
        findElement(btnUltimosDatos).click();
        Thread.sleep(1500);
    }



}
