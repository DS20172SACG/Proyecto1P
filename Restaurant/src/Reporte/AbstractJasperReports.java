/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reporte;

import java.sql.Connection;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.*;
import net.sf.jasperreports.view.*;
import java.util.Map;
/**
 *
 * @author User
 */
public class AbstractJasperReports {
    private static JasperReport reporte;
    private static JasperPrint reportfilled;
    private static JasperViewer viewer;
            
    public static void createReports(Connection cn,String path) {
        
        try{
            reporte = (JasperReport) JRLoader.loadObjectFromFile(path);
            reportfilled = JasperFillManager.fillReport(path, null, cn);
            
        }catch(JRException ex){
            ex.printStackTrace();
        }
    }
    
    public static void createReports(Connection cn,String path, Map parameters) {
        
        try{
            reporte = (JasperReport) JRLoader.loadObjectFromFile(path);
            reportfilled = JasperFillManager.fillReport(path, parameters, cn);
            
        }catch(JRException ex){
            ex.printStackTrace();
        }
    }

    public static void showViewer(){
        viewer = new JasperViewer(reportfilled,false);
        //viewer.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        viewer.setVisible(true);
    }
}
