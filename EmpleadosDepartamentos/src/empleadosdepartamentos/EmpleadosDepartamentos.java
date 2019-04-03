/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empleadosdepartamentos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author a16pablovc
 */
public class EmpleadosDepartamentos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
           Statement sentencia=null;
     try{
      Connection conexion=DriverManager.getConnection("jdbc:mysql://localhost:3307/?user=root&password=usbw");
             sentencia=conexion.createStatement();
        }catch(SQLException e){System.out.println(e.getMessage());}
     Creartablas.crear(sentencia);

        int op;
        do{
                  System.out.println(" Elige opcion: \n 1 Altas \n 2 Bajas \n 3 Consultas \n 4 Modificaciones \n 5 Fin");
        op=comprobaciones.opcion(5);
        
        switch(op){
            
            case 1:Altas.altas(sentencia);break;
            case 2:Bajas.bajas(sentencia);break;
            case 3:Consultas.consultas(sentencia);break;
            case 4:Modificaciones.modificaciones(sentencia);break;
            
        
        
        }
        
        }while(op!=5);
        
    }
    
}
