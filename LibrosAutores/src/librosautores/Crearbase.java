/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librosautores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author a16pablovc
 */
public class Crearbase {
    
    public static void Crear( Statement sentencia ){
        
        try{
//        Connection conexion=DriverManager.getConnection("jdbc:mysql://localhost:3307/?user=root&password=usbw");
       
            
            sentencia.execute("CREATE DATABASE IF NOT EXISTS milibreria");
            sentencia.execute("USE milibreria");
         
            sentencia.execute("CREATE TABLE IF NOT EXISTS autores ("
                    + "idAutor INT(11) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT,"
                    + "nombre VARCHAR(30) NOT NULL,"
                    + "nacionalidad VARCHAR(30) NOT NULL,"
                    + "PRIMARY KEY(idAutor));");
           
            sentencia.execute("CREATE TABLE IF NOT EXISTS libros ("
                     + "idLibro INT(11) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT,"
                     + "titulo VARCHAR(30) NOT NULL,"
                    + "precio FLOAT NOT NULL,"
                    + "PRIMARY KEY(idLibro));");
            
//            sentencia.execute("DROP TABLE IF EXISTS librosautores");
                  sentencia.execute("CREATE TABLE    librosautores ("
                          +"autor INT(11) UNSIGNED ZEROFILL NOT NULL ,"
                         + "libro INT(11) UNSIGNED ZEROFILL NOT NULL ,"
                          + "PRIMARY KEY(autor,libro),"
                          + "INDEX fk_autor(autor),"
                          + "INDEX fk_libro(libro),"
                               + "CONSTRAINT fk_libro"
                          + "   FOREIGN KEY(libro)"
                          + "       REFERENCES libros(idLibro)"
                          + "      ON DELETE CASCADE"
                          + "       ON UPDATE CASCADE ,"
                           + "CONSTRAINT fk_autor"
                          + "   FOREIGN KEY(autor)"
                          + "       REFERENCES autores(idAutor)"
                          + "      ON DELETE CASCADE"
                          + "       ON UPDATE CASCADE);"                          
                     
                  );
            
        }catch(SQLException e){System.out.println(e.getMessage());}
        
    
    }
    
}
