/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Vistas.VistaAdministrador;
import java.awt.event.ActionEvent;
import restaurant.Personal.Administrador;

/**
 *
 * @author Usuario
 */
public class ControlAdministrador implements Controlador {
    
    private VistaAdministrador ventana;
    private Administrador administrador;
    
    public ControlAdministrador(Administrador administrador){
        ventana = new VistaAdministrador();
        this.administrador = administrador;
        this.administrador.setControl(this);
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
