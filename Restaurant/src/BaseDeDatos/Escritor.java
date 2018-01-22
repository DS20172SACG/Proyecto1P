/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDeDatos;

import Pedidos.*;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class Escritor {
    
    private static String cadenaDeLlamada;
    private static CallableStatement llamada;
    private static ResultSet resultado;
    
    public Escritor(){
    }
    
    public static int ingresarPedidoPresencial(PedidoPresencial pedido){
        cadenaDeLlamada = "{CALL NuevoPedidoPresencial(?,?,?,?,?)}";
        int idPedido = 0;
        try{
            llamada = Connector.getInstancia().getConnection().prepareCall(cadenaDeLlamada);
            llamada.setString(1, pedido.getIdCliente());
            llamada.setString(2, pedido.getIdMesero());
            llamada.setInt(3, pedido.getIdMesa());
            llamada.setBoolean(4, pedido.isPreferencial());
            llamada.registerOutParameter(5, java.sql.Types.INTEGER);
            llamada.executeQuery();
            idPedido = llamada.getInt(5);
            System.out.println(idPedido);
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return idPedido;
    }
    
    public static void ingresarDetallePedido(LinkedList<DetallePedido> detalle){
        cadenaDeLlamada = "{CALL IngresarDetallePedido(?,?,?,?,?)}";
        for(DetallePedido d : detalle){
            try {
                llamada = Connector.getInstancia().getConnection().prepareCall(cadenaDeLlamada);
                llamada.setInt(1, d.getNumDetalle());
                llamada.setInt(2, d.getIdPedido());
                llamada.setInt(3, d.getIdArticulo());
                llamada.setInt(4, d.getCantidad());
                llamada.setString(5,d.getObservaciones());
                llamada.executeQuery();
            } catch (SQLException ex) {
                Logger.getLogger(Escritor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static void AgregarDetalleFactura(int id_ped, int id_fact){
        cadenaDeLlamada = "{CALL IngresarDetalleFactura(?,?)}";
        
        try {
            llamada = Connector.getInstancia().getConnection().prepareCall(cadenaDeLlamada);
            llamada.setInt(1, id_fact);
            llamada.setInt(2, id_ped);
            llamada.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(Escritor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static void pagarPedido(int Pedido){
        cadenaDeLlamada = "{CALL PedidoPagado(?)}";
        try {
            llamada = Connector.getInstancia().getConnection().prepareCall(cadenaDeLlamada);
            llamada.setInt(1,Pedido);
            llamada.executeQuery();
            
        } catch (SQLException ex) {
            Logger.getLogger(Escritor.class.getName()).log(Level.SEVERE, null, ex);
        }       
    }
    
    public static void Facturar(String cliente, int descuento, int TipoDePago){
        cadenaDeLlamada ="{CALL crearFactura(?,?,?)}";
        
        try {
            llamada = Connector.getInstancia().getConnection().prepareCall(cadenaDeLlamada);
            llamada.setString(1,cliente);
            llamada.setInt(2, descuento);
            llamada.setInt(3, TipoDePago);
            resultado = llamada.executeQuery();
            resultado.next();
            
            ArrayList<String> pedidos = Consultador.getInstancia().cargarListaPedidosNoPagadosPorCliente(cliente);
            for(String s: pedidos){
                
                AgregarDetalleFactura(Integer.parseInt(s), resultado.getInt(1));
                pagarPedido(Integer.parseInt(s));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Escritor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
