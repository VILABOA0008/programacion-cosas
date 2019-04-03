/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodos;

import clases.Autores;
import clases.Libros;
import java.sql.Date;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.ObjectValues;
import org.neodatis.odb.Objects;
import org.neodatis.odb.Values;
import org.neodatis.odb.core.query.criteria.And;
import org.neodatis.odb.core.query.criteria.ICriterion;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;
import org.neodatis.odb.impl.core.query.values.ValuesCriteriaQuery;

/**
 *
 * @author a16pablovc
 */
public class Consultas {
    
    public static void consultas(){
    
            int op;
        
        do{
            System.out.println("\n");
            System.out.println(" 1 Nacionalidad italiana \n 2 Libros por autor entre dos fechas \n 3 Españoles menores de 60  \n 4 autores por nacion   \n 5 Libros de cada autor \n 6 datos del libro y el autor \n 7 Salir");
             op=Comprobaciones.opcion(9);
        
             switch(op){
             
                 case 1: italianos();break;
                 case 2:entrefechas();break;
                 case 3:españolesjovenes();break;
                 case 4:autoresnacion();break;
                 case 5:librosdeautor();break;
                 case 6:datosdellibro();break;

             
             }
        
            
            
        }while(op!=7);
    
    
    }
    
                   public static void autoresnacion(){
                       
    
         ODB odb = ODBFactory.openClient("localhost",8000,"libros_autores");
        
         
             Values   query = odb.getValues(new ValuesCriteriaQuery(Autores.class ).field("nacionalidad").count("dni").groupBy("nacionalidad"));
            //Objects<Autores> objects = odb.getObjects(query);           
              while(query.hasNext()){
                  ObjectValues o=(ObjectValues)query.next();
               
                  System.out.println(o.getByAlias("nacionalidad")+"    "+o.getByIndex(1));
                
                }
              
           
    
             odb.close();
    }
     public static void entrefechas(){
                         System.out.println("Escribe el nombre del autor del que quieras ver sus libros \n");
                         autores();
                         String nombre=Comprobaciones.strin();
                         System.out.println("Escribe la primera fecha");
                         Date fecha1=Comprobaciones.fecha();
                        System.out.println("Escribe la segunda fecha");
                         Date fecha2=Comprobaciones.fecha();
    
         ODB odb = ODBFactory.openClient("localhost",8000,"libros_autores");
        
         //ICriterion cr=new And().add(Where.lt("edad", 60)) .add(Where.equal("nacionalidad", "española"));
             CriteriaQuery   query = new CriteriaQuery(Autores.class, Where.equal("nombre", nombre) );
            Objects<Autores> objects = odb.getObjects(query);
              System.out.println("\n");
            if (!objects.isEmpty()) {
            Autores a=objects.getFirst();
            
              
       System.out.printf("%-50s %-10s  \n","titulo","precio");
               for(Libros i:a.getLibros()){
                  if(fecha2.after(i.getFecha())&&fecha1.before(i.getFecha())){
                                System.out.printf("%-50s %-10s  \n",i.getTitulo(),i.getPrecio());    
                    }}
               }
            
                      
            
            odb.close();
    
    }
    /*
                   public static void entrefechas(){
                         System.out.println("Escribe el nombre del autor del que quieras ver sus libros");
                         autores();
                         String nombre=Comprobaciones.strin();
                         System.out.println("Escribe la primera fecha");
                         Date fecha1=Comprobaciones.fecha();
                        System.out.println("Escribe la segunda fecha");
                         Date fecha2=Comprobaciones.fecha();
    
         ODB odb = ODBFactory.openClient("localhost",8000,"libros_autores");
        
         //ICriterion cr=new And().add(Where.lt("edad", 60)) .add(Where.equal("nacionalidad", "española"));
             CriteriaQuery   query = new CriteriaQuery(Autores.class, Where.equal("nombre", nombre) );
            Objects<Autores> objects = odb.getObjects(query);
            if (!objects.isEmpty()) {
            Autores a=objects.getFirst();
            
            
            ICriterion cr=new And().add(Where.gt("fecha", fecha1)) .add(Where.lt("fecha", fecha2)) ;
                query = new CriteriaQuery(Libros.class, cr);
            Objects<Libros> ob = odb.getObjects(query);
            
                       System.out.println("");
            if (!ob.isEmpty()) {
                 System.out.println("    TITULO                    PRECIO ");
              while(ob.hasNext()&&ob.next().ge){
                  System.out.println(ob.next().getTitulo());
                //for (Libros i: objects.next().getLibros()){
                    //               System.out.printf("%S %10s  \n",i.getTitulo(),i.getPrecio());    
                 //   }
                
                }}else{System.out.println("No hay libros entre esas 2 fechas");}
            }
            odb.close();
    
    }*/
    

