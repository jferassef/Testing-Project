package utils;

import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class GestorDescargas {
    private WebDriver driver;
    private String rutaDescargas;

    public GestorDescargas(WebDriver driver, String rutaDescargas) {
        this.driver = driver;
        this.rutaDescargas = rutaDescargas;
    }

    /*
    public void descargarArchivo(String url, String xpathElemento) {
        DescargarArchivo.descargar(driver, url, xpathElemento);
    }

    public File esperarDescarga(String nombreArchivo, int timeoutSegundos) throws InterruptedException {
        return EsperarDescargaArchivo.esperarArchivoDescargado(rutaDescargas, nombreArchivo, timeoutSegundos);
    }

    public String leerPDF(File archivoPDF) throws IOException {
        return LeerPDF.leerContenidoPDF(archivoPDF);
    }

    public void leerExcel(File archivoExcel) throws IOException {
        LeerExcel.leerContenidoExcel(archivoExcel);
    }

    public static void main(String[] args) throws InterruptedException, IOException {
        // Configurar Selenium y el directorio de descargas
        String rutaDescargas = "C:/ruta/de/descargas";
        WebDriver driver = SeleniumDescargasConfig.configurarChromeConDescargas(rutaDescargas);

        GestorDescargas gestor = new GestorDescargas(driver, rutaDescargas);

        // Descargar un archivo
        gestor.descargarArchivo("https://ejemplo.com/archivo", "//a[@id='download-link']");

        // Esperar la descarga de un archivo PDF
        File archivoPDF = gestor.esperarDescarga("archivo_ejemplo.pdf", 30);

        // Leer el contenido del PDF
        String contenidoPDF = gestor.leerPDF(archivoPDF);
        System.out.println(contenidoPDF);

        // Para un archivo Excel:
        // File archivoExcel = gestor.esperarDescarga("archivo_ejemplo.xlsx", 30);
        // gestor.leerExcel(archivoExcel);

        // Cerrar el driver
        driver.quit();
    }

     */
}

