package bctsoft.g3.testcases;

import bctsoft.g3.pageobject.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HTJS_03 extends TestBase {

    protected JetSmartHomePage jsHomePage;
    protected JetSmartHotelesResultados jsHotelesResults;
    protected JetSmartHotelSeleccionado jsHotelSelected;
    protected JetSmartHotelCompletarDatos jsHotelCompletarDatos;
    protected JetSmartHotelPago jsHotelPago;

    @Test
    public void validarPosicionPreviaReservacion() throws InterruptedException {
        jsHomePage = new JetSmartHomePage(driver);
        jsHotelesResults = new JetSmartHotelesResultados(driver);
        jsHotelSelected = new JetSmartHotelSeleccionado(driver);
        jsHotelCompletarDatos = new JetSmartHotelCompletarDatos(driver);
        jsHotelPago = new JetSmartHotelPago(driver);
        jsHomePage.goToUrl("https://jetsmart.com/cl/es/");
        jsHomePage.cerrarModuloSuscribete();
        jsHomePage.seleccionarPestanaHotel();
        jsHomePage.setTxtInputHotelDestino("Buenos Aires");
        jsHomePage.iniciarBusquedaHotelSmart();
        jsHotelesResults.verHotelDisponible();
        jsHotelSelected.seleccionarHabitantesApartamentoYReservar();
        jsHotelCompletarDatos.completarNombreApellido("Luciano Carmonona");
        jsHotelCompletarDatos.completarEmailYConfirmacion("luciano123@gmail.com");
        jsHotelCompletarDatos.ClickYoSoyHuespedPrincipalYContinuar();
        Assert.assertTrue(jsHotelPago.validarPosicionPago());
    }
}
