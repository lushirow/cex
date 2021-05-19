package bctsoft.g3.testcases;

import bctsoft.g3.pageobject.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TTJS_02 extends TestBase{
    protected JetSmartHomePage jsHomePage;
    protected JetSmartTrasladosPage jsTrasladosPage;

    @Test
    public void busquedaTrasladosNoEncontrados() throws InterruptedException {
        jsHomePage = new JetSmartHomePage(driver);
        jsTrasladosPage = new JetSmartTrasladosPage(driver);
        jsHomePage.goToUrl("https://www.jetsmart.com/cl/es/");
        jsHomePage.cerrarModuloSuscribete();
        jsHomePage.seleccionarPestanaTraslados();
        jsHomePage.switchToIframe(2);
        jsHomePage.seleccionarCheckIdaTraslados();
        jsHomePage.setTxtInputTrasladosOrigen("Buenos Aires");
        jsHomePage.setTxtInputTrasladosDestino("Buenos Aires");
        jsHomePage.setSeleccionHorarioFechaTrasladoMasCercano();
        jsHomePage.iniciarBusquedaTraslados();
        jsHomePage.cambiarAPestanaActual(1);
        Assert.assertFalse(jsTrasladosPage.checkResultadosArrojados());
    }
}
