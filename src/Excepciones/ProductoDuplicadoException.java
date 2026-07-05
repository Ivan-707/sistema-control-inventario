package Excepciones;

/**
 * Excepción personalizada que se lanza cuando se intenta registrar
 * un producto cuyo código ya existe en el inventario.
 */
public class ProductoDuplicadoException extends Exception {

    public ProductoDuplicadoException(String mensaje) {
        super(mensaje);
    }

    public ProductoDuplicadoException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}
