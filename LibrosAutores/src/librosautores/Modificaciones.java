/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librosautores;

import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author mi
 */
public class Modificaciones {
    public static void modificaciones( Statement sentencia) throws SQLException{
           try{
                   sentencia.execute("USE milibreria;");
        Consultas.libros(sentencia);
        System.out.println("Escribe el ID del libro a modificar");
        int cod=comprobaciones.entero();
          System.out.println("Escribe el nuevo precio");
        int precio=comprobaciones.entero();
        
        sentencia.executeUpdate("update libros set precio="+precio+" Where idLibro="+cod+"");
        
        
        sentencia.execute("USE milibreria;");
             }catch(SQLException e){System.out.println(e.getMessage());}
    
    
    
    }
    
}
