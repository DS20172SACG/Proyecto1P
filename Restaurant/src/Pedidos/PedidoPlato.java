/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pedidos;

/**
 *
 * @author Usuario
 */
public class PedidoPlato {
    private String idPedidoPlato;
    private String idPedido;
    private String idPlato;
    private int cantidadPlatos;

    public PedidoPlato() {
    }

    public PedidoPlato(String idPedidoPlato, String idPedido, String idPlato) {
        this.idPedidoPlato = idPedidoPlato;
        this.idPedido = idPedido;
        this.idPlato = idPlato;
    }

    public String getIdPedidoPlato() {
        return idPedidoPlato;
    }

    public void setIdPedidoPlato(String idPedidoPlato) {
        this.idPedidoPlato = idPedidoPlato;
    }

    public String getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(String idPedido) {
        this.idPedido = idPedido;
    }

    public String getIdPlato() {
        return idPlato;
    }

    public void setIdPlato(String idPlato) {
        this.idPlato = idPlato;
    }

    public int getCantidadPlatos() {
        return cantidadPlatos;
    }

    public void setCantidadPlatos(int cantidadPlatos) {
        this.cantidadPlatos = cantidadPlatos;
    }
    
}
