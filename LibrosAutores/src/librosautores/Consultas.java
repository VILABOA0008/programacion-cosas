/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librosautores;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static librosautores.Bajas.autores;
import static librosautores.Bajas.libros;

/**
 *
 * @author mi
 */
public class Consultas {
    
     public static void consultas(  Statement sentencia) throws SQLException{
     
        try{
        sentencia.execute("USE milibreria;");
             }catch(SQLException e){System.out.println(e.getMessage());}
        int op;
    do{
        System.out.println(" 1 Para los datos del autor de un libro \n 2 Para ver los libros de un autor \n 3 Para Visulaizar todos los libros \n 4 Ver todos los autores con sus libros \n 5 Salir");

    op=comprobaciones.entero();
    switch(op){
        case 1:autor(sentencia);break;
        case 2:librosautor(sentencia);break;
        case 3:libros(sentencia);break;
        case 4:todo(sentencia);break;
        case 6:librosautores(sentencia);break;
    
    }
    
    }while (op!=5);
     
     
     }
    
        public static void autor(  Statement sentencia) throws SQLException{
            
            System.out.println("Escriba el titulo del libro");
            String titulo=comprobaciones.strin();
            
            try{
       ResultSet consulta=sentencia.executeQuery("SELECT * FROM autores where idAutor=(Select AUTOR FROM LIBROSAUTORES WHERE LIBRO=(SELECT IDLIBRO FROM LIBROS WHERE TITULO ='"+titulo+"'));");
              System.out.println("CODIGO                         NOMBRE         NACIONALIDAD");
       while(consulta.next()){
         
          System.out.printf("%s   %8s  %10s  %n",consulta.getString(1),consulta.getString(2),consulta.getString(3));}
       
         }catch(SQLException e){System.out.println(e.getMessage());}
    }
    
    public static int autores(  Statement sentencia) throws SQLException{
      int  error=0;
        try{
      
         
            ResultSet consulta=sentencia.executeQuery("SELECT * FROM autores");
           
            
              if(!consulta.next()){error=1;}else{consulta.previous();  System.out.println("ID          NOMBRE         NACIONALIDAD");
       while(consulta.next()){
         
          System.out.printf("%s   %8s  %10s  %n",consulta.getString(1),consulta.getString(2),consulta.getString(3));}
              }
               }catch(SQLException e){System.out.println(e.getMessage());}
        return error; }
     
     
    public static void libros(  Statement sentencia) throws SQLException{
            try{
       ResultSet consulta=sentencia.executeQuery("SELECT * FROM LIBROS");
              System.out.println("CODIGO        TITULO         PRECIO");
       while(consulta.next()){
         
          System.out.printf("%s   %8s  %10s  %n",consulta.getString(1),consulta.getString(2),consulta.getString(3));}
       
         }catch(SQLException e){System.out.println(e.getMessage());}
    }
    
        public static void librosautor(  Statement sentencia) throws SQLException{
                 System.out.println("Escriba el nombre del autor");
            String nombre=comprobaciones.strin();
            
            try{
       ResultSet consulta=sentencia.executeQuery("SELECT titulo FROM libros where idLibro in(Select libro FROM LIBROSAUTORES WHERE autor =(SELECT idautor FROM autores WHERE titulo ='"+nombre+"'));");

       while(consulta.next()){
         
          System.out.println(consulta.getString(1)+"  ");}
   
       
         }catch(SQLException e){System.out.println(e.getMessage());}    System.out.println("");
    }
    
           public static void todo(  Statement sentencia) throws SQLException{
        try{
      
         
            ResultSet consulta=sentencia.executeQuery("select a.titulo,l.titulo from autores as a,libros as l,librosautores as al where\n" +
"l.idlibro=al.libro and a.idautor=al.autor;");
              System.out.println("AUTOR        TITULO     ");
       while(consulta.next()){
         
          System.out.printf("%s   %14s  %n",consulta.getString(1),consulta.getString(2));}
      }catch(SQLException e){System.out.println(e.getMessage());}
}
     
      public static void librosautores(  Statement sentencia) throws SQLException{
            try{
       ResultSet consulta=sentencia.executeQuery("SELECT * FROM LIBROsAUTORES");
              System.out.println("IDAUTOR        IDLIBRO    ");
       while(consulta.next()){
         
          System.out.printf("%s   %8s    %n",consulta.getString(1),consulta.getString(2));}
       
         }catch(SQLException e){System.out.println(e.getMessage());}
    }
}