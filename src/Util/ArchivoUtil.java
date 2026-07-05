package Util;

import Excepciones.ArchivoException;
import Modelo.Producto;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Clase utilitaria encargada de exportar el inventario a un archivo
 * de texto plano (.csv o .txt).
 */
public class ArchivoUtil {

    private ArchivoUtil() {
        // Clase utilitaria: no se instancia.
    }

    /**
     * Exporta la lista de productos al archivo indicado.
     
     */
    public static void exportarInventario(File archivo, List<Producto> productos) throws ArchivoException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
            writer.write("ID,Código,Nombre,Categoría,Cantidad,Precio,Disponible");
            writer.newLine();

            for (Producto p : productos) {
                StringBuilder linea = new StringBuilder();
                linea.append(p.getId()).append(",")
                        .append(p.getCodigo()).append(",")
                        .append(p.getNombre()).append(",")
                        .append(p.getCategoria()).append(",")
                        .append(p.getCantidad()).append(",")
                        .append(p.getPrecio()).append(",")
                        .append(p.isDisponible() ? "Sí" : "No");
                writer.write(linea.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            // Encadenamiento de excepciones: se conserva la causa original (IOException).
            throw new ArchivoException("No fue posible exportar el inventario al archivo seleccionado.", e);
        }
    }
}
