/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.Personal;

import Constantes.ConstantesTipoPersonal;
import Vistas.VistaAdministrador;

/**
 *
 * @author Usuario
 */
public class Administrador extends Personal{
    
    public Administrador(String identificacion, String nombres, String apellidos, int Edad, double sueldo, String usuario) {
        super(identificacion, nombres, apellidos, Edad, sueldo, usuario);
        this.tipoPersonal = ConstantesTipoPersonal.ADMINISTRADOR;
    }

    @Override
    public void presentarPantalla() {
        new VistaAdministrador().setVisible(true);
    }
    
}
