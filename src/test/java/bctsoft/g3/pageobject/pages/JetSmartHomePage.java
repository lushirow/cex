package bctsoft.g3.pageobject.pages;

import bctsoft.g3.pageobject.base.SeleniumBase;
//import jnr.ffi.annotations.In;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class JetSmartHomePage extends SeleniumBase {

    public JetSmartHomePage(WebDriver driver) {
        super(driver);
    }

    //repositorio de objetos que vamos a utilizar de JetSmart
    private By btnPopUpClose = By.xpath("//div[@class='modal-header']//button[@type='button']");
    //repositorio de la pestaña vuelos
    private By txtInputVuelosOrigen = By.xpath("//div/input[@placeholder='Origen']");
    private By seleccionInputVuelosOrigen = By.xpath("//ul[@class='dg-typing-results-list']/li[contains(text(),'')]");
    private By txtInputVuelosDestino = By.xpath("//div/input[@placeholder='Destino']");
    private By seleccionInputVuelosDestino = By.xpath("//ul[@class='dg-typing-results-list']/li[contains(text(),'')]");
    private By checkIdaVuelos = By.xpath("//label[contains(text(),'Solo Ida')]");
    private By btnIdaVuelosCalendario = By.xpath("//div/input[@ref='fromDateElem']");
    private By seleccionFechaIdaVuelosCalendario = By.xpath("//span[@aria-label='']");
    private By txtInputCodigoPromocionalVuelos = By.xpath("//input[@id='rt_input']");
    private By contieneTextoAlertaVuelos = By.xpath("//span[contains(text(),'El código ingresado no es válido, por favor intent')]");
    private By btnBusquedaSmartVuelos = By.xpath("//button[@id='rt_button']");
    //repositorio de la pestaña hoteles (glosario: ninos = Niños ; pestania = Pestaña
    private By seleccionPestaniaHotel = By.xpath("//ul/li/label[@for='sbHotels']");
    private By txtInputHotelDestino = By.id("b_destination");
    private By seleccionCantidadNinosHotel = By.id("select_children");
    private By btnBusquedaHotel = By.xpath("//*/input[@name='submit']");
    //repositorio de la pestaña Traslados / glosario: Pestania = Pestaña
    private By seleccionPestaniaTraslados = By.xpath("//span[contains(text(),'Traslados')]");
    private By checkIdaTraslados = By.xpath("//span[contains(@ng-bind,'labelOneWay')]");
    private By txtInputTrasladosOrigen = By.id("input-pickup");
    private By seleccionInputTrasladosOrigen = By.xpath("//span[contains(text(),'')");
    private By txtInputTrasladosDestino = By.id("input-dropoff");
    private By seleccionInputTrasladosDestino = By.xpath("//span[contains(text(),'')");
    private By seleccionFechaTraslados = By.id("input-pickup-date");
    private By seleccionHorarioTraslados = By.id("ct-time-picker-pick-up-option-container");
    private By checkHorarioTraslados = By.xpath("//*[contains(@aria-label,'')]");
    private By seleccionPasajerosTraslados = By.xpath("//ul[contains(@class,'ct-list-container')]");
    private By checkPasajerosTraslados = By.xpath("//li[contains(text(),'')]");
    private By btnBusquedaTraslados = By.xpath("//button[contains(@ct-tracking,'Search')]");
    private By dropdownPasajerosTraslados = By.xpath("//*[@id=\"ct-passengers-list\"]/div/div[2]/ct-age-picker/div/div/div/ul/li/ul/li");

    //keyword Driven
    public void cerrarModuloSuscribete() throws InterruptedException {
        if (isDisplayed(btnPopUpClose)) {
            Thread.sleep(3000);
            esperaEnSegundosYClick(30, btnPopUpClose);
        }
    }

    public void setTxtInputVuelosOrigen(String origen) {
        this.seleccionInputVuelosOrigen = By.xpath("//ul[@class='dg-typing-results-list']/li[contains(text(),'" + origen + "')]");
        click(txtInputVuelosOrigen);
        type(origen, txtInputVuelosOrigen);
        click(seleccionInputVuelosOrigen);
    }

    public void setTxtInputVuelosDestino(String destino) throws InterruptedException {
        this.seleccionInputVuelosDestino = By.xpath("//ul[@class='dg-typing-results-list']/li[contains(text(),'" + destino + "')]");
        click(txtInputVuelosDestino);
        type(destino, txtInputVuelosDestino);
        click(seleccionInputVuelosDestino);
        Thread.sleep(3000);
    }

    public void setCheckIdaVuelos() throws InterruptedException {
        click(checkIdaVuelos);
        Thread.sleep(3000);
    }

    public void abrirCalendarioIdaVuelos() throws InterruptedException {
        click(btnIdaVuelosCalendario);
        Thread.sleep(3000);
    }

    public void setFechaDeIdaEnVuelosCalendario(String fecha) {
        this.seleccionFechaIdaVuelosCalendario = By.xpath("//span[@aria-label='" + fecha + "']");
        esperaEnSegundosYClick(30, seleccionFechaIdaVuelosCalendario);

    }

    public void setTxtInputCodigoPromocionalVuelos(String codigoPromocional) {
        type(codigoPromocional, txtInputCodigoPromocionalVuelos);
    }

    public boolean validarAlertaDeError() throws InterruptedException {
        Thread.sleep(2000);
        if (isDisplayed(contieneTextoAlertaVuelos)) {
            return true;
        } else {
            return false;
        }
    }

    public void iniciarBusquedaSmart() {
        click(btnBusquedaSmartVuelos);
    }


    ///////////////////////////////////////////////////////////////////////////////
    public void seleccionarPestanaHotel() {
        click(seleccionPestaniaHotel);
    }

    public void setTxtInputHotelDestino(String destino) {
        switchToIframe(0);
        click(txtInputHotelDestino);
        clearCampoDeTexto(txtInputHotelDestino);
        type(destino, txtInputHotelDestino);
    }

    public void setSeleccionCantidadNinosHotel(String cantidadNinos) {
        click(seleccionCantidadNinosHotel);
        type(cantidadNinos, seleccionCantidadNinosHotel);
    }

    public void iniciarBusquedaHotelSmart() throws InterruptedException {
        click(btnBusquedaHotel);
        switchToParentFrame();
        switchToWindows(1);
        Thread.sleep(5000);
    }
