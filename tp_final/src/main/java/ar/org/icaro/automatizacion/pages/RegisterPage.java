package ar.org.icaro.automatizacion.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegisterPage extends BasePage {

    private By formularioBy = By.id("content");

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public void scrollHastaElFormulario() {
        //Scrolleamos hasta el formulario para que los elementos esten a la vista
        WebElement formulario = getFormulario();
        scrollHasta(formulario);
    }

    private WebElement getFormulario() {
        wait.until(
                ExpectedConditions.presenceOfElementLocated(formularioBy));
        return driver.findElement(formularioBy);
    }
}
