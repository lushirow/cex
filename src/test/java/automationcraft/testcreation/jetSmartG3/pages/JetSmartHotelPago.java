package automationcraft.testcreation.jetSmartG3.pages;

import bctsoft.g3.pageobject.base.SeleniumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JetSmartHotelPago extends SeleniumBase {

    public JetSmartHotelPago(WebDriver driver) {
        super(driver);
    }

    private By txtCheckPago = By.xpath("//div[@class='required_fields_description bui-spacer--large']");

    public boolean validarPosicionPago() throws InterruptedException {
        boolean validarPosPago = false;
        esperaEnSegundosYIsDisplayed(20, txtCheckPago);
        if (findElement(txtCheckPago).isDisplayed()) {
            validarPosPago = true;
        }
        return validarPosPago;
    }
}
