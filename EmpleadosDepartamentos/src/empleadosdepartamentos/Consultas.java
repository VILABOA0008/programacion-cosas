/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empleadosdepartamentos;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author mi
 */
public class Consultas {
    public static void consultas(Statement sentencia) throws SQLException{
         sentencia.execute("use DEPARTAMPLADOS");
    int op;
    do{
        System.out.println(" 1 Para  ver los Empleados de un departamento \n 2 para el departamento de un empleado \n 3 Para Salir");
        op=comprobaciones.opcion(3);
        
        switch(op){
            case 1:empleadosdedepartamento(sentencia);break;
            case 2:departamentodeepelado(sentencia);break;
            case 4:departamentos(sentencia);break;
            case 5:empleados(sentencia);break;
                 case 6:pruebas(sentencia);break;
        
        }
    
    }while(op!=3);
    
    }
      public static void pruebas(Statement sentencia) throws SQLException{
        
                     ResultSet r= sentencia.executeQuery("SELECT * FROM DEPARTAMENTOS where nombre=2");
                     
               try{
                   r.next(); r.next();
r.first();
        while(r.next()){
            System.out.println("Codigo   Nombre       Localidad");
            System.out.printf("%s %12s %15s %n",r.getString(1),r.getString(2),r.getString(3));
        }                
        }catch(SQLException e){if(e.getErrorCode()==0){System.out.println("No hay tuplas");}}        
    }
            //////////////////////////////////////////////////////////        //////////////////////////////////////////////////////////
    
            //////////////////////////////////////////////////////////        //////////////////////////////////////////////////////////
    public static void departamentos(Statement sentencia) throws SQLException{
        
                     ResultSet r= sentencia.executeQuery("SELECT * FROM DEPARTAMENTOS");
               try{
            
        while(r.next()){
            System.out.println("Codigo   Nombre       Localidad");
            System.out.printf("%s %12s %15s %n",r.getString(1),r.getString(2),r.getString(3));
        }                
        }catch(SQLException e){System.out.println(e.getMessage());}        
    }
            //////////////////////////////////////////////////////////        //////////////////////////////////////////////////////////
        public static void empleados(Statement sentencia) throws SQLException{
    
                     ResultSet r= sentencia.executeQuery("SELECT * FROM empleados");
               try{
            
        while(r.next()){
            System.out.println("Dni         Nombre     Estudios  Direccion        Fecha    Salario    Comision     Departamento ");
            System.out.printf("%s %8s %12s %10s %12s %10s  %10s %10s %n",r.getString(1),r.getString(2),r.getString(3),r.getString(4),r.getString(5),r.getString(6)+"€",r.getString(7)+"%",r.getString(8));
        }                
        }catch(SQLException e){System.out.println(e.getMessage());}        
    }
        //////////////////////////////////////////////////////////        //////////////////////////////////////////////////////////
          public static void departamentodeepelado(Statement sentencia) throws SQLException{
              empleados(sentencia);
        System.out.println("Escribe el dni del empleado del que quieras ver su departamento");
              String dni=comprobaciones.dni();
    
                   ResultSet r= sentencia.executeQuery(" select nombre,localidad from departamentos where numero_dept=(select numero from empleados where dni='"+dni+"');");
               try{
            
        while(r.next()){
            System.out.println("Nombre     Localidad");
            System.out.printf("%s %12s  %n",r.getString(1),r.getString(2));
        }                
        }catch(SQLException e){System.out.println(e.getMessage());}        
    }
                //////////////////////////////////////////////////////////        //////////////////////////////////////////////////////////
            public static void empleadosdedepartamento(Statement sentencia) throws SQLException{
                departamentos(sentencia);
     System.out.println("Escribe el nombre del departamento del que quieras ver sus empleados");
              String nombre=comprobaciones.strin();
    
                   ResultSet r= sentencia.executeQuery(" select * from empleados where numero=(select numero_dept from departamentos where nombre='"+nombre+"');");
               try{
            
            
        while(r.next()){
                     System.out.println("Dni         Nombre     Estudios  Direccion        Fecha    Salario    Comision     Departamento ");
            System.out.printf("%s %8s %12s %10s %12s %10s  %10s %10s %n",r.getString(1),r.getString(2),r.getString(3),r.getString(4),r.getString(5),r.getString(6),r.getString(7)+"%",r.getString(8));
//        }  
//            System.out.println("Dni  Nombre       Estudios         Direccion       Fecha  Salario       Comision         Departamento ");
//            System.out.printf("%s %10s %10s %10s %10s %10s %10s %n",r.getString(1),r.getString(2),r.getString(3),r.getString(4),r.getString(5),r.getString(6),r.getString(7),r.getString(8));
        }                
        }catch(SQLException e){System.out.println(e.getMessage());}        
    }
            
            
            
}
