package reservahoteles;

import Pojos.*;
import java.sql.Date;
import java.util.List;
import org.hibernate.Session;


 public class Consultas{
 
public static void consultas(){  
  int op;
        
        do{
            System.out.println("1 Cliente reserva\n2 Consultas2\n3 Salir\n4 Habitaciones\n5 Reservas\n6 Clientes\n");
            op=Comprobaciones.opcion(7);
        
            switch(op){
case 1: Consultas0();break;
case 2: Consultas1();break;

case 4: Consultas3();break;
case 5: Reservas();break;
case 6: Clientes();break;
                  } 
      }while(op!=3);
      
    }

public static void Consultas0(){


}

public static void Consultas1(){


}



public static void Consultas3(){
Session s=NewHibernateUtil.getSession();
   List<Habitaciones>c= todos('a', s);
    System.out.println("ID    OCUPADO    HOTEL   PRECIO  ");
   for(Habitaciones i:c){
       System.out.println(i.getId()+" id  boolean  "+i.isOcupado()+"   hotel  "+i.getIdhotel().getNombre()+"  "+i.getPrecio());}
       s.close();

}

public static void Reservas(){
Session s=NewHibernateUtil.getSession();
   List<Reservas>c= todos('r', s);
    System.out.println("getFechaEntrada       getFechaSalida ");
   for(Reservas i:c){
       System.out.println(i.getFechaEntrada()+"         "+i.getFechaSalida()+i.getHabitacion());}
       s.close();

}

public static void Clientes(){
Session s=NewHibernateUtil.getSession();
   List<Clientes>c= todos('c', s);
    System.out.println("Dni       nombre     Telefono");
   for(Clientes i:c){
       System.out.println(i.getDni()+"         "+i.getNombre()+"     "+i.getTelefono());
   }       s.close();

}

     public static List todos(char a,Session s){
         List o=null;
         switch(a){
             case 'h':o=s.createCriteria(Hoteles.class).list();  break;
          case 'r':o=s.createCriteria(Reservas.class).list();  break;
           case 'a':o=s.createCriteria(Habitaciones.class).list();  break;
            case 'c':o=s.createCriteria(Clientes.class).list();  break;        
         }
     
     return o;
     }
     
          public static Object get(char a,Session s){
            boolean nul=true;String co=null;
          Object o=null;
          do{
              Date fecha=null;
               int cod=0;
              nul=false;
              if(a=='r'){fecha=Comprobaciones.fecha();}else{
              if(a!='c'){
              System.out.println("Escribe el codigo ");
               cod=Comprobaciones.entero();}
              else{System.out.println("scribe el dni");co=Comprobaciones.strin();}}
                switch(a){
             case 'h':o=s.get(Hoteles.class,cod); System.out.println(); break;
          case 'r':o=s.get(Reservas.class,fecha); System.out.println(); break;
            case 'a':o=s.get(Habitaciones.class,cod);System.out.println(); break;
            case 'c':o=s.get(Clientes.class,co); System.out.println(); break;            
         }
          if(o==null) {nul=true;System.out.println("Inexistente escribe un codigo valido");}
          }while(nul);
          return o;
          }

}
