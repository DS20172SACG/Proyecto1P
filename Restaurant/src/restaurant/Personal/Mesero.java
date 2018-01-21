/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.Personal;

import BaseDeDatos.Consultador;
import BaseDeDatos.Escritor;
import Constantes.ConstantesTipoPersonal;
import restaurant.ColasPedidos;
import static Constantes.TipoCola.*;
import Controladores.ControlMesero;
import Pedidos.DetallePedido;
import Pedidos.PedidoPresencial;
import java.util.LinkedList;

/**
 *
 * @author Usuario
 */
public class Mesero extends Personal implements Observador{
    ColasPedidos cola= ColasPedidos.getInstancia();
    private LinkedList<DetallePedido> detallePedidoNuevo;

    public Mesero(String identificacion, String nombres, String apellidos, int Edad, double sueldo, String usuario) {
        super(identificacion, nombres, apellidos, Edad, sueldo, usuario);
        this.tipoPersonal = ConstantesTipoPersonal.MESERO;
        control = new ControlMesero(this);
        detallePedidoNuevo = new LinkedList<>();
    }

    public LinkedList<DetallePedido> getDetallePedidoNuevo() {
        return detallePedidoNuevo;
    }

    public void setDetallePedidoNuevo(LinkedList<DetallePedido> detallePedidoNuevo) {
        this.detallePedidoNuevo = detallePedidoNuevo;
    }
    
    public void ingresarPedidoACola(int idPedido,int tipoCola){
        //cola.add(idPedido);
        
        if(tipoCola==COLAPREFERENCIAL){
            cola.agregarPedidoPrioritario(idPedido);
        }
        else{
            cola.agregarPedidoNormal(idPedido);
        }
    }

    @Override
    public void ActualizarPedido() {
        System.out.println("El pedido ha sido puesto en la cola para ser preparado");
    }
    
    public double totalDetalle(){
        double total = 0;
        for(DetallePedido detalle : detallePedidoNuevo){
            total += detalle.getPrecioArticulo()*detalle.getCantidad();
        }
        return total;
    }
    
    public void ingresarPedidoPresencial(PedidoPresencial pedido){
        pedido.setIdPedido(Escritor.ingresarPedidoPresencial(pedido));
        System.out.println(pedido.getIdPedido());
        for(DetallePedido d : detallePedidoNuevo){
            d.setIdPedido(pedido.getIdPedido());
            d.setIdArticulo(Consultador.getInstancia().idArticuloPorNombre(d.getNombreArticulo()));
        }
        Escritor.ingresarDetallePedido(detallePedidoNuevo);
        detallePedidoNuevo.clear();
        ingresarPedidoACola(pedido.getIdPedido(), pedido.isPreferencial() ? 1 : 0);
    }
    
    
}
