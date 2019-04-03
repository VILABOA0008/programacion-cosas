/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autores_libros_telefonos;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import pojos.*;



/**
 *
 * @author mi
 */
public class Consultas {
    public static void consutas(){
        int op=0;
  
    do{
        System.out.println("1 Autor de un libro  \n2 Todos los libros de un autor \n3 Todos los libros \n4 Todos los autores con sus libros \n5 Salir");
        op=Comprobaciones.opcion(9);
        switch(op){
            case 1:autorlibro();break;
            case 2:LibrosDeAutor();break;
            case 3:Libros();break;
            case 4:toddosAutoresLibros();break;
            case 6:Telefonos();break;
            case 7:autores();break;
            case 8:pruebas();break;
        
        }        
    }while(op!=5);}
    
    
       public static void pruebas(){   
       
         
       List <Autores> a=null;

         Session sesion;
            sesion = NewHibernateUtil.getSession();
               

        a=sesion.createCriteria(Autores.class).list();
         System.out.println("");
     
     
       }
        
            public static void autorlibro(){    
                
                Libros();
                System.out.println("Escribe el id del libro");
                int id=Comprobaciones.entero();
                Libros l=(Libros)Comprobaciones.libro_existe(id);
                Autores au=(Autores)Comprobaciones.autor_existe(l.getAutor().getDNI());
                  mostrar('a');
                  mostrar('-');
                      try{         
  System.out.printf("%s %9s %12s %14s \n",au.getDNI(),   au.getNombre(),  au.getNacionalidad(),au.getTelefono().getNumero());
     }catch(NullPointerException e){  System.out.printf("%s %9s %12s \n",au.getDNI(),au.getNombre(),au.getNacionalidad());}  
                      mostrar('-');
        
    }
    
        public static void toddosAutoresLibros(){   
        
  
     List <Autores> aut=null;
 
         Session sesion;
 
         try{
         sesion = NewHibernateUtil.getSession();
 
       aut=sesion.createCriteria(Autores.class).list();
         
        
                       for(Autores au:aut){
                           mostrar('-');
                           mostrar('a');
                           
  try{         
  System.out.printf("%s %9s %12s %14s \n",au.getDNI(),au.getNombre(),au.getNacionalidad(),au.getTelefono().getNumero());
     }catch(NullPointerException e){  System.out.printf("%s %9s %12s \n",au.getDNI(),au.getNombre(),au.getNacionalidad());}  
        
       
        Set <Libros> ll=  au.getLibros();
               for(Libros auto:ll){
                mostrar('l');
          System.out.printf("%s %12s %9s %10s \n",auto.getIdLibro(),auto.getTitulo(),auto.getPrecio(),auto.getAutor().getDNI());   
            }mostrar('-');}
       sesion.close();
           } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
         }
           
       public static void LibrosDeAutor(){   
          
                     List <Libros> ll=Comprobaciones.cargar('l');
               
              Consultas.autores();
        System.out.println("Escribe el Dni del autor a ver sus libros");                      
             String DNI=Comprobaciones.strin();
            Autores au=(Autores)Comprobaciones.autor_existe(DNI);
            System.out.println("Nombre Del Autor  "+au.getNombre());
            mostrar('-');
            mostrar('l');
            for(Libros auto:ll){
            if(auto.getAutor().getDNI().equalsIgnoreCase(au.getDNI())){  System.out.printf("%s %12s %9s %10s \n",auto.getIdLibro(),auto.getTitulo(),auto.getPrecio(),auto.getAutor().getDNI()); }
               } mostrar('-');
               
               
               
            }
    
    
    public static void autores(){    
        
        List <Autores>  au=Comprobaciones.cargar('a');
        mostrar('-');
           mostrar('a');
     for (Autores auto : au) {
         try{         
  System.out.printf("%s %9s %12s %14s \n",auto.getDNI(),auto.getNombre(),auto.getNacionalidad(),auto.getTelefono().getNumero());
     }catch(NullPointerException e){  System.out.printf("%s %9s %12s \n",auto.getDNI(),auto.getNombre(),auto.getNacionalidad());}  
     }    mostrar('-'); 
    }
    
      public static void Libros(){      

                     List <Libros> ll=Comprobaciones.cargar('l');
           
          mostrar('-');
          mostrar('l');
       for (Libros auto : ll) {
           System.out.printf("%s %12s %9s %10s \n",auto.getIdLibro(),auto.getTitulo(),auto.getPrecio(),auto.getAutor().getDNI());
 
       }   mostrar('-');
    }
   
      public static void Telefonos(){ 
        
                     List <Telefonos>   te=Comprobaciones.cargar('t');
          mostrar('-');
          mostrar('t');
     for (Telefonos auto : te) {
           System.out.printf("%s %15s \n",auto.getAutors(),auto.getNumero());

     }   mostrar('-');
     
    }
  
    public static void mostrar(char c){
    switch(c){
        case 'a':    System.out.println("DNI     NOMBRE     nacionalidad     telefono  ");break;
         case 'l':    System.out.println("ID      TITULO      Precio     AUTOR  ");break;
          case 't':    System.out.println("Dni Autor     Numero");break;
           case '-':    System.out.println("-----------------------------------------");break;
           case '1':     System.out.println("ID      TITULO      Precio     AUTOR      Nacionalidad");break;
                  
    
    
    }
    }
}
