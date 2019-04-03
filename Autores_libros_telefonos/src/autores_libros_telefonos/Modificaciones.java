/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autores_libros_telefonos;


import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import pojos.*;

/**
 *
 * @author mi
 */
public class Modificaciones {
    public static void modificaciones(){
  
            int op=0;
    do{
        System.out.println("1 Modificar el precio de un libro \n2 Modificar el telefono de un autor \n3 Salir");
        op=Comprobaciones.opcion(4);
        switch(op){
            case 1:libros();;break;
            case 2:telefono_autor();break;
    
        }
    }while(op!=3);        
    }
    
        public static void libros( ){
              Float precio;
      Consultas.Libros();
        System.out.println("Escribe el id del libro a modificar el precio");                      
             int id=Comprobaciones.entero();
              System.out.println("Escribe el nuevo precio");                      
           precio=Comprobaciones.floaat();
            Libros au=(Libros)Comprobaciones.libro_existe(id);
            au.setPrecio(precio);
         Session sesion;
       try {

          sesion = NewHibernateUtil.getSession();
            sesion.beginTransaction();
            sesion.saveOrUpdate(au); 
            sesion.getTransaction().commit();
            sesion.close();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
    }
    
    
    public static void telefono_autor( ) {
        List <Telefonos> te=Comprobaciones.cargar('t');
            Consultas.autores();
             System.out.println("Escribe el autor a cambiar el numero");                      
             String no=Comprobaciones.strin();
        System.out.println("Escribe el nuevo telefono");                      
             String telefono=Comprobaciones.strin();
            
            Autores a=(Autores)Comprobaciones.autor_existe(no);
            a.getTelefono().setNumero(telefono);
            
            
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
