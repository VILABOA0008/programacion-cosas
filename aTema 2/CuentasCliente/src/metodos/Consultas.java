/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodos;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Date;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.ObjectValues;
import org.neodatis.odb.Objects;
import org.neodatis.odb.Values;
import org.neodatis.odb.core.query.criteria.ICriterion;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;
import org.neodatis.odb.impl.core.query.values.ValuesCriteriaQuery;
import pojos.*;

/**
 *
 * @author a16pablovc
 */
public class Consultas {

    public static void consultas() {

        int op;

        do {
            System.out.println("\n");
            System.out.println(" 1 Clientes por C \n 2 Saldo mayor que 200.000 \n 3 Numeros rojos  \n 4 Saldo medio de las cuentas plazo  \n 5 Movimientos entre dos fechas \n 6 Salir");
            op = Comprobaciones.opcion(7);

            switch (op) {

                case 1:clientes();break;
                case 2:saldo();break;
                case 3:rojos();break;
                case 4:saldomedio();break;
                case 5:entrefechas();break;
    
            }

        } while (op != 6);

    }
    
        public static void mo() {
        ODB odb = ODBFactory.openClient("localhost", 8000, "cuentoscorrientes");
  CriteriaQuery query = new CriteriaQuery(Movimiento.class);
        Objects<Movimiento> objects = odb.getObjects(query);
         if (!objects.isEmpty()) {
             while(objects.hasNext()){
             System.out.println(objects.next().getHora().getTime());
             }
         }
        /*
        Values val = odb.getValues(new ValuesCriteriaQuery(Movimiento.class)
                
                .field("hora")
          
        );
  
        while (val.hasNext()) {
            ObjectValues ov = (ObjectValues) val.next();
            System.out.printf("%-10s    \n", ov.getByAlias("hora"));

        }*/
        odb.close();
    }
    

    
         public static void entrefechas(){
                         System.out.println("Escriba la cuenta corriente \n");
                         corriente();
                         String numero=Comprobaciones.strin();
   
    
         ODB odb = ODBFactory.openClient("localhost",8000,"cuentoscorrientes");
        
         //ICriterion cr=new And().add(Where.lt("edad", 60)) .add(Where.equal("nacionalidad", "española"));
        CriteriaQuery query = new CriteriaQuery(CuentaCorriente.class, Where.equal("numero", numero));
        Objects<CuentaCorriente> objects = odb.getObjects(query);
        if (!objects.isEmpty()) {
         
                
                          System.out.println("Escribe la primera fecha");
                         Date fecha1=Comprobaciones.fecha();
                        System.out.println("Escribe la segunda fecha");
                         Date fecha2=Comprobaciones.fecha();
                         
       System.out.printf("%-10s %-10s  \n","Cantidad","saldo");
               for(Movimiento i:objects.next().getMovimientos()){
                  if(fecha2.after(i.getFecha())&&fecha1.before(i.getFecha())){
                                System.out.printf("%-10s %-10s  \n",i.getCantidad(),i.getSaldo());    
                    }}
               }else{System.out.println("No existe esa cuenta corriente");}
            
                      
            
            odb.close();
    
    }
    
             public static void fechas() {
        ODB odb = ODBFactory.openClient("localhost", 8000, "cuentoscorrientes");
   int c=0;
        CriteriaQuery query = new CriteriaQuery(Cliente.class);
        Objects<Cliente> objects = odb.getObjects(query);        
      
        if(!objects.isEmpty()){
        while (objects.hasNext()) {
            Cliente a=objects.next();
          for (Cuenta i : a.getCuentas()) {
              
                        if(i.getSaldo()<0){c++;}                    
                  
                }

        }System.out.println("Hay "+c+" Clientes en numeros rojos");
        }else{System.out.println("No hacy clientes");}
        odb.close();
    }
    
          public static void rojos() {
        ODB odb = ODBFactory.openClient("localhost", 8000, "cuentoscorrientes");
   int c=0;
        CriteriaQuery query = new CriteriaQuery(Cliente.class);
        Objects<Cliente> objects = odb.getObjects(query);        
      
        if(!objects.isEmpty()){
        while (objects.hasNext()) {
            Cliente a=objects.next();
          for (Cuenta i : a.getCuentas()) {
              
                        if(i.getSaldo()<0){c++;}                    
                  
                }

        }System.out.println("Hay "+c+" Clientes en numeros rojos");
        }else{System.out.println("No hacy clientes");}
        odb.close();
    }

        public static void saldo() {
        ODB odb = ODBFactory.openClient("localhost", 8000, "cuentoscorrientes");
   
        CriteriaQuery query = new CriteriaQuery(Cliente.class);
        Objects<Cliente> objects = odb.getObjects(query);
        
        System.out.printf("%-10s %-18s  \n", "DNI", "Nombre");
        if(!objects.isEmpty()){
        while (objects.hasNext()) {
            Cliente a=objects.next();
          for (Cuenta i : a.getCuentas()) {
                if (i instanceof CuentaCorriente) {
                        if(i.getSaldo()>200000){
                                     System.out.printf("%-10s %-18s   \n", a.getDni(), a.getNombre());break;}                    
         
                }}

        }
        }else{System.out.println("No hacy clientes");}
        odb.close();
    }
    
