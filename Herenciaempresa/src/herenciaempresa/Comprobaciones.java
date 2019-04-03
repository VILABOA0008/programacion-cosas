/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herenciaempresa;

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
         String a;int d;String e;
    do{d=0;
    e="";
        Scanner s=new Scanner(System.in);   
       a=s.nextLine();  
        if(a.length()!=9){d=1;e+="\nLongitud incorrecta";}else{
        if(!a.substring(0, 8).matches("[0-9]*" )){d=1;e+="\nLos 8 primeros cartcteres tienen que ser numeros";}
        if(!a.substring(8).matches("[A-Za-z]")){d=1;e+="\nEl ultimo caracter tiene que ser una letra";}}
 
        System.out.println(e);
        
    }while(d==1);
    return a;
    }
        
           public static char cha(){
         char a='0';int d;
    do{d=0;
        Scanner s=new Scanner(System.in);   
        try{
       a=s.nextLine().charAt(0);
        }catch(StringIndexOutOfBoundsException e){d=1;System.out.println("Escribe algo");}
       
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
         if(a<1||a>op){d=1;System.out.println("Introduzca una opcion valida de 1 a "+op);}
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
        }catch(InputMismatchException e){d=1;s.nextLine();System.out.println("Valor erroneo Escriba un numeroo");}
        }while (d==1);        
        
        return a;
    }
       
      public static float floa(){
          float a=0f; int d=0;
        Scanner s=new Scanner(System.in);           
        do{
            d=0;
        try {
         a=s.nextInt();        
        }catch(InputMismatchException e){d=1;s.nextLine();System.out.println("Valor erroneo Escriba un numero");}
        }while (d==1);        
        
        return a;}
      
      
      
      
      
    
                 public static char tipo(){
         char a='0';int d;
    do{d=0;
        Scanner s=new Scanner(System.in);   
     try{
       a=s.nextLine().charAt(0);
     
       if(a!='l'&&a!='L'&&a!='r'&&a!='R'){d=1;System.out.println("Escribe l para libre o r para reservado");}
     }catch(StringIndexOutOfBoundsException e){System.out.println("Escriba algo ");d=1;}  
    }while(d==1);
    return a;
    }
          public static String cod(char c){
         String a,b,b2;int d;
    do{d=0;
    b="";
    b2="";
        Scanner s=new Scanner(System.in);   
       a=s.nextLine();
       if(a.length()!=4){d=1;b="\n La longitud tiene que ser de 4 ";}else{
         if(!a.substring(0,3).matches("[0-9]*")){b+="\n Los tres primeros caracteres tienen que ser digitos"; d=1;}
           String sub=a.substring(3);

           if(!sub.matches("[vV]")&&!sub.matches("[aA]")){d=1; b+="\n el ultimo caracter tiene que ser V para venta o A para alquiler ";}else{
           if(c=='v'){ if(!sub.matches("[vV]")){d=1;b+="\n La letra del codigo no se corresponde al tipo de coche que quiere dar de alta";}
           }
           else{
            if(!sub.matches("[aA]")){d=1;b+="\n La letra del codigo no se corresponde al tipo de coche que quiere datr de alta";}}           
           
           } }

        System.out.println(b+b2);
    }while(d==1);
    return a;
    }
    
}
