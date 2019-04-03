/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librosautores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author a16pablovc
 */
public class LibrosAutores {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
    
     Statement sentencia=null;
     try{
      Connection conexion=DriverManager.getConnection("jdbc:mysql://localhost:3307/?user=root&password=usbw");
             sentencia=conexion.createStatement();
        }catch(SQLException e){System.out.println(e.getMessage());}
        
     int op;
     do{
              System.out.println("Elige opcion \n 1 Crear base de datos \n 2 Altas \n 3 Bajas \n 4 Modificaciones \n 5 Consultas \n 6 Fin");
     op=comprobaciones.entero();
    
     switch (op){
     
         case 1:Crearbase.Crear(sentencia);System.out.println("creada");break;
          case 2:Altas.altas(sentencia);break;
           case 3:Bajas.Bajas(sentencia);break;
            case 4:Modificaciones.modificaciones(sentencia);break;
             case 5:Consultas.consultas(sentencia);break;
             
     
     
     }
     
     
     }while(op!=6);
     
    }
    
}
