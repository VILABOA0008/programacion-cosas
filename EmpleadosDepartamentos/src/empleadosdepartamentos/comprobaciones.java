
package empleadosdepartamentos;

import java.sql.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class comprobaciones {
    
    
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
         if(a<0&&a>op){d=1;}
        }catch(InputMismatchException e){d=1;System.out.println("Valor erroneo");}
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
       
    
}
