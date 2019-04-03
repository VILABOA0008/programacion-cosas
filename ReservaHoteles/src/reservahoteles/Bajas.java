package reservahoteles;

import Pojos.Habitaciones;
import Pojos.Reservas;
import java.sql.Date;
import org.hibernate.Session;


 public class Bajas{
 
public static void bajas(){  
  int op;
        
        do{
            System.out.println("1 Borrar Reserva\n2 Salir\n");
            op=Comprobaciones.opcion(2);
        
            switch(op){
case 1: Bajas0();break;
                  } 
      }while(op!=2);
      
    }

public static void Bajas0(){
    Reservas re=null;
    Consultas.Consultas3();
    Session s=NewHibernateUtil.getSession();
    Habitaciones a=(Habitaciones) Consultas.get('a', s);
Consultas.Reservas();


    for(Reservas i:a.getReservas()){
        System.out.println("id  "+i.getFechaEntrada());
    }
    String as="";
    System.out.println("Escribe la fecha");
    Date fecha=Comprobaciones.fecha();
    as+=fecha;
    as+=a;
    re=(Reservas) s.get(Reservas.class,as); 
    /*
       
      for(Reservas i:a.getReservas()){
          System.out.println(i.getFechaEntrada()+"   ee   "+fecha);
       if(i.getFechaEntrada().getTime()==fecha.getTime()){re=i;}
    }
    */
    
   s.close();
    s=NewHibernateUtil.getSession();
    s.beginTransaction();
    s.delete(re);
    s.getTransaction().commit();
    s.close();
}
}
