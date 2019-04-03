/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej_3_institutos_ciclos_talleres_pojos_tablas18;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author a16pablovc
 */
public class CrearBase {
    public static void crear(){
        Statement sentencia;
      try{
      Connection conexion=DriverManager.getConnection("jdbc:mysql://localhost:3307/?user=root&password=usbw");
             sentencia=conexion.createStatement();
    
    

        sentencia.execute("CREATE DATABASE IF NOT EXISTS institutos_ciclos_talleres");
    sentencia.execute("USE institutos_ciclos_talleres");

 /* sentencia.execute("DROP TABLE Libros");
    sentencia.execute("DROP TABLE Telefonos");
        sentencia.execute("DROP TABLE Autores");
*/
                sentencia.execute("CREATE TABLE IF NOT EXISTS ciclos ( "
                + "codciclo int(4) UNSIGNED ZEROFILL  NOT NULL, "
                + "nombre VARCHAR(30) NOT NULL, "
                + "PRIMARY KEY (codciclo)) "
                + ";");
                
                System.out.println("1");
                           sentencia.execute("CREATE TABLE IF NOT EXISTS institutos ( "
                  + "codinsti int(4) UNSIGNED ZEROFILL  NOT NULL, "
                + "telefono VARCHAR(30) NOT NULL, "
                  + "codciclo int(4) UNSIGNED ZEROFILL  NOT NULL, "
                         + "FOREIGN KEY (codciclo) REFERENCES CICLOS(codciclo)"
                         + "ON DELETE CASCADE "
                         + "ON UPDATE CASCADE,"          
                      + "PRIMARY KEY  (codinsti))"
                + ";");
                             System.out.println("22");
                         sentencia.execute("CREATE TABLE IF NOT EXISTS ciclos_institutos ( "
                  + "codinsti int(4) UNSIGNED ZEROFILL  NOT NULL, "
                + "codciclo int(4) UNSIGNED ZEROFILL  NOT NULL, "
                   +"FOREIGN KEY (codciclo) REFERENCES CICLOS(codciclo)"
                         + "ON DELETE CASCADE "
                         + "ON UPDATE CASCADE," 
                                 
                                 +"FOREIGN KEY (codinsti) REFERENCES institutos(codinsti)"
                         + "ON DELETE CASCADE "
                         + "ON UPDATE CASCADE,"        
               
                      + "PRIMARY KEY  (codinsti,codciclo))"
                + ";");
                           
                             System.out.println("333");
                           sentencia.execute("CREATE TABLE IF NOT EXISTS talleres ( "
                  + "codtaller int(4) UNSIGNED ZEROFILL  NOT NULL, "
                + "nombre VARCHAR(30) NOT NULL, "
                + "PRIMARY KEY  (codtaller))"
                + ";");
                             System.out.println("4444");
                              sentencia.execute("CREATE TABLE IF NOT EXISTS usos ( "
                  + "codciclo int(4) UNSIGNED ZEROFILL  NOT NULL, "
                + "codtaller  int(4) UNSIGNED ZEROFILL  NOT NULL, "
                + "fecha DATE NOT NULL, "
                + "hora TIME NOT NULL, "
                    + "FOREIGN KEY (codciclo) REFERENCES CICLOS(codciclo)"
                         + "ON DELETE CASCADE "
                         + "ON UPDATE CASCADE,"          
                      + "FOREIGN KEY (codtaller) REFERENCES talleres(codtaller)"
                         + "ON DELETE CASCADE "
                         + "ON UPDATE CASCADE,"          
                + "PRIMARY KEY  (codciclo,codtaller,fecha,hora))"
                + ";");

    
        }catch(SQLException e){System.out.println(e);}
          }
    
    
    }
    

