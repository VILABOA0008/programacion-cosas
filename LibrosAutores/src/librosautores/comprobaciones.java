/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librosautores;

import java.util.Scanner;

/**
 *
 * @author a16pablovc
 */
public class comprobaciones {
     
        
        public static int entero(){
            Scanner s =new Scanner (System.in);
           
        int a=s.nextInt();
        return a;
        }
        
        public static String strin(){
            Scanner s =new Scanner (System.in);
           
        String a=s.nextLine();
        return a;
        }
        
}
