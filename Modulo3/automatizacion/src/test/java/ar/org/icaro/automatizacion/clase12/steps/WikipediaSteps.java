package ar.org.icaro.automatizacion.clase12.steps;

import ar.org.icaro.automatizacion.clase10.WikipediaArticlePage;
import ar.org.icaro.automatizacion.clase10.WikipediaFrontPage;
import ar.org.icaro.automatizacion.clase10.WikipediaMainPage;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class WikipediaSteps {

    private static WebDriver driver;
    private static WebDriverWait wait;
    WikipediaMainPage mainPage;
    WikipediaFrontPage frontPage;
    WikipediaArticlePage articlePage;

    @BeforeAll
    public static void setUp() {
        FirefoxProfile fp = new FirefoxProfile();
        fp.setAcceptUntrustedCertificates(true);

        FirefoxOptions fo = new FirefoxOptions();
        fo.setProfile(fp);
        //fo.addArguments("-private");

        driver = new FirefoxDriver(fo);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Cuando("el usuario ingresa a la sección en español")
    public void elUsuarioIngresaALaSeccionEnEspanol() {
        mainPage = new WikipediaMainPage(driver);
        frontPage = mainPage.clickEspaniol();
    }

    @Y("realiza la búsqueda de {string}")
    public void realizaLaBusquedaDe(String terminoDeBusqueda) {
        frontPage.ingresarTerminoEnBusqueda(terminoDeBusqueda);
        articlePage = frontPage.clickBuscar();
    }

    @Entonces("observa que el título del artículo es {string}")
    public void observaQueElTítuloDelArtículoEs(String tituloEsperado) {
        String titulo = articlePage.getTitle();
        Assert.assertEquals(titulo, tituloEsperado, "Los titulos no coinciden");
    }

    @Y("observa que el título de la imagen es {string}")
    public void observaQueElTítuloDeLaImagenEs(String tituloImagenEsperado) {
        String tituloDeImagen = articlePage.getImageTitle();
        Assert.assertEquals(tituloDeImagen, tituloImagenEsperado, "Los titulos no coinciden");
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Dado("que el usuario se encuentra en la pagina principal de wikipedia")
    public void queElUsuarioSeEncuentraEnLaPaginaPrincipalDeWikipedia() {
        driver.get("https://www.wikipedia.org/");
    }
}
