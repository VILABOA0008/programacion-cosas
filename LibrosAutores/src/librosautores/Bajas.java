/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librosautores;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static librosautores.Altas.autores;
import static librosautores.Altas.libros;

/**
 *
 * @author mi
 */
public class Bajas {
  
    
    public static void Bajas(  Statement sentencia) throws SQLException{
        try{
        sentencia.execute("USE milibreria;");
             }catch(SQLException e){System.out.println(e.getMessage());}
        int op;
    do{
        System.out.println(" 1 Para borrar libro \n 2 Para borrar Autor \n 3 Para Salir");

    op=comprobaciones.entero();
    switch(op){
        case 1:libros(sentencia);break;
        case 2:autores(sentencia);break;
    
    }
    
    }while (op!=3);
}
public static void libros(  Statement sentencia) throws SQLException{
    
    Consultas.libros(sentencia);
    
    
   System.out.println("Escribe el id del libro");
          int cod=comprobaciones.entero();
     try{
         
        sentencia.executeUpdate("DELETE FROM libros where(idLibro="+cod+")");
             }catch(SQLException e){System.out.println(e.getMessage());}

}

public static void autores(  Statement sentencia) throws SQLException{
    
   if( Consultas.autores(sentencia)==1){System.out.println("La tabla autores esta vacia");}else{
    
    
   System.out.println("Escribe el id del autor");
          int cod=comprobaciones.entero();
     try{
         
        sentencia.executeUpdate("DELETE FROM autores where(idAutor="+cod+")");
             }catch(SQLException e){System.out.println(e.getMessage());}
   }
}


}
