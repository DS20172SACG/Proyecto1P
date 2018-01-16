/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Vistas.VistaMesero;
import java.awt.event.ActionEvent;
import restaurant.Personal.Mesero;

/**
 *
 * @author Usuario
 */
public class ControlMesero implements Controlador {

    private VistaMesero ventana;
    private Mesero mesero;

    public ControlMesero(Mesero mesero) {
        ventana = new VistaMesero();
        this.mesero = mesero;
        this.mesero.setControl(this);
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
