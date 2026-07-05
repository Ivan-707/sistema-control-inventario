package Excepciones;

/**
 * Excepción personalizada que se lanza cuando los datos ingresados
 * por el usuario no cumplen las reglas de negocio.
 */
public class DatoInvalidoException extends Exception {

    public DatoInvalidoException(String mensaje) {
        super(mensaje);
    }

    public DatoInvalidoException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}
