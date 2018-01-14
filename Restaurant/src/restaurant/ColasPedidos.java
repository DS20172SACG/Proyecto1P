/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Usuario
 */
public class ColasPedidos {
    
    private static ColasPedidos instancia = new ColasPedidos();
    private Queue<String> colaNormal;
    private Queue<String> colaPrioritaria;
    
    private ColasPedidos(){
        colaNormal = new LinkedList<>();
        colaPrioritaria = new LinkedList<>();
    }
    
    public void agregarPedidoNormal(String idPedido){
        colaNormal.offer(idPedido);
    }
    
    public void agregarPedidoPrioritario(String idPedido){
        colaPrioritaria.offer(idPedido);
    }
    
    public String atenderPedidoNormal(){
        return colaNormal.poll();
    }
    
    public String atenderPedidoPrioritario(){
        return colaNormal.poll();
    }
    
    public static ColasPedidos getInstancia(){
        return instancia;
    }
    
}
