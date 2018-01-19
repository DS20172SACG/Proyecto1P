/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import BaseDeDatos.Consultador;
import Constantes.ConstantesCategoria;
import Vistas.VistaMesero;
import java.awt.event.ActionEvent;
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
        }else if(e.getSource().equals(ventana.getjRadioButton5())){
            
        }else if(e.getSource().equals(ventana.getjRadioButton6())){
            
        }else if(e.getSource().equals(ventana.getjRadioButton7())){
            
        }else if(e.getSource().equals(ventana.getjRadioButton8())){
            
        }else if(e.getSource().equals(ventana.getjRadioButton9())){
            
        }else if(e.getSource().equals(ventana.getjRadioButton10())){
            
        }else if(e.getSource().equals(ventana.getjRadioButton11())){
            
        }else if(e.getSource().equals(ventana.getjRadioButton12())){
            
        }else if(e.getSource().equals(ventana.getjRadioButton13())){
            ventana.colocarArticulosEnCombo(Consultador.getInstancia().cargarArticulosPorCategoria(ConstantesCategoria.BEBIDAREFRESCO), ventana.getjComboBox3());
        }else if(e.getSource().equals(ventana.getjRadioButton14())){
            ventana.colocarArticulosEnCombo(Consultador.getInstancia().cargarArticulosPorCategoria(ConstantesCategoria.BEBIDANATURAL), ventana.getjComboBox1());
        }else if(e.getSource().equals(ventana.getjRadioButton15())){
            ventana.colocarArticulosEnCombo(Consultador.getInstancia().cargarArticulosPorCategoria(ConstantesCategoria.BEBIDAARTIFICIAL), ventana.getjComboBox1());
        }
    }
    
    @Override
    public void presentarVista() {
        ventana.setVisible(true);
    }
    
    public void addListeners(){
        ventana.getjRadioButton1().addActionListener(this);
        ventana.getjRadioButton2().addActionListener(this);
        ventana.getjRadioButton3().addActionListener(this);
        ventana.getjRadioButton4().addActionListener(this);
        ventana.getjRadioButton5().addActionListener(this);
        ventana.getjRadioButton6().addActionListener(this);
        ventana.getjRadioButton7().addActionListener(this);
        ventana.getjRadioButton8().addActionListener(this);
        ventana.getjRadioButton9().addActionListener(this);
        ventana.getjRadioButton10().addActionListener(this);
        ventana.getjRadioButton11().addActionListener(this);
        ventana.getjRadioButton12().addActionListener(this);
        ventana.getjRadioButton13().addActionListener(this);
        ventana.getjRadioButton14().addActionListener(this);
        ventana.getjRadioButton15().addActionListener(this);
        ventana.getjComboBox1().addActionListener(this);
    }
    
}
