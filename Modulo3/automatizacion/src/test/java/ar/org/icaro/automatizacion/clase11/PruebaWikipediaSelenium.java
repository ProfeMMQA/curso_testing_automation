package ar.org.icaro.automatizacion.clase11;

import ar.org.icaro.automatizacion.clase10.WikipediaArticlePage;
import ar.org.icaro.automatizacion.clase10.WikipediaFrontPage;
import ar.org.icaro.automatizacion.clase10.WikipediaMainPage;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;

public class PruebaWikipediaSelenium {

    private WebDriver driver;
    private WebDriverWait wait;

    private String testDataFile = "busquedaWikipediaTestData.xlsx";

    @BeforeClass
    public void setup() {
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test(dataProvider = "fuenteDeDatos")
    public void actividad1(String terminoDeBusqueda, String tituloEsperado, String tituloImagenEsperado) {
        String url = "https://www.wikipedia.org/";

        driver.get(url);

        WikipediaMainPage mainPage = new WikipediaMainPage(driver);

        WikipediaFrontPage frontPage = mainPage.clickEspaniol();

        frontPage.ingresarTerminoEnBusqueda(terminoDeBusqueda);
        WikipediaArticlePage articlePage = frontPage.clickBuscar();

        String titulo = articlePage.getTitle();
        String tituloDeImagen = articlePage.getImageTitle();

        Assert.assertEquals(titulo, tituloEsperado, "Los titulos no coinciden");
        Assert.assertEquals(tituloDeImagen, tituloImagenEsperado, "Los titulos no coinciden");
    }

    @Test
    public void pruebaScroll() {
        driver.get("https://opencart.abstracta.us/index.php?route=account/register");

        WebElement accountDiv = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("content")));

        int deltaY = accountDiv.getRect().y;

        new Actions(driver)
                .scrollByAmount(0, deltaY)
                .perform();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }


    @DataProvider(name = "fuenteDeDatos")
    public Object[][] fuenteDeDatos() {
        // Para leer el archivo de la carpeta resources
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(testDataFile);

        // Crea Libro con referencia al archivo .xlsx
        XSSFWorkbook workbook;
        try {
            workbook = new XSSFWorkbook(inputStream);
        } catch (IOException e) {
            throw new RuntimeException("Error al leer el archivo " + testDataFile, e);
        }

        // Obtiene la primer hoja del libro
        XSSFSheet sheet = workbook.getSheetAt(0);

        // Eliminamos la primer fila, que contiene los encabezados
        sheet.shiftRows(1, sheet.getLastRowNum(), -1);

        int filas = sheet.getLastRowNum() + 1;
        int columnas = sheet.getRow(0).getLastCellNum();
        Object[][] testData = new Object[filas][columnas];

        // Itera las filas de la hoja
        for (Row fila : sheet) {
            // Itera cada celda dentro de la fila
            for (Cell celda : fila) {
                // Llena la matriz con los datos
                int indiceFila = celda.getRowIndex();
                int indiceColumna = celda.getColumnIndex();
                testData[indiceFila][indiceColumna] = celda.getStringCellValue();
            }
        }
        try {
            inputStream.close();
        } catch (IOException e) {
            throw new RuntimeException("Error cerrando el archivo " + testDataFile, e);
        }

        return testData;
    }

}
