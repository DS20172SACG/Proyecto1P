/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import BaseDeDatos.Consultador;
import Constantes.ConstantesCategoria;
import Pedidos.DetallePedido;
import Pedidos.PedidoDomicilio;
import Pedidos.PedidoPresencial;
import Vistas.VistaMesero;
import java.awt.event.ActionEvent;
import java.util.LinkedList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import restaurant.Personal.Mesero;

/**
 *
 * @author Usuario
 */
public class ControlMesero implements Controlador {

    private VistaMesero ventana;
    private Mesero mesero;

    public ControlMesero(Mesero mesero) {
        ventana = new VistaMesero();
        ventana.colocarNombresMesas(Consultador.getInstancia().nombresMesas());
        this.mesero = mesero;
        this.mesero.setControl(this);
        addListeners();
    } 
    @Override
    public void actionPerformed(ActionEvent e) {
    }
    
    @Override
    public void presentarVista() {
        ventana.setVisible(true);
    }
    
    private void addListeners(){
        listenersRadioButtons();
        listenersComboBoxes();
        listenersButtons();
    }
    
    private boolean validarIngresoDetalle(){
        return true;
    }
    
    private void agregarDetallePedidoNuevo(){
        DetallePedido detalle = new DetallePedido();
        detalle.setNombreArticulo(String.valueOf(ventana.getjComboBox1().getSelectedItem()));
        detalle.setPrecioArticulo(Double.parseDouble(ventana.getjTextField2().getText()));
        detalle.setCantidad(Integer.parseInt(ventana.getjTextField3().getText()));
        detalle.setObservaciones(ventana.getjTextArea2().getText());
        detalle.setNumDetalle(mesero.getDetallePedidoNuevo().size()+1);
        mesero.getDetallePedidoNuevo().add(detalle);
        DefaultTableModel dm = (DefaultTableModel) ventana.getjTable1().getModel();
        dm.addRow(new Object[]{detalle.getNumDetalle(),detalle.getNombreArticulo(),detalle.getCantidad(),detalle.getPrecioArticulo()});
    }
    
    public PedidoPresencial generarPedidoPresencial(){
        return new PedidoPresencial(
            Consultador.getInstancia().idMesaPorNombre(String.valueOf(ventana.getjComboBox4().getSelectedItem())),
                ventana.getjCheckBox1().isSelected(),
                ventana.getjTextField1().getText(),
                mesero.getIdentificacion());
    }
    
    public PedidoDomicilio generarPedidoDomicilio(){
        return new PedidoDomicilio(
                ventana.getjTextField14().getText(),
                ventana.getjCheckBox1().isSelected(),
                ventana.getjTextField1().getText(),
                mesero.getIdentificacion());
    }
    
    public void actualizarTablaPedidosNoAtendidos(LinkedList<String[]> datos){
        DefaultTableModel dm = (DefaultTableModel) ventana.getjTable2().getModel();
        for(String[] info : datos){
            dm.addRow(info);
        }
    }
    
    public void actualizarTablaDetallePedidoNoAtendido(LinkedList<String[]> datos){
        DefaultTableModel dm = (DefaultTableModel) ventana.getjTable6().getModel();
        for(String[] info : datos){
            dm.addRow(info);
        }
    }
    
