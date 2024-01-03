package ar.org.icaro.automatizacion.clase10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class PruebaSelect {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void setup() {
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void actividadPractica3() {
        driver.get("https://the-internet.herokuapp.com/dropdown");

        By dropdownBy = By.id("dropdown");
        WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(dropdownBy));

        Select dropdownSelect = new Select(dropdown);

        dropdownSelect.selectByVisibleText("Option 1");
        String opcionActual = dropdownSelect.getFirstSelectedOption().getText();
        String opcionEsperada = "Option 1";
        Assert.assertEquals(opcionActual, opcionEsperada, "El texto no corresponde");

        dropdownSelect.selectByIndex(2);
        opcionActual = dropdownSelect.getFirstSelectedOption().getText();
        opcionEsperada = "Option 2";
        Assert.assertEquals(opcionActual, opcionEsperada, "El texto no corresponde");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
