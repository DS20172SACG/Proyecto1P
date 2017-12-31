/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant;

/**
 *
 * @author Usuario
 */
public class Mesa {
    private String id;
    private int cantidadAsientos;
    private boolean disponible;
    private String idAmbiente;

    public Mesa() {
    }
    
    public Mesa(String id, int cantidadAsientos, boolean disponible) {
        this.id = id;
        this.cantidadAsientos = cantidadAsientos;
        this.disponible = disponible;
    } 

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCantidadAsientos() {
        return cantidadAsientos;
    }

    public void setCantidadAsientos(int cantidadAsientos) {
        this.cantidadAsientos = cantidadAsientos;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public String getIdAmbiente() {
        return idAmbiente;
    }

    public void setIdAmbiente(String idAmbiente) {
        this.idAmbiente = idAmbiente;
    }
    
}
