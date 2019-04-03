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
        
 NewHibernateUtil.getSessionFactory();
            
       List <Autores> lautores =null;
         List <Libros> llibros =null;
           List <Telefonos> ltelegfonos =null;
          Session sesion;
       
    try {
            sesion = NewHibernateUtil.getSession();
            lautores=sesion.createCriteria(Autores.class).list();
            llibros=sesion.createCriteria(Libros.class).list();
            ltelegfonos=sesion.createCriteria(Telefonos.class).list();
            sesion.close();
            
         
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }

 
     int op=0;
     do{
         System.out.println("1 Para Crear la base de datos \n2 Para dar altas \n3 Para borrar \n4 Para Modificar \n5 Para consultar \n6 Salir");
         op=Comprobaciones.opcion(6);
         
         switch(op){
             case 1:CrearBase.crear(sentencia);break;
                case 2:Altas.altas(lautores,llibros,ltelegfonos);break;
                   case 3:Bajas.bajas(lautores,llibros,ltelegfonos);break;
                      case 4:Modificaciones.modificaciones(lautores,llibros,ltelegfonos);break;
                      case 5:Consultas.consutas(lautores,llibros,ltelegfonos);break;
         
         }
     
     }while(op!=6);
     
    }
    
}
