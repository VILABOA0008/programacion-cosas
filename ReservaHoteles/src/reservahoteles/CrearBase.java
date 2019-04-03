package reservahoteles;

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
    


        sentencia.execute("CREATE DATABASE IF NOT EXISTS Ej_2_ReservasHoteles2018");
    sentencia.execute("  Use  Ej_2_ReservasHoteles2018");
     System.out.println("1");
sentencia.execute("CREATE TABLE IF NOT EXISTS Hoteles ( "
+"Idhotel  INT  (4)  auto_increment  NOT NULL, "
 +"Nombre  VARCHAR  (40)    NOT NULL, "
 +"Telefono  CHAR  (9)    NOT NULL, "
 +"PRIMARY KEY  (Idhotel));");
     System.out.println("2");
     
sentencia.execute("CREATE TABLE IF NOT EXISTS Habitaciones ( "
+"Idhabitacion  INT  (4)    NOT NULL, "
 +"Ocupado boolean not null,"
 +"Precio  FLOAT      NOT NULL, "
 +"Idhotel  INT  (4)    NOT NULL, "
    +"FOREIGN KEY (Idhotel) REFERENCES Hoteles(Idhotel) "
 +"on delete cascade  "
 +"on update cascade,  "
 +"PRIMARY KEY  (Idhabitacion));");
 
          System.out.println("3");
 
sentencia.execute("CREATE TABLE IF NOT EXISTS Clientes ( "
+"Dni  CHAR  (9)    NOT NULL, "
 +"Nombre  VARCHAR  (15)    NOT NULL, "
 +"Telefono  CHAR  (9)    NOT NULL, "
 +"PRIMARY KEY  (Dni));");

sentencia.execute("CREATE TABLE IF NOT EXISTS Reservas ( "
+"Idhotel  INT  (4)    NOT NULL, "
 +"Idhabitacion  INT  (4)    NOT NULL, "
 +"FechaEntrada  DATE      NOT NULL, "
 +"FechaSalida  DATE      NOT NULL, "
 +"Dni  CHAR  (9)    NOT NULL, "        
 +"FOREIGN KEY (Dni) REFERENCES Clientes(Dni) "
 +"on delete cascade  "
 +"on update cascade,  "
 +"FOREIGN KEY (Idhotel) REFERENCES Hoteles(Idhotel) "
 +"on delete cascade  "
 +"on update cascade,  "
 +" FOREIGN KEY (Idhabitacion) REFERENCES Habitaciones(Idhabitacion) "
 +"on delete cascade  "
 +"on update cascade,  "
 +" PRIMARY KEY  (FechaEntrada,Idhabitacion));");

 }catch(SQLException e){System.out.println(e);}
          }}
