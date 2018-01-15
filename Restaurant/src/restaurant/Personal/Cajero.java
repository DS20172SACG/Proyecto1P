/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.Personal;

import Constantes.ConstantesTipoPersonal;
import Vistas.VistaCajero;

/**
 *
 * @author Usuario
 */
public class Cajero extends Personal{

    public Cajero(String identificacion, String nombres, String apellidos, int Edad, double sueldo, String usuario) {
        super(identificacion, nombres, apellidos, Edad, sueldo, usuario);
        this.tipoPersonal = ConstantesTipoPersonal.CAJERO;
    }

    @Override
    public void presentarPantalla() {
        new VistaCajero().setVisible(true);
    }
    
}
