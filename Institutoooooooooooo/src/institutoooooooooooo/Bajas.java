/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package institutoooooooooooo;

import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author a16pablovc
 */
public class Bajas {
    
    public static void bajas(Statement sentencia){
        try{
        sentencia.execute("USE INSTITITUTO");
        }catch(SQLException e){System.out.println(e.getMessage());}
    int op;
    
    do{
        System.out.println(" 1 Para borrar un profesor \n 2 Para borrar un alumno \n 3 para salir");
    op=Comprobaciones.opcion(4);
            
    
            switch(op){
                
                    case 1:profesores(sentencia);
                    case 2:alumnos(sentencia);
                        
            }
    
    }while(op!=3);
        }
    
    public static void profesores(Statement sentencia){
    int op;
    do{
        System.out.println("Escribe el dni del profesor");
        Consultas.profesores(sentencia);
        String dni=Comprobaciones.strin();
    
        try{
        int funciona=sentencia.executeUpdate("DELETE FROM PROFESORES WHERE(dni='"+dni+"')");
       if(funciona==1){System.out.println("Borrado completado");}else{System.out.println("Error en el borrado");}
        }catch(SQLException e){System.out.println(e.getMessage());}
    
    
        System.out.println(" 1 Para volver a borrar un profesor \n 2 para salir");
    op=Comprobaciones.opcion(3);
    }while(op==1);
            
    }
    
        public static void alumnos(Statement sentencia){
    int op;
    do{
        System.out.println("Escribe el id del alumno");
        Consultas.alumnos(sentencia);
        String id=Comprobaciones.strin();
    
        try{
        int funciona=sentencia.executeUpdate("DELETE FROM alumnos WHERE(id='"+id+"')");
       if(funciona==1){System.out.println("Borrado completado");}else{System.out.println("Error en el borrado");}
        }catch(SQLException e){System.out.println(e.getMessage());}
    
    
        System.out.println(" 1 Para volver a borrar un alumno \n 2 para salir");
    op=Comprobaciones.opcion(3);
    }while(op==1);
        
        }
    
}
