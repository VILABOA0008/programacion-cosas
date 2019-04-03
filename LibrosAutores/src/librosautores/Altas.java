/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librosautores;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author a16pablovc
 */
public class Altas {
    
    public static void altas(  Statement sentencia) throws SQLException{
        try{
        sentencia.execute("USE milibreria;");
             }catch(SQLException e){System.out.println(e.getMessage());}
        int op=0;
    do{
        System.out.println(" 1 Para insertar libro \n 2 Para Insertar Autor \n 3 Para Salir");

    op=comprobaciones.entero();
    switch(op){
        case 1:libros(sentencia);break;
        case 2:autores(sentencia);break;
    
    }
    
    }while (op!=3);
    
    }
      public static void libros(  Statement sentencia) throws SQLException{
          String autor ;
int op=0;
          System.out.println("Escribe el titulo");
          String titulo =comprobaciones.strin();
          System.out.println("Escribe el precio");
          int precio=comprobaciones.entero();
           try{
      
          sentencia.executeUpdate("Insert into libros(titulo,precio) values ( '"+titulo+"',"+precio+")");
      
                ResultSet consulta=sentencia.executeQuery("SELECT * FROM LIBROS");
              System.out.println("CODIGO        TITULO         PRECIO");
       while(consulta.next()){
         
          System.out.printf("%s   %8s  %10s  %n",consulta.getString(1),consulta.getString(2),consulta.getString(3));}
                  }catch(SQLException e){System.out.println(e.getMessage());}
           System.out.println("\n \n \n");
           
                 do{
                     System.out.println("1 Para ver los autores \n 2 para crear un nuevo autor");
           op=comprobaciones.entero();
           
           }while(op!=2&&op!=1);
               
                   if (op==2){
                    autores(sentencia);     ResultSet s=sentencia.executeQuery("Select max(idAutor) from autores");
                 s.next();
              autor=   s.getString(1);
                        sentencia.executeUpdate("Insert into librosautores(autor,libro) values ( '"+autor+"',(Select max(idLibro) from libros))");}
                
           
          do{
              try{
           if(Consultas.autores(sentencia)==1||op==2){if(op!=2)System.out.println("La tabla autores esta vacia");}else{
          System.out.println("Escribe el id del autor");
          autor=comprobaciones.strin();
        sentencia.executeUpdate("Insert into librosautores(autor,libro) values ( '"+autor+"',(Select max(idLibro) from libros))");
           }
            
                  }catch(SQLException e){if(e.getErrorCode()==1452)System.out.println("El codigo es invalido");}
                System.out.println("Quieres introducir otro autor para este libro \n 1 Si \n 2 No \n 3 crear nuevo autor");
                op=comprobaciones.entero();
              if(op==3){ ResultSet s;autores(sentencia);         s=sentencia.executeQuery("Select max(idAutor) from autores");
                 s.next();
              autor=   s.getString(1);
                      sentencia.executeUpdate("Insert into librosautores(autor,libro) values ( '"+autor+"',(Select max(idLibro) from libros))");
              
              }
          }while(op!=2);
       
          
//          try{
//      
//              sentencia.executeUpdate("Insert into libros(titulo,precio) values ( '"+titulo+"',"+precio+")");
//
//  sentencia.executeUpdate("Insert into librosautores(autor,libro) values ( '"+autor+"',(Select max(idLibro) from libros))");
//            ResultSet consulta=sentencia.executeQuery("SELECT * FROM LIBROS");
//              System.out.println("CODIGO        TITULO         PRECIO");
//       while(consulta.next()){
//         
//          System.out.printf("%s   %8s  %10s  %n",consulta.getString(1),consulta.getString(2),consulta.getString(3));
//       
//       }
//            }catch(SQLException e){System.out.println(e.getMessage());}
//          
          
      }
        public static void autores(  Statement sentencia) throws SQLException{
          

          System.out.println("Escribe el nombre");
          String nombre =comprobaciones.strin();
          System.out.println("Escribe la nacionalidad");
          String nacio=comprobaciones.strin();
          
          try{
      
              sentencia.executeUpdate("Insert into autores(titulo,nacionalidad) values ( '"+nombre+"','"+nacio+"')");
      Consultas.autores(sentencia);
       
       
            }catch(SQLException e){System.out.println(e.getMessage());}
      }
    
}



   
//            ResultSet consulta=sentencia.executeQuery("SELECT * FROM LIBROS");
//       while(consulta.next()){
//           System.out.println("CODIGO        TITULO         PRECIO");
//          System.out.printf("%s   %8s  %10s  %n",consulta.getString(1),consulta.getString(2),consulta.getString(3));
//       
//       }
//            }catch(SQLException e){System.out.println(e.getMessage());}