/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Scanner;

/**
 *
 * @author a16pablovc
 */
public class Pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        hora();
    }

  public static Time hora(){
    
        Scanner s=new Scanner(System.in);   
       
     Time a=null;
    int d;
            do{ d=0;
            try {
                 a=Time.valueOf((s.nextLine()));
                
                
            } catch (IllegalArgumentException e) {System.out.println(e);System.out.println("Formato incorrecto  hh:mm:ss");d=1;}

             }while (d==1);
    return a;
    }
    
}


/*



        Random r = new Random();
        dni = "3243245" + r.nextInt(445);
        System.out.println("Escriba el nombre del cliente");
        nombre = Comprobaciones.strin();
        direccion = "Lejos" + r.nextInt(445);


        Random r = new Random();
        numero = "3243245" + r.nextInt(445);
        sucursal = "sucursalcorriente" + r.nextInt(445);
        saldo = 1000 + r.nextFloat() * 100;


        Random r = new Random();
        numero = "3243245" + r.nextInt(445);
        sucursal = "sucursalplazo" + r.nextInt(445);
        saldo = 1000 + r.nextFloat() * 100;
        intereses = r.nextFloat();
        Date fecha = Date.valueOf((1000 + r.nextInt(1000) + "-1-1"));



        Random r = new Random();
        numero = "3243245" + r.nextInt(445);
        saldo = 1000 + r.nextFloat() * 100;
        cantidad = 1000 + r.nextFloat() * 100;
        Date fecha = Date.valueOf((1000 + r.nextInt(1000) + "-1-1"));
        Time hora = Time.valueOf((1 + r.nextInt(22) + ":" + 1 + r.nextInt(22) + ":11"));
        System.out.println(hora);

*/