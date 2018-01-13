/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDeDatos;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class Connector {
    
    private Connector instancia = new Connector();
    private Connection connection;
    private DatosBase datos = new DatosBase();
    
    private Connector(){
    }
    
    public Connector getInstancia(){
        return this.instancia;
    }
    
    public Connection getConnection() {
        try {
            connection = DriverManager.getConnection(datos.getUrl(), datos.getUser(), datos.getPassword());
            //System.out.println("Se generó la conexion. ");
        } catch (Exception ex) {
            System.out.println("error occured " + ex.toString());
            System.out.println("No se generó la conexion. ");
            JOptionPane.showMessageDialog(null, "No se generó la conexion con la base de datos ","Mensaje del sistema",JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        return connection;
    }
}
