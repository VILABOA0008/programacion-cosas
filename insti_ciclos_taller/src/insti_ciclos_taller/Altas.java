/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insti_ciclos_taller;

import Pojos.*;
import java.util.List;
import java.util.Random;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author a16pablovc
 */
public class Altas {
    
    public static void altas(SessionFactory sf,  Session s){
    
        int op;
        do{
            System.out.println("1 para insertar ciclos \n2 Para inserta talleres \n5 Salir");
        op=Comprobaciones.opcion(6);
        
        switch(op){
        
            case 1:ciclos(sf,s);break;
             case 2:talleres(sf);break;
              case 3:institutos(sf);break;
              case 4:casa(s);break;
        
        
        }
        }while(op!=5);
    
    }
     public static void casa(Session s){
          List <Ciclos>  ciclo=s.createCriteria(Ciclos.class).list();
            System.out.println("s");
     
     }
    
           public static void institutos(SessionFactory sf){
    Random r=new Random();
        int cod=r.nextInt(43);
        String nombre ="instituto";
        nombre+=String.valueOf(cod);
    Institutos i=new Institutos(cod, nombre);
        guardar(sf,i);
    
    }
    
       public static void talleres(SessionFactory sf){
    Random r=new Random();
        int cod=r.nextInt(43);
        String nombre ="taller";
        nombre+=String.valueOf(cod);
    Talleres t=new Talleres(cod, nombre);
        guardar(sf,t);
    
    }
    
    public static void ciclos(SessionFactory sf,  Session s){
    Random r=new Random();
        int cod=r.nextInt(43);
        String nombre ="ciclo";
        nombre+=String.valueOf(cod);
    Ciclos c=new Ciclos(cod, nombre);
        guardar(sf,c,s);
    
    }
    
        public static void guardar(SessionFactory sf,Object o,  Session s){
       
    try{
        
      
    s.beginTransaction();
    s.save(o);
    s.getTransaction().commit();
              
            List <Ciclos>  ciclo=s.createCriteria(Ciclos.class).list();
            System.out.println("s");
           s.close();
    
    }catch (HibernateException e) {
            System.out.println(e.getMessage());
    
    
    
    }
    
}}