                          public static void datosdellibro(){
                         
                         libros();
                         System.out.println("\n Escribe el titulo del libro ");
                         String titulo=Comprobaciones.strin();
    
         ODB odb = ODBFactory.openClient("localhost",8000,"libros_autores");        
         
             CriteriaQuery   query = new CriteriaQuery(Autores.class);
            Objects<Autores> objects = odb.getObjects(query);
            
            if (!objects.isEmpty()) {
            
              while(objects.hasNext()){
Autores a=objects.next();
                for (Libros i: a.getLibros()){
                                  if(i.getTitulo().equals(titulo)){
                                      System.out.println("\n Autor "+a.getNombre()+"   ncionalidad  "+a.getNacionalidad()+"  edad   "+a.getEdad());
                                      System.out.println("Libro "+i.getTitulo()+"   categoria "+i.getCatyegoria()+"   precio "+i.getPrecio()+"   fecha "+i.getFecha());
                                  
                }                    }                
                }
    }
                        odb.close();
    }
    
    
      public static void italianos(){
    
         ODB odb = ODBFactory.openClient("localhost",8000,"libros_autores");
        
              
      CriteriaQuery   query = new CriteriaQuery(Autores.class, Where.equal("nacionalidad", "Italiana") );
            Objects<Autores> objects = odb.getObjects(query);
            
            if (!objects.isEmpty()) {
                System.out.printf("%-10s %-14s %-14s %-9s \n","dni","nombre","nacionalidad","edad");
              while(objects.hasNext()){
Autores a=objects.next();
                  System.out.printf("%-10s %-34s %-14s %-9s \n",a.getDni(),a.getNombre(),a.getNacionalidad(),a.getEdad());                 
               
                    }
    }
                       odb.close();
    }
      
            public static void españolesjovenes(){
    
         ODB odb = ODBFactory.openClient("localhost",8000,"libros_autores");
        
                ICriterion cr=new And().add(Where.lt("edad", 60)) .add(Where.equal("nacionalidad", "española"));
                        
                  
      CriteriaQuery   query = new CriteriaQuery(Autores.class,cr );
            Objects<Autores> objects = odb.getObjects(query);
            
            if (!objects.isEmpty()) {
                    System.out.printf("%-10s %-14s %-14s %-9s \n","dni","nombre","nacionalidad","edad");
              while(objects.hasNext()){
Autores a=objects.next();
                   System.out.printf("%-10s %-34s %-14s %-9s \n",a.getDni(),a.getNombre(),a.getNacionalidad(),a.getEdad());               
               
                    }
         
    }
               odb.close();
    }
            
          
            
            
                     public static void librosdeautor(){
                         System.out.println("Escribe el dni del autor del que quieras ver sus libros \n");
                         autores();
                         String dni=Comprobaciones.strin();
    
            ODB odb = ODBFactory.openClient("localhost",8000,"libros_autores");        
         
            CriteriaQuery   query = new CriteriaQuery(Autores.class, Where.equal("dni", dni) );
            Objects<Autores> objects = odb.getObjects(query);           
            
            
            if (!objects.isEmpty()) {
                 System.out.printf("%-50s %-30s %n","titulo","precio");
              while(objects.hasNext()){

                for (Libros i: objects.next().getLibros()){
                                   System.out.printf("%-50s %-30s  %n",i.getTitulo(),i.getPrecio());    
                    }                
                }            
            }
              odb.close();
    }
      
    
    public static void autores(){
    
         ODB odb = ODBFactory.openClient("localhost",8000,"libros_autores");
        
        Values val=odb.getValues(new ValuesCriteriaQuery(Autores.class)
                .field("dni")
                .field("nombre")
                .field("direccion")
            );

        while(val.hasNext()){
        ObjectValues ov=(ObjectValues)val.next();
        
        System.out.println("dni: "+ov.getByAlias("dni")+"  Nombre: "+ov.getByAlias("nombre")+"  Direccion: "+ov.getByAlias("direccion"));
    }
        System.out.println("\n");
        odb.close();
    
    }
    
        public static void libros(){
       ODB odb = ODBFactory.openClient("localhost",8000,"libros_autores");
  Values val=odb.getValues(new ValuesCriteriaQuery(Libros.class)
                .field("isbn")
                .field("titulo")
            );
     
        while(val.hasNext()){
        ObjectValues ov=(ObjectValues)val.next();
        
        System.out.println("isbn: "+ov.getByAlias("isbn")+"  titulo: "+ov.getByAlias("titulo"));
             }
     odb.close();
        }
}

/*

 public static void entrefechas(){
                         System.out.println("Escribe el nombre del autor del que quieras ver sus libros");
                         autores();
                         String nombre=Comprobaciones.strin();
                         System.out.println("Escribe la primera fecha");
                         Date fecha1=Comprobaciones.fecha();
                        System.out.println("Escribe la segunda fecha");
                         Date fecha2=Comprobaciones.fecha();
    
         ODB odb = ODBFactory.openClient("localhost",8000,"libros_autores");
        
         //ICriterion cr=new And().add(Where.lt("edad", 60)) .add(Where.equal("nacionalidad", "española"));
             CriteriaQuery   query = new CriteriaQuery(Autores.class, Where.equal("nombre", nombre) );
            Objects<Autores> objects = odb.getObjects(query);
            if (!objects.isEmpty()) {
            Autores a=objects.getFirst();
            
            
       System.out.println("    TITULO                    PRECIO ");
               for(Libros i:a.getLibros()){
                  if(fecha2.after(i.getFecha())&&fecha1.before(i.getFecha())){
                                System.out.printf("%S %10s  \n",i.getTitulo(),i.getPrecio());    
                    }}
               }
            
                      
            
            odb.close();
    
    }
*/