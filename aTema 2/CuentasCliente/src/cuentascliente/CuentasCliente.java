/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cuentascliente;

import metodos.Bajas;
import metodos.Modificaciones;
import metodos.Consultas;
import metodos.Altas;
import metodos.*;

/**
 *
 * @author a16pablovc
 */
public class CuentasCliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int op;
   
        do{
        
            System.out.println(" 1 Altas \n 2 Dar de baja una cuenta plazo \n 3 Modificar intereses \n 4 Consultas  \n 5 Salir");
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
