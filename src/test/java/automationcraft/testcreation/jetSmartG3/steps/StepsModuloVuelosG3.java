package automationcraft.testcreation.jetSmartG3.steps;

import automationcraft.engine.selenium.DriverFactory;
import automationcraft.testcreation.jetSmartG3.pages.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class StepsModuloVuelosG3 {

    private JetSmartHomePage jsHomepage = new JetSmartHomePage(DriverFactory.getDriver());
    private JetSmartVuelosSeleccionDePasajes jsSeleccionPasajes = new JetSmartVuelosSeleccionDePasajes(DriverFactory.getDriver());
    private JetSmartVuelosOpcionalesDetallesPasajero jsDetallesPasajeros = new JetSmartVuelosOpcionalesDetallesPasajero(DriverFactory.getDriver());
    private JetSmartVuelosOpcionalesEquipaje jsEquipaje = new JetSmartVuelosOpcionalesEquipaje(DriverFactory.getDriver());
    private JetSmartVuelosOpcionalesAsientos jsAsientos = new JetSmartVuelosOpcionalesAsientos(DriverFactory.getDriver());
    private JetSmartVuelosOpcionalesExtras jsExtras = new JetSmartVuelosOpcionalesExtras(DriverFactory.getDriver());
    private JetSmartVuelosPago jsPago = new JetSmartVuelosPago(DriverFactory.getDriver());

    @Given("que soy un usuario e ingreso a la web {string}")
    public void que_soy_un_usuario_e_ingreso_a_la_web(String string) throws InterruptedException {
        jsHomepage.goToUrl("https://jetsmart.com/cl/es/");
    }
    @When("ingreso al formulario de Vuelos")
    public void ingreso_al_formulario_de_vuelos() throws InterruptedException {
        jsHomepage.cerrarModuloSuscribete();
    }
    @When("ingreso Origen {string}")
    public void ingreso_Origen(String string){
        jsHomepage.setTxtInputVuelosOrigen("Santiago");
    }
    @When("ingreso Destino {string}")
    public void ingreso_destino(String string) throws InterruptedException {
        jsHomepage.setTxtInputVuelosDestino("Buenos Aires");
    }

    @When("selecciono la opcion de viaje solo ida")
    public void selecciono_la_opcion_de_viaje_solo_ida() throws InterruptedException {
        jsHomepage.setCheckIdaVuelos();
    }

    @When("ingreso la {string} de ida en el Calendario")
    public void ingreso_la_de_ida_en_el_calendario(String string) throws InterruptedException {
        jsHomepage.abrirCalendarioIdaVuelos();
        jsHomepage.setFechaDeIdaEnVuelosCalendario("Junio 28, 2021");
    }

    @When("ingreso un {string} promocional")
    public void ingreso(String string) {
        jsHomepage.setTxtInputCodigoPromocionalVuelos("VUELOS2021OKEY");
    }

    @When("presiono el boton Busqueda Smart")
    public void presiono_el_boton_busqueda_smart() {
        jsHomepage.iniciarBusquedaSmart();
    }

    @Then("aparece alerta de codigo promocional no valido")
    public void aparece_alerta_de_codigo_promocional_no_valido() throws InterruptedException {
        Assert.assertTrue(jsHomepage.validarAlertaDeError());
    }
    @When("selecciono el paquete mas barato")
    public void selecciono_el_paquete_mas_barato() throws InterruptedException {
        jsSeleccionPasajes.seleccionarTarifa();
        jsSeleccionPasajes.seleccionarPaquete();
        jsSeleccionPasajes.clickContinuar();
    }

    @When("relleno los datos del pasajero con el {string} y la {string}")
    public void relleno_los_datos_del_pasajero_con_el_y_la(String string, String string2) {
        jsDetallesPasajeros.escribirNombreApellido("Carlos VanHelsing");
        jsDetallesPasajeros.escribirFechaDeNacimiento("30-09-1990");
        jsDetallesPasajeros.clickContinuar();
    }

    @Then("aparece la opcion de modificar la reserva")
    public void aparece_la_opcion_de_modificar_la_reserva(){
        Assert.assertTrue(jsEquipaje.ModificarReserva());
    }

    @When("selecciono el equipaje")
    public void selecciono_el_equipaje() {
        jsEquipaje.seleccionEquipaje();
        jsEquipaje.clickContinuar();
    }

    @When("presiono el boton No quiero elegir Asientos")
    public void presiono_el_boton_no_quiero_elegir_asientos() throws InterruptedException {
        jsAsientos.cerrarModalDeAsientos();
        jsAsientos.clickNoQuieroElegirAsientos();
    }

    @When("selecciono llevar tarjeta de Embargue")
    public void selecciono_llevar_tarjeta_de_embargue() {
        jsExtras.seleccionarLlevarTarjetaDeEmbargue();
        jsExtras.clickContinuar();
        jsExtras.cerrarModalSeguroDeViaje();
    }

    @Then("aparece el formulario de pago")
    public void aparece_el_formulario_de_pago() throws InterruptedException {
        Assert.assertTrue(jsPago.existeContainerPagatuReserva());
    }

}
