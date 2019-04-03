/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empleadosdepartamentos;

import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author a16pablovc
 */
public class Creartablas {
    public static void crear( Statement sentencia){
        try{
        sentencia.execute("CREATE DATABASE IF NOT EXISTS DEPARTAMPLADOS");
    sentencia.execute("USE DEPARTAMPLADOS");
//        sentencia.execute("DROP TABLE EMPLEADOS");
//    sentencia.execute("DROP TABLE DEPARTAMENTOS");

    
        sentencia.execute("CREATE TABLE IF NOT EXISTS DEPARTAMENTOS("
            + "NUMERO_DEPT INT(2) ZEROFILL NOT NULL AUTO_INCREMENT,"
            + "NOMBRE VARCHAR(10) NOT NULL,"
            + "LOCALIDAD  VARCHAR(10) NOT NULL,"
           + "UNIQUE INDEX AK_NOMBRE (NOMBRE),"
            + "PRIMARY KEY (NUMERO_DEPT));");
    
    sentencia.execute("CREATE TABLE IF NOT EXISTS EMPLEADOS("
            + "DNI CHAR(9) NOT NULL,"
             + "NOMBRE  VARCHAR(10) NOT NULL,"
            + "ESTUDIOS VARCHAR(10) NOT NULL,"
            + "DIR  VARCHAR(10) NOT NULL,"
            + "FECHA_ALTA DATE NOT NULL,"
            + "SALARIO INT NOT NULL,"
            + "COMISION INT NOT NULL,"
            + "NUMERO INT(2) ZEROFILL NOT NULL,"
            + "FOREIGN KEY (NUMERO)"
           + "REFERENCES DEPARTAMENTOS(NUMERO_DEPT)"
            + "ON DELETE CASCADE "
            +"ON UPDATE CASCADE,"
            + "PRIMARY KEY (DNI));");
    
    
    
    
    
                 }catch(SQLException e){System.out.println(e.getMessage());}
    
    }
    
}
