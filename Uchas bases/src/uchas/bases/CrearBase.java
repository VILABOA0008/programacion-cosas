
package uchas.bases;



import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author a16pablovc
 */
public class CrearBase {
      public static void crear( Statement sentencia){
        try{
        sentencia.execute("CREATE DATABASE IF NOT EXISTS Institituto");
    sentencia.execute("USE Institituto");
//    sentencia.execute("DROP TABLE NOTAS");
//         sentencia.execute("DROP TABLE PAA");
//       sentencia.execute("DROP TABLE PROFESORES");
//  sentencia.execute("DROP TABLE ALUMNOS");
//   sentencia.execute("DROP TABLE ASIGNATURAS");

    
        sentencia.execute("CREATE TABLE IF NOT EXISTS PROFESORES("
            + "DNI CHAR(9) NOT NULL,"
            + "NOMBRE VARCHAR(30) NOT NULL,"
            + "TITULACION  VARCHAR(30) NOT NULL,"
            + "PRIMARY KEY (DNI));");
    
       sentencia.execute("CREATE TABLE IF NOT EXISTS ALUMNOS("
            + "ID INT(4) ZEROFILL NOT NULL AUTO_INCREMENT,"
            + "CODIGO VARCHAR(30) NOT NULL,"
            + "NOMBRE  VARCHAR(30) NOT NULL,"
           + "UNIQUE INDEX AK_CODIGO (CODIGO),"
            + "PRIMARY KEY (ID));");
       
         sentencia.execute("CREATE TABLE IF NOT EXISTS ASIGNATURAS("
            + "ID INT(4) ZEROFILL NOT NULL AUTO_INCREMENT,"
            + "CODIGO VARCHAR(30) NOT NULL,"
            + "NOMBRE  VARCHAR(50) NOT NULL,"
            + "CICLO  VARCHAR(30) NOT NULL,"
            + "PRIMARY KEY (ID));");
         
               
         sentencia.execute("CREATE TABLE IF NOT EXISTS PAA("
            + "DNI_PROFESOR CHAR(9) NOT NULL,"
            + "ID_ALUMNO  INT(4) ZEROFILL NOT NULL,"
            + "ID_ASIGNATURA INT(4) ZEROFILL NOT NULL,"
            
            + "FOREIGN KEY (DNI_PROFESOR) REFERENCES PROFESORES(DNI)"
                 + "ON DELETE CASCADE "
                 + "ON UPDATE CASCADE,"
                 + "FOREIGN KEY (ID_ASIGNATURA) REFERENCES ASIGNATURAS(ID)"
                 + "ON DELETE CASCADE "
                 + "ON UPDATE CASCADE,"
                 + "FOREIGN KEY (ID_ALUMNO) REFERENCES ALUMNOS(ID)"
                 + "ON DELETE CASCADE "
                 + "ON UPDATE CASCADE,"
                 + "PRIMARY KEY (DNI_PROFESOR,ID_ASIGNATURA,ID_ALUMNO));");
         
                
         sentencia.execute("CREATE TABLE IF NOT EXISTS NOTAS("
            + "ALUMNO INT(4) ZEROFILL NOT NULL,"
            + "ASIGNATURA   INT(4) ZEROFILL NOT NULL , "
            + "FECHA  DATE NOT NULL,"
            + "NOTA FLOAT NOT NULL,"
            + "FOREIGN KEY (ALUMNO) REFERENCES ALUMNOS(ID)"
                 + "ON DELETE CASCADE "
                 + "ON UPDATE CASCADE,"
                 + " FOREIGN KEY(ASIGNATURA) REFERENCES ASIGNATURAS(ID)"
                 + "ON DELETE CASCADE "
                 + "ON UPDATE CASCADE,"
                 + "PRIMARY KEY (ALUMNO,ASIGNATURA,FECHA));");
    
    
    
    
    
                 }catch(SQLException e){System.out.println(e.getMessage());}
    
    }
    public static void insertar(Statement s){
    try{
    
    //Insertamos asignaturas en la base de datos
        s.executeUpdate("INSERT INTO ASIGNATURAS (CODIGO, NOMBRE, CICLO) VALUES ('0001', 'Programación', '1º DAM')");
        s.executeUpdate("INSERT INTO ASIGNATURAS (CODIGO, NOMBRE, CICLO) VALUES ('0002', 'Bases de Datos', '1º DAM')");
        s.executeUpdate("INSERT INTO ASIGNATURAS (CODIGO, NOMBRE, CICLO) VALUES ('0003', 'Sistemas Informáticos', '1º DAM')");
        s.executeUpdate("INSERT INTO ASIGNATURAS (CODIGO, NOMBRE, CICLO) VALUES ('0004', 'Contornos de Desarrollo', '1º DAM')");
        s.executeUpdate("INSERT INTO ASIGNATURAS (CODIGO, NOMBRE, CICLO) VALUES ('0005', 'Lenguaje de Marcas', '1º DAM')");
        s.executeUpdate("INSERT INTO ASIGNATURAS (CODIGO, NOMBRE, CICLO) VALUES ('0006', 'Acceso a Datos', '2º DAM')");
        s.executeUpdate("INSERT INTO ASIGNATURAS (CODIGO, NOMBRE, CICLO) VALUES ('0007', 'Desarrollo de Interfaces', '2º DAM')");
        s.executeUpdate("INSERT INTO ASIGNATURAS (CODIGO, NOMBRE, CICLO) VALUES ('0008', 'Programación Multimedia y Dispositivos Móviles', '2º DAM')");
        s.executeUpdate("INSERT INTO ASIGNATURAS (CODIGO, NOMBRE, CICLO) VALUES ('0009', 'Programación de Servicios y Procesos', '2º DAM')");
        s.executeUpdate("INSERT INTO ASIGNATURAS (CODIGO, NOMBRE, CICLO) VALUES ('0010', 'Sistemas de Gestión Empresarial', '2º DAM')");
        s.executeUpdate("INSERT INTO ASIGNATURAS (CODIGO, NOMBRE, CICLO) VALUES ('0011', 'Bases de Datos', '1º ASIR')");
        s.executeUpdate("INSERT INTO ASIGNATURAS (CODIGO, NOMBRE, CICLO) VALUES ('0012', 'Fundamentos de Hardware', '1º ASIR')");
        s.executeUpdate("INSERT INTO ASIGNATURAS (CODIGO, NOMBRE, CICLO) VALUES ('0013', 'Redes', '1 ASIR')");
        s.executeUpdate("INSERT INTO ASIGNATURAS (CODIGO, NOMBRE, CICLO) VALUES ('0014', 'Implantación de Sistemas Operativos', '1º ASIR')");
        s.executeUpdate("INSERT INTO ASIGNATURAS (CODIGO, NOMBRE, CICLO) VALUES ('0015', 'Lenguaje de Marcas', '1º ASIR')");
        s.executeUpdate("INSERT INTO ASIGNATURAS (CODIGO, NOMBRE, CICLO) VALUES ('0016', 'Formación y Orientación Laboral', '1º DAM')");
        s.executeUpdate("INSERT INTO ASIGNATURAS (CODIGO, NOMBRE, CICLO) VALUES ('0017', 'Formación y Orientación Laboral', '1º ASIR')");
        s.executeUpdate("INSERT INTO ASIGNATURAS (CODIGO, NOMBRE, CICLO) VALUES ('0018', 'Empresa e Iniciativa Emprendedora', '2º DAM')");
        s.executeUpdate("INSERT INTO ASIGNATURAS (CODIGO, NOMBRE, CICLO) VALUES ('0019', 'Empresa e Iniciativa Emprendedora', '2º ASIR')");
                 }catch(SQLException e){System.out.println(e.getMessage());}
    }
}

