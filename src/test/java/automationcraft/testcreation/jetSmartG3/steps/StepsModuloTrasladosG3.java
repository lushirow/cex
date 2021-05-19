package automationcraft.testcreation.jetSmartG3.steps;

import automationcraft.engine.selenium.DriverFactory;
import automationcraft.testcreation.jetSmartG3.pages.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class StepsModuloTrasladosG3 {

    private JetSmartHomePage jsHomepage = new JetSmartHomePage(DriverFactory.getDriver());
    protected JetSmartTrasladosPage jsTrasladosPage = new JetSmartTrasladosPage(DriverFactory.getDriver());
    protected JetSmartTrasladosInformacion jsTrasladosInformacion = new JetSmartTrasladosInformacion(DriverFactory.getDriver());


    @Given("soy un usuario e ingreso a la web {string}")
    public void que_soy_un_usuario_e_ingreso_a_la_web(String string) throws InterruptedException {
        jsHomepage.goToUrl("https://jetsmart.com/cl/es/");
    }

    @When("ingreso al formulario de Traslados")
    public void ingreso_al_formulario_de_traslados() throws InterruptedException {
        jsHomepage.cerrarModuloSuscribete();
        jsHomepage.seleccionarPestanaTraslados();
        jsHomepage.switchToIframe(2);
    }

    @When("presiono el boton ida")
    public void presiono_el_boton_ida() {
        jsHomepage.seleccionarCheckIdaTraslados();
    }

    @When("ingreso Origen de Traslado {string}")
    public void ingreso_Origen(String string) throws InterruptedException {
        jsHomepage.setTxtInputTrasladosOrigen(string);
    }

    @When("ingreso Destino de Traslado {string}")
    public void ingreso_destino(String string) throws InterruptedException {
        jsHomepage.setTxtInputTrasladosDestino(string);
    }

    @When("ingreso Fecha {string} dias despues de hoy")
    public void ingreso_fecha_dias_despues_de_hoy(String string) {
        int i = Integer.parseInt(string);
        jsHomepage.setSeleccionFechaTraslados(i);
    }

    @When("ingreso Horario {string}")
    public void ingreso_horario(String string) {
        jsHomepage.setSeleccionHorarioTraslados(string);
    }

    @When("ingreso Pasajeros {string}")
    public void ingreso_pasajeros(String string) {
        jsHomepage.setSeleccionPasajerosTraslados(string);
    }

    @When("presiono el boton de Busqueda Traslados")
    public void presiono_el_boton_de_busqueda() throws InterruptedException {
        jsHomepage.iniciarBusquedaTraslados();
        jsHomepage.cambiarAPestanaActual(1);
    }

    @Then("nos aparece una pagina con resultados")
    public void nos_aparece_una_pagina_con_resultados() throws InterruptedException {
        Assert.assertTrue(jsTrasladosPage.checkResultadosArrojados());
    }

    @When("ingreso Horario predeterminado")
    public void ingreso_horario_predeterminado() {
       jsHomepage.setSeleccionHorarioFechaTrasladoMasCercano();
    }

    @Then("nos aparece una pagina sin resultados")
    public void nos_aparece_una_pagina_sin_resultados() throws InterruptedException {
        Assert.assertFalse(jsTrasladosPage.checkResultadosArrojados());
    }

    @When("elijo la opcion {string} de traslados")
    public void elijo_la_opcion_de_traslados(String string) {
        jsTrasladosPage.reservarPrimeraOpcion();
    }

    @When("ingreso Nombre {string}")
    public void ingreso_nombre(String string) {
        jsTrasladosInformacion.llenarCampoNombre(string);
    }

    @When("ingreso y confirmo email {string}")
    public void ingreso_email(String string) {
        jsTrasladosInformacion.llenarYConfirmarEmail(string);
    }


    @When("ingreso Numero de telefono {string}")
    public void ingreso_numero_de_telefono(String string) {
        jsTrasladosInformacion.llenarCampoTelefono(string);
    }

    @When("ingreso Numero de vuelo {string}")
    public void ingreso_numero_de_vuelo(String string) throws InterruptedException {
        jsTrasladosInformacion.llenarCampoNumeroDeVuelo(string);
    }

    @When("presiono el boton Resultados")
    public void presiono_el_boton_resultados() throws InterruptedException {
        jsTrasladosInformacion.volverAResultados();
    }

    @Then("se muestran los datos de busquedas iniciales a la izquierda de la pagina")
    public void se_muestran_los_datos_de_busquedas_iniciales_a_la_izquierda_de_la_pagina() throws InterruptedException {
        Assert.assertTrue(jsTrasladosPage.checkTransporteIdaYVuelta("Buenos Aires", "Buenos Aires"));
    }

}
