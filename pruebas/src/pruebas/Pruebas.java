/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import java.awt.AWTException;
import java.awt.Event;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author a16pablovc
 */
public class Pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws AWTException, InterruptedException {
        
        
        
        try{
        String a="12345678S";
        if(a.substring(0, 8).matches("[0-9]*" )&& a.substring(8).matches("[A-Za-z]")&&a.length()==9){System.out.println("bien");}else {System.out.println("Formato incorrecto ");if(a.substring(8).matches("[A-Za-z]")){System.out.println("dsad");}}
        
        
        }catch(StringIndexOutOfBoundsException e){System.out.println("Longitud incorrecta   ");}
        
        
        
        
        
        
        
        
        
        
        
        
        
//        Random r=new Random();
//        
//        String a="";
//        a=a.valueOf(r.nextInt(43));
//        System.out.println(a);
        
        
        
//         Robot robot = new Robot();
//          
//        Scanner s=new Scanner(System.in);
////        String [] texm={"A","B","","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z","  "};
//        String [] tex={"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"," ","'"};
//                 int n[]={65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,32,222};
//         
//        do{ 
//        String t=s.nextLine();
//        Thread.sleep(500);
//robot.keyPress(44);
//robot.keyPress(46);
////        for (int i=65 ;i<91;i++){
////
////    System.out.print(i+",");
////}
//
////   for(int i=120;i<130;i++){
////       try {
////   robot.keyPress(30); 
////   System.out.println(35);
////       }catch(java.lang.IllegalArgumentException e){}            
////   }   
//   
//
//                       System.out.println("");
//            System.out.println("            acabose");
//    }while(1==2);
        }
}
