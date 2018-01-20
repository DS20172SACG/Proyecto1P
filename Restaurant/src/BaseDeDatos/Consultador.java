/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDeDatos;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import restaurant.Personal.*;

/**
 *
 * @author Usuario
 */
public class Consultador {
    
    private static Consultador instancia = new Consultador();
    private String cadenaDeLlamada;
    private CallableStatement llamada;
    private ResultSet resultado;

    public Consultador() {
    }
    
    public static Consultador getInstancia(){
        return instancia;
    }
    
    public boolean usuarioExiste(String usuario){
        cadenaDeLlamada = "{CALL buscarUsuario(?)}";
        try{
            llamada = Connector.getInstancia().getConnection().prepareCall(cadenaDeLlamada);
            llamada.setString(1, usuario);
            resultado = llamada.executeQuery();
            if(resultado.isBeforeFirst()){
                return true;
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return false;
    }
    
    public boolean datosUsuarioCorrectos(String usuario, String contrasena){
        cadenaDeLlamada = "{CALL verificarUsuarioContrasena(?,?)}";
        try{
            llamada = Connector.getInstancia().getConnection().prepareCall(cadenaDeLlamada);
            llamada.setString(1, usuario);
            llamada.setString(2, contrasena);
            resultado = llamada.executeQuery();
            if(resultado.isBeforeFirst()){
                return true;
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return false;
    }
    
    public ResultSet obtenerPersonalPorUsuario(String usuario){
        cadenaDeLlamada = "{CALL ObtenerPersonalPorUsuario(?)}";
        resultado = null;
        try{
            llamada = Connector.getInstancia().getConnection().prepareCall(cadenaDeLlamada);
            llamada.setString(1, usuario);
            resultado = llamada.executeQuery();
            resultado.next();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    public ResultSet cargarArticulosPorCategoria(int categoria){
        cadenaDeLlamada = "{CALL cargarArticuloPorCategoria(?)}";
        try{
            llamada = Connector.getInstancia().getConnection().prepareCall(cadenaDeLlamada);
            llamada.setInt(1, categoria);
            resultado = llamada.executeQuery();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    public String descripcionDeArticuloPorNombre(String nombre){
        if(nombre.isEmpty()) return "";
        cadenaDeLlamada = "{CALL cargarDescripcionArticuloPorNombre(?)}";
        String retorno = "";
        try{
            llamada = Connector.getInstancia().getConnection().prepareCall(cadenaDeLlamada);
            llamada.setString(1, nombre);
            resultado = llamada.executeQuery();
            if(resultado.isBeforeFirst()){
                resultado.next();
                retorno = resultado.getString(1);
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return retorno;
    }
    
    public double precioDeArticuloPorNombre(String nombre){
        if(nombre.isEmpty()) return 0;
        cadenaDeLlamada = "{CALL cargarPrecioArticuloPorNombre(?)}";
        double retorno = 0;
        try{
            llamada = Connector.getInstancia().getConnection().prepareCall(cadenaDeLlamada);
            llamada.setString(1, nombre);
            resultado = llamada.executeQuery();
            if(resultado.isBeforeFirst()){
                resultado.next();
                retorno = resultado.getDouble(1);
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return retorno;
    }

    public LinkedList<String> nombresMesas(){
        LinkedList<String> mesas = new LinkedList<>();
        cadenaDeLlamada = "{CALL cargarNombresMesas()}";
        try{
            llamada = Connector.getInstancia().getConnection().prepareCall(cadenaDeLlamada);
            resultado = llamada.executeQuery();
            if(resultado.isBeforeFirst()){
                resultado.next();
                mesas.add(resultado.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Consultador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mesas;
    }
}
