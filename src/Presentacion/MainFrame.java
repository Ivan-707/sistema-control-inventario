package Presentacion;

import Excepciones.ArchivoException;
import Modelo.Producto;
import Negocio.ProductoNegocio;
import Util.ArchivoUtil;

import java.io.File;
import java.util.List;

/**
 * Ventana principal del Sistema de Control de Inventario.
 * El JMenuBar, JToolBar y JTabbedPane son gestionados por el diseñador de NetBeans.
 * Los tres paneles (PanelRegistro, PanelLista, PanelEstadisticas) se añaden al
 * JTabbedPane en el constructor, después de initComponents().
 */
public class MainFrame extends javax.swing.JFrame {

    private final ProductoNegocio negocio;
    private PanelRegistro panelRegistro;
    private PanelLista panelLista;
    private PanelEstadisticas panelEstadisticas;

    public MainFrame() {
        this.negocio = new ProductoNegocio();

        // 1) Primero se crean los paneles auxiliares
        panelEstadisticas = new PanelEstadisticas(negocio);
        panelRegistro = new PanelRegistro(negocio, this);
        panelLista = new PanelLista(negocio, panelRegistro, this);

        // 2) initComponents genera el JMenuBar, JToolBar y el JTabbedPane vacío
        initComponents();

        // 3) Se agregan los paneles a las pestañas (fuera del código generado)
        jTabbedPane1.addTab("Registro de productos", panelRegistro);
        jTabbedPane1.addTab("Lista de productos", panelLista);
        jTabbedPane1.addTab("Estadísticas", panelEstadisticas);

        setLocationRelativeTo(null);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnOrdenar = new javax.swing.JButton();
        btnExportar = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuArchivo = new javax.swing.JMenu();
        itemNuevo = new javax.swing.JMenuItem();
        itemExportar = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        itemSalir = new javax.swing.JMenuItem();
        menuHerramientas = new javax.swing.JMenu();
        itemOrdenar = new javax.swing.JMenuItem();
        itemEstadisticas = new javax.swing.JMenuItem();
        itemHistorial = new javax.swing.JMenuItem();
        menuAyuda = new javax.swing.JMenu();
        itemAcerca = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de Control de Inventario");
        setMinimumSize(new java.awt.Dimension(950, 650));

        // --- JToolBar ---
        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        btnNuevo.setText("Nuevo");
        btnNuevo.setFocusable(false);
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        jToolBar1.add(btnNuevo);

        btnGuardar.setText("Guardar");
        btnGuardar.setFocusable(false);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnGuardar);

