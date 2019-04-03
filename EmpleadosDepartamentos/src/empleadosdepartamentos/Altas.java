/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empleadosdepartamentos;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author a16pablovc
 */
public class Altas {
    
    
     public static void altas(Statement sentencia) throws SQLException{
         sentencia.execute("use DEPARTAMPLADOS");
    int op;
    do{
        System.out.println(" 1 Para insertar Departamento \n 2 para insertar empleado \n 3 Para Salir");
        op=comprobaciones.opcion(3);
        
        switch(op){
            case 1:departamento(sentencia);break;
            case 2:empleado(sentencia);break;
        
        }
    
    }while(op!=3);
    
    
    }
    
    public static void empleado(Statement sentencia) throws SQLException{
            int op;
         do{
         
         System.out.println("Escriba el dni");
         String dni=comprobaciones.strin();
           System.out.println("Escriba el nombre");
         String nombre=comprobaciones.strin();
               System.out.println("Escriba los estudios");
         String estudios=comprobaciones.strin();
           System.out.println("Escriba la direccion");
         String direccion=comprobaciones.strin();
               System.out.println("Escriba la fecha de alta");
                     Date fecha=comprobaciones.fecha();
           System.out.println("Escriba el salario");
         int salario=comprobaciones.entero();
               System.out.println("Escriba la comison");
         int comison =comprobaciones.entero();
           System.out.println("Escriba el departamento al que perteneze");
                try {
                    Thread.sleep(300);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Altas.class.getName()).log(Level.SEVERE, null, ex);
                }
                Consultas.departamentos(sentencia);
         String departamento=comprobaciones.strin();
    
         
         try{
         sentencia.executeUpdate("Insert into empleados (dni,nombre,estudios,dir,fecha_alta,salario,comision,NUMERO) "
                 + "values('"+dni+"','"+nombre+"','"+estudios+"','"+direccion+"','"+fecha+"','"+salario+"','"+comison+"','"+departamento+"')");
                 }catch(SQLException e){System.out.println(e.getMessage());}     
             System.out.println(" 1 Para volver a introducir un empleado \n 2 Para Salir");
    op=comprobaciones.opcion(2);
         }while(op!=2);
    
    
    }
    
     public static void departamento(Statement sentencia) throws SQLException{
         int op;
         do{
         
         System.out.println("Escriba el nombre del departamento");
         String nombre=comprobaciones.strin();
           System.out.println("Escriba la localidad del departamento");
         String localidad=comprobaciones.strin();
             try {
                 
        
         sentencia.executeUpdate("Insert into departamentos (nombre,localidad) values('"+nombre+"','"+localidad+"')");
              } catch (SQLException e) {if(e.getErrorCode()==1062){System.out.println("Nombre Duplicado");}
             }
             System.out.println(" 1 Para volver a introducir un departamento \n 2 Para Salir");
    op=comprobaciones.opcion(2);
         }while(op!=2);
    }
    
    
}
