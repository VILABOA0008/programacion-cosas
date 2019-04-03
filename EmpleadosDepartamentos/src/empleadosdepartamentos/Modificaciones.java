/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empleadosdepartamentos;

import static empleadosdepartamentos.Altas.departamento;
import static empleadosdepartamentos.Altas.empleado;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author a16pablovc
 */
public class Modificaciones {
    
         public static void modificaciones(Statement sentencia) throws SQLException{
         sentencia.execute("use DEPARTAMPLADOS");
    int op;
    do{
        System.out.println(" 1 Para modificar salario o comision de empleado \n 2 para modificar la localidad de un departamento \n 3 Para Salir");
        op=comprobaciones.opcion(3);
        
        switch(op){
            case 1:empleado(sentencia);break;
            case 2:departamento(sentencia);break;
            
        
        }
    
    }while(op!=3);
    
    
    }
         
         
            public static void departamento(Statement sentencia) throws SQLException{
     
         Consultas.departamentos(sentencia);
         System.out.println("Escribe el nombre del departamento");
         String nombre=comprobaciones.strin();
           System.out.println("Escribe la nueva localidad");
         String localidad=comprobaciones.strin();
        
         
     try{
    
            
     sentencia.executeUpdate("update departamentos SET localidad ='"+localidad+"'  where nombre='"+nombre+"'");
     
     
     }catch(SQLException e){e.getMessage();}
     
     
     
     }
         
         
         
     public static void empleado(Statement sentencia) throws SQLException{
     
         Consultas.empleados(sentencia);
         System.out.println("Escribe el dni del empleado");
         String dni=comprobaciones.dni();
         int op;
             do{
        System.out.println(" 1 Para modificar el salario  \n 2 Para modificar la comision ");
        op=comprobaciones.opcion(3);
        
    
    }while(op<1||op>2);
         
         
     try{
         if(op==1){
             System.out.println("Escribe el nuevo salario");
             int sal=comprobaciones.entero();
     sentencia.executeUpdate("update empleados SET salario='"+sal+"'  where dni='"+dni+"'");}else{
               System.out.println("Escribe la nueva comision");
             int com=comprobaciones.entero();
         sentencia.executeUpdate("update empleados SET comision='"+com+"'  where dni='"+dni+"'");}
     
     
     }catch(SQLException e){e.getMessage();}
     
     
     
     }
    
}
