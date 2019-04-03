package reservahoteles;

import Pojos.*;
import java.sql.Date;
import java.util.List;

import org.hibernate.Session;


 public class Altas{
 
public static void altas(){  
  int op;
        
        do{
            System.out.println("1 Clientes\n2 Hoteles\n3 Habitaciones\n4 Reservas\n5 Salir\n");
            op=Comprobaciones.opcion(5);
        
            switch(op){
case 1: Clientes();break;
case 2: Hoteles();break;
case 3: Habitaciones();break;
case 4: Reservas();break;
                  } 
      }while(op!=5);
      
    }

public static void Clientes(){
System.out.println("Escribe el dni del cliente");
String dni=Comprobaciones.strin();
  //String dni=Comprobaciones.dni();
    System.out.println("Escribe el nombre del cliente");
    String nombre=Comprobaciones.strin();
     System.out.println("Escribe el telefono del clliente");
     String telefono=Comprobaciones.strin();
    
    
Clientes c=new Clientes(dni, nombre, telefono);
    guardar(c);

}

public static void Hoteles(){

    System.out.println("Escribe el nombre del hotel");
    String nombre=Comprobaciones.strin();
     System.out.println("Escribe el telefono del hotel");
     String telefono=Comprobaciones.strin();
    
    
Hoteles h=new Hoteles( nombre, telefono);
    guardar(h);
}

public static void Habitaciones(){
System.out.println("Escribe el id de la habitacion");
    int nombre=Comprobaciones.entero();
     System.out.println("Escribe el precio de la habitacionl");
     float precio =Comprobaciones.floa();
     Session s=NewHibernateUtil.getSession();
    List<Hoteles> l= Consultas.todos('h', s);
        System.out.println(l.size()+"  size");
    for(  Hoteles  i:l){
        System.out.println(i.getIdhotel());    
    }
    
 Hoteles ho=(Hoteles)Consultas.get('h', s);
 s.close();
Habitaciones h=new Habitaciones(nombre, ho, precio);
    guardar(h);


}

public static void Reservas(){
    Reservas r;
    
System.out.println("Escribe la fecha de entrada");
   Date entrada=Comprobaciones.fecha();
     System.out.println("Escribe la fechad de salida");
     Date salida=Comprobaciones.fecha();
     Session s=NewHibernateUtil.getSession();
    List<Hoteles> l= Consultas.todos('h', s);
         System.out.println("COD GOTE");
    for(  Hoteles  i:l){
        System.out.println(i.getIdhotel());}
     Hoteles ho=(Hoteles)Consultas.get('h', s);
         List<Clientes> cl= Consultas.todos('c', s);
              System.out.println("DNI CLIENTES");
      for(  Clientes  i:cl){
        System.out.println(i.getDni()+"  "+i.getNombre());}
     Clientes cli=(Clientes)Consultas.get('c', s);
         List<Habitaciones> ha= Consultas.todos('a', s);
         System.out.println("Id habi");
      for(  Habitaciones  i:ha){
        System.out.println(i.getId());}
     Habitaciones hab=(Habitaciones)Consultas.get('a', s);
    


r=new Reservas(ho, entrada, salida, cli);
r.addPropertyChangeListener(hab);
r.setHabitacion(hab);

   
 s.close();
    guardar(r);


    guardar(hab);

  

  




}

public static void guardar(Object o){
Session s=NewHibernateUtil.getSession();
s.beginTransaction();
s.saveOrUpdate(o);
s.getTransaction().commit();
s.close();

}
}
