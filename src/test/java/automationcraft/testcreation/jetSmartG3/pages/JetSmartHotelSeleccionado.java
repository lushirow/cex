package automationcraft.testcreation.jetSmartG3.pages;

import bctsoft.g3.pageobject.base.SeleniumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JetSmartHotelSeleccionado extends SeleniumBase {

    public JetSmartHotelSeleccionado(WebDriver driver) {
        super(driver);
    }

    WebDriverWait espera = new WebDriverWait(driver, 20);

    private By txtEstrellas = By.xpath("//span[@class='hp__hotel_ratings__stars nowrap']/span/span/span[@class='bui-rating bui-rating--smaller']/span[@role='presentation']");
    private By txtPopularidad = By.xpath("//div[@class='bui-review-score__badge']");
    private By lbSeleccionarApartamento = By.cssSelector(".hprt-block .hprt-nos-select");
    private By btnReservare = By.xpath("//span[contains(text(),'Reservaré')]");

    public boolean validarEstrellasyPopularidad() throws InterruptedException {
        boolean validaEstrellas;
        boolean validarPopularidad;
        boolean casoExitoso;
        if (findElements(txtEstrellas).size() > 2) {
            validaEstrellas = true;
        } else {
            validaEstrellas = false;
        }
        String popularidad = findElement(txtPopularidad).getText();
        popularidad = popularidad.replace(",", ".");
        double valorPopularidad = Double.parseDouble(popularidad);
        if (valorPopularidad > 7) {
            validarPopularidad = true;
        } else {
            validarPopularidad = false;
        }
        if (validaEstrellas == true && validarPopularidad == true) {
            casoExitoso = true;
        } else {
            casoExitoso = false;
        }
        return casoExitoso;
    }

    public void seleccionarHabitantesApartamentoYReservar() throws InterruptedException {
        findElement(lbSeleccionarApartamento).click();
        findElement(lbSeleccionarApartamento).sendKeys("1");
        findElement(lbSeleccionarApartamento).sendKeys(Keys.ENTER);
        Thread.sleep(1500);
        findElement(btnReservare).click();
        Thread.sleep(3000);
    }


}
