package Negocio;

import Excepciones.DatoInvalidoException;
import Excepciones.ProductoDuplicadoException;
import Modelo.Producto;
import Repositorio.ProductoRepositorio;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * Capa de Negocio.
 * Contiene las validaciones, reglas del sistema, ordenamientos,
 */
public class ProductoNegocio {

    private final ProductoRepositorio repositorio;

    // Stack<String> -> historial de acciones realizadas en el sistema.
    private final Stack<String> historial;

    public ProductoNegocio() {
        this.repositorio = new ProductoRepositorio();
        this.historial = new Stack<>();
    }

    // 
    // Registro / edición / eliminación
    // 

    public void agregar(Producto producto) throws DatoInvalidoException, ProductoDuplicadoException {
        validar(producto);
        repositorio.agregar(producto);
        historial.push("Producto registrado: " + producto.getNombre());
    }

    public void editar(Producto producto) throws DatoInvalidoException, ProductoDuplicadoException {
        validar(producto);
        repositorio.editar(producto);
        historial.push("Producto editado: " + producto.getNombre());
    }

    public boolean eliminar(int id) {
        Producto p = repositorio.buscarPorId(id);
        boolean resultado = repositorio.eliminar(id);
        if (resultado && p != null) {
            historial.push("Producto eliminado: " + p.getNombre());
        }
        return resultado;
    }

    public List<Producto> listar() {
        return repositorio.listar();
    }

    public Producto buscarPorId(int id) {
        return repositorio.buscarPorId(id);
    }

    public Producto buscarPorCodigo(String codigo) {
        return repositorio.buscarPorCodigo(codigo);
    }

    public boolean existeCodigo(String codigo) {
        return repositorio.existeCodigo(codigo);
    }

    /**
     * Búsqueda por nombre o código (coincidencia parcial, sin distinguir mayúsculas).
     */
    public List<Producto> buscar(String texto) {
        List<Producto> resultado = new ArrayList<>();
        String filtro = texto == null ? "" : texto.toLowerCase().trim();
        for (Producto p : repositorio.listar()) {
            if (p.getNombre().toLowerCase().contains(filtro)
                    || p.getCodigo().toLowerCase().contains(filtro)) {
                resultado.add(p);
            }
        }
        return resultado;
    }

    /**
     * Filtra productos por categoría. Si la categoría es "Todas" o vacía, retorna todos.
     */
    public List<Producto> filtrarPorCategoria(String categoria) {
        if (categoria == null || categoria.isEmpty() || categoria.equalsIgnoreCase("Todas")) {
            return repositorio.listar();
        }
        List<Producto> resultado = new ArrayList<>();
        for (Producto p : repositorio.listar()) {
            if (p.getCategoria().equalsIgnoreCase(categoria)) {
                resultado.add(p);
            }
        }
        return resultado;
    }

    // 
    // Validaciones (regla de negocio)
    //

    private void validar(Producto producto) throws DatoInvalidoException, ProductoDuplicadoException {
        if (producto.getCodigo() == null || producto.getCodigo().trim().isEmpty()) {
            throw new DatoInvalidoException("El código es obligatorio.");
        }
        if (producto.getNombre() == null || producto.getNombre().trim().isEmpty()) {
            throw new DatoInvalidoException("El nombre es obligatorio.");
        }
        if (producto.getNombre().trim().length() < 3) {
            throw new DatoInvalidoException("El nombre debe tener mínimo tres caracteres.");
        }
        if (producto.getCategoria() == null || producto.getCategoria().trim().isEmpty()) {
            throw new DatoInvalidoException("La categoría es obligatoria.");
        }
        if (producto.getCantidad() < 0) {
            throw new DatoInvalidoException("La cantidad debe ser mayor o igual que cero.");
        }
        if (producto.getPrecio() <= 0) {
            throw new DatoInvalidoException("El precio debe ser mayor que cero.");
        }

        // Validación de duplicados solo aplica si es un producto nuevo (id == 0)
        
        if (producto.getId() == 0 && repositorio.existeCodigo(producto.getCodigo())) {
            throw new ProductoDuplicadoException(
                    "Ya existe un producto registrado con el código: " + producto.getCodigo());
        }
    }

