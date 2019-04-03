/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neodatis_libros_autores_servidor;

import clases.Autores;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.ObjectValues;
import org.neodatis.odb.Values;
import org.neodatis.odb.impl.core.query.values.ValuesCriteriaQuery;

/**
 *
 * @author a16pablovc
 */
public class Visualizar {
    public static void visualizar(){
    
   ODB odb = ODBFactory.openClient("localhost",8000,"libros_autores");
        
        Values val=odb.getValues(new ValuesCriteriaQuery(Autores.class)
                .field("dni")
            );
            System.out.println("inicio");
        while(val.hasNext()){
        ObjectValues ov=(ObjectValues)val.next();
        
        System.out.println("Nombre: "+ov.getByAlias("dni"));
    }
        System.out.println("fin");
        odb.close();
    }

}