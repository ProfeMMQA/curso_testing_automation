package ar.org.icaro.automatizacion.clase10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class PruebaEsperas {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void setup() {
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void actividadWaitVisibility() {
        String url = "https://the-internet.herokuapp.com/dynamic_loading/1";

        driver.get(url);

        By startButtonBy = By.cssSelector("#start button");
        WebElement button = wait.until(ExpectedConditions.visibilityOfElementLocated(startButtonBy));
        button.click();

        By elementoOcultoBy = By.id("finish");
        WebElement elementoOculto = wait.until(ExpectedConditions.visibilityOfElementLocated(elementoOcultoBy));

        Assert.assertEquals(elementoOculto.getText(), "Hello World!", "Los textos no coinciden");
    }

    @Test
    public void actividadWaitPresence() {
        String url = "https://the-internet.herokuapp.com/dynamic_loading/2";

        driver.get(url);
        By startButtonBy = By.cssSelector("#start button");

        WebElement button = wait.until(ExpectedConditions.visibilityOfElementLocated(startButtonBy));
        button.click();

        By elementoOcultoBy = By.id("finish");
        WebElement elementoOculto = wait.until(ExpectedConditions.presenceOfElementLocated(elementoOcultoBy));

        Assert.assertEquals(elementoOculto.getText(), "Hello World!", "Los textos no coinciden");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }


}
