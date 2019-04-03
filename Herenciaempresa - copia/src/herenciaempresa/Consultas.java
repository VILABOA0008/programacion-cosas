/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herenciaempresa;

import Pojos.*;
import java.sql.Date;
import java.util.List;
import java.util.Set;
import org.hibernate.Session;

/**
 *
 * @author a16pablovc
 */
public class Consultas {
    public static void consultas(){    
     int op;
        do{
            System.out.println("1 Todas las empresas con sus coche de venta y alquiler \n2 Coches de alquiler de una empresa"
                    + " \n3 Calcular importe entre dos fechas \n4 Salir ");
            op=Comprobaciones.opcion(9);
        switch(op){
            case 1:todo();break;
            case 2:alquiler_de_una_empresa();break;
            case 3:fechas();break;
            case 5:empresa();break;
             case 6:venta();break;
             case 7:alquiler();break;
             case 8:usos();break;        
        }
        
        }while(op!=4);      
    
    }
    
       public static void todo(){
        Session s;
        s=NewHibernateUtil.getSession();
        List<Empresas> e=todos('e', s);
         System.out.println("Cif      Nombre   Telefono ");
             
        for(Empresas i:e){           
            System.out.printf("%s  %10s %8s \n",i.getCif(),i.getNombre(),i.getTlf());  
    
          if(i.getCoches().size()>0){    System.out.println("\n      Codigo      Marca   Modelo    Precio     Tipo ");}
              for(Coches c:i.getCoches()){                  
              
                 if(c instanceof Alquiler){                     
                       
           System.out.printf("     %s  %10s %8s %7.2f   %6c \n",c.getCodigocoche(),c.getMarca(),c.getModelo(),((Alquiler) c).getPrecio(),((Alquiler) c).getTipo());  
                 }else{   if(c instanceof Venta){
                  
                     System.out.printf("     %s  %10s %8s %7.2f \n",c.getCodigocoche(),c.getMarca(),c.getModelo(),((Venta) c).getPrecio());  }}
                 }System.out.println("\n \n");
                System.out.println("Cif      Nombre   Telefono ");
              }
                     
              s.close();  
        }
     
        
      
    public static void alquiler_de_una_empresa(){
           Session s;
        s=NewHibernateUtil.getSession();
           System.out.println("Cif      Nombre   Telefono ");
        empresa();
        Empresas e=(Empresas)get('e', s);          
        if(e.getCoches().isEmpty()){System.out.println(" Esta empresa ni tiene coches de alquiler");}else{
        System.out.println("Codigo      Marca   Modelo    Precio  Tipo ");
              for(Coches c:e.getCoches()){                 
                 if(c instanceof Alquiler){                   
                           
           System.out.printf("%s  %10s %8s %7.2f   %6c \n",c.getCodigocoche(),c.getMarca(),c.getModelo(),((Alquiler) c).getPrecio(),((Alquiler) c).getTipo());  }
              }
              
        }
              s.close();  
        
    }
    
