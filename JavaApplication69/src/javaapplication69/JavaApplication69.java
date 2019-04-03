/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication69;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.Scanner;

/**
 *
 * @author a16pablovc
 */
public class JavaApplication69 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws AWTException, InterruptedException {
           Robot robot = new Robot();
       
        Scanner s=new Scanner(System.in);
//        String [] texm={"A","B","","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z","  "};
        String [] tex={"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"," ","'",",",".","-"};
                 int n[]={65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,32,222,44,46,10};
          String v="";
       int j;
        do{   
        String t=s.nextLine(); 
        Thread.sleep(500);
        for(int i=0;i<t.length();i++){
          for( j=0;j<tex.length;j++){
   
      if(tex[j].equalsIgnoreCase(String.valueOf(t.charAt(i)))){ v =String.valueOf(t.charAt(i));break;}
          }
           Thread.sleep(10);
//           if(v.equals(tex[j])){System.out.print(n[j]);}else System.out.print("z");
 if(v.equals(tex[j])){robot.keyPress(n[j]);}else{  robot.keyPress(16);       robot.keyPress(n[j]);    robot.keyRelease(16);}
//            robot.keyPress(n[j]);
//            System.out.print(n[j]);
        } 
//
//        for (int i=65 ;i<91;i++){
//
//    System.out.print(i+",");
//}
//Thread.sleep(500);
//   for(int i=120;i<130;i++){
//       try {
//   robot.keyPress(30); 
//   System.out.println(35);
//       }catch(java.lang.IllegalArgumentException e){}            
//   }   
   

                       System.out.println("");
            System.out.println("            acabose");
    }while(1==1);
        }
}
