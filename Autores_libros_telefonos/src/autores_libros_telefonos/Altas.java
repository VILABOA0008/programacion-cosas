/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autores_libros_telefonos;

import java.util.List;
import java.util.Random;
import java.util.Set;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import pojos.Autores;
import pojos.Libros;
import pojos.Telefonos;

/**
 *
 * @author mi
 */
public class Altas {

    public static void altas(){
    int op=0;
    do{
        System.out.println("1 Autores \n2 Libros \n3 Telefonos\n4 Salir");
        op=Comprobaciones.opcion(4);
        switch(op){
            case 1:autores();break;
            case 2:libros();break;
            case 3:telefonos( );break;
        
        }
        
    }while(op<4);
    }
        public static void autores( ){
            String DNI,nombre,nacionalidad;
            System.out.println("Escribe el Dni");
            DNI=Comprobaciones.strin();
            System.out.println("Escribe el nombre");
            nombre=Comprobaciones.strin();
            System.out.println("Escribe la nacionalidad");
            nacionalidad=Comprobaciones.strin();
            Autores o=new Autores(DNI, nombre, nacionalidad);
           
            alta(o);
            System.out.println("Autor guardado");
        }
        
         public static void libros( ){
              String ID,titulo;
             float precio;
               Random r=new Random();
       
             System.out.println("Escribe el titulo");
            titulo=Comprobaciones.strin();
            System.out.println("Escribe el precio");
            precio=Comprobaciones.floaat();
             System.out.println("Escribe el Dni del autor");                      
             String DNI=Comprobaciones.strin();
            Autores au=(Autores)Comprobaciones.autor_existe(DNI);
                   
            Libros o=new Libros( titulo, precio, au);
         
            alta(o);
            
        }
         
          public static void telefonos(){
   String numero;
          
             System.out.println("Escribe el numero de telefono");
               numero =Comprobaciones.strin();
             System.out.println("Escribe el Dni del autor");                      
             String DNI=Comprobaciones.strin();
            Autores au=(Autores)Comprobaciones.autor_existe(DNI);
         
                 
           Telefonos o =new Telefonos(numero, au);
     
              alta(o);         
                 
      
     
          }
          
                   public static void alta(Object o){
                
 Session sesion;
       try {

          sesion = NewHibernateUtil.getSession();
            sesion.beginTransaction();
            sesion.saveOrUpdate(o); 
            sesion.getTransaction().commit();
            sesion.close();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
            
        }
}
