/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empleadocoche;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author a16pablovc
 */
public class Comprobaciones {
    
    public static String strin(){
    Scanner s=new Scanner(System.in);
    
    String a;
    int d=0;
    do{
    a=s.nextLine();
    if(a.length()==0){d=1;System.out.println("Escriba algo");d=1;}
            
    }while(d==1);
    return a;
    }
    
        public static int op(int b){
    Scanner s=new Scanner(System.in);
    
    int a=0;
    int d=0;
    do{
    try{
    a=s.nextInt();
    }catch(InputMismatchException e){d=1;s.nextLine();System.out.println("Escibe enteros");}
    if(a<0||a>b){d=1;System.out.println("Escriba una opcion valida");}        
    
    
    }while(d==1);
    return a;
    }
        
               public static int entero(){
    Scanner s=new Scanner(System.in);
    
    int a=0;
    int d=0;
    do{
    try{
    a=s.nextInt();
    }catch(InputMismatchException e){d=1;s.nextLine();System.out.println("Escibe enteros");}
    
    
    
    }while(d==1);
    return a;}
    
}
