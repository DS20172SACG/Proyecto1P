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
public class PedidoArticulo {
    private String idPedidoArticulo;
    private String idPedido;
    private String idArticulo;
    private int cantidadArticulos;

    public PedidoArticulo() {
    }

    public PedidoArticulo(String idPedidoArticulo, String idPedido, String idArticulo) {
        this.idPedidoArticulo = idPedidoArticulo;
        this.idPedido = idPedido;
        this.idArticulo = idArticulo;
    }

    public String getIdPedidoArticulo() {
        return idPedidoArticulo;
    }

    public void setIdPedidoArticulo(String idPedidoArticulo) {
        this.idPedidoArticulo = idPedidoArticulo;
    }

    public String getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(String idPedido) {
        this.idPedido = idPedido;
    }

    public String getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(String idArticulo) {
        this.idArticulo = idArticulo;
    }

    public int getCantidadArticulos() {
        return cantidadArticulos;
    }

    public void setCantidadArticulos(int cantidadArticulos) {
        this.cantidadArticulos = cantidadArticulos;
    }
    
}
