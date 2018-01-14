/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.Personal;

import java.util.*;

/**
 *
 * @author User
 */
public class Observado {
    private List<Observador> observers;

    public Observado() {
        super();
        observers=new ArrayList<>();
    }
    public void suscribirObservador(Observador observador){
        observers.add(observador);
    }
    public void removerObservador(Observador observador){
        observers.remove(observador);
    }
    public void notificarObservadores(){
        for(Observador ob: observers){
            ob.ActualizarPedido();
        }
    }
}
