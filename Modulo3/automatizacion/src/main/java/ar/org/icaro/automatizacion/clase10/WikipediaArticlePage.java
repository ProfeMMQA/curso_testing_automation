package ar.org.icaro.automatizacion.clase10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WikipediaArticlePage {

    private By tituloBy = By.className("mw-page-title-main");
    private By tituloImagenBy = By.className("cabecera");

    private WebDriver driver;
    private WebDriverWait wait;

    public WikipediaArticlePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public String getTitulo() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(tituloBy))
                .getText();
    }

    public String getTituloImagen() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(tituloImagenBy))
                .getText();
    }

}
