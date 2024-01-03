package ar.org.icaro.automatizacion.clase10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WikipediaMainPage {

    private By botonEspaniolBy = By.id("js-link-box-es");
    private WebDriver driver;
    private WebDriverWait wait;

    public WikipediaMainPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public WikipediaFrontPage clickEspaniol() {
        botonEspaniol().click();
        return new WikipediaFrontPage(driver);
    }

    private WebElement botonEspaniol() {
        wait.until(
                ExpectedConditions.refreshed(
                    ExpectedConditions.visibilityOfElementLocated(botonEspaniolBy))
        );
        return driver.findElement(botonEspaniolBy);
    }
}
