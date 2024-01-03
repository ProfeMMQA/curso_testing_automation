package ar.org.icaro.automatizacion.clase10;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class PruebaWikipediaSelenium {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void setup() {
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void validarTituloSeleniumWikipedia() {
        String tituloEsperado = "Selenium";

        driver.get("https://es.wikipedia.org/wiki/Selenium");

        WikipediaArticlePage wikiPage = new WikipediaArticlePage(driver);

        String titulo = wikiPage.getTitle();
        String tituloDeImagen = wikiPage.getImageTitle();

        Assert.assertEquals(titulo, tituloEsperado, "Los titulos no coinciden");
        Assert.assertEquals(tituloDeImagen, tituloEsperado, "Los titulos no coinciden");
    }

    @Test
    public void actividad4() {
        String tituloEsperado = "Selenium";
        String terminoDeBusqueda = "Selenium";
        String url = "https://www.wikipedia.org/";

        driver.get(url);

        WikipediaMainPage mainPage = new WikipediaMainPage(driver);

        WikipediaFrontPage frontPage = mainPage.clickEspaniol();

        frontPage.ingresarTerminoEnBusqueda(terminoDeBusqueda);
        WikipediaArticlePage articlePage = frontPage.clickBuscar();

        String titulo = articlePage.getTitle();
        String tituloDeImagen = articlePage.getImageTitle();

        Assert.assertEquals(titulo, tituloEsperado, "Los titulos no coinciden");
        Assert.assertEquals(tituloDeImagen, tituloEsperado, "Los titulos no coinciden");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
