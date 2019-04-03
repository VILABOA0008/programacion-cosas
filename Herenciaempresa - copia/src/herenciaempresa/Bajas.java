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
public class Bajas {
     public static void bajas(){
          Session s;
       Consultas.alquiler();
         s=NewHibernateUtil.getSession();
         System.out.println("Escribe el codigo del coche de alquiler que quieras dar de baja");
         Alquiler a=(Alquiler)Consultas.get('a', s);
         System.out.println(a.getCodigocoche());
                 s.close();
          s=NewHibernateUtil.getSession();
         s.beginTransaction();
       
                 s.delete(a);    
         s.getTransaction().commit();
           System.out.println("Borrado");
         s.close();
    
    }
}
