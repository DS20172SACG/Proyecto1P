/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.Personal;

import Constantes.ConstantesTipoPersonal;
import restaurant.ColasPedidos;
import static Constantes.TipoCola.*;
import Vistas.VistaMesero;

/**
 *
 * @author Usuario
 */
public class Mesero extends Personal implements Observador{
    ColasPedidos cola= ColasPedidos.getInstancia();

    public Mesero(String identificacion, String nombres, String apellidos, int Edad, double sueldo, String usuario) {
        super(identificacion, nombres, apellidos, Edad, sueldo, usuario);
        this.tipoPersonal = ConstantesTipoPersonal.MESERO;
    }
    
    public void IngresarPedido(String idPedido,int tipoCola){
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

    @Override
    public void presentarPantalla() {
        new VistaMesero().setVisible(true);
    }
}
