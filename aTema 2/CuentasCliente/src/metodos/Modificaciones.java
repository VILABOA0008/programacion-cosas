/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodos;


import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;
import pojos.Cliente;
import pojos.Cuenta;
import pojos.CuentaPlazo;

/**
 *
 * @author a16pablovc
 */
public class Modificaciones {
       
            public static void modificaciones(){
        ODB odb = ODBFactory.openClient("localhost",8000,"cuentoscorrientes");
        //187    Manolito84
        
        String  dni,numero;
        Consultas.clientes();
        System.out.println("Escribe el dni del cliente");
        dni=Comprobaciones.strin();
        if(Consultas.plazocliente(dni,'d')){
        
        System.out.println("Escribe el numero de la cuenta plazo");        
        numero=Comprobaciones.strin();
   

        
      CriteriaQuery   query = new CriteriaQuery(Cliente.class, Where.equal("dni", dni) );
            Objects<Cliente> objects = odb.getObjects(query);
            
            if (!objects.isEmpty()) {
              while(objects.hasNext()){
                    Cliente c= objects.next();
           for(Cuenta i:c.getCuentas() ){
                 
                 if(i instanceof CuentaPlazo&&i.getNumero().equalsIgnoreCase(numero)){
                     System.out.println("dsa");
                    CuentaPlazo h=(CuentaPlazo)i;
                     System.out.println("Intereses actuales "+h.getIntereses());
                     System.out.println("Escribe los nuevos intereses");
                     float intereses=Comprobaciones.floa();
                    h.setIntereses(intereses);
                    odb.store(h);
                    odb.commit();
                    System.out.println("Cuenta plazo modificada");
                    }
           }
                }             
                
    }else{System.out.println("No hay tal cuenta");}
            odb.close();
    }else{System.out.println("Ese cliente no tiene ninguna cuenta plazo");}
    }
}