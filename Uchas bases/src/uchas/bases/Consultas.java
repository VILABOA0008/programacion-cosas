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
public class Consultas {
    
    public static void consultas(Statement sentencia){
    try{
         sentencia.execute("USE Institituto");
 }catch(SQLException e){System.out.println(e.getMessage());}
    int op;
    do{
        System.out.println(" 1 Listado de un profesor con las asignaturas que imparte. \n 2 listado de un alumno con las notas que tiene en cada asignatura. "
                + "\n 3 Listado de una asignatura con los profesores que la imparten. \n 4 Para Salir");
        op=Comprobaciones.opcion(8);
   
        switch(op){
            case 1:profesor_asignaturas(sentencia);break;
            case 2:notasdealumno(sentencia);break;
             case 3:profesoresporasignatura(sentencia);break;
            case 5:profesores(sentencia);break;
            case 6:alumnos(sentencia);break;
             case 7:asignaturas(sentencia);break;
             case 8:notas(sentencia);break;
        
        }
    
    }while(op!=4);
    
    }
    
      public static void profesor_asignaturas(Statement sentencia){
        
           try{
               System.out.println("Escrib el nombre del profesor");
               Consultas.profesores(sentencia);
               String nombre=Comprobaciones.strin();
               ResultSet r= sentencia.executeQuery("select nombre from asignaturas where id in\n" +
"(select id_asignatura from paa where dni_profesor =\n" +
"(select dni from profesores where nombre='"+nombre+"'));");
               System.out.println(nombre+" Imparte las siguientes asignaturas \n");
               while(r.next()){
                 System.out.printf("%s \n",r.getString(1));
               
               }
               System.out.println("\n \n");
 }catch(SQLException e){System.out.println(e.getMessage());}
   
    }
        public static void notasdealumno(Statement sentencia){
        
           try{
               System.out.println("Escrib el id del alumno");
               Consultas.alumnos(sentencia);
               String id=Comprobaciones.strin();
               ResultSet r= sentencia.executeQuery("select n.nota,a.nombre,n.fecha from notas as n , asignaturas as a where n.alumno='"+id+"' and a.id=n.asignatura");
               System.out.println("NOTA    ASIGNATURA             FECHA \n");
               while(r.next()){
                             System.out.printf("%s %12s %25s %n",r.getString(1),r.getString(2),r.getString(3));
               
               }
               System.out.println("\n \n");
 }catch(SQLException e){System.out.println(e.getMessage());}
   
    }
        
      

    
    
           public static void profesoresporasignatura(Statement sentencia){
        
           try{
               System.out.println("Escrib el id de la asignatura");
               Consultas.asignaturas(sentencia);
               String id=Comprobaciones.strin();
               ResultSet r= sentencia.executeQuery( "select nombre from profesores where dni in(select dni_profesor from paa where id_asignatura='"+id+"')");
               System.out.println("Profesores que imparten dicha asignatura \n");
               while(r.next()){
                             System.out.printf("%s %n",r.getString(1));
               
               }
               System.out.println("\n \n");
 }catch(SQLException e){System.out.println(e.getMessage());}
   
    }
        
    
    
    
    
    
    
    
    
    
    
    
    public static void profesores(Statement sentencia){
        
           try{
               
               ResultSet r= sentencia.executeQuery("SELECT * FROM PROFESORES");
               System.out.println("DNI         NOMBRE        TITULACION");
               while(r.next()){
                 System.out.printf("%s %12s %15s %n",r.getString(1),r.getString(2),r.getString(3));
               
               }
 }catch(SQLException e){System.out.println(e.getMessage());}
   
    }
    public static void alumnos(Statement sentencia){
        
           try{
 
               ResultSet r= sentencia.executeQuery("SELECT * FROM alumnos");
               System.out.println("ID         CODIGO        NOMBRE");
               while(r.next()){
                 System.out.printf("%s %12s %15s %n",r.getString(1),r.getString(2),r.getString(3));
               
               }
 }catch(SQLException e){System.out.println(e.getMessage());}
   
    }
      public static void asignaturas(Statement sentencia){
        
           try{
 
               ResultSet r= sentencia.executeQuery("SELECT * FROM asignaturas");
               System.out.println("ID         CODIGO        NOMBRE                                     CICLO");
               while(r.next()){
                 System.out.printf("%s %12s %15s %42s %n",r.getString(1),r.getString(2),r.getString(3),r.getString(4));
               
               }
 }catch(SQLException e){System.out.println(e.getMessage());}
   
    }
    
       public static void notas(Statement sentencia){
        
           try{
 
               ResultSet r= sentencia.executeQuery("SELECT * FROM notas");
               System.out.println("ALUMNO    ASIGNATURA      FECHA        NOTA");
               while(r.next()){
                 System.out.printf("%s %12s %15s %7s %n",r.getString(1),r.getString(2),r.getString(3),r.getString(4));
               
               }
 }catch(SQLException e){System.out.println(e.getMessage());}
   
    }
    
}
