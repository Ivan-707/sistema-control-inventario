package Presentacion;

import Excepciones.DatoInvalidoException;
import Excepciones.ProductoDuplicadoException;
import Modelo.Producto;
import Negocio.ProductoNegocio;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

/**
 * Capa de Presentación.
 * Este panel se limita a capturar datos, mostrarlos y llamar a la capa de negocio.
 */
public class ProductoPanel extends JPanel {

    private final ProductoNegocio negocio;
    private final MainFrame mainFrame;

    // --- Componentes pestaña Registro ---
    private JTextField txtCodigo;
    private JTextField txtNombre;
    private JComboBox<String> cmbCategoria;
    private JTextField txtCantidad;
    private JTextField txtPrecio;
    private JCheckBox chkDisponible;
    private JRadioButton rbNacional;
    private JRadioButton rbImportado;
    private JTextArea txtDescripcion;
    private JButton btnGuardar;
    private JButton btnEditar;
    private JButton btnLimpiar;

    // ID del producto que se está editando (0 si es un registro nuevo).
    private int idEnEdicion = 0;

    // --- Componentes pestaña Lista ---
    private JTable tablaProductos;
    private DefaultTableModel modeloTabla;
    private JTextField txtBuscar;
    private JComboBox<String> cmbFiltroCategoria;

    public ProductoPanel(ProductoNegocio negocio, MainFrame mainFrame) {
        this.negocio = negocio;
        this.mainFrame = mainFrame;
        setLayout(new BorderLayout());
    }

    
    // PESTAÑA: REGISTRO DE PRODUCTOS
    

    public JPanel construirPanelRegistro() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JPanel formulario = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        int fila = 0;

        gbc.gridx = 0; gbc.gridy = fila;
        formulario.add(new JLabel("Código:"), gbc);
        txtCodigo = new JTextField(15);
        gbc.gridx = 1;
        formulario.add(txtCodigo, gbc);
        fila++;

        gbc.gridx = 0; gbc.gridy = fila;
        formulario.add(new JLabel("Nombre:"), gbc);
        txtNombre = new JTextField(15);
        gbc.gridx = 1;
        formulario.add(txtNombre, gbc);
        fila++;

        gbc.gridx = 0; gbc.gridy = fila;
        formulario.add(new JLabel("Categoría:"), gbc);
        cmbCategoria = new JComboBox<>(new String[]{
                "Electrónica", "Oficina", "Hogar", "Alimentos", "Ropa", "Otros"
        });
        gbc.gridx = 1;
        formulario.add(cmbCategoria, gbc);
        fila++;

        gbc.gridx = 0; gbc.gridy = fila;
        formulario.add(new JLabel("Cantidad:"), gbc);
        txtCantidad = new JTextField(15);
        gbc.gridx = 1;
        formulario.add(txtCantidad, gbc);
        fila++;

        gbc.gridx = 0; gbc.gridy = fila;
        formulario.add(new JLabel("Precio:"), gbc);
        txtPrecio = new JTextField(15);
        gbc.gridx = 1;
        formulario.add(txtPrecio, gbc);
        fila++;

        gbc.gridx = 0; gbc.gridy = fila;
        formulario.add(new JLabel("Disponible:"), gbc);
        chkDisponible = new JCheckBox("Sí, hay existencias");
        gbc.gridx = 1;
        formulario.add(chkDisponible, gbc);
        fila++;

        gbc.gridx = 0; gbc.gridy = fila;
        formulario.add(new JLabel("Tipo de producto:"), gbc);
        JPanel panelRadios = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        rbNacional = new JRadioButton("Nacional", true);
        rbImportado = new JRadioButton("Importado");
        ButtonGroup grupoTipo = new ButtonGroup();
        grupoTipo.add(rbNacional);
        grupoTipo.add(rbImportado);
        panelRadios.add(rbNacional);
        panelRadios.add(rbImportado);
        gbc.gridx = 1;
        formulario.add(panelRadios, gbc);
        fila++;

        gbc.gridx = 0; gbc.gridy = fila;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        formulario.add(new JLabel("Descripción:"), gbc);
        txtDescripcion = new JTextArea(4, 15);
        txtDescripcion.setLineWrap(true);
        txtDescripcion.setWrapStyleWord(true);
        JScrollPane scrollDescripcion = new JScrollPane(txtDescripcion);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        formulario.add(scrollDescripcion, gbc);

