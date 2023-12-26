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
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PruebaSelect {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void setup() {
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void actividadSelect() {
        String url = "https://the-internet.herokuapp.com/dropdown";

        driver.get(url);
        By dropdownBy = By.id("dropdown");

        WebElement dropdownElement = wait.until(ExpectedConditions.visibilityOfElementLocated(dropdownBy));
        Select dropdown = new Select(dropdownElement);

        dropdown.selectByVisibleText("Option 2");
        Assert.assertEquals(dropdown.getFirstSelectedOption().getText(), "Option 2");

        dropdown.selectByIndex(1);
        Assert.assertEquals(dropdown.getFirstSelectedOption().getText(), "Option 1");

    }

    @Test
    public void validarTodasLasOpciones() {
        driver.get("https://the-internet.herokuapp.com/dropdown");

        By dropdownBy = By.id("dropdown");

        WebElement dropdownElement = wait.until(ExpectedConditions.visibilityOfElementLocated(dropdownBy));
        Select dropdown = new Select(dropdownElement);

        List<WebElement> options = dropdown.getOptions();

        options.remove(0);

        Set<String> actualOptions = new HashSet<>();
        for (WebElement option:
                options) {
            actualOptions.add(option.getText());
        }
        Set<String> expectedOptions = Set.of("Option 1", "Option 2");

        Assert.assertEquals(actualOptions, expectedOptions, "Las opciones no coinciden");
    }

    @Test
    public void validarOpcionesDropdown2() {
        driver.get("https://the-internet.herokuapp.com/dropdown");

        By dropdownBy = By.id("dropdown");

        WebElement dropdownElement = wait.until(ExpectedConditions.visibilityOfElementLocated(dropdownBy));
        Select dropdown = new Select(dropdownElement);

        List<WebElement> options = dropdown.getOptions();

        options.remove(0);

        Set<String> actualOptions = new HashSet<>();
        for (WebElement option:
             options) {
            actualOptions.add(option.getText());
        }
        Set<String> expectedOptions = Set.of("Option 1", "Option 2");

        Assert.assertEquals(actualOptions, expectedOptions);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
