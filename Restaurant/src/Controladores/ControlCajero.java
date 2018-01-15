/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Vistas.VistaCajero;
import java.awt.event.ActionEvent;
import restaurant.Personal.Cajero;

/**
 *
 * @author Usuario
 */
public class ControlCajero implements Controlador {

    private VistaCajero ventana;
    private Cajero cajero;
    
    public ControlCajero(Cajero cajero){
        ventana = new VistaCajero();
        this.cajero = cajero;
        this.cajero.setControl(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void presentarVista() {
        ventana.setVisible(true);
    }
    
}
