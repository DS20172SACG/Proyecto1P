/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.Personal;

import Constantes.ConstantesTipoPersonal;
import Controladores.ControlCocinero;
import restaurant.ColasPedidos;

/**
 *
 * @author Usuario
 */
public class Cocinero extends Personal implements Observador{
    ColasPedidos cola= ColasPedidos.getInstancia();
    private int state;

    public Cocinero() {        
    }

    public Cocinero(String identificacion, String nombres, String apellidos, int Edad, double sueldo, String usuario) {
        super(identificacion, nombres, apellidos, Edad, sueldo, usuario);
        this.tipoPersonal = ConstantesTipoPersonal.COCINERO;
        control = new ControlCocinero(this);
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

    @Override
    public void ActualizarPedido() {
        System.out.println("El pedido ha sido preparado, y esta listo para ser entregado");
    }

}
