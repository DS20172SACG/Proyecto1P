/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import BaseDeDatos.Consultador;
import Vistas.VistaCajero;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import restaurant.Personal.Cajero;

/**
 *
 * @author Usuario
 */
public class ControlCajero implements Controlador {

    private VistaCajero ventana;
    private Cajero cajero;
    
    public ControlCajero(Cajero cajero){
        ventana = new VistaCajero();
        this.cajero = cajero;
        this.cajero.setControl(this);
        addListeners();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
    }

    @Override
    public void presentarVista() {
        ventana.setVisible(true);
    }
    
    public void addListeners(){
        ventana.getjButton3().addActionListener(this);
        ventana.getjList1().addListSelectionListener((ListSelectionEvent e) -> {
            ventana.getjTextField1().setText(ventana.getjList1().getSelectedValue().getCedula());
            ventana.getjTextField3().setText(ventana.getjList1().getSelectedValue().getNombre());
            ventana.getjTextField4().setText(ventana.getjList1().getSelectedValue().getApellido());
            ventana.getjTextField5().setText(ventana.getjList1().getSelectedValue().getDireccion());
        });
        
        ventana.getjButton3().addActionListener((ActionEvent e) -> {
            //actualizar cliente.
        });
        
        ventana.getjList2().addListSelectionListener((ListSelectionEvent e) -> {
            ventana.getjTextPane1().setText(Consultador.getInstancia().generarDetalleFactura(ventana.getjList2().getSelectedValue()));
        });
        
        
    }
    
    
    
}
