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
public class PedidoDomicilio extends Pedido{
    private String direccionEntrega;

    public PedidoDomicilio() {
    }

    public PedidoDomicilio(String direccionEntrega, boolean preferencial, String idCliente, String idMesero) {
        super(preferencial, idCliente, idMesero);
        this.direccionEntrega = direccionEntrega;
    }

    public PedidoDomicilio(String direccionEntrega, int idPedido, boolean pagado, boolean enPreparacion, boolean cocinado, boolean entregado, boolean enCola, boolean preferencial, String idCliente, String idMesero, String idCocinero) {
        super(idPedido, pagado, enPreparacion, cocinado, entregado, enCola, preferencial, idCliente, idMesero, idCocinero);
        this.direccionEntrega = direccionEntrega;
    }

    public String getDireccionEntrega() {
        return direccionEntrega;
    }

    public void setDireccionEntrega(String direccionEntrega) {
        this.direccionEntrega = direccionEntrega;
    }
    
}
