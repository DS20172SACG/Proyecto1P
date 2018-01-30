/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import BaseDeDatos.Consultador;
import Pagaduria.*;
import Vistas.VistaCajero;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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
    private String cliente;
    
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
        addListaClientesListener();
        addActualizarListener();
        addAgregarPedListener();
        addQuitarPedListener();
        addFacturarListener();
    }

    private void addFacturarListener() {
        ventana.getFacturarBut().addActionListener((e) -> {
            int desc = (Integer)ventana.getjSpinner1().getModel().getValue();
            String TipoDePago = ventana.getjComboBox1().getSelectedItem().toString();
            
            if("Efectivo".equals(TipoDePago)){
                PagoEfectivo pago = new PagoEfectivo();
                pago.pagar(cliente, desc);
            }
            else if("Tarjeta Visa".equals(TipoDePago)){
                PagoTarjetaVisa pago = new PagoTarjetaVisa();
                pago.pagar(cliente, desc);
            }
            else if("Dinero Electrónico".equals(TipoDePago)){
                PagoDineroElectronico pago = new PagoDineroElectronico();
                pago.pagar(cliente, desc);
            }
            DefaultListModel<String> ListaPedidosPorPagar  = (DefaultListModel)ventana.getjList2().getModel();
            ListaPedidosPorPagar.removeElement(cliente);
            DefaultListModel<String> ListaPedidosEnFactura = (DefaultListModel)ventana.getjList3().getModel();
            ListaPedidosEnFactura.removeAllElements();
            
            ventana.getjTextPane1().setText("Cod.   Articulo\tCant.   Precio");
            
        });
    }

    private void addQuitarPedListener() {
        ventana.getQuitarPed().addActionListener((ActionEvent e) -> {

            DefaultListModel<String> ListaPedidosEnFactura = (DefaultListModel)ventana.getjList3().getModel();
            ListaPedidosEnFactura.removeAllElements();
            
            ventana.getjTextPane1().setText("Cod.   Articulo\tCant.   Precio");
        });
    }

    private void addAgregarPedListener() {
        ventana.getAgregarPed().addActionListener((ActionEvent e) -> {
            cliente = ventana.getjList2().getSelectedValue();
            DefaultListModel<String> ListaPedidosPorPagar  = (DefaultListModel)ventana.getjList2().getModel();
            
            DefaultListModel<String> ListaPedidosEnFactura = (DefaultListModel)ventana.getjList3().getModel();
            ListaPedidosEnFactura.removeAllElements();
            ArrayList<String> pedidosPorCliente = Consultador.getInstancia().cargarListaPedidosNoPagadosPorCliente(cliente);
            String text = "";
            
            for(String s: pedidosPorCliente){
                ListaPedidosEnFactura.addElement(s);
                text += Consultador.getInstancia().generarDetalleFactura(s);
            }
            ventana.getjTextPane1().setText(ventana.getjTextPane1().getText() + "\n"+ text);
        });
    }

    private void addActualizarListener() {
        ventana.getjButton3().addActionListener((ActionEvent e) -> {
            //actualizar cliente.
        });
    }

    private void addListaClientesListener() {
        ventana.getjList1().addListSelectionListener((ListSelectionEvent e) -> {
            ventana.getjTextField1().setText(ventana.getjList1().getSelectedValue().getCedula());
            ventana.getjTextField3().setText(ventana.getjList1().getSelectedValue().getNombre());
            ventana.getjTextField4().setText(ventana.getjList1().getSelectedValue().getApellido());
            ventana.getjTextField5().setText(ventana.getjList1().getSelectedValue().getDireccion());
        });
    }
    
    
    
}