    public void listenersRadioButtons(){
        
        ventana.getjRadioButton1().addActionListener((ActionEvent e) -> {
            ventana.colocarArticulosEnCombo(Consultador.getInstancia().cargarArticulosPorCategoria(ConstantesCategoria.PLATOENTRADA), ventana.getjComboBox1());
        });
        
        ventana.getjRadioButton2().addActionListener((ActionEvent e) -> {
            ventana.colocarArticulosEnCombo(Consultador.getInstancia().cargarArticulosPorCategoria(ConstantesCategoria.PLATOFUERTE), ventana.getjComboBox1());
        });
        
        ventana.getjRadioButton3().addActionListener((ActionEvent e) -> {
            ventana.colocarArticulosEnCombo(Consultador.getInstancia().cargarArticulosPorCategoria(ConstantesCategoria.PLATOPOSTRE), ventana.getjComboBox1());
        });
        
        ventana.getjRadioButton4().addActionListener((ActionEvent e) -> {
            ventana.colocarArticulosEnCombo(Consultador.getInstancia().cargarArticulosPorCategoria(ConstantesCategoria.COMBO), ventana.getjComboBox1());
        });
        
        ventana.getjRadioButton13().addActionListener((ActionEvent e) -> {
            ventana.colocarArticulosEnCombo(Consultador.getInstancia().cargarArticulosPorCategoria(ConstantesCategoria.BEBIDAREFRESCO), ventana.getjComboBox1());
        });
        
        ventana.getjRadioButton14().addActionListener((ActionEvent e) -> {
            ventana.colocarArticulosEnCombo(Consultador.getInstancia().cargarArticulosPorCategoria(ConstantesCategoria.BEBIDANATURAL), ventana.getjComboBox1());
        });
        
        ventana.getjRadioButton15().addActionListener((ActionEvent e) -> {
            ventana.colocarArticulosEnCombo(Consultador.getInstancia().cargarArticulosPorCategoria(ConstantesCategoria.BEBIDAARTIFICIAL), ventana.getjComboBox1());
        });
        
        ventana.getjRadioButton16().addActionListener((ActionEvent e) -> {
            ventana.getjComboBox4().setEnabled(true);
            ventana.getjTextField14().setEnabled(false);
        });
        
        ventana.getjRadioButton17().addActionListener((ActionEvent e) -> {
            ventana.getjComboBox4().setEnabled(false);
            ventana.getjTextField14().setEnabled(false);
        });
        
    }
    
    public void listenersComboBoxes(){
        ventana.getjComboBox1().addActionListener((ActionEvent e) -> {
            String texto = String.valueOf(ventana.getjComboBox1().getSelectedItem());
            ventana.getjTextArea1().setText(Consultador.getInstancia().descripcionDeArticuloPorNombre(texto));
            ventana.getjTextField2().setText(Double.toString(Consultador.getInstancia().precioDeArticuloPorNombre(texto)));
        });
    }
    
    public void listenersButtons(){
        ventana.getjButton1().addActionListener((ActionEvent e) -> {
            if(ventana.getjRadioButton16().isSelected()){
                mesero.ingresarPedidoPresencial(generarPedidoPresencial());
            }else if(ventana.getjRadioButton17().isSelected()){
                mesero.ingresarPedidoDomicilio(generarPedidoDomicilio());
            }
        });
        
        ventana.getjButton2().addActionListener((ActionEvent e) -> {
            actualizarTablaDetallePedidoNoAtendido(Consultador.getInstancia().detalleDePedidoParaTabla(Integer.parseInt(ventana.getjTextField7().getText())));
        });
        
        ventana.getjButton3().addActionListener((ActionEvent e) -> {
            if(Consultador.getInstancia().pedidoEsADomicilio(Integer.parseInt(ventana.getjTextField7().getText()))){
                ventana.getjPanel4().setVisible(true);
                ventana.getjTextField10().setText(Consultador.getInstancia().direccionEntregaPedido(Integer.parseInt(ventana.getjTextField7().getText())));
            }else{
                ventana.getjPanel9().setVisible(true);
                ventana.getjComboBox3().setSelectedIndex(Consultador.getInstancia().idMesaDePedido(Integer.parseInt(ventana.getjTextField7().getText())));
            }
        });
        
        ventana.getjButton4().addActionListener((ActionEvent e) -> {
            actualizarTablaPedidosNoAtendidos(Consultador.getInstancia().pedidosNoAtendidosDeClienteParaTabla(ventana.getjTextField6().getText()));
        });
        
        ventana.getjButton9().addActionListener((ActionEvent e) -> {
            if(validarIngresoDetalle()){ 
                agregarDetallePedidoNuevo();
                ventana.limpiarParteIngresoDetalle();
                ventana.actualizarSubtotal(mesero.totalDetalle());
            };
        });
    }
}
