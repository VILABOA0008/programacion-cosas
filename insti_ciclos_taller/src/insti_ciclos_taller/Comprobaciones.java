/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insti_ciclos_taller;

import Pojos.*;
import java.sql.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author a16pablovc
 */
public class Comprobaciones {
 
        public static Date fecha(){
    
        Scanner s=new Scanner(System.in);   
       
     Date a=null;
    int d;
            do{ d=0;
            try {
                
                a=Date.valueOf((s.nextLine()));
           
            } catch (IllegalArgumentException e) {System.out.println("Formato incorrecto  yyyy-MM-dd");      d=1;               }

             }while (d==1);
    return a;
    }
        
        
         public static String dni(){
         String a;int d;
    do{d=0;
        Scanner s=new Scanner(System.in);   
       a=s.nextLine();
       
       
       
       try{
   
        if(a.substring(0, 8).matches("[0-9]*" )&& a.substring(8).matches("[A-Za-z]")&&a.length()==9){}else {System.out.println("Formato incorrecto ");d=1;}
        
        
        }catch(StringIndexOutOfBoundsException e){System.out.println("Longitud incorrecta   ");d=1;}
        
    }while(d==1);
    return a;
    }
        
    
    public static String strin(){
         String a;int d;
    do{d=0;
        Scanner s=new Scanner(System.in);   
       a=s.nextLine();
       if(a.isEmpty()){d=1;System.out.println("Escribe algo");}
    }while(d==1);
    return a;
    }
    
       public static int opcion(int op){
    int a=0,d;
        Scanner s=new Scanner(System.in);   
        
        do{
            d=0;
        try {
         a=s.nextInt();
         if(a<0||a>op){d=1;System.out.println("Introduzca una opcion valida");}
        }catch(InputMismatchException e){d=1;s.nextLine();System.out.println("Valor erroneo Escriba la opcion de nuevo");}
        }while (d==1);
        
        
        return a;
    }
         public static int entero(){
    int a=0,d=0;
        Scanner s=new Scanner(System.in);   
        
        do{
            d=0;
        try {
         a=s.nextInt();
        
        }catch(InputMismatchException e){d=1;}
        }while (d==1);
        
        
        return a;
    }
       
         public static List criteria(Session sesion,char c){
         List o=null;
      
            
           
               
switch(c){
        
    case 'c':o=sesion.createCriteria(Ciclos.class).list();break;
    case 'i':o=sesion.createCriteria(Institutos.class).list();break;
    case 't':o=sesion.createCriteria(Talleres.class).list();break;
    case 'u':o=sesion.createCriteria(Usos.class).list();break;
      
}
           
         
         return o;
         }
    
}
