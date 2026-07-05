package Presentacion;

import Excepciones.DatoInvalidoException;
import Excepciones.ProductoDuplicadoException;
import Modelo.Producto;
import Negocio.ProductoNegocio;

/**
 * Panel de registro de productos.
 * Los componentes visuales son generados y mantenidos por el diseñador de NetBeans.
 * La lógica de negocio se delega a ProductoNegocio.
 */
public class PanelRegistro extends javax.swing.JPanel {

    private final ProductoNegocio negocio;
    private MainFrame mainFrame;

    /** ID del producto en edición; 0 significa nuevo registro. */
    private int idEnEdicion = 0;

    public PanelRegistro(ProductoNegocio negocio, MainFrame mainFrame) {
        this.negocio = negocio;
        this.mainFrame = mainFrame;
        initComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupTipo = new javax.swing.ButtonGroup();
        jLabelCodigo = new javax.swing.JLabel();
        jTextFieldCodigo = new javax.swing.JTextField();
        jLabelNombre = new javax.swing.JLabel();
        jTextFieldNombre = new javax.swing.JTextField();
        jLabelCategoria = new javax.swing.JLabel();
        jComboBoxCategoria = new javax.swing.JComboBox<>();
        jLabelCantidad = new javax.swing.JLabel();
        jTextFieldCantidad = new javax.swing.JTextField();
        jLabelPrecio = new javax.swing.JLabel();
        jTextFieldPrecio = new javax.swing.JTextField();
        jLabelDisponible = new javax.swing.JLabel();
        jCheckBoxDisponible = new javax.swing.JCheckBox();
        jLabelTipo = new javax.swing.JLabel();
        jRadioButtonNacional = new javax.swing.JRadioButton();
        jRadioButtonImportado = new javax.swing.JRadioButton();
        jLabelDescripcion = new javax.swing.JLabel();
        jScrollPaneDescripcion = new javax.swing.JScrollPane();
        jTextAreaDescripcion = new javax.swing.JTextArea();
        jButtonGuardar = new javax.swing.JButton();
        jButtonEditar = new javax.swing.JButton();
        jButtonLimpiar = new javax.swing.JButton();

        jLabelCodigo.setText("Código:");

        jLabelNombre.setText("Nombre:");

        jLabelCategoria.setText("Categoría:");

        jComboBoxCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {
            "Electrónica", "Oficina", "Hogar", "Alimentos", "Ropa", "Otros"
        }));

        jLabelCantidad.setText("Cantidad:");

        jLabelPrecio.setText("Precio:");

        jLabelDisponible.setText("Disponible:");

        jCheckBoxDisponible.setText("Sí, hay existencias");

        jLabelTipo.setText("Tipo de producto:");

        buttonGroupTipo.add(jRadioButtonNacional);
        jRadioButtonNacional.setSelected(true);
        jRadioButtonNacional.setText("Nacional");

        buttonGroupTipo.add(jRadioButtonImportado);
        jRadioButtonImportado.setText("Importado");

        jLabelDescripcion.setText("Descripción:");

        jTextAreaDescripcion.setColumns(20);
        jTextAreaDescripcion.setRows(4);
        jScrollPaneDescripcion.setViewportView(jTextAreaDescripcion);

        jButtonGuardar.setText("Guardar");
        jButtonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuardarActionPerformed(evt);
            }
        });

        jButtonEditar.setText("Editar");
        jButtonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarActionPerformed(evt);
            }
        });

        jButtonLimpiar.setText("Limpiar campos");
        jButtonLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelCodigo)
                            .addComponent(jLabelNombre)
                            .addComponent(jLabelCategoria)
                            .addComponent(jLabelCantidad)
                            .addComponent(jLabelPrecio)
                            .addComponent(jLabelDisponible)
                            .addComponent(jLabelTipo)
                            .addComponent(jLabelDescripcion))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBoxDisponible)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jRadioButtonNacional)
                                .addGap(15, 15, 15)
                                .addComponent(jRadioButtonImportado))
                            .addComponent(jScrollPaneDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonGuardar)
                        .addGap(10, 10, 10)
                        .addComponent(jButtonEditar)
                        .addGap(10, 10, 10)
                        .addComponent(jButtonLimpiar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCodigo)
                    .addComponent(jTextFieldCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNombre)
                    .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCategoria)
                    .addComponent(jComboBoxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCantidad)
                    .addComponent(jTextFieldCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPrecio)
                    .addComponent(jTextFieldPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDisponible)
                    .addComponent(jCheckBoxDisponible))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTipo)
                    .addComponent(jRadioButtonNacional)
                    .addComponent(jRadioButtonImportado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelDescripcion)
                    .addComponent(jScrollPaneDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonGuardar)
                    .addComponent(jButtonEditar)
                    .addComponent(jButtonLimpiar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // ---------------------------------------------------------------
    // Manejadores de eventos (fuera del código generado)
    // ---------------------------------------------------------------

    private void jButtonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarActionPerformed
        guardarProducto();
    }//GEN-LAST:event_jButtonGuardarActionPerformed

    private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarActionPerformed
        editarProductoActual();
    }//GEN-LAST:event_jButtonEditarActionPerformed

    private void jButtonLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimpiarActionPerformed
        limpiarCampos();
    }//GEN-LAST:event_jButtonLimpiarActionPerformed

    // ---------------------------------------------------------------
    // Lógica de presentación (delega a negocio)
    // ---------------------------------------------------------------

    private void guardarProducto() {
        try {
            Producto producto = construirProductoDesdeFormulario();
            producto.setId(0);
            negocio.agregar(producto);
            javax.swing.JOptionPane.showMessageDialog(this, "Producto guardado correctamente.",
                    "Éxito", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            limpiarCampos();
            mainFrame.refrescarTabla();
            mainFrame.refrescarEstadisticas();
        } catch (DatoInvalidoException | ProductoDuplicadoException e) {
            javax.swing.JOptionPane.showMessageDialog(this, e.getMessage(),
                    "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }

    private void editarProductoActual() {
        if (idEnEdicion == 0) {
            javax.swing.JOptionPane.showMessageDialog(this,
                    "Seleccione un producto desde la pestaña 'Lista de productos' para editarlo.",
                    "Aviso", javax.swing.JOptionPane.WARNING_MESSAGE);
            return;
        }
        try {
            Producto producto = construirProductoDesdeFormulario();
            producto.setId(idEnEdicion);
            negocio.editar(producto);
            javax.swing.JOptionPane.showMessageDialog(this, "Producto actualizado correctamente.",
                    "Éxito", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            limpiarCampos();
            mainFrame.refrescarTabla();
            mainFrame.refrescarEstadisticas();
        } catch (DatoInvalidoException | ProductoDuplicadoException e) {
            javax.swing.JOptionPane.showMessageDialog(this, e.getMessage(),
                    "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }

    /** Construye un Producto con los valores del formulario. */
    private Producto construirProductoDesdeFormulario() throws DatoInvalidoException {
        String codigo = jTextFieldCodigo.getText().trim();
        String nombre = jTextFieldNombre.getText().trim();
        String categoria = (String) jComboBoxCategoria.getSelectedItem();
        int cantidad = negocio.parsearCantidad(jTextFieldCantidad.getText());
        double precio = negocio.parsearPrecio(jTextFieldPrecio.getText());
        boolean disponible = jCheckBoxDisponible.isSelected();
        String descripcion = jTextAreaDescripcion.getText().trim();
        String tipo = jRadioButtonNacional.isSelected() ? "Nacional" : "Importado";
        return new Producto(0, codigo, nombre, categoria, cantidad, precio, disponible, descripcion, tipo);
    }

    public void limpiarCampos() {
        jTextFieldCodigo.setText("");
        jTextFieldNombre.setText("");
        jComboBoxCategoria.setSelectedIndex(0);
        jTextFieldCantidad.setText("");
        jTextFieldPrecio.setText("");
        jCheckBoxDisponible.setSelected(false);
        jRadioButtonNacional.setSelected(true);
        jTextAreaDescripcion.setText("");
        idEnEdicion = 0;
    }

    /** Carga datos de un producto para su edición (llamado desde PanelLista). */
    public void cargarProductoParaEditar(Producto producto) {
        idEnEdicion = producto.getId();
        jTextFieldCodigo.setText(producto.getCodigo());
        jTextFieldNombre.setText(producto.getNombre());
        jComboBoxCategoria.setSelectedItem(producto.getCategoria());
        jTextFieldCantidad.setText(String.valueOf(producto.getCantidad()));
        jTextFieldPrecio.setText(String.valueOf(producto.getPrecio()));
        jCheckBoxDisponible.setSelected(producto.isDisponible());
        if ("Importado".equals(producto.getTipoProducto())) {
            jRadioButtonImportado.setSelected(true);
        } else {
            jRadioButtonNacional.setSelected(true);
        }
        jTextAreaDescripcion.setText(producto.getDescripcion());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupTipo;
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JButton jButtonGuardar;
    private javax.swing.JButton jButtonLimpiar;
    private javax.swing.JCheckBox jCheckBoxDisponible;
    private javax.swing.JComboBox<String> jComboBoxCategoria;
    private javax.swing.JLabel jLabelCategoria;
    private javax.swing.JLabel jLabelCodigo;
    private javax.swing.JLabel jLabelCantidad;
    private javax.swing.JLabel jLabelDescripcion;
    private javax.swing.JLabel jLabelDisponible;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JLabel jLabelPrecio;
    private javax.swing.JLabel jLabelTipo;
    private javax.swing.JRadioButton jRadioButtonImportado;
    private javax.swing.JRadioButton jRadioButtonNacional;
    private javax.swing.JScrollPane jScrollPaneDescripcion;
    private javax.swing.JTextArea jTextAreaDescripcion;
    private javax.swing.JTextField jTextFieldCantidad;
    private javax.swing.JTextField jTextFieldCodigo;
    private javax.swing.JTextField jTextFieldNombre;
    private javax.swing.JTextField jTextFieldPrecio;
    // End of variables declaration//GEN-END:variables
}
