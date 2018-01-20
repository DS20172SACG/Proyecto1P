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
            resultado = llamada.executeQuery();
            resultado.next();
            idPedido = resultado.getInt(1);
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
                llamada.setInt(1, d.getIdPedido());
            } catch (SQLException ex) {
                Logger.getLogger(Escritor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
