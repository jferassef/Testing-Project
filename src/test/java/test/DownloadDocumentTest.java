package test;

import com.amaris.automation.model.testing.SuiteManager;
import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.TestObject;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import steps.ActionSteps;
import utils.DocumentHelper;

import java.io.File;

public class DownloadDocumentTest extends TestObject {

    protected SuiteManager suiteM = new SuiteManager("Login");
    @DataProvider(parallel = false)
    public String[][] downloadDoc() {
        String testCase = "2_DownloadDocument";
        String[][] casesMatrix = suiteM.initializeTestObjects(testCase, null, null);

        return casesMatrix;
    }

    @Test(dataProvider = "downloadDoc")
    public void pruebaDocumentoDescargas(String testCase, String id) throws Exception {
        UserStory userS = suiteM.createUserStory(testCase, id);

        userS.testActions(() -> {

            // Configurar el WebDriver con la ruta de descargas
            String rutaDescargas = "C:\\Users\\jessica.fernandez_am\\Downloads";
            WebDriver driver = DocumentHelper.configurarChromeConDescargas(rutaDescargas);

            // Navegar a la página web y descargar el archivo
            String url = "https://www.selenium.dev/downloads/";
            String xpathElemento = "#post-809 > div > div.entry-content > div.elementor.elementor-809 > section.elementor-section.elementor-top-section.elementor-element.elementor-element-71bd271.elementor-section-boxed.elementor-section-height-default.elementor-section-height-default > div > div > div > div > div > div > div > div > div > div.ml-3 > a > font > font";
            DocumentHelper.descargarArchivo(driver, url, xpathElemento);

            // Esperar a que el archivo se descargue
            String nombreArchivo = "sample-pdf-file.pdf";
            File archivoDescargado = DocumentHelper.esperarArchivoDescargado(rutaDescargas, nombreArchivo, 30);

            // Leer el contenido del archivo descargado
            String contenidoPDF = DocumentHelper.leerContenidoPDF(archivoDescargado);
            System.out.println(contenidoPDF);

            // Cerrar el WebDriver
            driver.quit();

            return null;

        }).onEnd(() -> {


            return null;
        }).run();
    }

    @AfterSuite
    public void afterSuite
            () {
        suiteM.createHtmlReport();
    }
}

