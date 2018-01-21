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

    public PedidoDomicilio(String direccionEntrega, int idPedido, double total, boolean pagado, boolean cocinado, boolean entregado, String idCliente, String idMesero) {
        super(idPedido, total, pagado, cocinado, entregado, idCliente, idMesero);
        this.direccionEntrega = direccionEntrega;
    }

    public PedidoDomicilio(String direccionEntrega, int idPedido, double total, boolean pagado, boolean cocinado, boolean entregado, String idCliente, String idMesero, String idCocinero) {
        super(idPedido, total, pagado, cocinado, entregado, idCliente, idMesero, idCocinero);
        this.direccionEntrega = direccionEntrega;
    }

    public PedidoDomicilio(String direccionEntrega, double total, String idCliente, String idMesero, boolean preferencial) {
        super(total, idCliente, idMesero, preferencial);
        this.direccionEntrega = direccionEntrega;
    }

    public String getDireccionEntrega() {
        return direccionEntrega;
    }

    public void setDireccionEntrega(String direccionEntrega) {
        this.direccionEntrega = direccionEntrega;
    }
    
}
