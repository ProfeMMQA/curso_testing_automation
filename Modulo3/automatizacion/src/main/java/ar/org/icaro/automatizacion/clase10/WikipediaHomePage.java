package ar.org.icaro.automatizacion.clase10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WikipediaHomePage {
    private WebDriver driver;
    private WebDriverWait wait;
    public WikipediaHomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public WikipediaFrontPage clickEspaniol() {
        botonEspaniol().click();
        return new WikipediaFrontPage(driver);
    }

    private WebElement botonEspaniol() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("js-link-box-es")));
    }
}
