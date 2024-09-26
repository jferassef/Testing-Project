package utils;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.io.File;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.IOException;



public class DocumentHelper {
    public static WebDriver configurarChromeConDescargas(String rutaDescargas) {
        // Configuración para Chrome
        ChromeOptions options = new ChromeOptions();

        // Configurar el directorio de descargas
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("download.default_directory", rutaDescargas); // Ruta donde descargar los archivos
        prefs.put("download.prompt_for_download", false);
        prefs.put("download.directory_upgrade", true);
        prefs.put("safebrowsing.enabled", true);

        options.setExperimentalOption("prefs", prefs);

        // Inicializar el WebDriver con las opciones
        WebDriver driver = new ChromeDriver(options);
        return driver;
    }


        public static void descargarArchivo(WebDriver driver, String url, String xpathElemento) {
            // Navegar a la página web
            driver.get(url);

            // Hacer clic en el botón o enlace para descargar
            driver.findElement(By.xpath(xpathElemento)).click();
        }

        public static File esperarArchivoDescargado(String rutaDescargas, String nombreArchivo, int timeoutSegundos) throws InterruptedException {
            File archivoDescargado = new File(rutaDescargas + File.separator + nombreArchivo);
            int contador = 0;
            while (!archivoDescargado.exists() && contador < timeoutSegundos) {
                Thread.sleep(1000); // Espera 1 segundo
                contador++;
            }

            if (archivoDescargado.exists()) {
                return archivoDescargado;
            } else {
                throw new RuntimeException("El archivo no fue descargado en el tiempo esperado.");
            }
        }

        public static String leerContenidoPDF(File archivoPDF) throws IOException {
            PDDocument documento = PDDocument.load(archivoPDF);
            PDFTextStripper pdfStripper = new PDFTextStripper();
            String texto = pdfStripper.getText(documento);
            documento.close();
            return texto;
        }

    public static void leerContenidoExcel(File archivoExcel) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(archivoExcel);
        Workbook workbook = new XSSFWorkbook(fileInputStream);
        Sheet hoja = workbook.getSheetAt(0);

        for (Row fila : hoja) {
            for (Cell celda : fila) {
                switch (celda.getCellType()) {
                    case STRING:
                        System.out.print(celda.getStringCellValue() + "\t");
                        break;
                    case NUMERIC:
                        System.out.print(celda.getNumericCellValue() + "\t");
                        break;
                    default:
                        break;
                }
            }
            System.out.println();
        }
        workbook.close();
        fileInputStream.close();
    }
    }








