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
    private int idMesa;

    public PedidoPresencial() {
    }

    public PedidoPresencial(int idMesa, boolean preferencial, String idCliente, String idMesero) {
        super(preferencial, idCliente, idMesero);
        this.idMesa = idMesa;
    }

    public PedidoPresencial(int idMesa, int idPedido, boolean pagado, boolean enPreparacion, boolean cocinado, boolean entregado, boolean enCola, boolean preferencial, String idCliente, String idMesero, String idCocinero) {
        super(idPedido, pagado, enPreparacion, cocinado, entregado, enCola, preferencial, idCliente, idMesero, idCocinero);
        this.idMesa = idMesa;
    }

    public int getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(int idMesa) {
        this.idMesa = idMesa;
    }
    
}
