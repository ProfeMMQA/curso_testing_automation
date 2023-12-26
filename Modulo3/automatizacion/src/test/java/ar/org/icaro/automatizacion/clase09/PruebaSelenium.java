package ar.org.icaro.automatizacion.clase09;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.time.temporal.TemporalUnit;

public class PruebaSelenium {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void setup() {
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @Test
    public void validarTituloDelArticuloDeJava() {
        driver.get("https://es.wikipedia.org/wiki/Java_(lenguaje_de_programaci%C3%B3n)");

        String tituloEsperado = "Java (lenguaje de programación)";
        driver.getTitle();
        //WebElement elementoTitulo = driver.findElement(By.cssSelector(".mw-page-title-main"));
        WebElement elementoTitulo = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".mw-page-title-main")));

        String tituloEncontrado = elementoTitulo.getText();


        Assert.assertEquals(tituloEncontrado, tituloEsperado, "El titulo es diferente");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }


}
