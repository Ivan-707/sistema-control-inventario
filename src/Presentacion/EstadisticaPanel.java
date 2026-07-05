package Presentacion;

import Modelo.Producto;
import Negocio.ProductoNegocio;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

/**
 * Panel de la pestaña Estadísticas.
 * Solo se encarga de mostrar la información calculada por la capa de negocio.
 */
public class EstadisticaPanel extends JPanel {

    private final ProductoNegocio negocio;
    private JTextArea areaEstadisticas;

    public EstadisticaPanel(ProductoNegocio negocio) {
        this.negocio = negocio;
        construirPanel();
    }

    private void construirPanel() {
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JLabel titulo = new JLabel("Estadísticas del inventario", SwingConstants.CENTER);
        titulo.setFont(new Font("SansSerif", Font.BOLD, 16));
        add(titulo, BorderLayout.NORTH);

        areaEstadisticas = new JTextArea();
        areaEstadisticas.setEditable(false);
        areaEstadisticas.setFont(new Font("Monospaced", Font.PLAIN, 13));
        add(new JScrollPane(areaEstadisticas), BorderLayout.CENTER);

        JButton btnActualizar = new JButton("Actualizar estadísticas");
        btnActualizar.addActionListener(e -> actualizar());
        add(btnActualizar, BorderLayout.SOUTH);

        actualizar();
    }

    /**
     * Recalcula y muestra las estadísticas actuales del inventario.
     */
    public void actualizar() {
        StringBuilder sb = new StringBuilder();

        sb.append("Cantidad total de productos: ").append(negocio.totalProductos()).append("\n");
        sb.append("Cantidad de productos disponibles: ").append(negocio.totalDisponibles()).append("\n");
        sb.append("Cantidad de productos no disponibles: ").append(negocio.totalNoDisponibles()).append("\n");
        sb.append("Cantidad de unidades almacenadas: ").append(negocio.totalUnidades()).append("\n");

        Producto mayor = negocio.productoMayorPrecio();
        Producto menor = negocio.productoMenorPrecio();
        sb.append("Producto con mayor precio: ")
                .append(mayor != null ? mayor.getNombre() + " ($" + mayor.getPrecio() + ")" : "N/A").append("\n");
        sb.append("Producto con menor precio: ")
                .append(menor != null ? menor.getNombre() + " ($" + menor.getPrecio() + ")" : "N/A").append("\n");

        sb.append("\nProductos por categoría:\n");
        Map<String, Integer> porCategoria = negocio.productosPorCategoria();
        if (porCategoria.isEmpty()) {
            sb.append("  (sin datos)\n");
        } else {
            for (Map.Entry<String, Integer> entry : porCategoria.entrySet()) {
                sb.append("  - ").append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
            }
        }

        sb.append("\nValor total del inventario: $").append(String.format("%.2f", negocio.valorTotalInventario()));

        areaEstadisticas.setText(sb.toString());
    }
}
