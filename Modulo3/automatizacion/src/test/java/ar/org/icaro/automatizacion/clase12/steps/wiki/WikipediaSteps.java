package ar.org.icaro.automatizacion.clase12.steps.wiki;

import ar.org.icaro.automatizacion.clase10.WikipediaArticlePage;
import ar.org.icaro.automatizacion.clase10.WikipediaFrontPage;
import ar.org.icaro.automatizacion.clase10.WikipediaMainPage;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.StepDefinitionAnnotations;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class WikipediaSteps {

    private static WebDriver driver;
    private WikipediaFrontPage frontPage;
    private WikipediaArticlePage articlePage;

    @BeforeAll
    public static void setUp() {
        driver = new FirefoxDriver();
    }

    @Dado("un usuario que se encuentra en la pagina principal de Wikipedia")
    public void unUsuarioQueSeEncuentraEnLaPaginaPrincipalDeWikipedia() {
        driver.get("https://www.wikipedia.org/");
    }


    @Cuando("el usuario navega a la seccion en espanol")
    public void elUsuarioNavegaALaSeccionEnEspanol() {
        WikipediaMainPage mainPage = new WikipediaMainPage(driver);
        frontPage = mainPage.clickEspaniol();
    }

    @Y("realiza la busqueda del termino {string}")
    public void realizaLaBusquedaDelTermino(String terminoDeBusqueda) {
        frontPage.ingresarTerminoEnBusqueda(terminoDeBusqueda);
        articlePage = frontPage.clickBuscar();
    }

    @Entonces("se muestra el titulo {string}")
    public void seMuestraElTitulo(String tituloEsperado) {
        String titulo = articlePage.getTitle();
        Assert.assertEquals(titulo, tituloEsperado, "Los titulos no coinciden");
    }

    @Y("se muestra el titulo de la imagen {string}")
    public void seMuestraElTituloDeLaImagen(String tituloImagenEsperado) {
        String tituloDeImagen = articlePage.getImageTitle();
        Assert.assertEquals(tituloDeImagen, tituloImagenEsperado, "Los titulos no coinciden");
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
