package bctsoft.g3.testcases;

import bctsoft.g3.pageobject.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TTJS_03 extends TestBase{
    protected JetSmartHomePage jsHomePage;
    protected JetSmartTrasladosPage jsTrasladosPage;
    protected JetSmartTrasladosInformacion jsTrasladosInformacion;

    @Test
    public void busquedaTrasladosChequeoDeValoresIniciales() throws InterruptedException {
        jsHomePage = new JetSmartHomePage(driver);
        jsTrasladosPage = new JetSmartTrasladosPage(driver);
        jsTrasladosInformacion = new JetSmartTrasladosInformacion(driver);
        jsHomePage.goToUrl("https://www.jetsmart.com/cl/es/");
        jsHomePage.cerrarModuloSuscribete();
        jsHomePage.seleccionarPestanaTraslados();
        jsHomePage.switchToIframe(2);
        jsHomePage.seleccionarCheckIdaTraslados();
        jsHomePage.setTxtInputTrasladosOrigen("Buenos Aires");
        jsHomePage.setTxtInputTrasladosDestino("Buenos Aires");
        jsHomePage.setSeleccionFechaTraslados(5);
        jsHomePage.setSeleccionHorarioTraslados("12:00 AM");
        jsHomePage.setSeleccionPasajerosTraslados("1");
        jsHomePage.iniciarBusquedaTraslados();
        jsHomePage.cambiarAPestanaActual(1);
        jsTrasladosPage.reservarPrimeraOpcion();
        jsTrasladosInformacion.llenarCampoNombre("Christian Bale");
        jsTrasladosInformacion.llenarYConfirmarEmail("Christian@gmail.com");
        jsTrasladosInformacion.llenarCampoTelefono("3804141414");
        jsTrasladosInformacion.llenarCampoNumeroDeVuelo("AB123");
        jsTrasladosInformacion.volverAResultados();
        Assert.assertTrue(jsTrasladosPage.checkTransporteIdaYVuelta("Buenos Aires", "Buenos Aires"));
    }
}
