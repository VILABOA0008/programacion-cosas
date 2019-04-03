/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebaproy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import pojoss.pato;

/**
 *
 * @author a16pablovc
 */
public class Pruebaproy {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
          Statement sentencia=null;
           try{
      Connection conexion=DriverManager.getConnection("jdbc:mysql://localhost:3307/?user=root&password=usbw");
             sentencia=conexion.createStatement();
        }catch(SQLException e){System.out.println(e.getMessage());}
          pato.crear(sentencia);
    }
    
}
