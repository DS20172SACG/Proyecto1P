/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuarios;

import BaseDeDatos.Consultador;
import Constantes.ConstantesTipoPersonal;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import restaurant.Personal.*;

/**
 *
 * @author Usuario
 */
public class Usuario {
    private String usuario;
    private String contrasena;
    private Personal personal;

    public Usuario() {
    }

    public Usuario(String usuario, String contrasena) {
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    
    public void crearPersonal(ResultSet rs){
        try{
            switch (rs.getInt(6)){
                case ConstantesTipoPersonal.ADMINISTRADOR:
                    personal = new Administrador(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDouble(5), rs.getString(7));
                    break;
                case ConstantesTipoPersonal.CAJERO:
                    personal = new Cajero(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDouble(5), rs.getString(7));
                    break;
                case ConstantesTipoPersonal.COCINERO:
                    personal = new Cocinero(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDouble(5), rs.getString(7));
                    break;
                case ConstantesTipoPersonal.MESERO:
                    personal = new Mesero(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDouble(5), rs.getString(7));
                    break;
                case ConstantesTipoPersonal.REPARTIDOR:
                    personal = new Repartidor(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDouble(5), rs.getString(7));
                    break;
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    public void iniciarSesion(){
        if(Consultador.getInstancia().usuarioExiste(usuario)){
            if(!Consultador.getInstancia().datosUsuarioCorrectos(usuario, contrasena)){
                JOptionPane.showMessageDialog(null, "La contrasena no corresponde a ese usuario.", "Mensaje del sistema.", JOptionPane.ERROR_MESSAGE);
            }else{
                crearPersonal(Consultador.getInstancia().obtenerPersonalPorUsuario(usuario));
                personal.presentarPantalla();
                JOptionPane.showMessageDialog(null, "Ingreso Exitoso", "Mensaje del sistema.", JOptionPane.INFORMATION_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(null, "No existe ese usuario en la base de datos.", "Mensaje del sistema.", JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
