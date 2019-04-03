/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodos;

import clases.Autores;
import clases.Libros;
import static metodos.Altas.autores;
import static metodos.Altas.libros;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

/**
 *
 * @author a16pablovc
 */
public class Modificaciones {
    
    public static void modificaciones(){
    
            int op;
        
        do{
        
            System.out.println(" 1 direccion de autor \n 2 precio de libro \n 3 Salir");
             op=Comprobaciones.opcion(3);
        
             switch(op){
             
                 case 1:direccion();break;
                 case 2:precio();break;
              
             
             }       
                        
        }while(op!=3);
    
    
    }
    
    public static void direccion(){
        autores();
        System.out.println("Escribe el dni del autor");
        String dni=Comprobaciones.strin();
                ODB odb = ODBFactory.openClient("localhost",8000,"libros_autores");
                
                
          CriteriaQuery   query = new CriteriaQuery(Autores.class, Where.equal("dni", dni));
            Objects<Autores> objects = odb.getObjects(query);
            
            if (!objects.isEmpty()) {
                System.out.println("Autor encontrado");
            Autores a=objects.getFirst();
                System.out.println("La direccion actual es "+a.getDireccion());
                System.out.println("Escriba la nueva direccion");
                String direc=Comprobaciones.strin();
                System.out.println("asdas");
                a.setDireccion(direc);
                System.out.println(a.getDireccion());
                odb.store(a);
                odb.commit();
                odb.close();
                System.out.println("Autor modificado");
            }else{ System.out.println("No existe ningun autor con ese DNI");
            
            
            }
    
    
    }
    
        public static void precio(){
    
ODB odb = ODBFactory.openClient("localhost",8000,"libros_autores");
        //187    Manolito84
        
        String  nombre;
        Consultas.autores();
        System.out.println("Escribe le nombre del autor");
        nombre=Comprobaciones.strin();

 //       La caza del pesacado  43
//      Manolito246
        
      CriteriaQuery   query = new CriteriaQuery(Autores.class, Where.equal("nombre", nombre) );
            Objects<Autores> objects = odb.getObjects(query);
            Autores a=null;
                     if (!objects.isEmpty()) {
                 System.out.println("    TITULO                    PRECIO ");
              while(objects.hasNext()){
                    a=objects.next();
                for (Libros i: a.getLibros()){
                                   System.out.printf("%S %10s  \n",i.getTitulo(),i.getPrecio());    
                    }
                
                }
              
        
    
            
        if(a!=null){

        System.out.println("Escribe el TITULO del libro");
        String  titulo=Comprobaciones.strin();
                
                
     
            System.out.println("ds");
                for (Libros i: a.getLibros()){
                    if(i.getTitulo().equalsIgnoreCase(titulo)){
                        Libros l=i;
                        System.out.println("Libro encontrado el precio es "+l.getPrecio()+"€");
                        System.out.println("Escribe el nuevo precio");
                        float precio=Comprobaciones.floa();
                        l.setPrecio(precio);
                    odb.store(l);
                    odb.commit();
                
                    }
                }
                
              
              
  
    }}else{System.out.println("No hay tal autor");}
       odb.close();
    }
    
    
    
}