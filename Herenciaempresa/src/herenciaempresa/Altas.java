/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herenciaempresa;


import Pojos.*;
import java.sql.Date;
import org.hibernate.Session;

/**
 *
 * @author a16pablovc
 */
public class Altas {
    public static void altas(){
        Alquiler u=new Alquiler();
        
        int op;
        do{
            System.out.println("1 Empresa \n2 Coches Venta \n3 Coches alquiler \n4 Usos \n5 Salir");
            op=Comprobaciones.opcion(5);
        switch(op){
            case 1:empresa();break;
            case 2:venta();break;
            case 3:alquiler();break;
            case 4:usos();break;
        
        }
        
        }while(op!=5);      
    
    }
    
    public static void empresa(){
    String cif,nombre,tlf;

        System.out.println("Escriba el cif");
    cif=Comprobaciones.strin();
       System.out.println("Escriba el nombre");
    nombre=Comprobaciones.strin();
      System.out.println("Escriba el telefono");
    tlf=Comprobaciones.strin();
    Empresas e=new Empresas(cif, nombre, tlf);
        guarda(e);
       System.out.println("Guardado");
        
    }
    
      public static void venta(){
        String codigo,marca,modelo;Empresas e;
   
          System.out.println("Escriba el precio");
    float precio=Comprobaciones.floa();
        System.out.println("Escriba el codigo del coche");
    codigo=Comprobaciones.cod('v');
      System.out.println("Escriba la marca del coche");
    marca=Comprobaciones.strin();
      System.out.println("Escriba el modelo del coche");
    modelo=Comprobaciones.strin();
    Consultas.empresa();
       Session s=NewHibernateUtil.getSession();       
          System.out.println("Escribe el codigo de la empresa a la qu esta asociada el coche ");
          e=(Empresas) Consultas.get('e', s);               
          s.close();
         Venta v=new Venta(precio, codigo, marca, modelo, e);
        guarda(v);
        System.out.println("Guardado");
        
    
    }
      
        public static void alquiler(){
        String codigo,marca,modelo;Empresas e;
   
        System.out.println("Escriba el tipo");
    char tipo=Comprobaciones.tipo();
          System.out.println("Escriba el precio diario");
    float precio=Comprobaciones.floa();
            System.out.println("Escriba el codigo del coche");
    codigo=Comprobaciones.cod('a');
      System.out.println("Escriba la marca del coche");
    marca=Comprobaciones.strin();
      System.out.println("Escriba el modelo del coche");
    modelo=Comprobaciones.strin();
      Consultas.empresa();
       Session s=NewHibernateUtil.getSession();
            System.out.println("Escribe el codigo de la empresa a la qu esta asociada el coche ");
       
          e=(Empresas) Consultas.get('e', s);
              
          
                  s.close();
    Alquiler a=new Alquiler(tipo, precio, codigo, marca, modelo, e);
        guarda(a);
        System.out.println("Guardado");
        
    
    }
        
          public static void usos(){
       Alquiler a;Date alquiler,entrega;
       
       
         Consultas.alquiler();
                 Session s=NewHibernateUtil.getSession();
              System.out.println("Escribe el codigo del coche de alquiler");
          a=(Alquiler) Consultas.get('a', s);
       if(a.getTipo()=='r' ||a.getTipo()=='R'){System.out.println("Ese cohe esta reservado");}else{
  
    boolean fech;int fecha;
    do{
        fech=false;
        System.out.println("Escriba la fecha de alquiler");
     alquiler=Comprobaciones.fecha();
          System.out.println("Escriba la fecha de entrega");
      entrega=Comprobaciones.fecha();
              System.out.println(alquiler+"  alquiler   entrega   "+entrega);
              fecha=(int)((entrega.getTime()-alquiler.getTime())/86400000);        
              if(fecha<0){fech=true;System.out.println("La fecha de alquier es anterior a la de la entrega");}
    }while(fech);    
                 float precio=(float)(fecha*a.getPrecio());
                 System.out.println(alquiler+"    entrega   "+entrega+"   precio"+ precio);
                Usos u=new Usos(alquiler, entrega, precio , a);
                 s.close();
                    guarda(u);

       if( System.currentTimeMillis()>alquiler.getTime()&&System.currentTimeMillis()<entrega.getTime()){
        a.setTipo('R');
           guarda(a);}
        System.out.println("Guardado");}
          
          }
    public static void guarda(Object o){
    Session s;
      
        s=NewHibernateUtil.getSession();
          s.beginTransaction();
        s.saveOrUpdate(o);
        s.getTransaction().commit();
        s.close();
    
    }
}
