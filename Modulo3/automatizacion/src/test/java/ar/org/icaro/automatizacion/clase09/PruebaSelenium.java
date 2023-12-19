package ar.org.icaro.automatizacion.clase09;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PruebaSelenium {

    private WebDriver driver;

    @BeforeClass
    public void setup() {
        driver = new FirefoxDriver();
    }

    @Test
    public void validarTituloDelArticuloDeJava() {
        driver.get("https://es.wikipedia.org/wiki/Java_(lenguaje_de_programaci%C3%B3n)");

        WebElement elementoTitulo = driver.findElement(By.cssSelector(".mw-page-title-main"));

        String tituloEncontrado = elementoTitulo.getText();

        String tituloEsperado = "Java (lenguaje de programación)";

        Assert.assertEquals(tituloEncontrado, tituloEsperado, "El titulo es diferente");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }


}
