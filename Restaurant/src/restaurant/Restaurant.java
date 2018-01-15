/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant;

import Controladores.ControlLogin;
import Vistas.Login;

/**
 *
 * @author Usuario
 */
public class Restaurant {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ControlLogin controlLogin = new ControlLogin(new Login());
        controlLogin.presentarVista();
    }
    
}
