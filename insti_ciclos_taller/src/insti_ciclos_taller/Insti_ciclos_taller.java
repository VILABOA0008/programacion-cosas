/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insti_ciclos_taller;

import Pojos.Ciclos;
import static insti_ciclos_taller.Altas.guardar;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Random;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author a16pablovc
 */
public class Insti_ciclos_taller {

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
      //  SessionFactory sf=NewHibernateUtil.getSessionFactory();    
      
 

     String a;
  do{
       Session s;
       s=NewHibernateUtil.getSession();
      System.out.println("par");
   a=Comprobaciones.strin();
    Random r=new Random();
        int cod=r.nextInt(43);
        String nombre ="ciclo";
        nombre+=String.valueOf(cod);
        
    Ciclos c=new Ciclos(cod, nombre);
     s.beginTransaction();
    s.saveOrUpdate(c);
        s.getTransaction().commit();
        
      s.close();   
      comprobar();
      
  }while(a.equalsIgnoreCase("a"));

 
   
           try{
                           
       int op=0;
     do{
  
         System.out.println("1 Para dar altas \n2 Para borrar \n3 Para Modificar \n4 Para consultar \n6 Salir");
         op=Comprobaciones.opcion(7);

         switch(op){
                           case 1:Altas.altas(sf,s);break;
                   case 2:Bajas.bajas();break;
                      case 3:Modificaciones.modificaciones();break;
                        case 4:Consultas.consultas(sf,s);break;
         
         }
              
   
     
     }while(op!=6);
             
             } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }       
             
        System.exit(1);
    
    }
    
public static void comprobar(){
     Session s;
   s=NewHibernateUtil.getSession();
          List <Ciclos> ciclo =null;             
            ciclo=s.createCriteria(Ciclos.class).list();
      System.out.println("sdsdsda");
s.close();
}
}
