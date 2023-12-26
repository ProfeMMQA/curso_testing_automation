package ar.org.icaro.automatizacion.clase10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WikipediaFrontPage {
    private final By campoBusquedaBy = By.id("searchInput");
    private final By botonBuscarBy = By.cssSelector("button.cdx-search-input__end-button");
    private WebDriver driver;
    private WebDriverWait wait;

    public WikipediaFrontPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void ingresarEnBusqueda(String terminoDeBusqueda) {
        campoBusqueda().sendKeys(terminoDeBusqueda);
    }

    private WebElement campoBusqueda() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(campoBusquedaBy));
    }

    public WikipediaArticlePage clickEnBuscar() {
        botonBuscar().click();
        return new WikipediaArticlePage(driver);
    }

    private WebElement botonBuscar() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(botonBuscarBy));
    }
}
