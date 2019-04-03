/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodos;

import clases.Autores;
import clases.Libros;
import java.util.Random;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.criteria.ICriterion;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

/**
 *
 * @author a16pablovc
 */
public class Bajas {
    
    public static void bajas(){
     
        
        ODB odb = ODBFactory.openClient("localhost",8000,"libros_autores");
        //187    Manolito84
        
        String  nombre;
        Consultas.autores();
        System.out.println("Escribe le nombre del autor");
        nombre=Comprobaciones.strin();
        System.out.println("Escribe el isbn del libro");
        int isbn;
        isbn=Comprobaciones.entero();
   

        
      CriteriaQuery   query = new CriteriaQuery(Autores.class, Where.equal("nombre", nombre) );
            Objects<Autores> objects = odb.getObjects(query);
            
            if (!objects.isEmpty()) {
              while(objects.hasNext()){

                for (Libros i: objects.next().getLibros()){
                    if(i.getIsbn()==isbn){
                    odb.delete(i);
                    odb.commit();
                        System.out.println("Libro dado de baja");
                    }
                
                }
              
              
  
    }}else{System.out.println("No hay tal autor");}
            odb.close();
    }
    
}