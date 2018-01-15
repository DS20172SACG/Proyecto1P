/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Vistas.VistaCocinero;
import java.awt.event.ActionEvent;
import restaurant.Personal.Cocinero;

/**
 *
 * @author Usuario
 */
public class ControlCocinero implements Controlador {

    private VistaCocinero ventana;
    private Cocinero cocinero;

    public ControlCocinero(Cocinero cocinero) {
        ventana = new VistaCocinero();
        this.cocinero = cocinero;
        this.cocinero.setControl(this);
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
