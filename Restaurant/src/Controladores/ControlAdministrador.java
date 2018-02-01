/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import BaseDeDatos.Connector;
import BaseDeDatos.Consultador;
import Reporte.AbstractJasperReports;
import Vistas.VistaAdministrador;
import static Vistas.VistaAdministrador.TablaUsuario;
import java.awt.event.ActionEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
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
    
    public ControlAdministrador(Administrador administrador)  {
        ventana = new VistaAdministrador();
        this.administrador = administrador;
        this.administrador.setControl(this);
        addListenerUser();
        addListenerReport();
        
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(ventana.MostrarReporte==e.getSource()){
            Map parameters = new HashMap();
            parameters.put("FechaDesde", VistaAdministrador.FechaInicio.getDate());
            parameters.put("FechaHasta", VistaAdministrador.FechaHasta.getDate());
            if(ventana.RadioBotonPlato.isSelected()){
                
                parameters.put("Nombre", VistaAdministrador.TextoFiltroSeleccionado.getText());
                AbstractJasperReports.createReports(Connector.getInstancia().getConnection(),"C:\\Users\\User\\Documents\\ESPOL Edward Cruz\\Java y netbeans\\SARES\\Restaurant\\src\\Reporte\\ReporteGeneral.jasper",parameters);
            }
            if(ventana.RadioBotonMesero.isSelected()){
                parameters.put("Lastname", VistaAdministrador.TextoFiltroSeleccionado.getText());
                System.out.println(parameters.get("Lastname"));
                AbstractJasperReports.createReports(Connector.getInstancia().getConnection(),"C:\\Users\\User\\Documents\\ESPOL Edward Cruz\\Java y netbeans\\SARES\\Restaurant\\src\\Reporte\\ReporteMesero.jasper",parameters);
            }
            if(ventana.RadioBotonAmbiente.isSelected()){
                parameters.put("Nombre", VistaAdministrador.TextoFiltroSeleccionado.getText());
                AbstractJasperReports.createReports(Connector.getInstancia().getConnection(),"C:\\Users\\User\\Documents\\ESPOL Edward Cruz\\Java y netbeans\\SARES\\Restaurant\\src\\Reporte\\ReporteCategoria.jasper",parameters);
            }
            if(ventana.RadioBotonCategoria.isSelected()){
                //parameters.put("Nombre", VistaAdministrador.TextoFiltroSeleccionado.getText());
                //AbstractJasperReports.createReports(Connector.getInstancia().getConnection(),"C:\\Users\\User\\Documents\\ESPOL Edward Cruz\\Java y netbeans\\SARES\\Restaurant\\src\\Reporte\\ReporteGeneral.jasper",parameters);
            }
            AbstractJasperReports.showViewer();
            
        }
        if(ventana.BotonCerrar==e.getSource()){
            ventana.dispose();
            ControlLogin login= new ControlLogin();
            login.presentarVista();
        }
        if(ventana.BusquedaPorFiltro==e.getSource()){
            if(ventana.RadioBotonPlato.isSelected()){
                MostrarReportePlatos("Plato");
            }
            if(ventana.RadioBotonMesero.isSelected()){
                MostrarReportePlatos("Mesero");
            }
            if(ventana.RadioBotonAmbiente.isSelected()){
                MostrarReportePlatos("Ambiente");
            }
            if(ventana.RadioBotonCategoria.isSelected()){
                MostrarReportePlatos("Categoria");
            }
            VistaAdministrador.ListaPlatosReporte.isSelectedIndex(0);
        }
        if(ventana.BuscarSeleccionFiltro==e.getSource()){
            VistaAdministrador.TextoFiltroSeleccionado.setText(VistaAdministrador.ListaPlatosReporte.getSelectedValue().toString());
            VistaAdministrador.MostrarReporte.setEnabled(true);
        }
        if(ventana.BotonNuevo==e.getSource()){
            habilitarOpcionesdeIngresar(true);
            VistaAdministrador.BotonModificar.setEnabled(false);
            VistaAdministrador.BotonEliminar.setEnabled(false);            
        }
        if(ventana.BotonGuardar==e.getSource()){
            if(TodosCampoLlenos()){
                
                PreparedStatement guardarUsuario;
                PreparedStatement guardarPersonal;
                try {
                    guardarUsuario = Connector.getInstancia().getConnection().prepareStatement("INSERT INTO Usuario (usuario, clave, eliminado)VALUES(?,?,?)");
                    guardarPersonal = Connector.getInstancia().getConnection().prepareStatement("INSERT INTO Personal (cedula, nombres, apellidos, edad, sueldo, idCargo, usuario, eliminado) VALUES(?,?,?,?,?,?,?,?)");
                    guardarUsuario.setString(1, VistaAdministrador.TextoUsuario.getText());
                    guardarUsuario.setString(2, VistaAdministrador.TextoContraseña.getText());
                    guardarUsuario.setInt(3, 0);
                    
                    guardarPersonal.setString(1, VistaAdministrador.TextoCedula.getText());
                    guardarPersonal.setString(2, VistaAdministrador.TextoNombre.getText());
                    guardarPersonal.setString(3, VistaAdministrador.TextoApellido.getText());
                    guardarPersonal.setInt(4, Integer.parseInt(VistaAdministrador.TextoEdad.getText()));
                    guardarPersonal.setFloat(5,Float.parseFloat( VistaAdministrador.TextoSueldo.getText()));
                    guardarPersonal.setInt(6, Consultador.getInstancia().idCargoPorNombre(VistaAdministrador.Funciones_o_Cargos.getSelectedItem().toString()));//modificar
                    guardarPersonal.setString(7, VistaAdministrador.TextoUsuario.getText());
                    guardarPersonal.setInt(8, 0);
                    
                    guardarUsuario.executeUpdate();
                    guardarPersonal.executeUpdate();
                    MostrarUsuarios("","");
                    JOptionPane.showMessageDialog(null,"DATOS INGRESADOS CORRECTAMENTE");
                
                } catch (SQLException ex) {
                    Logger.getLogger(ControlAdministrador.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
               
                VistaAdministrador.BotonModificar.setEnabled(true);
                VistaAdministrador.BotonGuardar.setEnabled(false);
                VistaAdministrador.BotonEliminar.setEnabled(true);
                LimpiarCampoLlenos();
                habilitarOpcionesdeIngresar(false);
            }else{
                JOptionPane.showMessageDialog(null, "LLene los campos vacios primero");
            }
            
        }
        if(ventana.BotonModificar==e.getSource()){
            
            habilitarOpcionesdeIngresar(true);
            VistaAdministrador.BotonActualizar.setEnabled(true);
            VistaAdministrador.BotonNuevo.setEnabled(false);
            VistaAdministrador.BotonEliminar.setEnabled(false);
            VistaAdministrador.BotonGuardar.setEnabled(false);
            
            int fila = TablaUsuario.getSelectedRow();
            if(fila>=0){
                VistaAdministrador.TextoCedula.setText(TablaUsuario.getValueAt(fila, 0).toString());
                VistaAdministrador.TextoNombre.setText(TablaUsuario.getValueAt(fila, 1).toString());
                VistaAdministrador.TextoApellido.setText(TablaUsuario.getValueAt(fila, 2).toString());
                VistaAdministrador.TextoEdad.setText(TablaUsuario.getValueAt(fila, 3).toString());
                VistaAdministrador.TextoSueldo.setText(TablaUsuario.getValueAt(fila, 4).toString());
                VistaAdministrador.TextoUsuario.setText(TablaUsuario.getValueAt(fila, 6).toString());
                VistaAdministrador.TextoContraseña.setText(Consultador.getInstancia().ContrasenaPorUsuario(TablaUsuario.getValueAt(fila, 6).toString()));
            }else{
                JOptionPane.showMessageDialog(null,"fila no selecionada");
            }
            
        }
        if(ventana.BotonActualizar==e.getSource()){
            if(TodosCampoLlenos()){
                PreparedStatement actualizarUsuario;
                PreparedStatement actualizarPersonal;
                try {
                    actualizarUsuario = Connector.getInstancia().getConnection().prepareStatement("UPDATE usuario SET usuario='"+VistaAdministrador.TextoUsuario.getText()+"',clave='"+VistaAdministrador.TextoContraseña.getText()+"',eliminado='"+0+"'");
                    actualizarPersonal = Connector.getInstancia().getConnection().prepareStatement("UPDATE personal SET cedula='"+VistaAdministrador.TextoCedula.getText()+"',nombres='"+VistaAdministrador.TextoNombre.getText()+"',apellidos='"+VistaAdministrador.TextoApellido.getText()+"',edad='"+Integer.parseInt(VistaAdministrador.TextoEdad.getText())+"',sueldo='"+Float.parseFloat(VistaAdministrador.TextoSueldo.getText())+"',idCargo='"+Consultador.getInstancia().idCargoPorNombre(VistaAdministrador.Funciones_o_Cargos.getSelectedItem().toString())+"',usuario='"+VistaAdministrador.TextoUsuario.getText()+"',eliminado='"+0+"'");
                    
                    actualizarUsuario.executeUpdate();
                    actualizarPersonal.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Datos Actualizados");
                    MostrarUsuarios("", "");
                } catch (SQLException ex) {
                    Logger.getLogger(ControlAdministrador.class.getName()).log(Level.SEVERE, null, ex);
                }
                VistaAdministrador.BotonActualizar.setEnabled(false);
                VistaAdministrador.BotonNuevo.setEnabled(true);
                VistaAdministrador.BotonEliminar.setEnabled(true);
                LimpiarCampoLlenos();
                habilitarOpcionesdeIngresar(false);
            }else{
                JOptionPane.showMessageDialog(null, "Complete los campos vacios primero");
            }
            
            //falta
        }
        if(ventana.BotonEliminar==e.getSource()){
            //falta
            //habilitarOpcionesdeIngresar(false);
        }
    }
    boolean TodosCampoLlenos(){
        if(!VistaAdministrador.TextoCedula.getText().isEmpty()&&
        !VistaAdministrador.TextoNombre.getText().isEmpty() &&
        !VistaAdministrador.TextoApellido.getText().isEmpty() &&
        !VistaAdministrador.TextoEdad.getText().isEmpty() &&
        !VistaAdministrador.TextoUsuario.getText().isEmpty()&&
        !VistaAdministrador.TextoContraseña.getText().isEmpty() &&
        !VistaAdministrador.TextoSueldo.getText().isEmpty()){
            return true;
        }else{
            return false;
        }
    }
    void LimpiarCampoLlenos(){
        VistaAdministrador.TextoCedula.setText("");
        VistaAdministrador.TextoNombre.setText("");
        VistaAdministrador.TextoApellido.setText("");
        VistaAdministrador.TextoEdad.setText("");
        VistaAdministrador.TextoUsuario.setText("");
        VistaAdministrador.TextoContraseña.setText("");
        VistaAdministrador.TextoSueldo.setText("");        
    }
    @Override
    public void presentarVista() {
        ventana.setVisible(true);
        agregarRadioBotones();
        MostrarUsuarios("","");
        MostrarMesas();
        VistaAdministrador.MostrarReporte.setEnabled(false);
        habilitarOpcionesdeIngresar(false);
        //VistaAdministrador.BotonEliminar.setEnabled(false);
        VistaAdministrador.BotonActualizar.setEnabled(false);
    }
    void habilitarOpcionesdeIngresar(boolean b){
        VistaAdministrador.BotonGuardar.setEnabled(b);
        
        VistaAdministrador.TextoCedula.setEnabled(b);
        VistaAdministrador.TextoNombre.setEnabled(b);
        VistaAdministrador.TextoApellido.setEnabled(b);
        VistaAdministrador.TextoEdad.setEnabled(b);
        VistaAdministrador.TextoUsuario.setEnabled(b);
        VistaAdministrador.TextoContraseña.setEnabled(b);
        VistaAdministrador.TextoSueldo.setEnabled(b);
    }
    void MostrarUsuarios(String valor,String variable){
        DefaultTableModel modo=new DefaultTableModel();
        modo.addColumn("cedula");
        modo.addColumn("Nombres");
        modo.addColumn("Apellidos");
        modo.addColumn("Edad");
        modo.addColumn("Sueldo");
        modo.addColumn("Id Cargo");
        modo.addColumn("Usuario");
        VistaAdministrador.TablaUsuario.setModel(modo);
        String sql ="";
        if(valor.equals("")&&variable.equals("")){
            sql="select * from personal";
        }
        else{
            sql="select * from personal where "+variable+" like '"+valor+"%'";
        }
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
            VistaAdministrador.TablaUsuario.setModel(modo);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "No se pudo mostrar la tabla de personal por usuario");
        
        } 
    }
    void MostrarReportePlatos(String opcion){
        DefaultListModel<String> model = new DefaultListModel<>();
        String sql;
        if(opcion.equals("Mesero")){
            sql="SELECT * FROM personal WHERE idCargo=3";
        }else if(opcion.equals("Ambiente")){
            sql="SELECT * FROM ambientes ";
        }else if(opcion.equals("Categoria")){
            sql="SELECT * FROM categoria_articulo ";
        }else{
            sql="SELECT * FROM articulo";
        }
        
        
        try{
            Statement st = Connector.getInstancia().getConnection().createStatement();
            ResultSet rs= st.executeQuery(sql);
            while(rs.next()){
                if(opcion.equals("Mesero")){
                    model.addElement(rs.getString(3));//para apellido
                }else{
                    model.addElement(rs.getString(2));
                }
                
                
            }
            VistaAdministrador.ListaPlatosReporte.setModel(model);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "No se pudo mostrar la tabla de articulo");
        
        } 
    }
    
    void agregarRadioBotones(){
        VistaAdministrador.GrupoRadioBotonesReporte.add(VistaAdministrador.RadioBotonPlato);
        VistaAdministrador.GrupoRadioBotonesReporte.add(VistaAdministrador.RadioBotonMesero);
        VistaAdministrador.GrupoRadioBotonesReporte.add(VistaAdministrador.RadioBotonAmbiente);
        VistaAdministrador.GrupoRadioBotonesReporte.add(VistaAdministrador.RadioBotonCategoria);
        VistaAdministrador.GrupoRadioBotonesBusquedaUsuario.add(VistaAdministrador.RadioBotonNombre);
        VistaAdministrador.GrupoRadioBotonesBusquedaUsuario.add(VistaAdministrador.RadioBotonApellido);
        VistaAdministrador.GrupoRadioBotonesBusquedaUsuario.add(VistaAdministrador.RadioBotonEdad);
        VistaAdministrador.GrupoRadioBotonesBusquedaUsuario.add(VistaAdministrador.RadioBotonFuncion);
    }
    void MostrarMesas(){
        DefaultTableModel modo=new DefaultTableModel();
        modo.addColumn("ID Mesa");
        modo.addColumn("Nombre");
        modo.addColumn("Asientos");
        modo.addColumn("Disponibilidaad");
        modo.addColumn("Disponibilidad");
        VistaAdministrador.TablaMesasDisponible.setModel(modo);
        String sql ="select * from mesa where disponibilidad=1";
        
        String datos[] = new String[5];
        
        try{
            Statement st = Connector.getInstancia().getConnection().createStatement();
            ResultSet rs= st.executeQuery(sql);
            while(rs.next()){
                datos[0]=rs.getString(1);
                datos[1]=rs.getString(2);
                datos[2]=rs.getString(3);
                datos[3]=rs.getString(4);
                datos[4]=rs.getString(5);
                modo.addRow(datos);
            }
            VistaAdministrador.TablaMesasDisponible.setModel(modo);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "No se pudo mostrar la tabla de personal por usuario");
        
        } 
    }

    private void addListenerUser() {
        this.ventana.BotonNuevo.addActionListener(this);
        this.ventana.BotonModificar.addActionListener(this);
        this.ventana.BotonActualizar.addActionListener(this);
        this.ventana.BotonGuardar.addActionListener(this);
        this.ventana.BotonEliminar.addActionListener(this);
        this.ventana.BotonCerrar.addActionListener(this);
    }

    private void addListenerReport() {
        this.ventana.MostrarReporte.addActionListener(this);
        this.ventana.BusquedaPorFiltro.addActionListener(this);
        this.ventana.BuscarSeleccionFiltro.addActionListener(this);
    }
}
