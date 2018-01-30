/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pedidos;

import BaseDeDatos.Consultador;
import java.util.Date;
import java.util.LinkedList;

/**
 *
 * @author Usuario
 */
public abstract class Pedido {
    protected int idPedido;
    protected boolean pagado;
    protected boolean enPreparacion;
    protected boolean cocinado;
    protected boolean entregado;
    protected boolean enCola;
    protected boolean preferencial;
    protected String idCliente;
    protected String idMesero;
    protected String idCocinero; /*Es null hasta que un cocinero cocina el pedido, o el Mesero asigna un cocinero.*/
    protected LinkedList<DetallePedido> detalle;

    public Pedido() {
    }

    public Pedido(boolean preferencial, String idCliente, String idMesero) {
        this.preferencial = preferencial;
        this.idCliente = idCliente;
        this.idMesero = idMesero;
        detalle = new LinkedList();
    }

    public Pedido(int idPedido, boolean pagado, boolean enPreparacion, boolean cocinado, boolean entregado, boolean enCola, boolean preferencial, String idCliente, String idMesero, String idCocinero) {
        this.idPedido = idPedido;
        this.pagado = pagado;
        this.enPreparacion = enPreparacion;
        this.cocinado = cocinado;
        this.entregado = entregado;
        this.enCola = enCola;
        this.preferencial = preferencial;
        this.idCliente = idCliente;
        this.idMesero = idMesero;
        this.idCocinero = idCocinero;
        detalle = Consultador.getInstancia().detalleDePedido(idPedido);
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public boolean isPagado() {
        return pagado;
    }

    public void setPagado(boolean pagado) {
        this.pagado = pagado;
    }

    public boolean isEnPreparacion() {
        return enPreparacion;
    }

    public void setEnPreparacion(boolean enPreparacion) {
        this.enPreparacion = enPreparacion;
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

    public boolean isEnCola() {
        return enCola;
    }

    public void setEnCola(boolean enCola) {
        this.enCola = enCola;
    }

    public boolean isPreferencial() {
        return preferencial;
    }

    public void setPreferencial(boolean preferencial) {
        this.preferencial = preferencial;
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
    
    public int minutosEstimados(){
        int minMax = 0;
        for(DetallePedido d : this.detalle){
            int minDeArt = Consultador.getInstancia().tiempoPreparacionArticulo(d.getIdArticulo());
            if(minDeArt>minMax){
                minMax = minDeArt;
            }
        }
        return minMax + (3 * detalle.size());
    }
}
