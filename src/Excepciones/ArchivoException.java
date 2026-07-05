package Excepciones;

/**
 * Excepción personalizada para errores ocurridos durante la
 * lectura o escritura de archivos (por ejemplo, al exportar el inventario).
 */
public class ArchivoException extends Exception {

    public ArchivoException(String mensaje) {
        super(mensaje);
    }

    public ArchivoException(String mensaje, Throwable causa) {
        // Encadenamiento de excepciones: se conserva la causa original (ej. IOException)
        super(mensaje, causa);
    }
}
