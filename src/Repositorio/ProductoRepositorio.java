package Repositorio;

import Excepciones.ProductoDuplicadoException;
import Modelo.Producto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Capa de Repositorio.
 * Administra las Collections y las operaciones de almacenamiento en memoria.
 */
public class ProductoRepositorio {

    // List<Producto> -> almacena los productos registrados.
    private final List<Producto> productos;

    // Set<String> -> controla los códigos existentes para evitar duplicados de forma eficiente.
    private final Set<String> codigosRegistrados;

    // Contador autoincremental simple para asignar IDs.
    private int contadorId;

    public ProductoRepositorio() {
        this.productos = new ArrayList<>();
        this.codigosRegistrados = new HashSet<>();
        this.contadorId = 1;
    }

    /**
     * Agrega un producto nuevo al repositorio.
     * Lanza ProductoDuplicadoException si el código ya existe.
     */
    public void agregar(Producto producto) throws ProductoDuplicadoException {
        if (codigosRegistrados.contains(producto.getCodigo())) {
            throw new ProductoDuplicadoException(
                    "Ya existe un producto registrado con el código: " + producto.getCodigo());
        }
        producto.setId(contadorId++);
        productos.add(producto);
        codigosRegistrados.add(producto.getCodigo());
    }

    /**
     * Devuelve la lista completa de productos
     */
    public List<Producto> listar() {
        return new ArrayList<>(productos);
    }

    /**
     * Busca un producto por su código exacto.
     */
    public Producto buscarPorCodigo(String codigo) {
        for (Producto p : productos) {
            if (p.getCodigo().equalsIgnoreCase(codigo)) {
                return p;
            }
        }
        return null;
    }

    /**
     * Busca un producto por su ID.
     */
    public Producto buscarPorId(int id) {
        for (Producto p : productos) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    /**
     * Reemplaza los datos de un producto existente (identificado por ID).
     */
    public void editar(Producto productoEditado) throws ProductoDuplicadoException {
        Producto existente = buscarPorId(productoEditado.getId());
        if (existente == null) {
            return;
        }

        // Si el código cambió y el nuevo código ya pertenece a otro producto, es duplicado.
        if (!existente.getCodigo().equalsIgnoreCase(productoEditado.getCodigo())
                && codigosRegistrados.contains(productoEditado.getCodigo())) {
            throw new ProductoDuplicadoException(
                    "Ya existe un producto registrado con el código: " + productoEditado.getCodigo());
        }

        codigosRegistrados.remove(existente.getCodigo());

        existente.setCodigo(productoEditado.getCodigo());
        existente.setNombre(productoEditado.getNombre());
        existente.setCategoria(productoEditado.getCategoria());
        existente.setCantidad(productoEditado.getCantidad());
        existente.setPrecio(productoEditado.getPrecio());
        existente.setDisponible(productoEditado.isDisponible());
        existente.setDescripcion(productoEditado.getDescripcion());
        existente.setTipoProducto(productoEditado.getTipoProducto());

        codigosRegistrados.add(existente.getCodigo());
    }

    /**
     * Elimina un producto según su ID.
     */
    public boolean eliminar(int id) {
        Producto existente = buscarPorId(id);
        if (existente == null) {
            return false;
        }
        productos.remove(existente);
        codigosRegistrados.remove(existente.getCodigo());
        return true;
    }

    /**
     * Indica si un código ya está registrado.
     */
    public boolean existeCodigo(String codigo) {
        return codigosRegistrados.contains(codigo);
    }

    public int totalProductos() {
        return productos.size();
    }
}
