package Presentacion;

import Presentacion.MainFrame;

/**
 * Punto de entrada del Sistema de Control de Inventario.
 */
public class Main {
    public static void main(String[] args) {
        /* Iniciar en el Event Dispatch Thread de Swing */
        java.awt.EventQueue.invokeLater(() -> {
            new MainFrame().setVisible(true);
        });
    }
}
