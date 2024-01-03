package ar.org.icaro.automatizacion.clase10;

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

public class PruebaWait {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void setup() {
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void actividadPractica1() {
        String textoEsperado = "Hello World!";

        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        By botonStartBy = By.cssSelector("div#start > button");
        WebElement botonStart = wait.until(ExpectedConditions.visibilityOfElementLocated(botonStartBy));
        botonStart.click();

        By textoEscondidoBy = By.cssSelector("div#finish> h4");
        WebElement textoEscondido = wait.until(ExpectedConditions.visibilityOfElementLocated(textoEscondidoBy));

        Assert.assertEquals(textoEscondido.getText(), textoEsperado, "Los textos no coinciden");
    }

    @Test
    public void actividadPractica2() {
        String textoEsperado = "Hello World!";

        driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");

        By botonStartBy = By.cssSelector("div#start > button");
        WebElement botonStart = wait.until(ExpectedConditions.visibilityOfElementLocated(botonStartBy));
        botonStart.click();

        By textoEscondidoBy = By.cssSelector("div#finish> h4");
        WebElement textoEscondido = wait.until(ExpectedConditions.presenceOfElementLocated(textoEscondidoBy));

        Assert.assertEquals(textoEscondido.getText(), textoEsperado, "Los textos no coinciden");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
