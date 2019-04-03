/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herenciaempresa;

import Pojos.*;
import org.hibernate.Session;

/**
 *
 * @author mi
 */
public class Modificaciones {
    
    public static void modificaciones(){
    int op;
    do{
   Session s=NewHibernateUtil.getSession();
   s.close();
        System.out.println("1 Modificar el precio de venta \n2 Modificar el precio del dia \n3 Salir");
         op=Comprobaciones.opcion(4);
    switch(op){    
        case 1:venta();break;
        case 2:dia();break;
    }
    }while(op!=3);
    }
    
    public static void venta(){
    Consultas.venta();
    
        Session s;
        s=NewHibernateUtil.getSession();
          System.out.println("Escribe el codigo del coche a modificar su precio");
        Venta v=(Venta)Consultas.get('v', s);
        System.out.println("Precio actual "+v.getPrecio());
        System.out.println("Escriba el nuevo precio");
        float precio=Comprobaciones.floa();
        v.setPrecio(precio);
        s.close();
        Altas.guarda(v);
    }
       public static void dia(){
               Consultas.alquiler();
      
        Session s;
        s=NewHibernateUtil.getSession();
        System.out.println("Escribe el codigo del coche de alquiler a modificar su precio diario");
        Alquiler a=(Alquiler)Consultas.get('a', s);
        System.out.println("Precio diario  actual "+a.getPrecio());
        System.out.println("Escriba el nuevo precio");
        float precio=Comprobaciones.floa();
        a.setPrecio(precio);
        s.close();
        Altas.guarda(a);    
    
    }
}
