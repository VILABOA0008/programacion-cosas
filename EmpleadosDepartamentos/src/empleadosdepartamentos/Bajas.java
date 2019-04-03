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
 * @author mi
 */
public class Bajas {
    
         public static void bajas(Statement sentencia) throws SQLException{
         sentencia.execute("use DEPARTAMPLADOS");
    int op;
    do{
        System.out.println(" 1 Para borrar Departamento \n 2 para borrar empleado \n 3 Para Salir");
        op=comprobaciones.opcion(3);
        
        switch(op){
            case 1:departamento(sentencia);break;
            case 2:empleado(sentencia);break; }    
    }while(op!=3);
    
            }
          public static void empleado(Statement sentencia) throws SQLException{
                  int op;
    do{
              
          Consultas.empleados(sentencia);
              System.out.println("Inserte el DNI del empleado a borrar");
              String cod=comprobaciones.dni();
              
              try {
       sentencia.executeUpdate("DELETE FROM EMPLEADOS where(dni='"+cod+"')");
              } catch (SQLException e) {System.out.println(e.getMessage());
              }
         System.out.println(" 1 Para  volver a borrar  \n 2 Para Salir");
         op=comprobaciones.opcion(2);
              }while(op!=2);
          }
          
                   public static void departamento(Statement sentencia) throws SQLException{
                  int op;
    do{
              
          Consultas.departamentos(sentencia);
              System.out.println("Inserte el codigo del departamento a borrar");
              int cod=comprobaciones.entero();
              
              try {
       sentencia.executeUpdate("DELETE FROM departamentos where(numero_dept="+cod+")");
              } catch (SQLException e) {System.out.println(e.getMessage());
              }
         System.out.println(" 1 Para  volver a borrar  \n 2 Para Salir");
         op=comprobaciones.opcion(2);
              }while(op!=2);
          }
}
