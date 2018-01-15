/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Vistas.VistaRepartidor;
import java.awt.event.ActionEvent;
import restaurant.Personal.Repartidor;

/**
 *
 * @author Usuario
 */
public class ControlRepartidor implements Controlador {

    private VistaRepartidor ventana;
    private Repartidor repartidor;

    public ControlRepartidor(Repartidor repartidor) {
        ventana = new VistaRepartidor();
        this.repartidor = repartidor;
        this.repartidor.setControl(this);
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
