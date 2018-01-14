/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pagaduria;

import java.util.Date;

/**
 *
 * @author Usuario
 */
public class Factura {
    protected String id;
    protected Date fecha;
    protected double total;
    protected EstrategiaDePago estrategiaDePago;

    public Factura() {
    }

    public Factura(String id, Date fecha, double total, EstrategiaDePago estrategiaDePago) {
        this.id = id;
        this.fecha = fecha;
        this.total = total;
        this.estrategiaDePago = estrategiaDePago;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public EstrategiaDePago getEstrategiaDePago() {
        return estrategiaDePago;
    }

    public void setEstrategiaDePago(EstrategiaDePago estrategiaDePago) {
        this.estrategiaDePago = estrategiaDePago;
    }
    
}
