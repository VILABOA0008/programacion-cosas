/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodos;

import clases.Autores;
import clases.Libros;
import java.sql.Date;
import java.util.Random;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

/**
 *
 * @author a16pablovc
 */
public class Altas {
    
    public static void altas(){
    
            int op;
        
        do{
            System.out.println("\n");
            System.out.println(" 1 autores \n 2 libros \n 3 Salir");
             op=Comprobaciones.opcion(3);
        
             switch(op){
             
                 case 1:autores() ;   break;
                 case 2:libros();    break;
              
             
             }       
                        
        }while(op!=3);
    
    
    }
    
    public static void autores(){
        
        ODB odb = ODBFactory.openClient("localhost",8000,"libros_autores");
        
        
        String dni,  nombre,  direccion,  nacionalidad;
        int edad;
        Random r=new Random();
//        dni="3243245"+r.nextInt(445);
//        nombre="Juanit"+r.nextInt(445);
//        direccion="Lejos"+r.nextInt(445);
//        nacionalidad="española";
 System.out.println("Escribe la dni");
        dni=Comprobaciones.strin();
 System.out.println("Escribe la nombre");
        nombre=Comprobaciones.strin();
        System.out.println("Escribe la direccion");
        direccion=Comprobaciones.strin();
         System.out.println("Escribe la nacionalidad");
        nacionalidad=Comprobaciones.strin();      
        System.out.println("Escribe la edad");
        edad=Comprobaciones.entero();
        
        
        Autores a =new Autores(dni, nombre, direccion, nacionalidad, edad);
        
      CriteriaQuery   query = new CriteriaQuery(Autores.class, Where.equal("dni", dni));
            Objects<Autores> objects = odb.getObjects(query);
            
            if (!objects.isEmpty()) {
                System.out.println("Ya existe un autor con ese dni");}else{
        
    odb.store(a);
    odb.commit();
    
        System.out.println("Autor dado de alta");}
    }
    
    public static void libros(){
        Autores a;
           ODB odb = ODBFactory.openClient("localhost",8000,"libros_autores");
           Consultas.autores();
        System.out.println("Escribe el dni del autor al que quieres añadir un libro");
        String dni=Comprobaciones.strin();
        
           CriteriaQuery   query = new CriteriaQuery(Autores.class, Where.equal("dni", dni));
            Objects<Autores> objects = odb.getObjects(query);
            
            if (!objects.isEmpty()) {
                a=objects.getFirst();
                System.out.println("Autor "+a.getNombre()+" encontrado");
            
         String titulo,  categoria;
        int isbn;
        float precio;
        Random r=new Random();
//        titulo="La caza del pesacado  "+r.nextInt(445);
//        categoria="Tragicomedia"+r.nextInt(445);
//        isbn=r.nextInt(445);
//        precio=r.nextInt(445);
System.out.println("Escribe la titulo");
titulo= Comprobaciones.strin();
System.out.println("Escribe la categoria");
categoria= Comprobaciones.strin();
System.out.println("Escribe la isbn");
isbn= Comprobaciones.entero();
System.out.println("Escribe la precio");
precio= Comprobaciones.floa();
                System.out.println("Escribe la fecha");
        Date fecha=Comprobaciones.fecha();
        
                Libros l=new Libros(isbn, titulo, categoria, precio, fecha);
            a.getLibros().add(l);
                odb.store(a);
    odb.commit();
        System.out.println("Libro dado de alta");
            }else{
                System.out.println("Ese autor no existe");
                
                

                
                
            }
        
    }
    
}
