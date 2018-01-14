/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;
import restaurant.Personal.Observador;

/**
 *
 * @author Usuario
 */
public class ColasPedidos {
    private Vector Observadores = new Vector();
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
        Observadores.addElement(idPedido);
    }
    
    public void agregarPedidoPrioritario(String idPedido){
        colaPrioritaria.offer(idPedido);
        Observadores.addElement(idPedido);
    }
    
    public String atenderPedidoNormal(){
        
        return colaNormal.poll();
    }
    
    public String atenderPedidoPrioritario(){
        
        return colaNormal.poll();
    }  
    public void AgregarPedidoPorEntregar(String idPedido){
         colaEntrega.offer(idPedido);
    }
    public String PedidoPorEntregado(){
         return colaEntrega.poll();
    }
    public static ColasPedidos getInstancia(){
        return instancia;
    }
}
