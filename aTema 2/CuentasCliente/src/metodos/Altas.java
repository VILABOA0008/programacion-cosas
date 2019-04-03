/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodos;

import java.sql.Date;
import java.sql.Time;
import java.util.Random;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;
import pojos.*;

/**
 *
 * @author a16pablovc
 */
public class Altas {

    public static void altas() {

        int op;

        do {
            System.out.println("\n");
            System.out.println(" 1 Cliente \n 2 Cuenta Corriente \n 3 Cuenta Plazo \n 4 Movimiento \n 5 Salir");
            op = Comprobaciones.opcion(5);

            switch (op) {

                case 1:cliente();break;
                case 2:corriente();break;
                case 3: plazo();  break;
                case 4:movimiento(); break;
            }

        } while (op != 5);

    }

    public static void cliente() {

        ODB odb = ODBFactory.openClient("localhost", 8000, "cuentoscorrientes");

        String dni, nombre, direccion;

        Random r = new Random();
        System.out.println("Escriba el dni del cliente");
        dni = Comprobaciones.dni();
        System.out.println("Escriba el nombre del cliente");
        nombre = Comprobaciones.strin();
        System.out.println("Escriba la direccion del cliente");
        direccion =Comprobaciones.strin();

        Cliente a = new Cliente(dni, nombre, direccion);

        CriteriaQuery query = new CriteriaQuery(Cliente.class, Where.equal("dni", dni));
        Objects<Cliente> objects = odb.getObjects(query);

        if (!objects.isEmpty()) {
            System.out.println("Ya existe un cliente con ese dni");
        } else {
            odb.store(a);
            odb.commit();
            System.out.println("Cliente dado de alta");
        }
    }

    public static void corriente() {

        ODB odb = ODBFactory.openClient("localhost", 8000, "cuentoscorrientes");

        String numero, sucursal;
        float saldo;

        Random r = new Random();


        System.out.println("Escriba el dni del cliente");
        Consultas.clientes();
        String dni = Comprobaciones.dni();
        System.out.println("Escriba el numero de cuenta");
        numero =Comprobaciones.cuenta();
        System.out.println("Escriba la sucursal");
        sucursal = Comprobaciones.strin();
        System.out.println("Escriba el saldo de la cuenta");
        saldo =Comprobaciones.floa();

        CriteriaQuery query = new CriteriaQuery(Cliente.class, Where.equal("dni", dni));
        Objects<Cliente> objects = odb.getObjects(query);
        if (!objects.isEmpty()) {
            Cliente cliente = objects.getFirst();

            CuentaCorriente a = new CuentaCorriente(numero, sucursal, cliente, saldo);

            query = new CriteriaQuery(CuentaCorriente.class, Where.equal("numero", numero));
            Objects<CuentaPlazo> objectos = odb.getObjects(query);

            if (!objectos.isEmpty()) {
                System.out.println("esa cuenta ya existe");
            } else {
                cliente.getCuentas().add(a);
                odb.store(a);
                odb.commit();
                System.out.println("Cuenta dada de alta");
            }
        } else {
            System.out.println("ese cliente no existe");
        }
        odb.close();
    }

    public static void plazo() {

        ODB odb = ODBFactory.openClient("localhost", 8000, "cuentoscorrientes");

        String numero, sucursal;
        float saldo, intereses;

         System.out.println("Escriba el dni del cliente");
        Consultas.clientes();
        String dni =Comprobaciones.dni();
        Random r = new Random();
        System.out.println("Escriba el numero de cuenta");
        numero =Comprobaciones.cuenta();
        System.out.println("Escriba la sucursal");
        sucursal = Comprobaciones.strin();
        System.out.println("Escriba el saldo");
        saldo = Comprobaciones.floa();
        System.out.println("Escriba los interes");
        intereses = Comprobaciones.floa();
        System.out.println("Escriba la fecha");
        Date fecha = Comprobaciones.fecha();

        CriteriaQuery query = new CriteriaQuery(Cliente.class, Where.equal("dni", dni));
        Objects<Cliente> objects = odb.getObjects(query);
        if (!objects.isEmpty()) {
            Cliente cliente = objects.getFirst();

            CuentaPlazo a = new CuentaPlazo(numero, sucursal, cliente, saldo, intereses, fecha);

            query = new CriteriaQuery(CuentaPlazo.class, Where.equal("numero", numero));
            Objects<CuentaPlazo> objectos = odb.getObjects(query);

            if (!objectos.isEmpty()) {
                System.out.println("esa cuenta ya existe");
            } else {
                cliente.getCuentas().add(a);
                odb.store(a);
                odb.commit();
                System.out.println("Cuenta dada de alta");
            }
        } else {
            System.out.println("ese cliente no existe");
        }
        odb.close();
    }

    public static void movimiento() {

        ODB odb = ODBFactory.openClient("localhost", 8000, "cuentoscorrientes");

        String numero;
        float saldo, cantidad;

        Random r = new Random();
         System.out.println("Escriba el numero de cuenta  corriente");
        Consultas.corriente();
        String num = Comprobaciones.cuenta();
        System.out.println("Escriba el numero del movimiento");
        numero = Comprobaciones.cuenta();
        System.out.println("Escriba la cantidad");
        cantidad = Comprobaciones.floa();
        System.out.println("Escriba la fecha");
        Date fecha =Comprobaciones.fecha();
        System.out.println("Escriba la hora");
        Time hora = Comprobaciones.hora();
        
       

        CriteriaQuery query = new CriteriaQuery(CuentaCorriente.class, Where.equal("numero", num));
        Objects<CuentaCorriente> objects = odb.getObjects(query);
        if (!objects.isEmpty()) {
            CuentaCorriente cuenta = objects.getFirst();
            saldo=cuenta.getSaldo();
            Movimiento m = new Movimiento(cuenta, fecha, hora, cantidad, saldo);

            query = new CriteriaQuery(Movimiento.class, Where.equal("numero", numero));
            Objects<Movimiento> obj = odb.getObjects(query);

            if (!obj.isEmpty()) {
                System.out.println("Ya existe un Movimiento con ese numero");
            } else {
                cuenta.getMovimientos().add(m);
                cuenta.setSaldo(cuenta.getSaldo()+m.getCantidad());
                odb.store(cuenta);
             
                odb.commit();
                System.out.println("Movimiento dado de alta");
            }
            odb.close();
        } else {
            System.out.println("No existe esa cuenta corriente");
        }
    }
}
