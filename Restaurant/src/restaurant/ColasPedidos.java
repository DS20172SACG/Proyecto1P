/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant;

import java.util.*;
import restaurant.Personal.Observado;

/**
 *
 * @author Usuario
 */
public class ColasPedidos extends Observado{
    
    private static ColasPedidos instancia = new ColasPedidos();
    private Queue<String> colaNormal;
    private Queue<String> colaPrioritaria;
    private Queue<String> colaEntrega;
    
    private ColasPedidos(){
        colaNormal = new LinkedList<>();
        colaPrioritaria = new LinkedList<>();
        colaEntrega = new LinkedList<>();
    }    
    public void agregarPedidoNormal(String idPedido){
        colaNormal.offer(idPedido);
        notificarObservadores();
    }
    
    public void agregarPedidoPrioritario(String idPedido){
        colaPrioritaria.offer(idPedido);
        notificarObservadores();
    }
    
    public String atenderPedidoNormal(){
        return colaNormal.poll();
    }
    
    public String atenderPedidoPrioritario(){
        return colaNormal.poll();
    }  
    public void AgregarPedidoPorEntregar(String idPedido){
         colaEntrega.offer(idPedido);
         notificarObservadores();
    }
    public String PedidoPorEntregado(){
         return colaEntrega.poll();
    }
    public static ColasPedidos getInstancia(){
        return instancia;
    }
}
