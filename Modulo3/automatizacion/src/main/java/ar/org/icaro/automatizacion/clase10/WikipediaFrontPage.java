package ar.org.icaro.automatizacion.clase10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WikipediaFrontPage {

    By campoBusquedaBy = By.className("cdx-text-input__input");
    By botonBuscarBy = By.cssSelector("button.cdx-search-input__end-button");

    private WebDriver driver;
    private WebDriverWait wait;

    public WikipediaFrontPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void ingresarTerminoEnBusqueda(String termino) {
        campoBusqueda().sendKeys(termino);
    }

    private WebElement campoBusqueda() {
        wait.until(
                ExpectedConditions.refreshed(
                        ExpectedConditions.visibilityOfElementLocated(campoBusquedaBy)
                )
        );
        return driver.findElement(campoBusquedaBy);
    }

    public WikipediaArticlePage clickBuscar() {
        botonBuscar().click();
        return new WikipediaArticlePage(driver);
    }

    private WebElement botonBuscar() {
        wait.until(ExpectedConditions.refreshed(
                ExpectedConditions.visibilityOfElementLocated(botonBuscarBy)
                )
        );
        return driver.findElement(botonBuscarBy);
    }
}
