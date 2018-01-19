/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Usuarios.Usuario;
import Vistas.Login;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Usuario
 */
public class ControlLogin implements ActionListener, Controlador{
    
    private Login ventana;
    private Usuario usuario;

    public ControlLogin() {
        this.ventana = new Login();
        this.usuario = new Usuario();
        ventana.getjButton1().addActionListener(this);
        ventana.getjButton2().addActionListener(this);
    }

    public Login getVentana() {
        return ventana;
    }

    public void setVentana(Login ventana) {
        this.ventana = ventana;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(ventana.getjButton2())){
            ventana.limpiar();
        }else if(e.getSource().equals(ventana.getjButton1())){
            usuario.setUsuario(ventana.getTextUsuario());
            usuario.setContrasena(ventana.getTextContraseña());
            usuario.iniciarSesion();
            ventana.dispose();
        }
    }
    
    @Override
    public void presentarVista(){
        ventana.setVisible(true);
    }

}
