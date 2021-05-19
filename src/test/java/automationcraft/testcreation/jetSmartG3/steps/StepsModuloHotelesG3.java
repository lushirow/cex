package automationcraft.testcreation.jetSmartG3.steps;

import automationcraft.engine.selenium.DriverFactory;
import automationcraft.testcreation.jetSmartG3.pages.*;
import bctsoft.g3.pageobject.pages.JetSmartHotelPago;
import io.cucumber.java.en.*;
import org.testng.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepsModuloHotelesG3 {

    protected JetSmartHomePage jsHomePage = new JetSmartHomePage(DriverFactory.getDriver());
    protected JetSmartHotelesResultados jsHotelesResults =  new JetSmartHotelesResultados(DriverFactory.getDriver());
    protected JetSmartHotelSeleccionado  jsHotelSelected = new JetSmartHotelSeleccionado(DriverFactory.getDriver());;
    protected JetSmartHotelCompletarDatos jsHotelCompletarDatos = new JetSmartHotelCompletarDatos(DriverFactory.getDriver());;
    protected JetSmartHotelPago jsHotelPago =  new JetSmartHotelPago(DriverFactory.getDriver());;


    @When("Ingreso al formulario de Hoteles")
    public void ingresoAlFormularioDeHoteles() throws InterruptedException{
        jsHomePage.goToUrl("https://jetsmart.com/cl/es/");
        jsHomePage.cerrarModuloSuscribete();
        jsHomePage.seleccionarPestanaHotel();
    }


    @And("Ingreso el destino")
    public void ingresoElDestino() {
        jsHomePage.setTxtInputHotelDestino("Buenos Aires");
    }

    @And("Ingreso fecha de entrada y salida")
    public void ingresoFechaDeEntradaYSalida() {

    }

    @And("Agrego un niño")
    public void agregoUnNiño() {
        jsHomePage.setSeleccionCantidadNinosHotel("1");
    }

    @And("Hago click en busqueda smart")
    public void hagoClickEnBusquedaSmart() throws  InterruptedException{
        jsHomePage.iniciarBusquedaHotelSmart();
    }

    @And("Selecciono el primer hotel disponible")
    public void seleccionoElPrimerHotelDisponible() throws InterruptedException{
        jsHotelesResults.verHotelDisponible();
    }

    @Then("Aparece el hotel seleccionado")
    public void apareceElHotelSeleccionado() throws InterruptedException {
        Assert.assertTrue(jsHotelesResults.verificarResultadoPagina());
    }


    @And("Selecciono el apartamento")
    public void seleccionoElApartamento() throws InterruptedException{
        jsHotelesResults.verHotelDisponible();
    }


    @And("Aplico filtros de busqueda")
    public void aplicoFiltrosDeBusqueda()throws InterruptedException{
        jsHotelesResults.aplicarFiltroDesayunoIncluido();
        jsHotelesResults.aplicarFiltroDeEstrellas("3 estrellas");
    }

    @Then("Comprobamos que estamos en la pagina que queremos con los filtros seleccionados")
    public void comprobamosQueEstamosEnLaPaginaQueQueremosConLosFiltrosSeleccionados() throws InterruptedException{
        Assert.assertTrue(jsHotelSelected.validarEstrellasyPopularidad());
    }

    @And("Selecciono los habitantes del apartamento y reservo")
    public void seleccionoLosHabitantesDelApartamentoYReservo() throws InterruptedException{
        jsHotelSelected.seleccionarHabitantesApartamentoYReservar();
    }

    @Then("Comprobamos que estamos en la pagina que queremos")
    public void comprobamosQueEstamosEnLaPaginaQueQueremos() throws InterruptedException{
        Assert.assertTrue(jsHotelPago.validarPosicionPago());
    }

    @And("Selecciono los habitantes del apartamento y hago click en reservar")
    public void seleccionoLosHabitantesDelApartamentoYHagoClickEnReservar() throws InterruptedException {
        jsHotelSelected.seleccionarHabitantesApartamentoYReservar();
    }

    @And("Lleno todos los datos personales")
    public void llenoTodosLosDatosPersonales() throws InterruptedException {
        jsHotelCompletarDatos.completarNombreApellido("Luciano Carmonona");
        jsHotelCompletarDatos.completarEmailYConfirmacion("luciano123@gmail.com");
        jsHotelCompletarDatos.ClickYoSoyHuespedPrincipalYContinuar();
    }
}
