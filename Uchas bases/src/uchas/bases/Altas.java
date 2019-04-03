/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uchas.bases;


import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author a16pablovc
 */
public class Altas {
 

    public static void altas(Statement sentencia) throws SQLException{
         sentencia.execute("USE Institituto");
    int op;
    do{
        System.out.println(" 1 Para insertar Profesor \n 2 Para insertar Alumno \n 3 Para insertar relacion  \n 4 Para insertar notas \n 5 Para Salir");
        op=Comprobaciones.opcion(5);
        
        switch(op){
            case 1:profesores(sentencia);break;
            case 2:alumnos(sentencia);break;
            case 3:relacion(sentencia);break;
            case 4:notas(sentencia);break;
        
        }
    
    }while(op!=5);
    
    
    }
        public static void profesores(Statement sentencia) throws SQLException{
            int op;
            do{
            
            System.out.println("Escribe El dni del profesor");
            String dni= Comprobaciones.strin();
                System.out.println("Escribe El nombre del profesor");
               String nombre= Comprobaciones.strin();
                System.out.println("Escribe la titulacion del profesor");
               String titulacion= Comprobaciones.strin();
               try{
           int fun=   sentencia.executeUpdate("INSERT INTO PROFESORES (DNI,NOMBRE,TITULACION) VALUES('"+dni+"','"+nombre+"','"+titulacion+"')");
   if(fun==1){System.out.println("Profesor insertado");}else{System.out.println("Error en la insercion");}
         }catch(SQLException e){System.out.println(e.getMessage());}
               
               
               System.out.println(" 1 Para volver a introducir un profesor \n 2 Para Salir");
                op=Comprobaciones.opcion(3);
               
            }while(op==1);
            }
        
          public static void alumnos(Statement sentencia) throws SQLException{
            int op;
            do{
            
            System.out.println("Escribe El codigo del alumno");
            String codigo= Comprobaciones.strin();
                System.out.println("Escribe El nombre del alumno");
               String nombre= Comprobaciones.strin();
             
               try{
           int fun=   sentencia.executeUpdate("INSERT INTO alumnos (CODIGO,NOMBRE) VALUES('"+codigo+"','"+nombre+"')");
   if(fun==1){System.out.println("Alumno insertado");}else{System.out.println("Error en la insercion");}
         }catch(SQLException e){System.out.println(e.getMessage());}
               
               
              System.out.println(" 1 Para volver a introducir un alumno \n 2 Para Salir");
              
                op=Comprobaciones.opcion(3);
               
            }while(op==1);
            }
          
             public static void notas(Statement sentencia) throws SQLException{
            int op;
            do{
            
            System.out.println("Escribe El id del alumno");
            Consultas.alumnos(sentencia);
            String id= Comprobaciones.strin();
       
                System.out.println("Escribe el id de la asignatura");
                Consultas.asignaturas(sentencia);
               String nombre= Comprobaciones.strin();
                      System.out.println("Escribe la nota");
               String nota= Comprobaciones.strin();
             
               try{
           int fun=   sentencia.executeUpdate("INSERT INTO NOTAS (alumno,asignatura,fecha,nota) VALUES('"+id+"','"+nombre+"',CURRENT_DATE(),'"+nota+"')");
   if(fun==1){System.out.println("nota insertada");}else{System.out.println("Error en la insercion");}
         }catch(SQLException e){System.out.println(e.getMessage());}
               
               
              System.out.println(" 1 Para volver a introducir una nota \n 2 Para Salir");
                op=Comprobaciones.opcion(3);
               
            }while(op==1);
            }
                          public static void relacion(Statement sentencia) throws SQLException{
            int op;
            do{
              System.out.println("Escribe El dni del profesor");
            Consultas.profesores(sentencia);
            String dni=Comprobaciones.strin();
            System.out.println("Escribe El id del alumno");
            Consultas.alumnos(sentencia);
            String id= Comprobaciones.strin();
                       System.out.println("Escribe el id de la asignatura");
                Consultas.asignaturas(sentencia);
               String nombre= Comprobaciones.strin();
                     
             
               try{
           int fun=   sentencia.executeUpdate("INSERT INTO PAA (DNI_PROFESOR,id_alumno,id_asignatura) VALUES('"+dni+"','"+id+"','"+nombre+"')");
   if(fun==1){System.out.println("Relacion insertada");}else{System.out.println("Error en la insercion");}
         }catch(SQLException e){System.out.println(e.getMessage());}
               
               
              System.out.println(" 1 Para volver a introducir una relacion \n 2 Para Salir");
                op=Comprobaciones.opcion(3);
               
            }while(op==1);
            }
        
        
    
    
}
