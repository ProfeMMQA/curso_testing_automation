package ar.org.icaro.automatizacion.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    private By mp3PlayersButtonBy = By.xpath("//*[text()='MP3 Players']/parent::*[@class='dropdown']");
    private By showAllMP3PlayersButtonBy = By.xpath("//*[text()='Show All MP3 Players']");

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    protected void scrollHasta(WebElement elemento) {
        int deltaY = elemento.getRect().y;
        new Actions(driver)
                .scrollByAmount(0, deltaY)
                .perform();
    }

    public MP3PlayersPage clickOnMP3PlayersButton() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(mp3PlayersButtonBy));
        WebElement mp3PlayerButton = driver.findElement(mp3PlayersButtonBy);
        new Actions(driver)
                .moveToElement(mp3PlayerButton)
                .perform();

        wait.until(ExpectedConditions.visibilityOfElementLocated(showAllMP3PlayersButtonBy));
        driver.findElement(showAllMP3PlayersButtonBy).click();

        return new MP3PlayersPage(driver);
    }
}
