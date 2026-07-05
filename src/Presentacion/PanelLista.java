package Presentacion;

import Modelo.Producto;
import Negocio.ProductoNegocio;

import java.util.List;

/**
 * Panel de lista de productos con búsqueda, filtro y ordenamiento.
 * Los componentes visuales son gestionados por el diseñador de NetBeans.
 */
public class PanelLista extends javax.swing.JPanel {

    private final ProductoNegocio negocio;
    private final PanelRegistro panelRegistro;
    private final MainFrame mainFrame;

    private javax.swing.table.DefaultTableModel modeloTabla;

    public PanelLista(ProductoNegocio negocio, PanelRegistro panelRegistro, MainFrame mainFrame) {
        this.negocio = negocio;
        this.panelRegistro = panelRegistro;
        this.mainFrame = mainFrame;
        initComponents();
        configurarTabla();
    }

    /** Configura el modelo de la tabla con las columnas requeridas. */
    private void configurarTabla() {
        modeloTabla = new javax.swing.table.DefaultTableModel(
            new String[]{"ID", "Código", "Nombre", "Categoría", "Cantidad", "Precio", "Disponible"}, 0
        ) {
            @Override
            public boolean isCellEditable(int row, int column) { return false; }
        };
        jTableProductos.setModel(modeloTabla);
        refrescarTabla();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelSuperior = new javax.swing.JPanel();
        jLabelBuscar = new javax.swing.JLabel();
        jTextFieldBuscar = new javax.swing.JTextField();
        jButtonBuscar = new javax.swing.JButton();
        jLabelCategoria = new javax.swing.JLabel();
        jComboBoxFiltro = new javax.swing.JComboBox();
        jButtonFiltrar = new javax.swing.JButton();
        jScrollPaneTabla = new javax.swing.JScrollPane();
        jTableProductos = new javax.swing.JTable();
        jPanelInferior = new javax.swing.JPanel();
        jButtonEditarSel = new javax.swing.JButton();
        jButtonEliminarSel = new javax.swing.JButton();
        jButtonOrdenNombre = new javax.swing.JButton();
        jButtonOrdenPrecio = new javax.swing.JButton();
        jButtonOrdenCantidad = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        jPanelSuperior.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));

        jLabelBuscar.setText("Buscar (nombre/código):");

        jButtonBuscar.setText("Buscar");
        jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarActionPerformed(evt);
            }
        });

        jLabelCategoria.setText("Categoría:");

        jComboBoxFiltro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Todas", "Electrónica", "Oficina", "Hogar", "Alimentos", "Ropa", "Otros" }));

        jButtonFiltrar.setText("Filtrar");
        jButtonFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFiltrarActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanelSuperiorLayout = new org.jdesktop.layout.GroupLayout(jPanelSuperior);
        jPanelSuperior.setLayout(jPanelSuperiorLayout);
        jPanelSuperiorLayout.setHorizontalGroup(
            jPanelSuperiorLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanelSuperiorLayout.createSequentialGroup()
                .addContainerGap()
                .add(jLabelBuscar)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jTextFieldBuscar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 160, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jButtonBuscar)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 15, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(jLabelCategoria)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jComboBoxFiltro, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 130, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jButtonFiltrar)
                .add(0, 0, Short.MAX_VALUE))
        );
        jPanelSuperiorLayout.setVerticalGroup(
            jPanelSuperiorLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanelSuperiorLayout.createSequentialGroup()
                .addContainerGap()
                .add(jPanelSuperiorLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabelBuscar)
                    .add(jTextFieldBuscar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jButtonBuscar)
                    .add(jLabelCategoria)
                    .add(jComboBoxFiltro, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jButtonFiltrar))
                .addContainerGap())
        );

        add(jPanelSuperior, java.awt.BorderLayout.NORTH);

        jTableProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Código", "Nombre", "Categoría", "Cantidad", "Precio", "Disponible"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableProductos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPaneTabla.setViewportView(jTableProductos);

        add(jScrollPaneTabla, java.awt.BorderLayout.CENTER);

        jPanelInferior.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));

        jButtonEditarSel.setText("Editar seleccionado");
        jButtonEditarSel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarSelActionPerformed(evt);
            }
        });

        jButtonEliminarSel.setText("Eliminar seleccionado");
        jButtonEliminarSel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarSelActionPerformed(evt);
            }
        });

        jButtonOrdenNombre.setText("Ordenar por nombre");
        jButtonOrdenNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOrdenNombreActionPerformed(evt);
            }
        });

        jButtonOrdenPrecio.setText("Ordenar por precio");
        jButtonOrdenPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOrdenPrecioActionPerformed(evt);
            }
        });

        jButtonOrdenCantidad.setText("Ordenar por cantidad");
        jButtonOrdenCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOrdenCantidadActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanelInferiorLayout = new org.jdesktop.layout.GroupLayout(jPanelInferior);
        jPanelInferior.setLayout(jPanelInferiorLayout);
        jPanelInferiorLayout.setHorizontalGroup(
            jPanelInferiorLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanelInferiorLayout.createSequentialGroup()
                .addContainerGap()
                .add(jButtonEditarSel)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jButtonEliminarSel)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 20, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(jButtonOrdenNombre)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jButtonOrdenPrecio)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jButtonOrdenCantidad)
                .addContainerGap())
        );
        jPanelInferiorLayout.setVerticalGroup(
            jPanelInferiorLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanelInferiorLayout.createSequentialGroup()
                .addContainerGap()
                .add(jPanelInferiorLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jButtonEditarSel)
                    .add(jButtonEliminarSel)
                    .add(jButtonOrdenNombre)
                    .add(jButtonOrdenPrecio)
                    .add(jButtonOrdenCantidad))
                .addContainerGap())
        );

        add(jPanelInferior, java.awt.BorderLayout.SOUTH);
    }// </editor-fold>//GEN-END:initComponents

    
    // Manejadores de eventos
   

    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed
        cargarFilas(negocio.buscar(jTextFieldBuscar.getText()));
    }//GEN-LAST:event_jButtonBuscarActionPerformed

    private void jButtonFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFiltrarActionPerformed
        cargarFilas(negocio.filtrarPorCategoria((String) jComboBoxFiltro.getSelectedItem()));
    }//GEN-LAST:event_jButtonFiltrarActionPerformed

    private void jButtonEditarSelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarSelActionPerformed
        Producto sel = obtenerProductoSeleccionado();
        if (sel != null) {
            panelRegistro.cargarProductoParaEditar(sel);
            mainFrame.seleccionarPestanaRegistro();
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Seleccione un producto de la tabla.",
                    "Aviso", javax.swing.JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButtonEditarSelActionPerformed

    private void jButtonEliminarSelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarSelActionPerformed
        Producto sel = obtenerProductoSeleccionado();
        if (sel == null) {
            javax.swing.JOptionPane.showMessageDialog(this, "Seleccione un producto de la tabla.",
                    "Aviso", javax.swing.JOptionPane.WARNING_MESSAGE);
            return;
        }
        int conf = javax.swing.JOptionPane.showConfirmDialog(this,
                "¿Está seguro de eliminar el producto \"" + sel.getNombre() + "\"?",
                "Confirmar eliminación", javax.swing.JOptionPane.YES_NO_OPTION);
        if (conf == javax.swing.JOptionPane.YES_OPTION) {
            negocio.eliminar(sel.getId());
            refrescarTabla();
            mainFrame.refrescarEstadisticas();
            javax.swing.JOptionPane.showMessageDialog(this, "Producto eliminado correctamente.");
        }
    }//GEN-LAST:event_jButtonEliminarSelActionPerformed

    private void jButtonOrdenNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOrdenNombreActionPerformed
        cargarFilas(negocio.ordenarPorNombre(negocio.listar()));
    }//GEN-LAST:event_jButtonOrdenNombreActionPerformed

    private void jButtonOrdenPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOrdenPrecioActionPerformed
        cargarFilas(negocio.ordenarPorPrecio(negocio.listar()));
    }//GEN-LAST:event_jButtonOrdenPrecioActionPerformed

    private void jButtonOrdenCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOrdenCantidadActionPerformed
        cargarFilas(negocio.ordenarPorCantidad(negocio.listar()));
    }//GEN-LAST:event_jButtonOrdenCantidadActionPerformed

    // Métodos públicos
   

    public void refrescarTabla() {
        cargarFilas(negocio.listar());
    }

    private void cargarFilas(List<Producto> productos) {
        modeloTabla.setRowCount(0);
        for (Producto p : productos) {
            modeloTabla.addRow(new Object[]{
                p.getId(), p.getCodigo(), p.getNombre(), p.getCategoria(),
                p.getCantidad(), p.getPrecio(), p.isDisponible() ? "Sí" : "No"
            });
        }
    }

    private Producto obtenerProductoSeleccionado() {
        int fila = jTableProductos.getSelectedRow();
        if (fila == -1) return null;
        int id = (int) modeloTabla.getValueAt(fila, 0);
        return negocio.buscarPorId(id);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonEditarSel;
    private javax.swing.JButton jButtonEliminarSel;
    private javax.swing.JButton jButtonFiltrar;
    private javax.swing.JButton jButtonOrdenCantidad;
    private javax.swing.JButton jButtonOrdenNombre;
    private javax.swing.JButton jButtonOrdenPrecio;
    private javax.swing.JComboBox jComboBoxFiltro;
    private javax.swing.JLabel jLabelBuscar;
    private javax.swing.JLabel jLabelCategoria;
    private javax.swing.JPanel jPanelInferior;
    private javax.swing.JPanel jPanelSuperior;
    private javax.swing.JScrollPane jScrollPaneTabla;
    private javax.swing.JTable jTableProductos;
    private javax.swing.JTextField jTextFieldBuscar;
    // End of variables declaration//GEN-END:variables
}
