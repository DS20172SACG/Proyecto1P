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

    public Combo(String id, String nombre, String descripcion, double precio, boolean disponible, LinkedList<Articulo> articulos) {
        super(id, nombre, descripcion, precio, disponible);
        calcularMinutos();
        this.articulos = articulos;
    }
    
    private void calcularMinutos(){
        for(Articulo articulo : articulos){
            if(articulo.getMinutosPreparacion()>this.minutosPreparacion){
                this.minutosPreparacion += articulo.getMinutosPreparacion();
            }
        }
        this.minutosPreparacion = this.minutosPreparacion + (3*articulos.size());
    }
}
