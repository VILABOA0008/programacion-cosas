/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autores_libros_telefonos;

import static autores_libros_telefonos.Bajas.autores;
import static autores_libros_telefonos.Bajas.libros;
import static autores_libros_telefonos.Bajas.telefonos;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import pojos.*;

/**
 *
 * @author mi
 */
public class Modificaciones {
    public static void modificaciones(List <Autores> lautores ,List <Libros> llibros,List <Telefonos> ltelegfonos){
  
            int op=0;
    do{
        System.out.println("1 Modificar el precio de un libro \n2 Modificar el telefono de un autor \n3 Telefonos\n4 Salir");
        op=Comprobaciones.opcion(4);
        switch(op){
            case 1:libros(llibros);;break;
            case 2:libros(llibros);break;
            case 3:telefonos(ltelegfonos,lautores);break;  }        
        
    }while(op<4);        
    }
    
        public static void libros(List <Libros> llibros ){
              Float precio;
      Consultas.Libros(llibros);
        System.out.println("Escribe el id del libro a borrar");                      
             String id=Comprobaciones.strin();
              System.out.println("Escribe el nuevo precio");                      
           precio=Comprobaciones.floaat();
            Libros au=(Libros)Comprobaciones.libro_existe(llibros,id);
            au.setPrecio(precio);
         Session sesion;
       try {

          sesion = NewHibernateUtil.getSession();
            sesion.beginTransaction();
            sesion.update(au); 
            sesion.getTransaction().commit();
            sesion.close();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
    }
    
    
    public static void telefonos(List <Telefonos> ltelegfonos,List <Autores> lautores ) {
            Consultas.Telefonos(ltelegfonos);
             System.out.println("Escribe el autor borrar");                      
             String no=Comprobaciones.strin();
        System.out.println("Escribe el telefono borrar");                      
             String telefono=Comprobaciones.strin();
            Telefonos au=(Telefonos)Comprobaciones.telefono_existe(ltelegfonos,telefono);
            Autores a=(Autores)Comprobaciones.autor_existe(lautores,no);
            a.setTelefono(ltelegfonos.get(0));
         Session sesion;
       try {

          sesion = NewHibernateUtil.getSession();
            sesion.beginTransaction();
            sesion.update(a); 
            sesion.getTransaction().commit();
            sesion.close();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
        
    }
}
