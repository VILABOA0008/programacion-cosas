package metodos; 

import java.sql.Date;
import java.sql.Time;
import java.time.LocalTime;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Comprobaciones{   
    
    
    public static Date fecha(){
    
        Scanner s=new Scanner(System.in);   
       
     Date a=null;
    int d;
            do{ d=0;
            try {                
                a=Date.valueOf((s.nextLine()));           
            } catch (IllegalArgumentException e) {System.out.println("Formato incorrecto  yyyy-MM-dd");  d=1; }

             }while (d==1);
    return a;
    }
    
    
    
        public static Time hora(){                
        Scanner s=new Scanner(System.in);  
        
        Time a=null;int d;
    
            do{ 
                d=0;
            try {
                //a=Time.valueOf(LocalTime.now());
                a=Time.valueOf((s.nextLine()));                
                System.out.println(a);
            } catch (IllegalArgumentException e) {System.out.println("Formato incorrecto  hh:mm:ss"); d=1;}

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
         
           public static String cuenta(){
         String a;int d;
    do{d=0;
        Scanner s=new Scanner(System.in);   
       a=s.nextLine();
       
       
       
       try{
   
        if(a.substring(0, 4).matches("[0-9]*" )&& a.substring(4).matches("[A-Za-z]")&&a.length()==5){}else {System.out.println("Formato incorrecto ");d=1;}
        
        
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
    int a=0,d;
        Scanner s=new Scanner(System.in);   
        
        do{
            d=0;
        try {
         a=s.nextInt();
        
        }catch(InputMismatchException e){System.out.println("Escribe un numero");d=1;s.nextLine();}
        }while (d==1);
       
        
        return a;
  }
    public static float floa(){
    float a=0,d;
        Scanner s=new Scanner(System.in);   
        
        do{
            d=0;
        try {
         a=s.nextFloat();
        
        }catch(InputMismatchException e){System.out.println("Escribe un numero");d=1;s.nextLine();}
        }while (d==1);
       
        
        return a;
  }


}