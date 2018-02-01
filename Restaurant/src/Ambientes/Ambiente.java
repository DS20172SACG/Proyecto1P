/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ambientes;

/**
 *
 * @author Usuario
 */
public class Ambiente {
    
    private int tipoAmbiente;
    private String nombre;
    
    public Ambiente(){
        
    }
    
    public Ambiente(int tipoAmbiente){
        this.tipoAmbiente = tipoAmbiente;
    }

    public int getTipoAmbiente() {
        return tipoAmbiente;
    }

    public void setTipoAmbiente(int tipoAmbiente) {
        this.tipoAmbiente = tipoAmbiente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
