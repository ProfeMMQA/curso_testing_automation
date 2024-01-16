package ar.org.icaro.automatizacion.steps;


import ar.org.icaro.automatizacion.pages.RegisterPage;
import ar.org.icaro.automatizacion.steps.driver.DriverManager;
import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Y;
import org.openqa.selenium.WebDriver;

public class CrearCuentaSteps {

    private WebDriver driver;
    private RegisterPage registerPage;

    @Before
    public void setUp() {
        driver = DriverManager.driver;
    }

    @Cuando("el usuario navega a la pagina de registro")
    public void elUsuarioNavegaALaPaginaDeRegistro() {
        //Completar lo necesario para llegar a la pagina de registro
        registerPage = new RegisterPage(driver);
    }

    @Y("completa la registracion")
    public void completaLaRegistracion() {
        registerPage.scrollHastaElFormulario();

        //Completar lo necesario para completar la registracion
    }
}
