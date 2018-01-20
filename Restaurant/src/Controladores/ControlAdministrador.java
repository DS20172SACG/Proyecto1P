/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import BaseDeDatos.Connector;
import Vistas.VistaAdministrador;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
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
        MostrarUsuarios();
    }
    void MostrarUsuarios(){
        DefaultTableModel modo=new DefaultTableModel();
        modo.addColumn("cedula");
        modo.addColumn("Nombres");
        modo.addColumn("Apellidos");
        modo.addColumn("Edad");
        modo.addColumn("Sueldo");
        modo.addColumn("Id Cargo");
        modo.addColumn("Usuario");
        ventana.getTablaUsuario().setModel(modo);
        
        String sql="SELECT * FROM Personal";
        String datos[] = new String[7];
        
        try{
            Statement st = Connector.getInstancia().getConnection().createStatement();
            ResultSet rs= st.executeQuery(sql);
            while(rs.next()){
                datos[0]=rs.getString(1);
                datos[1]=rs.getString(2);
                datos[2]=rs.getString(3);
                datos[3]=rs.getString(4);
                datos[4]=rs.getString(5);
                datos[5]=rs.getString(6);
                datos[6]=rs.getString(7);
                modo.addRow(datos);
            }
            ventana.getTablaUsuario().setModel(modo);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "No se pudo mostrar la tabla de personal por usuario");
        
        } 
    }
}