//////////////////////////////////////////////////////////////////////////////////////////////

    public void seleccionarPestanaTraslados() {
        click(seleccionPestaniaTraslados);
    }

    public void seleccionarCheckIdaTraslados() {
        click(checkIdaTraslados);
    }

    public void setTxtInputTrasladosOrigen(String origen) {
        this.seleccionInputTrasladosOrigen = By.xpath("//span[contains(text(),'" + origen + "')]");
        click(txtInputTrasladosOrigen);
        type(origen, txtInputTrasladosOrigen);
        click(seleccionInputTrasladosOrigen);
    }

    public void setTxtInputTrasladosDestino(String destino) {
        this.seleccionInputTrasladosDestino = By.xpath("//span[contains(text(),'" + destino + "')]");
        click(txtInputTrasladosDestino);
        type(destino, txtInputTrasladosDestino);
        click(seleccionInputTrasladosDestino);
    }

    public void setSeleccionFechaTraslados(int dias) {
        if (dias > 0) {
            for (int i = 0; i < dias; i++) {
                sendKey(Keys.ARROW_RIGHT, seleccionFechaTraslados);
            }
        }
        sendKey(Keys.ENTER, seleccionFechaTraslados);
    }

    public void setSeleccionHorarioTraslados(String horarioTraslados) {
        this.checkHorarioTraslados = By.xpath("//*[contains(@aria-label,'" + horarioTraslados + "')]");
        click(checkHorarioTraslados);
    }

    public void setSeleccionHorarioFechaTrasladoMasCercano() {
        sendKey(Keys.ENTER, seleccionFechaTraslados);
    }

    public void setSeleccionPasajerosTraslados(String pasajerosTraslados) {
        this.checkPasajerosTraslados = By.xpath("//li[contains(text(),'" + pasajerosTraslados + "')]");
        List<WebElement> pasajerosList = this.findElements(dropdownPasajerosTraslados);
        for (int i = 0; i < pasajerosList.size(); i++) {
            WebElement pasajero = pasajerosList.get(i);
            if (pasajero.getText().contains(pasajerosTraslados)) {
                pasajero.click();
                break;
            }
        }
    }

    public void iniciarBusquedaTraslados()throws InterruptedException {
        click(btnBusquedaTraslados);
        Thread.sleep(4000);
    }

    public void cambiarAPestanaActual(int i) throws InterruptedException{
        this.switchToParentFrame();
        this.switchToWindows(i);
        Thread.sleep(10000);
    }
}
