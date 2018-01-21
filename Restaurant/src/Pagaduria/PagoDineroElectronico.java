/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pagaduria;

import BaseDeDatos.Consultador;
import BaseDeDatos.Escritor;

/**
 *
 * @author Usuario
 */
public class PagoDineroElectronico implements EstrategiaDePago{

    @Override
    public void pagar(String cliente, int desc) {
        Escritor.Facturar(cliente, desc, 3);
    }
    
}
