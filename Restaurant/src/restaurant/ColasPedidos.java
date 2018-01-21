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
    private Queue<Integer> colaNormal;
    private Queue<Integer> colaPrioritaria;
    private Queue<Integer> colaEntrega;
    
    private ColasPedidos(){
        colaNormal = new LinkedList<>();
        colaPrioritaria = new LinkedList<>();
        colaEntrega = new LinkedList<>();
    }    
    public void agregarPedidoNormal(int idPedido){
        colaNormal.offer(idPedido);
        notificarObservadores();
    }
    
    public void agregarPedidoPrioritario(int idPedido){
        colaPrioritaria.offer(idPedido);
        notificarObservadores();
    }
    
    public int atenderPedidoNormal(){
        return colaNormal.poll();
    }
    
    public int atenderPedidoPrioritario(){
        return colaNormal.poll();
    }
    
    public void AgregarPedidoPorEntregar(int idPedido){
         colaEntrega.offer(idPedido);
         notificarObservadores();
    }
    
    public int PedidoPorEntregado(){
         return colaEntrega.poll();
    }
    
    public static ColasPedidos getInstancia(){
        return instancia;
    }
    
}
