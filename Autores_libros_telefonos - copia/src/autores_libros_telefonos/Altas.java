/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autores_libros_telefonos;

import java.util.List;
import java.util.Random;
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

    public static void altas(List <Autores> lautores ,List <Libros> llibros,List <Telefonos> ltelegfonos){
    int op=0;
    do{
        System.out.println("1 Autores \n2 Libros \n3 Telefonos\n4 Salir");
        op=Comprobaciones.opcion(4);
        switch(op){
            case 1:autores(lautores);break;
            case 2:libros(lautores);break;
            case 3:telefonos(lautores);break;
        
        }
        
    }while(op<4);
    }
        public static void autores(List <Autores> lautores ){
            String DNI,nombre,nacionalidad;
            System.out.println("Escribe el Dni");
            DNI=Comprobaciones.dni();
            System.out.println("Escribe el nombre");
            nombre=Comprobaciones.strin();
            System.out.println("Escribe la nacionalidad");
            nacionalidad=Comprobaciones.strin();
            Autores o=new Autores(DNI, nombre, nacionalidad);
            lautores.add(o);
            alta(o);
        }
        
         public static void libros(List <Autores> lautores ){
              String ID,titulo;
             float precio;
               Random r=new Random();
String a=String.valueOf(40+r.nextInt(54));
          

            ID=a;
             System.out.println("Escribe el titulo");
            titulo=Comprobaciones.strin();
            System.out.println("Escribe el precio");
            precio=Comprobaciones.floaat();
             System.out.println("Escribe el Dni del autor");                      
             String DNI=Comprobaciones.strin();
            Autores au=(Autores)Comprobaciones.autor_existe(lautores,DNI);
       
                       
            Libros o=new Libros(ID, titulo, precio, au);
            alta(o);
            
        }
         
          public static void telefonos(List <Autores> lautores ){
   String numero;
          
             System.out.println("Escribe el numero de telefono");
               numero =Comprobaciones.strin();
             System.out.println("Escribe el Dni del autor");                      
             String DNI=Comprobaciones.strin();
            Autores au=(Autores)Comprobaciones.autor_existe(lautores,DNI);
         
                 
           Telefonos o =new Telefonos(numero, au);
           
              alta(o);         
                 au.setTelefono(o);
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
           
          //    au.setTelefono(o);
    //     alta(au);
         
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
