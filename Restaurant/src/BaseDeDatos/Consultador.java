/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDeDatos;

import Pagaduria.Cliente;
import Pedidos.DetallePedido;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author Usuario
 */
public class Consultador {
    
    private static Consultador instancia = new Consultador();
    private String cadenaDeLlamada;
    private CallableStatement llamada;
    private ResultSet resultado;

    public Consultador() {
    }
    
    public static Consultador getInstancia(){
        return instancia;
    }
    
    public boolean usuarioExiste(String usuario){
        cadenaDeLlamada = "{CALL buscarUsuario(?)}";
        try{
            llamada = Connector.getInstancia().getConnection().prepareCall(cadenaDeLlamada);
            llamada.setString(1, usuario);
            resultado = llamada.executeQuery();
            if(resultado.isBeforeFirst()){
                return true;
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return false;
    }
    
    public boolean datosUsuarioCorrectos(String usuario, String contrasena){
        cadenaDeLlamada = "{CALL verificarUsuarioContrasena(?,?)}";
        try{
            llamada = Connector.getInstancia().getConnection().prepareCall(cadenaDeLlamada);
            llamada.setString(1, usuario);
            llamada.setString(2, contrasena);
            resultado = llamada.executeQuery();
            if(resultado.isBeforeFirst()){
                return true;
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return false;
    }
    
    public ResultSet obtenerPersonalPorUsuario(String usuario){
        cadenaDeLlamada = "{CALL ObtenerPersonalPorUsuario(?)}";
        resultado = null;
        try{
            llamada = Connector.getInstancia().getConnection().prepareCall(cadenaDeLlamada);
            llamada.setString(1, usuario);
            resultado = llamada.executeQuery();
            resultado.next();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    public ResultSet cargarArticulosPorCategoria(int categoria){
        cadenaDeLlamada = "{CALL cargarArticuloPorCategoria(?)}";
        try{
            llamada = Connector.getInstancia().getConnection().prepareCall(cadenaDeLlamada);
            llamada.setInt(1, categoria);
            resultado = llamada.executeQuery();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    public String descripcionDeArticuloPorNombre(String nombre){
        if(nombre.isEmpty()) return "";
        cadenaDeLlamada = "{CALL cargarDescripcionArticuloPorNombre(?)}";
        String retorno = "";
        try{
            llamada = Connector.getInstancia().getConnection().prepareCall(cadenaDeLlamada);
            llamada.setString(1, nombre);
            resultado = llamada.executeQuery();
            if(resultado.isBeforeFirst()){
                resultado.next();
                retorno = resultado.getString(1);
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return retorno;
    }
    
    public double precioDeArticuloPorNombre(String nombre){
        if(nombre.isEmpty()) return 0;
        cadenaDeLlamada = "{CALL cargarPrecioArticuloPorNombre(?)}";
        double retorno = 0;
        try{
            llamada = Connector.getInstancia().getConnection().prepareCall(cadenaDeLlamada);
            llamada.setString(1, nombre);
            resultado = llamada.executeQuery();
            if(resultado.isBeforeFirst()){
                resultado.next();
                retorno = resultado.getDouble(1);
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return retorno;
    }

    public LinkedList<String> nombresMesas(){
        LinkedList<String> mesas = new LinkedList<>();
        cadenaDeLlamada = "{CALL cargarNombresMesas()}";
        try{
            llamada = Connector.getInstancia().getConnection().prepareCall(cadenaDeLlamada);
            resultado = llamada.executeQuery();
            while(resultado.next()){
                mesas.add(resultado.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Consultador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mesas;
    }
    
    public int idMesaPorNombre(String nombre){
        int idMesa = 0;
        cadenaDeLlamada = "{CALL idMesaPorNombre(?)}";
        try{
            llamada = Connector.getInstancia().getConnection().prepareCall(cadenaDeLlamada);
            llamada.setString(1, nombre);
            resultado = llamada.executeQuery();
            resultado.next();
            idMesa = resultado.getInt(1);
        } catch (SQLException ex) {
            Logger.getLogger(Consultador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return idMesa;
    }
    public ArrayList<Cliente> obtenerListaClientes(){
        cadenaDeLlamada = "{CALL cargarListaClientes}";
        resultado = null;
        ArrayList<Cliente> clientes = new ArrayList();
        try{
            llamada = Connector.getInstancia().getConnection().prepareCall(cadenaDeLlamada);
            resultado = llamada.executeQuery();
            
            while(resultado.next())
            {
                Cliente cliente = new Cliente(  resultado.getString(1),
                                                resultado.getString(2),
                                                resultado.getString(3),
                                                resultado.getString(4));
                clientes.add(cliente); 

            }
            
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            
        }
        return clientes;
    }
    
    public ArrayList<Cliente> obtenerListaClientesPendientes(){
        cadenaDeLlamada = "{CALL cargarListaClientesPendientes}";
        resultado = null;
        ArrayList<Cliente> clientes = new ArrayList();
        try{
            llamada = Connector.getInstancia().getConnection().prepareCall(cadenaDeLlamada);
            resultado = llamada.executeQuery();
            
            while(resultado.next())
            {
                Cliente cliente = new Cliente(  resultado.getString(1),
                                                resultado.getString(2),
                                                resultado.getString(3),
                                                resultado.getString(4));
                clientes.add(cliente); 

            }
            
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            
        }
        return clientes;
    }
    
    
    public ArrayList<String> cargarListaPedidosNoPagadosPorCliente(String id){
        cadenaDeLlamada = "{CALL cargarListaIdPedidosNoPagados(?)}";
        resultado = null;
        ArrayList<String> Id_pedidos= new ArrayList<>();
        try{
            llamada = Connector.getInstancia().getConnection().prepareCall(cadenaDeLlamada);
            llamada.setString(1, id);
            resultado = llamada.executeQuery();
            
            while(resultado.next())
            {
                Id_pedidos.add(resultado.getString(1));
                

            }
            
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            
        }
        return Id_pedidos;
    }
    public String generarDetalleFactura(String Id_Pedido){
        cadenaDeLlamada = "{CALL cargarInfoPedidos(?)}";
        float total = 0;
        resultado = null;
        String result = "";
        try{
            llamada = Connector.getInstancia().getConnection().prepareCall(cadenaDeLlamada);
            llamada.setString(1, Id_Pedido);
            resultado = llamada.executeQuery();
            while(resultado.next()){
                result += String.format("\n%-7s %-8s\t %-8d %-6.2f", 
                                        resultado.getString(1), resultado.getString(2), 
                                        resultado.getInt(3), resultado.getFloat(4));
                total += resultado.getFloat(4);
            }
            
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        
        return result;
        
    }
    
    public int idArticuloPorNombre(String nombre){
        int idArticulo = 0;
        cadenaDeLlamada = "{CALL idArticuloPorNombre(?)}";
        try {
            llamada = Connector.getInstancia().getConnection().prepareCall(cadenaDeLlamada);
            llamada.setString(1, nombre);
            resultado = llamada.executeQuery();
            resultado.next();
            idArticulo = resultado.getInt(1);
        } catch (SQLException ex) {
            Logger.getLogger(Consultador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return idArticulo;
    }
    
    public LinkedList<String[]> pedidosNoAtendidosDeClienteParaTabla(String cedula){
        LinkedList<String[]> lista = new LinkedList();
        cadenaDeLlamada = "{CALL pedidosNoAtendidosDeCliente(?)}";
        try {
            llamada = Connector.getInstancia().getConnection().prepareCall(cadenaDeLlamada);
            llamada.setString(1, cedula);
            resultado = llamada.executeQuery();
            while(resultado.next()){
                String[] pedido = new String[3];
                pedido[0] = Integer.toString(resultado.getInt(1));
                pedido[1] = resultado.getString(8);
                if(resultado.getString(11) == null){
                    pedido[2] = "No";
                }else{
                    pedido[2] = "Si";
                }
                lista.add(pedido);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Consultador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
    public int idCargoPorNombre(String nombre){
        int idCargo = 0;
        cadenaDeLlamada = "{CALL buscarIdentificaciondeCargo(?)}";
        try {
            llamada = Connector.getInstancia().getConnection().prepareCall(cadenaDeLlamada);
            llamada.setString(1, nombre);
            resultado = llamada.executeQuery();
            resultado.next();
            idCargo = resultado.getInt(1);
        } catch (SQLException ex) {
            Logger.getLogger(Consultador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return idCargo;
    }
    
    public String ContrasenaPorUsuario(String usuario){
        if(usuario.isEmpty()) return "";
        cadenaDeLlamada = "{CALL cargarContrasenaPorUsuario(?)}";
        String retorno = "";
        try{
            llamada = Connector.getInstancia().getConnection().prepareCall(cadenaDeLlamada);
            llamada.setString(1, usuario);
            resultado = llamada.executeQuery();
            if(resultado.isBeforeFirst()){
                resultado.next();
                retorno = resultado.getString(1);
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return retorno;
    }
    
    public String direccionEntregaPedido(int idPedido){
        cadenaDeLlamada = "{CALL obtenerDireccionEntregaPedido(?)}";
        String retorno = "";
        try{
            llamada = Connector.getInstancia().getConnection().prepareCall(cadenaDeLlamada);
            llamada.setInt(1, idPedido);
            resultado = llamada.executeQuery();
            resultado.next();
            retorno = resultado.getString(1);
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return retorno;
    }
    
    public boolean pedidoEsADomicilio(int idPedido){
        cadenaDeLlamada = "{CALL obtenerDireccionEntregaPedido(?)}";
        try{
            llamada = Connector.getInstancia().getConnection().prepareCall(cadenaDeLlamada);
            llamada.setInt(1, idPedido);
            resultado = llamada.executeQuery();
            if(resultado.isBeforeFirst()) return true;
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return false;
    }
    
    public double totalPedido(int idPedido){
        cadenaDeLlamada = "{CALL calcularTotalPedido(?)}";
        double total = 0;
        try{
            llamada = Connector.getInstancia().getConnection().prepareCall(cadenaDeLlamada);
            llamada.setInt(1, idPedido);
            resultado = llamada.executeQuery();
            resultado.next();
            resultado.getDouble(1);
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return total;
    }
    
    public LinkedList<String[]> detalleDePedidoParaTabla(int idPedido){
        LinkedList<String[]> lista = new LinkedList();
        cadenaDeLlamada = "{CALL obtenerDetalleDePedidoParaTabla(?)}";
        try {
            llamada = Connector.getInstancia().getConnection().prepareCall(cadenaDeLlamada);
            llamada.setInt(1, idPedido);
            resultado = llamada.executeQuery();
            while(resultado.next()){
                String[] detalle = new String[4];
                detalle[0] = Integer.toString(resultado.getInt(1));
                detalle[1] = resultado.getString(2);
                detalle[2] = Integer.toString(resultado.getInt(3));
                detalle[3] = Double.toString(resultado.getDouble(4));
                lista.add(detalle);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Consultador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
    public int idMesaDePedido(int idPedido){
        int id = 0;
        cadenaDeLlamada = "{CALL obtenerMesaDePedido(?)}";
        try {
            llamada = Connector.getInstancia().getConnection().prepareCall(cadenaDeLlamada);
            llamada.setInt(1, idPedido);
            resultado = llamada.executeQuery();
            resultado.next();
            id = resultado.getInt(1);
        } catch (SQLException ex) {
            Logger.getLogger(Consultador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }
    
    public LinkedList<DetallePedido> detalleDePedido(int idPedido){
        LinkedList<DetallePedido> lista = new LinkedList();
        cadenaDeLlamada = "{CALL obtenerDetalleDePedido(?)}";
        try {
            llamada = Connector.getInstancia().getConnection().prepareCall(cadenaDeLlamada);
            llamada.setInt(1, idPedido);
            resultado = llamada.executeQuery();
            while(resultado.next()){
                lista.add(new DetallePedido(resultado.getInt(1),
                        resultado.getInt(2),
                        resultado.getInt(3),
                        resultado.getInt(4),
                        resultado.getInt(5),
                        resultado.getString(6)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Consultador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
    public int tiempoPreparacionArticulo(int idArticulo){
        int minutos = 0;
        cadenaDeLlamada = "{CALL tiempoPreparacionArticulo(?)}";
        try {
            llamada = Connector.getInstancia().getConnection().prepareCall(cadenaDeLlamada);
            llamada.setInt(1, idArticulo);
            resultado = llamada.executeQuery();
            resultado.next();
            minutos = resultado.getInt(1);
        } catch (SQLException ex) {
            Logger.getLogger(Consultador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return minutos;
    }
}

