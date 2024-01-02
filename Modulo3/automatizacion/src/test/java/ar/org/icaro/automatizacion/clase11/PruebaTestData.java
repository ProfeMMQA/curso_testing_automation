package ar.org.icaro.automatizacion.clase11;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;

public class PruebaTestData {

    private String testDataFile = "testData.xlsx";

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

    @Test(dataProvider = "fuenteDeDatos")
    public void verificarDatosDeArchivoTest(String nombre, String valor) {

        System.out.println("Probando nombre: " + nombre + "; valor: " + valor);
        Assert.assertEquals(nombre, valor, "Nombre y valor deben ser iguales!");

    }
}
