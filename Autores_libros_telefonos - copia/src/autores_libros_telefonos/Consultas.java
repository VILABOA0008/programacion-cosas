/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autores_libros_telefonos;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import pojos.*;



/**
 *
 * @author mi
 */
public class Consultas {
    public static void consutas(List <Autores> lautores ,List <Libros> llibros,List <Telefonos> ltelegfonos){
        int op=0;
    do{
        System.out.println("1 Autor de un libro  \n2 Todos los libros de un autor \n3 Todos los libros \n4 Todos los autores de con sus libros \n5 Salit");
        op=Comprobaciones.opcion(8);
        switch(op){
            case 1:autorlibro(llibros);break;
            case 2:LibrosDeAutor(lautores, llibros);break;
            case 3:Libros(llibros);break;
            case 4:toddosAutoresLibros(lautores, llibros);break;
            case 7:autores(lautores);break;
            case 6:Telefonos(ltelegfonos);break;
        
        }        
    }while(op!=5);}
    
    
    
    
    
    
        public static void toddosAutoresLibros(List <Autores> lautores ,List <Libros> llibros){          
                       for(Autores au:lautores){
         //   Autores au=(Autores)Comprobaciones.autor_existe(lautores,DNI);
            System.out.println("Nombre Del Autor  "+au.getNombre());
            for(Libros auto:llibros){
            if(auto.getAutor().equals(au)){  System.out.println("ID  "+auto.getIdLibro()+"  TITULO  "+auto.getTitulo()+"  Precio  "+String.valueOf(auto.getPrecio())+"   AUTOR   "
                 +auto.getAutor().getDNI());}     }
            }}
           
       public static void LibrosDeAutor(List <Autores> lautores ,List <Libros> llibros){          
              Consultas.autores(lautores);
        System.out.println("Escribe el Dni del autor a ver sus libros");                      
             String DNI=Comprobaciones.strin();
            Autores au=(Autores)Comprobaciones.autor_existe(lautores,DNI);
            System.out.println("Nombre Del Autor  "+au.getNombre());
            for(Libros auto:llibros){
            if(auto.getAutor().equals(au)){  System.out.println("ID  "+auto.getIdLibro()+"  TITULO  "+auto.getTitulo()+"  Precio  "+String.valueOf(auto.getPrecio())+"   AUTOR   "
                 +auto.getAutor().getDNI());}     }
            }
    
    
    
    
    
          public static void autorlibro(List <Libros> llibros){          
                    Consultas.Libros(llibros);
        System.out.println("Escribe el id del libro a consultar");                      
             String id=Comprobaciones.strin();
            Libros au=(Libros)Comprobaciones.libro_existe(llibros,id);
        Autores autor=au.getAutor();
        
              System.out.println("IdLibro  "+au.getIdLibro()+"  Titulo  "+au.getTitulo()+"  Precio  "+au.getPrecio()+"  Nombre autor  "+autor.getNombre()
              +"  nacionalidad  "+autor.getNacionalidad());
     
    }
          
          
          
    
    public static void autores(List <Autores> lautores ){    
     for (Autores auto : lautores) {
         System.out.println("DNI  "+auto.getDNI()+"  NOMBRE  "+auto.getNombre()+"   nacionalidad   "+auto.getNacionalidad());}    
     
    }
 
    
      public static void Libros(List <Libros> llibros){          
       for (Libros auto : llibros) {
         System.out.println("ID  "+auto.getIdLibro()+"  TITULO  "+auto.getTitulo()+"  Precio  "+String.valueOf(auto.getPrecio())+"   AUTOR   "
                 +auto.getAutor().getDNI());}     
     
    }
   
      public static void Telefonos(List <Telefonos> ltelegfonos){ 
     for (Telefonos auto : ltelegfonos) {
         System.out.println("Autor  "+auto.getAutor().getDNI()+"  Numero  "+auto.getNumero());}
     
     
    }
  
    
}
