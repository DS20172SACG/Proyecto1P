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
        if(e.getSource().equals(ventana.getjRadioButton1())){
            ventana.colocarArticulosEnCombo(Consultador.getInstancia().cargarArticulosPorCategoria(ConstantesCategoria.PLATOENTRADA), ventana.getjComboBox1());
        }else if(e.getSource().equals(ventana.getjRadioButton2())){
            ventana.colocarArticulosEnCombo(Consultador.getInstancia().cargarArticulosPorCategoria(ConstantesCategoria.PLATOFUERTE), ventana.getjComboBox1());            
        }else if(e.getSource().equals(ventana.getjRadioButton3())){
            ventana.colocarArticulosEnCombo(Consultador.getInstancia().cargarArticulosPorCategoria(ConstantesCategoria.PLATOPOSTRE), ventana.getjComboBox1());
        }else if(e.getSource().equals(ventana.getjRadioButton4())){
            ventana.colocarArticulosEnCombo(Consultador.getInstancia().cargarArticulosPorCategoria(ConstantesCategoria.COMBO), ventana.getjComboBox1()); 
        

            
        }else if(e.getSource().equals(ventana.getjRadioButton13())){
            ventana.colocarArticulosEnCombo(Consultador.getInstancia().cargarArticulosPorCategoria(ConstantesCategoria.BEBIDAREFRESCO), ventana.getjComboBox1());
        }else if(e.getSource().equals(ventana.getjRadioButton14())){
            ventana.colocarArticulosEnCombo(Consultador.getInstancia().cargarArticulosPorCategoria(ConstantesCategoria.BEBIDANATURAL), ventana.getjComboBox1());
        }else if(e.getSource().equals(ventana.getjRadioButton15())){
            ventana.colocarArticulosEnCombo(Consultador.getInstancia().cargarArticulosPorCategoria(ConstantesCategoria.BEBIDAARTIFICIAL), ventana.getjComboBox1());
        }else if(e.getSource().equals(ventana.getjComboBox1())){
            String texto = String.valueOf(ventana.getjComboBox1().getSelectedItem());
            ventana.getjTextArea1().setText(Consultador.getInstancia().descripcionDeArticuloPorNombre(texto));
            ventana.getjTextField2().setText(Double.toString(Consultador.getInstancia().precioDeArticuloPorNombre(texto)));
        }else if(e.getSource().equals(ventana.getjButton9())){
            if(validarIngresoDetalle()){ 
                agregarDetallePedidoNuevo();
                ventana.limpiarParteIngresoDetalle();
                ventana.actualizarSubtotal(mesero.totalDetalle());
            };
        }else if(e.getSource().equals(ventana.getjButton1())){
            if(ventana.getjRadioButton16().isSelected()){
                mesero.ingresarPedidoPresencial(generarPedidoPresencial());
            }else if(ventana.getjRadioButton17().isSelected()){
                mesero.ingresarPedidoDomicilio(generarPedidoDomicilio());
            }
        }else if(e.getSource().equals(ventana.getjButton4())){
            
        }else if(e.getSource().equals(ventana.getjRadioButton16())){
            ventana.getjComboBox4().setEnabled(true);
            ventana.getjTextField14().setEnabled(false);
        }else if(e.getSource().equals(ventana.getjRadioButton17())){
            ventana.getjComboBox4().setEnabled(false);
            ventana.getjTextField14().setEnabled(false);
        }
    }
    
    @Override
    public void presentarVista() {
        ventana.setVisible(true);
    }
    
    private void addListeners(){
        ventana.getjRadioButton1().addActionListener(this);
        ventana.getjRadioButton2().addActionListener(this);
        ventana.getjRadioButton3().addActionListener(this);
        ventana.getjRadioButton4().addActionListener(this);
        ventana.getjRadioButton13().addActionListener(this);
        ventana.getjRadioButton14().addActionListener(this);
        ventana.getjRadioButton15().addActionListener(this);
        ventana.getjRadioButton16().addActionListener(this);
        ventana.getjRadioButton17().addActionListener(this);
        ventana.getjComboBox1().addActionListener(this);
        ventana.getjButton9().addActionListener(this);
        ventana.getjButton1().addActionListener(this);
        ventana.getjButton4().addActionListener(this);
        
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
            mesero.totalDetalle(),
            ventana.getjTextField1().getText(),
            mesero.getIdentificacion(),
            ventana.getjCheckBox1().isSelected());
    }
    
    public PedidoDomicilio generarPedidoDomicilio(){
        return new PedidoDomicilio(
                ventana.getjTextField14().getText(),
                mesero.totalDetalle(),
                ventana.getjTextField1().getText(),
                mesero.getIdentificacion(),
                ventana.getjCheckBox1().isSelected());
                
    }
}
