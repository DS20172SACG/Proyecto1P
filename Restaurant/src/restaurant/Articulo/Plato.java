/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.Articulo;

/**
 *
 * @author Usuario
 */
public class Plato extends Articulo {

    public Plato(String id, String nombre, String descripcion, double precio, boolean disponible,int minutosPreparacion, int categoria) {
        super(id, nombre, descripcion, precio, disponible, minutosPreparacion);
        this.categoria = categoria;
    }

}
