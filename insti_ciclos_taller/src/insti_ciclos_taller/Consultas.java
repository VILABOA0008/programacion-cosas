/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insti_ciclos_taller;


import Pojos.*;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author a16pablovc
 */
public class Consultas {
    
       public static void consultas(SessionFactory sf,  Session s){
            int op=0;
    do{
        System.out.println("6 Ciclos  7 institutos  8 talleres  \n1 Autor de un libro  \n2 Todos los libros de un autor \n3 Todos los libros \n4 Todos los autores de con sus libros \n5 Salir");
        op=Comprobaciones.opcion(10);
        switch(op){
            case 1:autorlibro();break;
            case 2:LibrosDeAutor();break;
            case 3:Libros(llibros);break;
            case 4:toddosAutoresLibros();break;
            case 6:ciclos(sf,s);break;
            case 7:institutos(sf);break;
             case 8:talleres(sf);break;
            case 9:usos();break;
        
        }        
    }while(op!=5);}
        
         
         
         
         public static void ciclos(SessionFactory sf,  Session s){      
                
           
                 List <Ciclos> ciclo =null;             
            ciclo=s.createCriteria(Ciclos.class).list();
           
             for(Ciclos i:ciclo){
                 System.out.println(i.getCodciclo()+"  cod  nombre   "+i.getNombre());
             }
                 s.close();}
         
              public static void institutos(SessionFactory sf){      
                
                 Session s=   sf.openSession();
                 List <Institutos> instituto =null;             
            instituto=s.createCriteria(Institutos.class).list();
           
    /*         for(Ciclos i:ciclo){
                 System.out.println(i.getCodciclo()+"  cod  nombre   "+i.getNombre());
             }*/
                 s.close();}
        
              
         public static void talleres(SessionFactory sf){      
                
                 Session s=   sf.openSession();
                 List <Talleres> taller =null;             
            taller=s.createCriteria(Talleres.class).list();
           
         /*    for(Talleres i:taller){
                 System.out.println(i.getCodciclo()+"  cod  nombre   "+i.getNombre());
             }*/
                 s.close();}
        
        
         public static void usos(){
           List <Usos> uso =null;
             try{
               Session sesion;
            sesion = NewHibernateUtil.getSession();               
      uso=Comprobaciones.criteria(sesion, 'u');            
                 
             for(Usos i:uso){
                 System.out.println(i.getFecha()+"  cod  nombre   "+i.getHora());
             }
               sesion.close();
          } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
       }
 
       
    }
    

