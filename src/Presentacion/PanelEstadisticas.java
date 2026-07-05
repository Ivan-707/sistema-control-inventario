package Presentacion;

import Modelo.Producto;
import Negocio.ProductoNegocio;

import java.util.Map;

/**
 * Panel de estadísticas del inventario.
 * Los componentes visuales son gestionados por el diseñador de NetBeans.
 */
public class PanelEstadisticas extends javax.swing.JPanel {

    private final ProductoNegocio negocio;

    public PanelEstadisticas(ProductoNegocio negocio) {
        this.negocio = negocio;
        initComponents();
        actualizar();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelTitulo = new javax.swing.JLabel();
        jScrollPaneStats = new javax.swing.JScrollPane();
        jTextAreaEstadisticas = new javax.swing.JTextArea();
        jButtonActualizar = new javax.swing.JButton();

        jLabelTitulo.setFont(new java.awt.Font("SansSerif", java.awt.Font.BOLD, 16));
        jLabelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitulo.setText("Estadísticas del inventario");
        jLabelTitulo.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 0, 10, 0));

        jTextAreaEstadisticas.setEditable(false);
        jTextAreaEstadisticas.setColumns(20);
        jTextAreaEstadisticas.setFont(new java.awt.Font("Monospaced", java.awt.Font.PLAIN, 13));
        jTextAreaEstadisticas.setRows(10);
        jScrollPaneStats.setViewportView(jTextAreaEstadisticas);

        jButtonActualizar.setText("Actualizar estadísticas");
        jButtonActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonActualizarActionPerformed(evt);
            }
        });

        setLayout(new java.awt.BorderLayout());
        add(jLabelTitulo, java.awt.BorderLayout.NORTH);
        add(jScrollPaneStats, java.awt.BorderLayout.CENTER);
        add(jButtonActualizar, java.awt.BorderLayout.SOUTH);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonActualizarActionPerformed
        actualizar();
    }//GEN-LAST:event_jButtonActualizarActionPerformed

    /** Recalcula y muestra todas las estadísticas del inventario. */
    public void actualizar() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cantidad total de productos   : ").append(negocio.totalProductos()).append("\n");
        sb.append("Productos disponibles         : ").append(negocio.totalDisponibles()).append("\n");
        sb.append("Productos no disponibles      : ").append(negocio.totalNoDisponibles()).append("\n");
        sb.append("Unidades almacenadas (total)  : ").append(negocio.totalUnidades()).append("\n");

        Producto mayor = negocio.productoMayorPrecio();
        Producto menor = negocio.productoMenorPrecio();
        sb.append("Producto con mayor precio     : ")
          .append(mayor != null ? mayor.getNombre() + " ($" + mayor.getPrecio() + ")" : "N/A").append("\n");
        sb.append("Producto con menor precio     : ")
          .append(menor != null ? menor.getNombre() + " ($" + menor.getPrecio() + ")" : "N/A").append("\n");

        sb.append("\nProductos por categoría:\n");
        Map<String, Integer> porCategoria = negocio.productosPorCategoria();
        if (porCategoria.isEmpty()) {
            sb.append("  (sin datos)\n");
        } else {
            for (Map.Entry<String, Integer> e : porCategoria.entrySet()) {
                sb.append("  - ").append(e.getKey()).append(": ").append(e.getValue()).append("\n");
            }
        }
        sb.append("\nValor total del inventario    : $")
          .append(String.format("%.2f", negocio.valorTotalInventario()));

        jTextAreaEstadisticas.setText(sb.toString());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonActualizar;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JScrollPane jScrollPaneStats;
    private javax.swing.JTextArea jTextAreaEstadisticas;
    // End of variables declaration//GEN-END:variables
}
