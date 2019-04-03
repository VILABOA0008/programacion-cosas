package base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author a16pablovc
 */
public class crearbase {
    public static void crear(Statement sentencia){
    
      try{
      Connection conexion=DriverManager.getConnection("jdbc:mysql://localhost:3307/?user=root&password=usbw");
             sentencia=conexion.createStatement();
    
    

        sentencia.execute("CREATE DATABASE IF NOT EXISTS Ej_2_ReservasHoteles2018");
    sentencia.execute("  Use  Ej_2_ReservasHoteles2018");
 
sentencia.execute("CREATE TABLE IF NOT EXISTS Hoteles ( "
+"nombre  VARCHAR   (30)     NOT NULL, "
 +"telefono  VARCHAR   (30)     NOT NULL, "
 +"idHotel  INT      NOT NULL, "
 +"PRIMARY KEY  (idHotel));");
 
sentencia.execute("CREATE TABLE IF NOT EXISTS Clientes ( "
+"dni  VARCHAR   (30)     NOT NULL, "
 +"nombre  VARCHAR   (30)     NOT NULL, "
 +"telefono  VARCHAR   (30)     NOT NULL, "
 +"PRIMARY KEY  (dni));");
 
sentencia.execute("CREATE TABLE IF NOT EXISTS Reservas ( "
+"idHotel  VARCHAR   (30)     NOT NULL, "
 +"idHabitacion  FLOAT      NOT NULL, "
 +"fechaEntrada  DATE      NOT NULL, "
 +"fechaSalida  DATE      NOT NULL, "
 +"dni  VARCHAR   (30)     NOT NULL, "
 +" FOREIGN KEY (idHotel) REFERENCES Hoteles(idHotel) "
 +"on delete cascade  "
 +"on update cascade,  "
 +" FOREIGN KEY (idHabitacion) REFERENCES Habitaciones(idHabitacion) "
 +"on delete cascade  "
 +"on update cascade,  "
 +" FOREIGN KEY (dni) REFERENCES Clientes(dni) "
 +"on delete cascade  "
 +"on update cascade,  "
 +" PRIMARY KEY  (Hoteles,fechaEntrada));");
 
sentencia.execute("CREATE TABLE IF NOT EXISTS Habitaciones ( "
+"precio  FLOAT      NOT NULL, "
 +"idHabitacion  INT      NOT NULL, "
 +"idHotel  VARCHAR   (30)     NOT NULL, "
 +"ocupado  BOOLEAN      NOT NULL, "
 +"FOREIGN KEY (idHotel) REFERENCES Hoteles(idHotel) "
 +"on delete cascade  "
 +"on update cascade,  "
 +" PRIMARY KEY  (idHabitacion));");
 
sentencia.execute("CREATE TABLE IF NOT EXISTS Reservas ( "
+"idHotel  VARCHAR   (30)     NOT NULL, "
 +"idHabitacion  FLOAT      NOT NULL, "
 +"fechaEntrada  DATE      NOT NULL, "
 +"fechaSalida  DATE      NOT NULL, "
 +"dni  VARCHAR   (30)     NOT NULL, "
 +"PRIMARY KEY  (Hoteles));");
 
sentencia.execute("CREATE TABLE IF NOT EXISTS Reservas ( "
+"idHotel  VARCHAR   (30)     NOT NULL, "
 +"idHabitacion  FLOAT      NOT NULL, "
 +"fechaEntrada  DATE      NOT NULL, "
 +"fechaSalida  DATE      NOT NULL, "
 +"dni  VARCHAR   (30)     NOT NULL, "
 +"PRIMARY KEY  (Hoteles));");
 }catch(SQLException e){System.out.println(e);}
          }}
