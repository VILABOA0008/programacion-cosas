/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autores_libros_telefonos;

import static autores_libros_telefonos.Altas.autores;
import static autores_libros_telefonos.Altas.libros;
import static autores_libros_telefonos.Altas.telefonos;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import pojos.*;


/**
 *
 * @author mi
 */
public class Bajas {
    public static void bajas(List <Autores> lautores ,List <Libros> llibros,List <Telefonos> ltelegfonos){
        
            int op=0;
    do{
        System.out.println("1 Autores \n2 Libros \n3 Telefonos\n4 Salir");
        op=Comprobaciones.opcion(4);
        switch(op){
            case 1:autores(lautores);break;
            case 2:libros(llibros);break;
            case 3:telefonos(ltelegfonos);break;  }        
        
    }while(op<4);        
    }
    
    public static void autores(List <Autores> lautores ){
    
        Consultas.autores(lautores);
        System.out.println("Escribe el Dni del autor a borrar");                      
             String DNI=Comprobaciones.strin();
            Autores au=(Autores)Comprobaciones.autor_existe(lautores,DNI);
         Session sesion;
       try {

          sesion = NewHibernateUtil.getSession();
            sesion.beginTransaction();
            sesion.delete(au); 
            sesion.getTransaction().commit();
            sesion.close();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
    
    
    }
    
        
    public static void libros(List <Libros> llibros ){
      Consultas.Libros(llibros);
        System.out.println("Escribe el id del libro a borrar");                      
             String id=Comprobaciones.strin();
            Libros au=(Libros)Comprobaciones.libro_existe(llibros,id);
         Session sesion;
       try {

          sesion = NewHibernateUtil.getSession();
            sesion.beginTransaction();
            sesion.delete(au); 
            sesion.getTransaction().commit();
            sesion.close();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
    }
    
        
    public static void telefonos(List <Telefonos> ltelegfonos ){
      Consultas.Telefonos(ltelegfonos);
        System.out.println("Escribe el telefono borrar");                      
             String telefono=Comprobaciones.strin();
            Telefonos au=(Telefonos)Comprobaciones.telefono_existe(ltelegfonos,telefono);
         Session sesion;
       try {

          sesion = NewHibernateUtil.getSession();
            sesion.beginTransaction();
            sesion.delete(au); 
            sesion.getTransaction().commit();
            sesion.close();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
    }
}