    /**
     * Convierte y valida un texto a entero, lanzando DatoInvalidoException
     */
    public int parsearCantidad(String texto) throws DatoInvalidoException {
        try {
            if (texto == null || texto.trim().isEmpty()) {
                throw new DatoInvalidoException("La cantidad es obligatoria.");
            }
            return Integer.parseInt(texto.trim());
        } catch (NumberFormatException e) {
            // Encadenamiento de excepciones: se conserva la causa original.
            throw new DatoInvalidoException("La cantidad debe ser un valor numérico entero.", e);
        }
    }

    /**
     * si no es numérico (usada para validar Precio desde la interfaz).
     */
    public double parsearPrecio(String texto) throws DatoInvalidoException {
        try {
            if (texto == null || texto.trim().isEmpty()) {
                throw new DatoInvalidoException("El precio es obligatorio.");
            }
            return Double.parseDouble(texto.trim());
        } catch (NumberFormatException e) {
            throw new DatoInvalidoException("El precio debe ser un valor numérico.", e);
        }
    }

    // 
    // Ordenamientos (Collections.sort + Comparator<Producto>)
    // 

    public List<Producto> ordenarPorNombre(List<Producto> lista) {
        List<Producto> copia = new ArrayList<>(lista);
        copia.sort(Comparator.comparing(Producto::getNombre, String.CASE_INSENSITIVE_ORDER));
        return copia;
    }

    public List<Producto> ordenarPorPrecio(List<Producto> lista) {
        List<Producto> copia = new ArrayList<>(lista);
        copia.sort(Comparator.comparingDouble(Producto::getPrecio));
        return copia;
    }

    public List<Producto> ordenarPorCantidad(List<Producto> lista) {
        List<Producto> copia = new ArrayList<>(lista);
        copia.sort(Comparator.comparingInt(Producto::getCantidad));
        return copia;
    }

    // 
    // Estadísticas
    // 

    public int totalProductos() {
        return repositorio.listar().size();
    }

    public long totalDisponibles() {
        return repositorio.listar().stream().filter(Producto::isDisponible).count();
    }

    public long totalNoDisponibles() {
        return totalProductos() - totalDisponibles();
    }

    public int totalUnidades() {
        int total = 0;
        for (Producto p : repositorio.listar()) {
            total += p.getCantidad();
        }
        return total;
    }

    public Producto productoMayorPrecio() {
        Producto mayor = null;
        for (Producto p : repositorio.listar()) {
            if (mayor == null || p.getPrecio() > mayor.getPrecio()) {
                mayor = p;
            }
        }
        return mayor;
    }

    public Producto productoMenorPrecio() {
        Producto menor = null;
        for (Producto p : repositorio.listar()) {
            if (menor == null || p.getPrecio() < menor.getPrecio()) {
                menor = p;
            }
        }
        return menor;
    }

    /**
     * Map<String, Integer> -> cantidad de productos por categoría.
     */
    public Map<String, Integer> productosPorCategoria() {
        Map<String, Integer> mapa = new HashMap<>();
        for (Producto p : repositorio.listar()) {
            mapa.merge(p.getCategoria(), 1, Integer::sum);
        }
        return mapa;
    }

    public double valorTotalInventario() {
        double total = 0;
        for (Producto p : repositorio.listar()) {
            total += p.getValorTotal();
        }
        return total;
    }

    // 
    // Historial (Stack<String>)
    // 

    public void registrarAccion(String accion) {
        historial.push(accion);
    }

    public List<String> obtenerHistorial() {
        // Se invierte para mostrar lo más reciente primero, sin alterar el Stack original.
        List<String> lista = new ArrayList<>(historial);
        java.util.Collections.reverse(lista);
        return lista;
    }
}
