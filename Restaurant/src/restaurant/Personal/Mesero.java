/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.Personal;

import restaurant.ColasPedidos;
import static Constantes.TipoCola.*;

/**
 *
 * @author Usuario
 */
public class Mesero extends Personal{
    ColasPedidos cola= ColasPedidos.getInstancia();
    
    
    public void IngresarPedido(String idPedido,int tipoCola){
        //cola.add(idPedido);
        
        if(tipoCola==COLAPREFERENCIAL){
            cola.agregarPedidoPrioritario(idPedido);
        }
        else{
            cola.agregarPedidoNormal(idPedido);
        }
    }
}
