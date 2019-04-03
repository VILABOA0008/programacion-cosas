/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neodatis_libros_autores;

import metodos.*;
import metodos.Comprobaciones;

/**
 *
 * @author a16pablovc
 */
public class Neodatis_libros_autores {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int op;
        
        do{
        
            System.out.println(" 1 Altas \n 2 Dar de baja libro \n 3 Modificaciones \n 4 Consultas  \n 5 Salir");
             op=Comprobaciones.opcion(5);
        
             switch(op){
             
                 case 1:Altas.altas();break;
                 case 2:Bajas.bajas();    break;
                 case 3:Modificaciones.modificaciones();    break;
                 case 4:Consultas.consultas();    break;
             
             }
        
            
            
        }while(op!=5);
        
    }
    
}
