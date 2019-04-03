/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autores_libros_telefonos;

import java.sql.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import pojos.*;

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
    
    
    public static Object autor_existe(String dni){
    Autores o=null;
   
    List <Autores>   lautores=   Comprobaciones.cargar('a');
    
    boolean encontrado=false;
        for(Autores i:lautores){
        if(i.getDNI().equalsIgnoreCase(dni)){System.out.println("Autor Encontrado");o=i;encontrado=true;break;}
        }
        if(encontrado==false){System.out.println("No existe ese autor");}
    return o;
    }
    
       public static Object telefono_existe(String numero){
    Telefonos o=null;
    List <Telefonos> telefono=cargar('t');
    boolean encontrado=false;
        for(Telefonos i:telefono){
        if(i.getNumero().equalsIgnoreCase(numero)){encontrado=true;System.out.println("Telefono Encontrado");o=i;break;}
        }
        if(encontrado==false){System.out.println("No existe ese telefono");}
    return o;
    }
    
          public static Object libro_existe(int id){
    Libros o=null;  
    List <Libros> ll=Comprobaciones.cargar('l');
               
    boolean encontrado=false;
        for(Libros i:ll){
        if(i.getIdLibro()==id){System.out.println("Libro Encontrado");o=i;encontrado=true;break;}
        }
        if(encontrado==false){System.out.println("No existe ese libro");}
    return o;
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
       
    public static Float floaat(){
    float a=0;int d=0;
        Scanner s=new Scanner(System.in);   
        
        do{
            d=0;
        try {
         a=s.nextFloat();
        
        }catch(InputMismatchException e){d=1;System.out.println("Escribe un numero");s.nextLine();}
        }while (d==1);
        
        
        return a;
    }
    
    public static List cargar(char c){
        List a=null;
     try {
         Session sesion;
            sesion = NewHibernateUtil.getSession();
               
             switch(c){
            case 'a': a=sesion.createCriteria(Autores.class).list();break;
            case 'l' :a=sesion.createCriteria(Libros.class).list();break;
            case 't':a=sesion.createCriteria(Telefonos.class).list();break;
        
        
        }
             System.out.println("");
             System.out.println("");
             sesion.close();
          } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("");
     return a;
    }
}
