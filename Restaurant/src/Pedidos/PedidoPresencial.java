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
public class PedidoPresencial extends Pedido{
    private String idMesa;

    public PedidoPresencial() {
    }

    public PedidoPresencial(String idMesa, String idPedido, double total, boolean pagado, boolean cocinado, boolean entregado, String idCliente, String idMesero) {
        super(idPedido, total, pagado, cocinado, entregado, idCliente, idMesero);
        this.idMesa = idMesa;
    }

    public PedidoPresencial(String idMesa, String idPedido, double total, boolean pagado, boolean cocinado, boolean entregado, String idCliente, String idMesero, String idCocinero) {
        super(idPedido, total, pagado, cocinado, entregado, idCliente, idMesero, idCocinero);
        this.idMesa = idMesa;
    }

    public String getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(String idMesa) {
        this.idMesa = idMesa;
    }
    
}