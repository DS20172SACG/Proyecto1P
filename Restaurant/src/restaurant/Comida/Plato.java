/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.Comida;

/**
 *
 * @author Usuario
 */
public class Plato {
    private String id;
    private String nombre;
    private String descripcion;
    private double precio;
    private boolean disponible;
    private String idCategoria;

    public Plato() {
    }

    public Plato(String id, String nombre, String descripcion, double precio, boolean disponible, String categoria) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.disponible = disponible;
        this.idCategoria = categoria;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getCategoria() {
        return idCategoria;
    }

    public void setCategoria(String idCategoria) {
        this.idCategoria = idCategoria;
    }
    
    
}