        btnEditar.setText("Editar");
        btnEditar.setFocusable(false);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnEditar);

        btnEliminar.setText("Eliminar");
        btnEliminar.setFocusable(false);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnEliminar);

        btnOrdenar.setText("Ordenar");
        btnOrdenar.setFocusable(false);
        btnOrdenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrdenarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnOrdenar);

        btnExportar.setText("Exportar");
        btnExportar.setFocusable(false);
        btnExportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnExportar);

        // --- JMenuBar ---
        menuArchivo.setText("Archivo");

        itemNuevo.setText("Nuevo producto");
        itemNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemNuevoActionPerformed(evt);
            }
        });
        menuArchivo.add(itemNuevo);

        itemExportar.setText("Exportar inventario");
        itemExportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemExportarActionPerformed(evt);
            }
        });
        menuArchivo.add(itemExportar);
        menuArchivo.add(jSeparator1);

        itemSalir.setText("Salir");
        itemSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemSalirActionPerformed(evt);
            }
        });
        menuArchivo.add(itemSalir);
        jMenuBar1.add(menuArchivo);

        menuHerramientas.setText("Herramientas");

        itemOrdenar.setText("Ordenar productos");
        itemOrdenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemOrdenarActionPerformed(evt);
            }
        });
        menuHerramientas.add(itemOrdenar);

        itemEstadisticas.setText("Ver estadísticas");
        itemEstadisticas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemEstadisticasActionPerformed(evt);
            }
        });
        menuHerramientas.add(itemEstadisticas);

        itemHistorial.setText("Ver historial");
        itemHistorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemHistorialActionPerformed(evt);
            }
        });
        menuHerramientas.add(itemHistorial);
        jMenuBar1.add(menuHerramientas);

        menuAyuda.setText("Ayuda");

        itemAcerca.setText("Acerca del sistema");
        itemAcerca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemAcercaActionPerformed(evt);
            }
        });
        menuAyuda.add(itemAcerca);
        jMenuBar1.add(menuAyuda);

        setJMenuBar(jMenuBar1);

        getContentPane().setLayout(new java.awt.BorderLayout());
        getContentPane().add(jToolBar1, java.awt.BorderLayout.NORTH);
        getContentPane().add(jTabbedPane1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // ---------------------------------------------------------------
    // Manejadores de eventos del toolbar
    // ---------------------------------------------------------------

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        seleccionarPestanaRegistro();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        seleccionarPestanaRegistro();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        seleccionarPestanaLista();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        seleccionarPestanaLista();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnOrdenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrdenarActionPerformed
        seleccionarPestanaLista();
    }//GEN-LAST:event_btnOrdenarActionPerformed

    private void btnExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarActionPerformed
        exportarInventario();
    }//GEN-LAST:event_btnExportarActionPerformed

    // ---------------------------------------------------------------
    // Manejadores de eventos del menú
    // ---------------------------------------------------------------

    private void itemNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemNuevoActionPerformed
        seleccionarPestanaRegistro();
    }//GEN-LAST:event_itemNuevoActionPerformed

    private void itemExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemExportarActionPerformed
        exportarInventario();
    }//GEN-LAST:event_itemExportarActionPerformed

    private void itemSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_itemSalirActionPerformed

    private void itemOrdenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemOrdenarActionPerformed
        seleccionarPestanaLista();
    }//GEN-LAST:event_itemOrdenarActionPerformed

    private void itemEstadisticasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemEstadisticasActionPerformed
        seleccionarPestanaEstadisticas();
    }//GEN-LAST:event_itemEstadisticasActionPerformed

    private void itemHistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemHistorialActionPerformed
        mostrarHistorial();
    }//GEN-LAST:event_itemHistorialActionPerformed

    private void itemAcercaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemAcercaActionPerformed
        javax.swing.JOptionPane.showMessageDialog(this,
                "Sistema de Control de Inventario\nProgramación IV\nDesarrollado en Java Swing.",
                "Acerca del sistema", javax.swing.JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_itemAcercaActionPerformed

    // ---------------------------------------------------------------
    // Métodos públicos (usados por los paneles hijos)
    // ---------------------------------------------------------------

    public void seleccionarPestanaRegistro() {
        jTabbedPane1.setSelectedIndex(0);
    }

    public void seleccionarPestanaLista() {
        jTabbedPane1.setSelectedIndex(1);
    }

    public void seleccionarPestanaEstadisticas() {
        jTabbedPane1.setSelectedIndex(2);
        panelEstadisticas.actualizar();
    }

    public void refrescarTabla() {
        panelLista.refrescarTabla();
    }

    public void refrescarEstadisticas() {
        panelEstadisticas.actualizar();
    }

    private void mostrarHistorial() {
        List<String> historial = negocio.obtenerHistorial();
        StringBuilder sb = new StringBuilder();
        if (historial.isEmpty()) {
            sb.append("Aún no se han realizado acciones.");
        } else {
            for (String accion : historial) {
                sb.append("- ").append(accion).append("\n");
            }
        }
        javax.swing.JTextArea area = new javax.swing.JTextArea(sb.toString(), 15, 35);
        area.setEditable(false);
        javax.swing.JOptionPane.showMessageDialog(this, new javax.swing.JScrollPane(area),
                "Historial de acciones", javax.swing.JOptionPane.INFORMATION_MESSAGE);
    }

    private void exportarInventario() {
        List<Producto> productos = negocio.listar();
        if (productos.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "No hay productos para exportar.",
                    "Aviso", javax.swing.JOptionPane.WARNING_MESSAGE);
            return;
        }
        javax.swing.JFileChooser fileChooser = new javax.swing.JFileChooser();
        fileChooser.setDialogTitle("Exportar inventario");
        fileChooser.setSelectedFile(new File("inventario.csv"));
        if (fileChooser.showSaveDialog(this) != javax.swing.JFileChooser.APPROVE_OPTION) return;

        try {
            ArchivoUtil.exportarInventario(fileChooser.getSelectedFile(), productos);
            negocio.registrarAccion("Inventario exportado correctamente");
            javax.swing.JOptionPane.showMessageDialog(this,
                    "Inventario exportado en:\n" + fileChooser.getSelectedFile().getAbsolutePath(),
                    "Éxito", javax.swing.JOptionPane.INFORMATION_MESSAGE);
        } catch (ArchivoException e) {
            javax.swing.JOptionPane.showMessageDialog(this, e.getMessage(),
                    "Error al exportar", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnExportar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnOrdenar;
    private javax.swing.JMenuItem itemAcerca;
    private javax.swing.JMenuItem itemEstadisticas;
    private javax.swing.JMenuItem itemExportar;
    private javax.swing.JMenuItem itemHistorial;
    private javax.swing.JMenuItem itemNuevo;
    private javax.swing.JMenuItem itemOrdenar;
    private javax.swing.JMenuItem itemSalir;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JMenu menuArchivo;
    private javax.swing.JMenu menuAyuda;
    private javax.swing.JMenu menuHerramientas;
    // End of variables declaration//GEN-END:variables
}
