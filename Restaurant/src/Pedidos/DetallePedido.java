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
public class DetallePedido {
    private int id;
    private int numDetalle;
    private int idPedido;
    private int idArticulo;
    private int cantidad;
    private String observaciones;
    private String nombreArticulo; //No es necesario en base
    private double precioArticulo; //Tampoco es necesario en base

    public DetallePedido() {
    }

    public DetallePedido(int id, int num, int idPedido, int idArticulo, int cantidad, String observaciones) {
        this.id = id;
        this.numDetalle = num;
        this.idPedido = idPedido;
        this.idArticulo = idArticulo;
        this.cantidad = cantidad;
        this.observaciones = observaciones;
    }

    public DetallePedido(int idArticulo, int cantidad, String observaciones) {
        this.idArticulo = idArticulo;
        this.cantidad = cantidad;
        this.observaciones = observaciones;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(int idArticulo) {
        this.idArticulo = idArticulo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getNombreArticulo() {
        return nombreArticulo;
    }

    public void setNombreArticulo(String nombreArticulo) {
        this.nombreArticulo = nombreArticulo;
    }

    public double getPrecioArticulo() {
        return precioArticulo;
    }

    public void setPrecioArticulo(double precioArticulo) {
        this.precioArticulo = precioArticulo;
    }

    public int getNumDetalle() {
        return numDetalle;
    }

    public void setNumDetalle(int numDetalle) {
        this.numDetalle = numDetalle;
    }
    
}
