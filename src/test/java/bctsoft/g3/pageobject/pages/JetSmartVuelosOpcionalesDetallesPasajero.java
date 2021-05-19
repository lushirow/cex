package bctsoft.g3.pageobject.pages;

import bctsoft.g3.pageobject.base.SeleniumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JetSmartVuelosOpcionalesDetallesPasajero extends SeleniumBase {
    public JetSmartVuelosOpcionalesDetallesPasajero(WebDriver driver){
        super(driver);
    }
    //objetos
    private String NombreYApellido="", FechaDeNacimiento="";
    private By txtInputNombrePasajero = By.id("Pfn0");
    private By txtInputApellidoPasajero= By.id("Pln0");
    private By txtInputDiaDeNacimiento= By.id("date_of_birth_day_0");
    private By txtInputMesDeNacimiento=By.id("date_of_birth_month_0");
    private By txtInputAnoDeNacimiento=By.id("date_of_birth_year_0");
    private By btnContinuar=By.cssSelector(".passengers-button-container .rounded-primary-btn");

    //keyword Driven
    public void escribirNombreApellido(String nombreYApellido){
        String[] SplitNombreYApellido = nombreYApellido.split(" ");
        type(SplitNombreYApellido[0],txtInputNombrePasajero);
        type(SplitNombreYApellido[1],txtInputApellidoPasajero);
    }
    public void escribirFechaDeNacimiento(String fechaDeNacimiento){
        String[] SplitFechaDeNacimiento = fechaDeNacimiento.split("-");
        type(SplitFechaDeNacimiento[0],txtInputDiaDeNacimiento);
        type(SplitFechaDeNacimiento[1],txtInputMesDeNacimiento);
        type(SplitFechaDeNacimiento[2],txtInputAnoDeNacimiento);
    }
    public void clickContinuar(){
        click(btnContinuar);
    }
}