    public static void fechas(){
             Date alquiler,entrega;  boolean fech;
           
             float precio=0f;
             
        Session s;
        s=NewHibernateUtil.getSession();
        List<Alquiler> la=todos('a', s);
          System.out.println("Codigo      Marca   Modelo    Precio  Tipo ");
        for(Alquiler i:la){          
            System.out.printf("%s  %10s %8s %7.2f   %6c \n",i.getCodigocoche(),i.getMarca(),i.getModelo(),i.getPrecio(),i.getTipo());  }
            s.close();    
            
        System.out.println("Introduzca el codigo del coche");       
        s=NewHibernateUtil.getSession();
        Alquiler a=(Alquiler)Consultas.get('a', s);
        
         
        s=NewHibernateUtil.getSession();
        Set<Usos> u=a.getUsos();
        if(u.isEmpty()){System.out.println("EL COCHE NO TIENE USOS \n");}else{
          System.out.println("Coche  Fecha Alquiler    Fecha Entrga    Precio   ");
        for(Usos i:u){          
            System.out.printf("%s  %15s  %17s   %6.2f \n",i.getCodigoalquiler().getCodigocoche(),i.getFechaAlquiler(),i.getFechaEntrega(),i.getImporteAPagar()); }
        s.close();    
        
        if(a.getUsos()!=null){
            do{
        fech=false;
        System.out.println("Escriba la primera fecha");
     alquiler=Comprobaciones.fecha();
          System.out.println("Escriba la segunda fecha");
      entrega=Comprobaciones.fecha();            
              if(alquiler.after(entrega)){fech=true;System.out.println("La fecha de alquier es anterior a la de la entrega");}
    }while(fech);
            float preciototal=0f;
              Date auxalq=alquiler,auxent=entrega;
        for(Usos j:a.getUsos()){
            preciototal+=j.getImporteAPagar();
            if(alquiler.before(j.getFechaAlquiler())&&entrega.after(j.getFechaEntrega())){precio+=j.getImporteAPagar();}
        }
        if(precio==0){System.out.println("No hay registros en tres esas dos fechas");}else{
            System.out.println("Importe   Empresa   Marca    Modelo      Precio Total \n");
              System.out.printf("%.2f  %10s %8s  %6s %7.2f \n \n \n",precio,a.getEmpresa().getCif(),a.getMarca(),a.getModelo(),preciototal); 
        }
        }
        }
    
    }
    
    public static void empresa(){
        Session s;
        s=NewHibernateUtil.getSession();
        List<Empresas> e=todos('e', s);
         System.out.println("Cif      Nombre   Telefono ");
        for(Empresas i:e){           
            System.out.printf("%s  %10s %8s \n",i.getCif(),i.getNombre(),i.getTlf());  }
        s.close();    
    }
        public static void venta(){
        Session s;
        s=NewHibernateUtil.getSession();
        List<Venta> v=todos('v', s);
          System.out.println("Codigo      Marca   Modelo    Precio ");
        for(Venta i:v){          
            System.out.printf("%s  %10s %8s %7.2f \n",i.getCodigocoche(),i.getMarca(),i.getModelo(),i.getPrecio());  }
        s.close();    
    }
            public static void alquiler(){
        Session s;
        s=NewHibernateUtil.getSession();
        List<Alquiler> a=todos('a', s);
          System.out.println("Codigo      Marca   Modelo    Precio  Tipo ");
        for(Alquiler i:a){          
            System.out.printf("%s  %10s %8s %7.2f   %6c \n",i.getCodigocoche(),i.getMarca(),i.getModelo(),i.getPrecio(),i.getTipo());  }
        s.close();    
    }
            
             public static void usos(){
        Session s;
        s=NewHibernateUtil.getSession();
        List<Usos> u=todos('u', s);
          System.out.println("Coche  Fecha Alquiler    Fecha Entrga    Precio   ");
        for(Usos i:u){          
            System.out.printf("%s  %15s  %17s   %6.2f \n",i.getCodigoalquiler().getCodigocoche(),i.getFechaAlquiler(),i.getFechaEntrega(),i.getImporteAPagar()); }
        s.close();    
    }
            
     public static List todos(char a,Session s){
         List o=null;
         switch(a){
             case 'e':o=s.createCriteria(Empresas.class).list();  break;
          case 'a':o=s.createCriteria(Alquiler.class).list();  break;
           case 'u':o=s.createCriteria(Usos.class).list();  break;
            case 'v':o=s.createCriteria(Venta.class).list();  break;        
         }
     
     return o;
     }
     
          public static Object get(char a,Session s){
            boolean nul=true;
          Object o=null;
          do{
              nul=false;
              
                String cod=Comprobaciones.strin();
                switch(a){
             case 'e':o=s.get(Empresas.class,cod); System.out.println(); break;
          case 'a':o=s.get(Alquiler.class,cod); System.out.println(); break;
           case 'u':break;
            case 'v':o=s.get(Venta.class,cod); System.out.println(); break;            
         }
          if(o==null) {nul=true;System.out.println("Inexistente escribe un codigo valido");}
          }while(nul);
          return o;
          }
}