    public static void saldomedio() {
        ODB odb = ODBFactory.openClient("localhost", 8000, "cuentoscorrientes");
            try{
           
        ObjectValues val = odb.getValues(new ValuesCriteriaQuery(CuentaPlazo.class).sum("saldo").count("count")).getFirst();
        float media=((BigDecimal)val.getByAlias("saldo")).floatValue()/((BigInteger)val.getByAlias("count")).floatValue();
         // Values val = odb.getValues(new ValuesCriteriaQuery(CuentaPlazo.class).avg("saldo"));
                System.out.println("");
                System.out.println(media);
        }catch(ArithmeticException e){System.out.println("d");}
        odb.close();
    }

    public static void Cclientes() {
        ODB odb = ODBFactory.openClient("localhost", 8000, "cuentoscorrientes");
        ICriterion criterio = Where.like("nombre", "C%");
        Values val = odb.getValues(new ValuesCriteriaQuery(Cliente.class, criterio)
                .field("dni")
                .field("nombre")
        );
        System.out.printf("%-10s %-18s  \n", "DNI", "Nombre");
        while (val.hasNext()) {
            ObjectValues ov = (ObjectValues) val.next();
            System.out.printf("%-10s %-18s   \n", ov.getByAlias("dni"), ov.getByAlias("nombre"));

        }
        odb.close();
    }

    public static boolean plazocliente(String cliente, char c) {
        String aux;
        if (c == 'n') {
            aux = "nombre";
        } else {
            aux = "dni";
        }

        ODB odb = ODBFactory.openClient("localhost", 8000, "cuentoscorrientes");
        CriteriaQuery query = new CriteriaQuery(Cliente.class, Where.equal(aux, cliente));
        Objects<Cliente> objects = odb.getObjects(query);
        boolean bien = false;
        if (!objects.isEmpty()) {
            Cliente a = objects.getFirst();
            System.out.printf("%-20s %-8s %-16s  \n", "Numero de cuenta", "saldo", "intereses");
            for (Cuenta i : a.getCuentas()) {
                if (i instanceof CuentaPlazo) {

                    bien = true;
                    System.out.printf("%-20s %-8s %-16f  \n", i.getNumero(), i.getSaldo(), ((CuentaPlazo) i).getIntereses());

                }
            }
            odb.close();
        } else {
            System.out.println("ese cliente no existe");
        }

        return bien;
    }

    public static void clientes() {
        ODB odb = ODBFactory.openClient("localhost", 8000, "cuentoscorrientes");
        Values val = odb.getValues(new ValuesCriteriaQuery(Cliente.class)
                .field("dni")
                .field("nombre")
        );

        while (val.hasNext()) {
            ObjectValues ov = (ObjectValues) val.next();

            System.out.println("dni: " + ov.getByAlias("dni") + "  nombre: " + ov.getByAlias("nombre"));
        }
        odb.close();
    }

    public static void corriente() {
        ODB odb = ODBFactory.openClient("localhost", 8000, "cuentoscorrientes");
        Values val = odb.getValues(new ValuesCriteriaQuery(CuentaCorriente.class)
                .field("numero")
                .field("sucursal")
                .field("saldo")
        );
System.out.printf(" \n %-10s %-18s %-16s \n", "Numero", "Sucursal","Saldo");
        while (val.hasNext()) {
            ObjectValues ov = (ObjectValues) val.next();
            
            System.out.printf(" \n %-10s %-18s %-16s \n", ov.getByAlias("numero") , ov.getByAlias("sucursal"), ov.getByAlias("saldo"));
        }
        odb.close();
    }

    public static void plazo() {
        ODB odb = ODBFactory.openClient("localhost", 8000, "cuentoscorrientes");
        Values val = odb.getValues(new ValuesCriteriaQuery(CuentaPlazo.class)
                .field("numero")
                .field("sucursal")
                .field("fecha")
        );
System.out.printf(" \n %-10s %-18s %-16s \n", "Numero", "Sucursal","Fecha");
        while (val.hasNext()) {
            ObjectValues ov = (ObjectValues) val.next();
System.out.printf(" \n %-10s %-18s %-16s \n", ov.getByAlias("numero") , ov.getByAlias("sucursal"), ov.getByAlias("fecha"));
          
        }
        odb.close();
    }

    public static void movimientos() {
        ODB odb = ODBFactory.openClient("localhost", 8000, "cuentoscorrientes");
        Values val = odb.getValues(new ValuesCriteriaQuery(Movimiento.class)
                .field("fecha")
                .field("hora")
        );

        while (val.hasNext()) {
            ObjectValues ov = (ObjectValues) val.next();

            System.out.println("fecha: " + ov.getByAlias("fecha") + "  hora: " + ov.getByAlias("hora"));
        }
        odb.close();
    }
}
