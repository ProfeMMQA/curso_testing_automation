package ar.org.icaro.automatizacion.clase10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class PruebaWikipedia {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void setup() {
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void validarTitulosArticuloSelenium() {
        driver.get("https://es.wikipedia.org/wiki/Selenium");

        WikipediaArticlePage paginaWiki = new WikipediaArticlePage(driver);

        String actualTitle = paginaWiki.getTitulo();
        String actualImageTitle = paginaWiki.getTituloImagen();

        String expectedTitle = "Selenium";
        String expectedImageTitle = "Selenium";

        Assert.assertEquals(actualTitle, expectedTitle, "Los titulos no coinciden");
        Assert.assertEquals(actualImageTitle, expectedImageTitle, "Los titulos no coinciden");
    }

    @Test
    public void validaWikipediaSelenium() {
        String terminoDeBusqueda = "Selenium";
        String expectedTitle = "Selenium";
        String expectedImageTitle = "Selenium";

        driver.get("https://www.wikipedia.org/");

        WikipediaHomePage homePage = new WikipediaHomePage(driver);

        WikipediaFrontPage frontPage = homePage.clickEspaniol();

        frontPage.ingresarEnBusqueda(terminoDeBusqueda);
        WikipediaArticlePage paginaWiki = frontPage.clickEnBuscar();

        String actualTitle = paginaWiki.getTitulo();
        String actualImageTitle = paginaWiki.getTituloImagen();


        Assert.assertEquals(actualTitle, expectedTitle, "Los titulos no coinciden");
        Assert.assertEquals(actualImageTitle, expectedImageTitle, "Los titulos no coinciden");

    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