        panel.add(formulario, BorderLayout.CENTER);

        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        btnGuardar = new JButton("Guardar");
        btnEditar = new JButton("Editar");
        btnLimpiar = new JButton("Limpiar campos");
        panelBotones.add(btnGuardar);
        panelBotones.add(btnEditar);
        panelBotones.add(btnLimpiar);
        panel.add(panelBotones, BorderLayout.SOUTH);

        btnGuardar.addActionListener(e -> guardarProducto());
        btnEditar.addActionListener(e -> editarProductoActual());
        btnLimpiar.addActionListener(e -> limpiarCampos());

        return panel;
    }

    private void guardarProducto() {
        try {
            Producto producto = construirProductoDesdeFormulario();
            producto.setId(0); // Nuevo registro

            // Llamado a la capa de negocio: try/catch/throw demostrados aquí.
            negocio.agregar(producto);

            JOptionPane.showMessageDialog(this, "Producto guardado correctamente.",
                    "Éxito", JOptionPane.INFORMATION_MESSAGE);
            limpiarCampos();
            mainFrame.refrescarTabla();
            mainFrame.refrescarEstadisticas();

        } catch (DatoInvalidoException | ProductoDuplicadoException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void editarProductoActual() {
        if (idEnEdicion == 0) {
            JOptionPane.showMessageDialog(this,
                    "Seleccione un producto desde la pestaña 'Lista de productos' para editarlo.",
                    "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        try {
            Producto producto = construirProductoDesdeFormulario();
            producto.setId(idEnEdicion);

            negocio.editar(producto);

            JOptionPane.showMessageDialog(this, "Producto actualizado correctamente.",
                    "Éxito", JOptionPane.INFORMATION_MESSAGE);
            limpiarCampos();
            mainFrame.refrescarTabla();
            mainFrame.refrescarEstadisticas();

        } catch (DatoInvalidoException | ProductoDuplicadoException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Construye un objeto Producto a partir de los datos del formulario.
     */
    private Producto construirProductoDesdeFormulario() throws DatoInvalidoException {
        String codigo = txtCodigo.getText().trim();
        String nombre = txtNombre.getText().trim();
        String categoria = (String) cmbCategoria.getSelectedItem();
        int cantidad = negocio.parsearCantidad(txtCantidad.getText());
        double precio = negocio.parsearPrecio(txtPrecio.getText());
        boolean disponible = chkDisponible.isSelected();
        String descripcion = txtDescripcion.getText().trim();
        String tipoProducto = rbNacional.isSelected() ? "Nacional" : "Importado";

        return new Producto(0, codigo, nombre, categoria, cantidad, precio,
                disponible, descripcion, tipoProducto);
    }

    private void limpiarCampos() {
        txtCodigo.setText("");
        txtNombre.setText("");
        cmbCategoria.setSelectedIndex(0);
        txtCantidad.setText("");
        txtPrecio.setText("");
        chkDisponible.setSelected(false);
        rbNacional.setSelected(true);
        txtDescripcion.setText("");
        idEnEdicion = 0;
    }

    /**
     * llamado desde la pestaña Lista al seleccionar "Editar".
     */
    public void cargarProductoParaEditar(Producto producto) {
        idEnEdicion = producto.getId();
        txtCodigo.setText(producto.getCodigo());
        txtNombre.setText(producto.getNombre());
        cmbCategoria.setSelectedItem(producto.getCategoria());
        txtCantidad.setText(String.valueOf(producto.getCantidad()));
        txtPrecio.setText(String.valueOf(producto.getPrecio()));
        chkDisponible.setSelected(producto.isDisponible());
        if ("Importado".equals(producto.getTipoProducto())) {
            rbImportado.setSelected(true);
        } else {
            rbNacional.setSelected(true);
        }
        txtDescripcion.setText(producto.getDescripcion());
        mainFrame.seleccionarPestanaRegistro();
    }

  
    // PESTAÑA: LISTA DE PRODUCTOS

    public JPanel construirPanelLista() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // --- Panel superior: búsqueda y filtro ---
        JPanel panelSuperior = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 8));
        panelSuperior.add(new JLabel("Buscar (nombre/código):"));
        txtBuscar = new JTextField(15);
        panelSuperior.add(txtBuscar);

        JButton btnBuscar = new JButton("Buscar");
        panelSuperior.add(btnBuscar);

        panelSuperior.add(new JLabel("Categoría:"));
        cmbFiltroCategoria = new JComboBox<>(new String[]{
                "Todas", "Electrónica", "Oficina", "Hogar", "Alimentos", "Ropa", "Otros"
        });
        panelSuperior.add(cmbFiltroCategoria);

        JButton btnFiltrar = new JButton("Filtrar");
        panelSuperior.add(btnFiltrar);

        panel.add(panelSuperior, BorderLayout.NORTH);

        //Tabla
        String[] columnas = {"ID", "Código", "Nombre", "Categoría", "Cantidad", "Precio", "Disponible"};
        modeloTabla = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // La edición se hace mediante el formulario, no directamente en la tabla.
            }
        };
        tablaProductos = new JTable(modeloTabla);
        JScrollPane scrollTabla = new JScrollPane(tablaProductos);
        panel.add(scrollTabla, BorderLayout.CENTER);

        //Panel inferior: acciones 
        JPanel panelInferior = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        JButton btnEditarSeleccion = new JButton("Editar seleccionado");
        JButton btnEliminarSeleccion = new JButton("Eliminar seleccionado");
        JButton btnOrdenNombre = new JButton("Ordenar por nombre");
        JButton btnOrdenPrecio = new JButton("Ordenar por precio");
        JButton btnOrdenCantidad = new JButton("Ordenar por cantidad");
        panelInferior.add(btnEditarSeleccion);
        panelInferior.add(btnEliminarSeleccion);
        panelInferior.add(btnOrdenNombre);
        panelInferior.add(btnOrdenPrecio);
        panelInferior.add(btnOrdenCantidad);
        panel.add(panelInferior, BorderLayout.SOUTH);

        //Eventos 
        btnBuscar.addActionListener(e -> cargarFilas(negocio.buscar(txtBuscar.getText())));
        btnFiltrar.addActionListener(e ->
                cargarFilas(negocio.filtrarPorCategoria((String) cmbFiltroCategoria.getSelectedItem())));

        btnOrdenNombre.addActionListener(e -> cargarFilas(negocio.ordenarPorNombre(negocio.listar())));
        btnOrdenPrecio.addActionListener(e -> cargarFilas(negocio.ordenarPorPrecio(negocio.listar())));
        btnOrdenCantidad.addActionListener(e -> cargarFilas(negocio.ordenarPorCantidad(negocio.listar())));

        btnEditarSeleccion.addActionListener(e -> {
            Producto seleccionado = obtenerProductoSeleccionado();
            if (seleccionado != null) {
                cargarProductoParaEditar(seleccionado);
            } else {
                JOptionPane.showMessageDialog(this, "Seleccione un producto de la tabla.",
                        "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        });

        btnEliminarSeleccion.addActionListener(e -> {
            Producto seleccionado = obtenerProductoSeleccionado();
            if (seleccionado == null) {
                JOptionPane.showMessageDialog(this, "Seleccione un producto de la tabla.",
                        "Aviso", JOptionPane.WARNING_MESSAGE);
                return;
            }
            int confirmacion = JOptionPane.showConfirmDialog(this,
                    "¿Está seguro de eliminar el producto \"" + seleccionado.getNombre() + "\"?",
                    "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
            if (confirmacion == JOptionPane.YES_OPTION) {
                negocio.eliminar(seleccionado.getId());
                refrescarTabla();
                mainFrame.refrescarEstadisticas();
                JOptionPane.showMessageDialog(this, "Producto eliminado correctamente.");
            }
        });

        refrescarTabla();
        return panel;
    }

    private Producto obtenerProductoSeleccionado() {
        int fila = tablaProductos.getSelectedRow();
        if (fila == -1) {
            return null;
        }
        int id = (int) modeloTabla.getValueAt(fila, 0);
        return negocio.buscarPorId(id);
    }

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
}
