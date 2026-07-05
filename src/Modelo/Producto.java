package Modelo;

/**
 * Clase modelo que representa un producto del inventario.
 */
public class Producto {

    private int id;
    private String codigo;
    private String nombre;
    private String categoria;
    private int cantidad;
    private double precio;
    private boolean disponible;
    private String descripcion;
    private String tipoProducto; 

    public Producto() {
    }

    public Producto(int id, String codigo, String nombre, String categoria, int cantidad,
                     double precio, boolean disponible, String descripcion, String tipoProducto) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.categoria = categoria;
        this.cantidad = cantidad;
        this.precio = precio;
        this.disponible = disponible;
        this.descripcion = descripcion;
        this.tipoProducto = tipoProducto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(String tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    /**
     * Valor total que aporta este producto al inventario (cantidad x precio).
     */
    public double getValorTotal() {
        return cantidad * precio;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", categoria='" + categoria + '\'' +
                ", cantidad=" + cantidad +
                ", precio=" + precio +
                ", disponible=" + disponible +
                ", descripcion='" + descripcion + '\'' +
                ", tipoProducto='" + tipoProducto + '\'' +
                '}';
    }
}
