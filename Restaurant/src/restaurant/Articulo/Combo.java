/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.Articulo;

import java.util.LinkedList;

/**
 *
 * @author Usuario
 */
public class Combo extends Articulo{
    
    private LinkedList<Articulo> articulos;

    public Combo(String id, String nombre, String descripcion, double precio, boolean disponible, int minutosPreparacion, LinkedList<Articulo> articulos) {
        super(id, nombre, descripcion, precio, disponible, minutosPreparacion);
        this.articulos = articulos;
    }
    
}
