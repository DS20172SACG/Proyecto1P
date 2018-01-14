/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.Personal;

import restaurant.ColasPedidos;

/**
 *
 * @author Usuario
 */
public class Cocinero {
    ColasPedidos cola= ColasPedidos.getInstancia();
    private int state;

    public Cocinero() {
    }
    
    public void cocinarPedido(){
        String pedidoEnproceso;
        if((pedidoEnproceso=cola.atenderPedidoPrioritario())!=null){
            CambioEstadoPedido(pedidoEnproceso);
        }else{
            pedidoEnproceso=cola.atenderPedidoPrioritario();
            CambioEstadoPedido(pedidoEnproceso);
        }
    }
    public void CambioEstadoPedido(String pedidoEnproceso){
        System.out.println("Cocinando Pedido .......");
        PedidoTerminado(pedidoEnproceso);
    }
    
    
    public void PedidoTerminado(String idPedido){
        cola.AgregarPedidoPorEntregar(idPedido);
    }

}
