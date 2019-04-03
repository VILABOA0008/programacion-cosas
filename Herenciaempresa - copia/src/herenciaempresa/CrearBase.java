/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herenciaempresa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author a16pablovc
 */
public class CrearBase {
    public static void crear(Statement sentencia){
    
      try{
      Connection conexion=DriverManager.getConnection("jdbc:mysql://localhost:3307/?user=root&password=usbw");
             sentencia=conexion.createStatement();
    
    

        sentencia.execute("CREATE DATABASE IF NOT EXISTS Herencia_empresascoches");
    sentencia.execute("USE Herencia_empresascoches");

 /* sentencia.execute("DROP TABLE Libros");
    sentencia.execute("DROP TABLE Telefonos");
        sentencia.execute("DROP TABLE Autores");
*/
                sentencia.execute("CREATE TABLE IF NOT EXISTS empresas ( "
                + "cif char(4)    NOT NULL, "
                + "nombre VARCHAR(30) NOT NULL, "
                 + "telefono char(9) Not null,"
                + "PRIMARY KEY (CIF)) "
                + ";");
                
                System.out.println("1");
                           sentencia.execute("CREATE TABLE IF NOT EXISTS coches ( "
                   + "codcoches char(4)    NOT NULL, "
                + "marca VARCHAR(30) NOT NULL, "
                 + "modelo VARCHAR(30) Not null,"
                  + "empresa CHAR(4) NOT NULL,"
                 + "FOREIGN KEY (empresa) REFERENCES empresas(cif)"
                                       + "on delete cascade "
                                   + "on update cascade, "
                               
                        
                      + "PRIMARY KEY  (codcoches))"
                + ";");
                             System.out.println("22");
                             
                              
                           sentencia.execute("CREATE TABLE IF NOT EXISTS cochesventa ( "
                                 
                + "precio float NOT NULL, "
                  + "codcoches char(4)    NOT NULL, "                 
                 + "FOREIGN KEY (codcoches) REFERENCES coches(codcoches)"
                                       + "on delete cascade " 
                                   + "on update cascade, "
                                                      
                      + "PRIMARY KEY  (codcoches))"
                + ";");
                              System.out.println("333");
                           
                         sentencia.execute("CREATE TABLE IF NOT EXISTS cochesalquiler ( "
             
                + "preciodia float NOT NULL, "
                  + "estado char(1)    NOT NULL, "                 
                 + "codcoches char(4)    NOT NULL, "    
                 + "FOREIGN KEY (codcoches) REFERENCES coches(codcoches)"
                              
                                   + "on delete cascade "             
                                      + "on update cascade, "
                      + "PRIMARY KEY  (codcoches))"
                + ";");
                         
                                 System.out.println("44");
                           
                         sentencia.execute("CREATE TABLE IF NOT EXISTS usos ( "
                                   + "fecha_alquiler date  NOT NULL, "
                  + "fecha_entrega date  NOT NULL, "
                  + "importe float NOT NULL, "
                   
                        + "codcoches char(4)    NOT NULL, "    
                 + "FOREIGN KEY (codcoches) REFERENCES cochesalquiler(codcoches)"
                                 + "on delete cascade "
                                   + "on update cascade, "
                                                           
                      + "PRIMARY KEY  (codcoches,fecha_alquiler))"
                + ";");
                         /*
                         Date FechaAlquiler.
Date FechaEntrega.
float importeAPagar.
FechaAlquiler+códigoCoche (clave primaria compuesta).
códigoCoche (clave foránea).*/
                         
        }catch(SQLException e){System.out.println(e);}
          }
    
    

}
