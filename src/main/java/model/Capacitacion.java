package model;

public class Capacitacion {
    private int id;
    private String nombre;
    private String detalle;

    // Constructor vacío necesario para ciertas operaciones
    public Capacitacion() {}

    // Constructor con parámetros
    public Capacitacion(int id, String nombre, String detalle) {
        this.id = id;
        this.nombre = nombre;
        this.detalle = detalle;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    @Override
    public String toString() {
        return "Capacitacion:" +
               "id='" + id + '\'' +
               ", nombre='" + nombre + '\'' +
               ", descripcion='" + detalle + '\'' +
               '.';
    }
}