/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej_3_institutos_ciclos_talleres_pojos_tablas18;

/**
 *
 * @author a16pablovc
 */
public class Ej_3_Institutos_ciclos_Talleres_Pojos_Tablas18 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
          CrearBase.crear();
         NewHibernateUtil.getSessionFactory();
     int op=0;
     do{
         System.out.println("2 Para dar altas \n3 Para borrar \n4 Para Modificar \n5 Para consultar \n6 Salir");
         op=Comprobaciones.opcion(7);
         
         switch(op){
           
                case 1:Altas.altas();break;
                   case 2:Bajas.bajas();break;
                      case 3:Modificaciones.modificaciones();break;
                        case 4:Consultas.consultas();break;
         
         }
              
   
     
     }while(op!=6);
        System.exit(1);
    
    }
    
}
