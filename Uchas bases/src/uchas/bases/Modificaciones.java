/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uchas.bases;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author a16pablovc
 */
public class Modificaciones {
    
    
     
    
    public static void modificaciones(Statement sentencia){
    int op;
    
      try{
        sentencia.execute("USE INSTITITUTO");
        }catch(SQLException e){System.out.println(e.getMessage());}
    do{
        System.out.println("Escribe el id del alumno");
        Consultas.alumnos(sentencia);
        String id=Comprobaciones.strin();
    
        try{
                
            ResultSet r=sentencia.executeQuery("select * from notas where alumno='"+id+"'");
       
             System.out.println("ASIGNATURA      FECHA       NOTA");
               while(r.next()){
                             System.out.printf("%s %20s %5s %n",r.getString(2),r.getString(3),r.getString(4));
               
               }
    
            
        }catch(SQLException e){System.out.println(e.getMessage());}
        System.out.println("Elige la asignatura a modificar su nota");
        String asi=Comprobaciones.strin();
        String nota="";
          try{
                
            ResultSet r=sentencia.executeQuery("select * from notas where alumno='"+id+"' and asignatura='"+asi+"'");
       
           
               while(r.next()){
                           
                            
               
             
        System.out.println("Escriba la nueva nota");
        nota=Comprobaciones.strin();
         System.out.println("La nota actual es "+r.getString(4)+" quieres cambiarla a "+nota);
        
          }  }catch(SQLException e){System.out.println(e.getMessage());}
        
              System.out.println(" 1 Si  \n 2 No");
    op=Comprobaciones.opcion(2);


    if(op==1){
            try{
        sentencia.executeUpdate("update notas SET nota ='"+nota+"'  where alumno='"+id+"' and asignatura='"+asi+"'");
       }catch(SQLException e){System.out.println(e.getMessage());}
    }
 
    
    else{
        System.out.println("No se modificado nada");
    
    }
    
        System.out.println(" 1 Para volver a modificar \n 2 para salir");
    op=Comprobaciones.opcion(3);
    }while(op==1);
            
    }
    
}
