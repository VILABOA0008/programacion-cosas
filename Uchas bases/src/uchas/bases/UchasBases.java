/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uchas.bases;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author a16pablovc
 */
public class UchasBases {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
      Statement sentencia=null;
         int op;
          Connection conexion=null;
     try{
       conexion=DriverManager.getConnection("jdbc:mysql://localhost:3307/?user=root&password=usbw");
             sentencia=conexion.createStatement();
        }catch(SQLException e){System.out.println(e.getMessage());}
     CrearBase.crear(sentencia);
        System.out.println("Elige base de datos \n 1 sqlite \n 2 derby \n 3 h2 \n 4 hsqldb \n 5 jdbc");
        op=Comprobaciones.opcion(5);
     String ruta = "./bases_de_datos/";
        try {
            switch (op) {
                case 1:  conexion = DriverManager.getConnection("jdbc:sqlite:" + ruta + "institutolite.db");
                    System.out.println("CONECTADO");
                    break;
                case 2:  conexion = DriverManager.getConnection("jdbc:derby:" + ruta + "institutopache;create=true");
                    System.out.println("CONECTADO ");
                    break;
                case 3:  conexion = DriverManager.getConnection("jdbc:h2:" + ruta + "institutoh2");
                    System.out.println("CONECTADO con H2");
                    break;
                case 4:conexion = DriverManager.getConnection("jdbc:hsqldb:file:" + ruta + "institutohqlsd");
                    System.out.println("CONECTADO");
                    break;
                    case 5:conexion =DriverManager.getConnection("jdbc:mysql://localhost:3307/?user=root&password=usbw");
                    System.out.println("CONECTADO");
                    break;
              
                default:
                    System.out.println("No se ha conectado");
                    break;
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
       sentencia=conexion.createStatement();

     
        do{
                  System.out.println(" Elige opcion: \n 1 Altas \n 2 Bajas \n 3 Consultas \n 4 Modificaciones \n 5 Fin");
        op=Comprobaciones.opcion(7);
        
        switch(op){
            
            case 1:Altas.altas(sentencia);break;
            case 2:Bajas.bajas(sentencia);break;
            case 3:Consultas.consultas(sentencia);break;
            case 4:Modificaciones.modificaciones(sentencia);break;
            case 6:CrearBase.insertar(sentencia);break;
            
        
        
        }
        
        }while(op!=5);
        
    }
    
}