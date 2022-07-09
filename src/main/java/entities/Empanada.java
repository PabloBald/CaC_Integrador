package entities;

public class Empanada {
    private int id;
    private String nombre;
    private String descripcion;
    private Double precio;
    private String tipo;
    private int baja;

    public Empanada() {
    }

    public Empanada(int id, String nombre, String descripcion, Double precio, String tipo,int baja) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.tipo = tipo;
        this.baja=baja;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBaja(int baja) {
        this.baja = baja;
    }

    public Empanada(String nombre, String descripcion, Double precio, String tipo) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Empanada{" + "id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", precio=" + precio + ", tipo=" + tipo + ", baja=" + baja + '}';
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getTipo() {
        return tipo;
    }
    public int getBaja(){
    return baja;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
