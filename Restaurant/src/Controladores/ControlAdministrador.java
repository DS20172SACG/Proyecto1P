/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import BaseDeDatos.Connector;
import Reporte.AbstractJasperReports;
import Vistas.VistaAdministrador;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
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
        this.ventana.MostrarReporte.addActionListener(this);
        this.ventana.BusquedaPorFiltro.addActionListener(this);
        this.ventana.BuscarSeleccionFiltro.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(ventana.MostrarReporte==e.getSource()){
            Map parameters = new HashMap();
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
    }

    @Override
    public void presentarVista() {
        ventana.setVisible(true);
        agregarRadioBotones();
        MostrarUsuarios();
        VistaAdministrador.MostrarReporte.setEnabled(false);
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
        VistaAdministrador.TablaUsuario.setModel(modo);
        
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
    }
}
