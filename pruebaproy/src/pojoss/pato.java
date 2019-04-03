package pojoss;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author a16pablovc
 */
public class pato {
    public static void crear(Statement sentencia){
    
      try{
      Connection conexion=DriverManager.getConnection("jdbc:mysql://localhost:3307/?user=root&password=usbw");
             sentencia=conexion.createStatement();
    
    

        sentencia.execute("CREATE DATABASE IF NOT EXISTS crearbase");
    sentencia.execute("  Use  crearbase");
 
sentencia.execute("CREATE TABLE IF NOT EXISTS Usuarios ( "
+"Nombre  VARCHAR   (30)     NOT NULL, "
 +"Contraseña  VARCHAR   (30)     NOT NULL, "
 +"PRIMARY KEY  (Nombre));");
 
sentencia.execute("CREATE TABLE IF NOT EXISTS Clientes ( "
+"DNI  VARCHAR   (30)     NOT NULL, "
 +"Nombre  VARCHAR   (30)     NOT NULL, "
 +"Direccion  VARCHAR   (30)     NOT NULL, "
 +"Telefono  VARCHAR   (30)     NOT NULL, "
 +"Email  VARCHAR   (30)     NOT NULL, "
 +"PRIMARY KEY  (DNI));");
 
sentencia.execute("CREATE TABLE IF NOT EXISTS Cuentas ( "
+"numero  VARCHAR   (30)     NOT NULL, "
 +"saldo  FLOAT      NOT NULL, "
 +"cliente  FLOAT      NOT NULL, "
 +"numero  VARCHAR   (30)     NOT NULL, "
 +"FOREIGN KEY (numero) REFERENCES Tarjetas(numero) "
 +"on delete cascade  "
 +"on update cascade,  "
 +" PRIMARY KEY  (Numero));");
 
sentencia.execute("CREATE TABLE IF NOT EXISTS Compras ( "
+"ID  INT      NOT NULL, "
 +"Numero  VARCHAR   (30)     NOT NULL, "
 +"direccion  VARCHAR   (30)     NOT NULL, "
 +"preciototal  FLOAT      NOT NULL, "
 +"formadepago  BOOLEAN      NOT NULL, "
 +"fechasolicitud  DATE      NOT NULL, "
 +"FOREIGN KEY (Numero) REFERENCES Cuentas(Numero) "
 +"on delete cascade  "
 +"on update cascade,  "
 +" PRIMARY KEY  (ID));");
 
sentencia.execute("CREATE TABLE IF NOT EXISTS Tarjetas ( "
+"numero  VARCHAR   (30)     NOT NULL, "
 +"fechacaducidad  DATE      NOT NULL, "
 +"CVV  VARCHAR   (30)     NOT NULL, "
 +"PRIMARY KEY  (numero));");
 
sentencia.execute("CREATE TABLE IF NOT EXISTS Pedidos ( "
+"ID  INT      NOT NULL, "
 +"cantidad  INT      NOT NULL, "
 +"preciototal  FLOAT      NOT NULL, "
 +"ID  INT      NOT NULL, "
 +"FOREIGN KEY (ID) REFERENCES Productos(ID) "
 +"on delete cascade  "
 +"on update cascade,  "
 +" PRIMARY KEY  (ID));");
 
sentencia.execute("CREATE TABLE IF NOT EXISTS Productos ( "
+"ID  INT      NOT NULL, "
 +"stockmin  INT      NOT NULL, "
 +"stockmax  INT      NOT NULL, "
 +"stockactual  INT      NOT NULL, "
 +"nombre  VARCHAR   (30)     NOT NULL, "
 +"precio  FLOAT      NOT NULL, "
 +"CIF  VARCHAR   (30)     NOT NULL, "
 +"FOREIGN KEY (CIF) REFERENCES Proovedor(CIF) "
 +"on delete cascade  "
 +"on update cascade,  "
 +" PRIMARY KEY  (ID));");
 
sentencia.execute("CREATE TABLE IF NOT EXISTS Proovedor ( "
+"CIF  VARCHAR   (30)     NOT NULL, "
 +"email  VARCHAR   (30)     NOT NULL, "
 +"telefono  VARCHAR   (30)     NOT NULL, "
 +"direccion  VARCHAR   (30)     NOT NULL, "
 +"PRIMARY KEY  (CIF));");
 }catch(SQLException e){System.out.println(e);}
          }}
