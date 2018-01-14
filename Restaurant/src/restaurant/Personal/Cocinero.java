/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.Personal;

import java.util.*;

/**
 *
 * @author Usuario
 */
public class Cocinero extends Personal{
    private List<Observador> Observadores;
    private int state;

    public Cocinero() {
        Observadores= new ArrayList<Observador>();
    }
    
    public void add(Observador o) {
        Observadores.add(o);
    }
    public void remove(Observador o) {
        Observadores.remove(o);
    }
    public void NotificarPedidoListo(String idPedido){
        NotificarObservadores(idPedido);
    }
    public void NotificarObservadores(String idPedido){
        for(Observador obs: Observadores){
            obs.ActualizarPedido(idPedido);
        }
    }
}
