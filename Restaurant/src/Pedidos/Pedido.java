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
public abstract class Pedido {
    protected int idPedido;
    protected double total;
    protected boolean pagado;
    protected boolean cocinado;
    protected boolean entregado;
    protected boolean preferencial;
    protected String idCliente;
    protected String idMesero;
    protected String idCocinero; /*Es null hasta que un cocinero cocina el pedido, o el Mesero asigna un cocinero.*/

    public Pedido() {
    }

    public Pedido(int idPedido, double total, boolean pagado, boolean cocinado, boolean entregado, String idCliente, String idMesero) {
        this.idPedido = idPedido;
        this.total = total;
        this.pagado = pagado;
        this.cocinado = cocinado;
        this.entregado = entregado;
        this.idCliente = idCliente;
        this.idMesero = idMesero; /*No se asigna ningún cocinero cuando recién se crea el pedido*/
    }

    public Pedido(int idPedido, double total, boolean pagado, boolean cocinado, boolean entregado, String idCliente, String idMesero, String idCocinero) {
        this.idPedido = idPedido;
        this.total = total;
        this.pagado = pagado;
        this.cocinado = cocinado;
        this.entregado = entregado;
        this.idCliente = idCliente;
        this.idMesero = idMesero;
        this.idCocinero = idCocinero;
    }

    public Pedido(double total, String idCliente, String idMesero) {
        this.total = total;
        this.idCliente = idCliente;
        this.idMesero = idMesero;
    }

    
    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public boolean isPagado() {
        return pagado;
    }

    public void setPagado(boolean pagado) {
        this.pagado = pagado;
    }

    public boolean isCocinado() {
        return cocinado;
    }

    public void setCocinado(boolean cocinado) {
        this.cocinado = cocinado;
    }

    public boolean isEntregado() {
        return entregado;
    }

    public void setEntregado(boolean entregado) {
        this.entregado = entregado;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getIdMesero() {
        return idMesero;
    }

    public void setIdMesero(String idMesero) {
        this.idMesero = idMesero;
    }

    public String getIdCocinero() {
        return idCocinero;
    }

    public void setIdCocinero(String idCocinero) {
        this.idCocinero = idCocinero;
    }

    public boolean isPreferencial() {
        return preferencial;
    }

    public void setPreferencial(boolean preferencial) {
        this.preferencial = preferencial;
    }
    
}
