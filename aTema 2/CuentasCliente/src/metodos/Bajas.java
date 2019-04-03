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
public class Bajas {
    
    public static void bajas(){
     
        
        ODB odb = ODBFactory.openClient("localhost",8000,"cuentoscorrientes");
        //187    Manolito84
        
        String  nombre,numero;
        Consultas.clientes();
        System.out.println("\n \nEscribe el nombre del cliente");
        nombre=Comprobaciones.strin();
        if(Consultas.plazocliente(nombre,'n')){
        
        System.out.println("Escribe el numero de la cuenta plazo");        
        numero=Comprobaciones.cuenta();
   

        
      CriteriaQuery   query = new CriteriaQuery(Cliente.class, Where.equal("nombre", nombre) );
            Objects<Cliente> objects = odb.getObjects(query);
            
            if (!objects.isEmpty()) {
              while(objects.hasNext()){
                    Cliente c= objects.next();
           for(Cuenta i:c.getCuentas() ){
                 
                 if(i instanceof CuentaPlazo&&i.getNumero().equalsIgnoreCase(numero)){
                     System.out.println("d");
                    odb.delete(i);
                    odb.commit();
                    System.out.println("Cuenta plazo dada de baja");
                    }
           }
                }             
                
    }else{System.out.println("No hay tal cuenta");}
            odb.close();
    }else{System.out.println("Ese cliente no tiene ninguna cuenta plazp");}
    }
}