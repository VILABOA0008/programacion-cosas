/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autores_libros_telefonos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import pojos.*;

/**
 *
 * @author mi
 */
public class Autores_libros_telefonos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
 Statement sentencia=null;

     try{
      Connection conexion=DriverManager.getConnection("jdbc:mysql://localhost:3307/?user=root&password=usbw");
             sentencia=conexion.createStatement();
        }catch(SQLException e){System.out.println(e.getMessage());}
   CrearBase.crear(sentencia);
 NewHibernateUtil.getSessionFactory();
            CrearBase.crear(sentencia);
       List <Autores> lautores =new ArrayList<>();
         List <Libros> llibros =new ArrayList<>();
           List <Telefonos> ltelegfonos =new ArrayList<>();
        
       
  

 
     int op=0;
     do{
         System.out.println("2 Para dar altas \n3 Para borrar \n4 Para Modificar \n5 Para consultar \n6 Salir");
         op=Comprobaciones.opcion(6);
         
         switch(op){
            
                case 2:Altas.altas();break;
                   case 3:Bajas.bajas();break;
                      case 4:Modificaciones.modificaciones();break;
                        case 5:Consultas.consutas();break;
         
         }
              
   
     
     }while(op!=6);
        System.exit(1);
    }
    
}
