/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.Personal;

import Pedidos.Pedido;

/**
 *
 * @author User
 */
public abstract class Observador {
    protected Cocinero cosinero;
    public abstract void ActualizarPedido(String IdPedido);
}
