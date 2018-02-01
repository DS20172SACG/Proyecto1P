/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pedidos;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author agamboa
 */
public class PedidoTest {
    
    public PedidoTest() {
    }

    /**
     * Test minutosEstimados del pedido 1, con tres platos:max 20 minutos
     */
    @Test
    public void testMinutosEstimados1() {
        System.out.println("minutosEstimados1");
        Pedido instance = new PedidoPresencial();
        DetallePedido plato1 = new DetallePedido(101, 1, "");
        DetallePedido plato2 = new DetallePedido(102, 1, "");
        DetallePedido plato3 = new DetallePedido(103, 1, "");
        instance.addDetalles(plato1);
        instance.addDetalles(plato2);
        instance.addDetalles(plato3);
        int expResult = 26;
        int result = instance.minutosEstimados();
        assertEquals(expResult, result);
        
    }
    /**
     * Test minutosEstimados del pedido 2, con dos platos:max 17 minutos
     */
    @Test
    public void testMinutosEstimados2() {
        System.out.println("minutosEstimados2");
        Pedido instance = new PedidoPresencial();
        DetallePedido plato4 = new DetallePedido(104, 1, "");
        DetallePedido plato5 = new DetallePedido(105, 1, "");
        
        instance.addDetalles(plato4);
        instance.addDetalles(plato5);
        
        int expResult = 20;
        int result = instance.minutosEstimados();
        assertEquals(expResult, result);
        
    }
    @Test
    public void testMinutosEstimados3() {
        System.out.println("minutosEstimados3");
        Pedido instance = new PedidoPresencial();
        DetallePedido plato6 = new DetallePedido(106, 1, "");
        DetallePedido plato7 = new DetallePedido(107, 1, "");
        DetallePedido combo1 = new DetallePedido(109, 1, "");
        instance.addDetalles(plato6);
        instance.addDetalles(plato7);
        instance.addDetalles(combo1);
        int expResult = 21;
        int result = instance.minutosEstimados();
        assertEquals(expResult, result);
        
    }
    
    /**
     * Test minutosEstimados del pedido 4, con dos platos:max 17 minutos
     */
    @Test
    public void testMinutosEstimados4() {
        System.out.println("minutosEstimados4");
        Pedido instance = new PedidoPresencial();
        DetallePedido plato8 = new DetallePedido(108, 1, "");
        
        
        instance.addDetalles(plato8);
        
        
        int expResult = 30;
        int result = instance.minutosEstimados();
        assertEquals(expResult, result);
        
    }
    
}
