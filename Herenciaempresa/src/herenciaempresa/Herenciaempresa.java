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
import org.hibernate.Session;

/**
 *
 * @author a16pablovc
 */
public class Herenciaempresa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
           Statement sentencia=null;
           try{
      Connection conexion=DriverManager.getConnection("jdbc:mysql://localhost:3307/?user=root&password=usbw");
             sentencia=conexion.createStatement();
        }catch(SQLException e){System.out.println(e.getMessage());}
   CrearBase.crear(sentencia);
   
        Session s=NewHibernateUtil.getSession();
 
        int op;
        
        do{
            System.out.println("1 Altas \n2 Bajas \n3 Modificaciones \n4 Consultas \n5 Salir");
            op=Comprobaciones.opcion(5);
        
            switch(op){
                case 1:Altas.altas();break;
                case 2:Bajas.bajas();break;
                case 3:Modificaciones.modificaciones();break;
                case 4:Consultas.consultas();break;}
                   
      }while(op!=5);
        System.exit(0);
    }
  
}
