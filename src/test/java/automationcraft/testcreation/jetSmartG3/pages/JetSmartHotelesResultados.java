package automationcraft.testcreation.jetSmartG3.pages;

import bctsoft.g3.pageobject.base.SeleniumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JetSmartHotelesResultados extends SeleniumBase {

    public JetSmartHotelesResultados(WebDriver driver) {
        super(driver);
    }

    WebDriverWait espera = new WebDriverWait(driver, 20);

    private By btnFiltroEstrellas = By.xpath("//div[@class='bui-checkbox__label filter_item css-checkbox']/span[contains(text(),'')]");
    private By btnFiltroDesayunoInlcuido = By.xpath("//div[@class='bui-checkbox__label filter_item css-checkbox']/span[contains(text(),'Desayuno incluido')]");
    private By btnVerDisponibilidad = By.xpath("//span[@class='bui-button__text js-sr-cta-text']");

    private By txtResultados = By.xpath("//*[@class='bui-breadcrumb__text'][contains(text(),'Resultados de la búsqueda')]");
    private By txtPersonas = By.xpath("//*[contains(text(),'1 noche, 1 adulto, 1 niño')]");

    public void verPrimerHotelDisponible() {
        espera.until(ExpectedConditions.elementToBeClickable(btnVerDisponibilidad));
        click(btnVerDisponibilidad);
    }

    public void aplicarFiltroDeEstrellas(String filtro) throws InterruptedException {
        this.btnFiltroEstrellas = By.xpath("//div[@class='bui-checkbox__label filter_item css-checkbox']/span[contains(text(),'" + filtro + "')]");
        esperaEnSegundosYIsDisplayed(30,btnFiltroEstrellas);
        click(btnFiltroEstrellas);
        Thread.sleep(5000);
    }

    public void aplicarFiltroDesayunoIncluido() throws InterruptedException {
        esperaEnSegundosYIsDisplayed(30,btnFiltroDesayunoInlcuido);
        click(btnFiltroDesayunoInlcuido);
        Thread.sleep(5000);
    }

    public boolean verificarResultadoPagina() throws InterruptedException {
        //espera.until(ExpectedConditions.elementToBeClickable(findElement(txtResultados))).isDisplayed();
        esperaEnSegundosYIsDisplayed(30,txtPersonas);
        boolean resultadofinal = findElement(txtPersonas).isDisplayed();
        return resultadofinal;
    }
    public void verHotelDisponible() throws  InterruptedException{
        Thread.sleep(3000);
        esperaEnSegundosYIsDisplayed(30,btnVerDisponibilidad);
        click(btnVerDisponibilidad);
        switchToParentFrame();
        switchToWindows(2);
        Thread.sleep(5000);
    }


}
