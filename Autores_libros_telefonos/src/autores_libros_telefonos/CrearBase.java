/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autores_libros_telefonos;

import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author mi
 */
public class CrearBase {
          public static void crear( Statement sentencia){
        try{
        sentencia.execute("CREATE DATABASE IF NOT EXISTS libr_aut_telf");
    sentencia.execute("USE libr_aut_telf");

 /* sentencia.execute("DROP TABLE Libros");
    sentencia.execute("DROP TABLE Telefonos");
        sentencia.execute("DROP TABLE Autores");
*/
                sentencia.execute("CREATE TABLE IF NOT EXISTS Autores ( "
                + "DNI char(9)  NOT NULL, "
                + "nombre VARCHAR(30) NOT NULL, "
                + "nacionalidad VARCHAR(30) NOT NULL, "
                       
                + "PRIMARY KEY (DNI)) "
                + ";");
                
                 sentencia.execute("CREATE TABLE IF NOT EXISTS Libros ( "
                + "idLibro int(3)   NOT NULL AUTO_INCREMENT , "
                + "Titulo VARCHAR(30) NOT NULL, "
                + "precio FLOAT  NOT NULL, "
                + "PRIMARY KEY (idLibro), "
                + "Autor char(9)  NOT NULL,"
                         + "FOREIGN KEY (Autor) REFERENCES Autores(DNI)"
                         + "ON DELETE CASCADE "
                         + "ON UPDATE CASCADE,"
                           + "INDEX FK1_AUTOR (Autor))"
                + ";");
                 
                     sentencia.execute("CREATE TABLE IF NOT EXISTS Telefonos ( "
                + "numero VARCHAR(30) NOT NULL, "
                             + "Autor char(9)  NOT NULL,"
                       + "FOREIGN KEY (Autor) REFERENCES Autores(DNI)"
                         + "ON DELETE CASCADE "
                         + "ON UPDATE CASCADE,"
                           + "PRIMARY KEY  (numero))"
                + ";");

    
        }catch(SQLException e){System.out.println(e);}
          }
}
