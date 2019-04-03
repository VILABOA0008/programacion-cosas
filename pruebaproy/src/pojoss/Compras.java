package pojoss;

import java.util.Date;
import java.util.HashSet;

import java.util.Set;


 public class Compras{
 

private int id;
private Cuentas cuenta;
private Set<Pedidos> pedidos;
private String direccion;
private float preciototal;
private boolean formaPago;
private Date fechaSolicitud;


public Compras(int ID,Cuentas cuenta,String direccion,float preciototal,boolean formadepago,Date fechasolicitud){
this.id=ID;
this.cuenta=cuenta;
this.pedidos=new HashSet<>();
this.direccion=direccion;
this.preciototal=preciototal;
this.formaPago=formadepago;
this.fechaSolicitud=fechasolicitud;
}
public Compras() {
    }


public int getID() {
        return id;
    }

 public void ID(int ID) {
        this.id = ID;
    }

public Cuentas getCuenta() {
        return cuenta;
    }

 public void cuenta(Cuentas cuenta) {
        this.cuenta = cuenta;
    }

public Set<Pedidos> getPedidos() {
        return pedidos;
    }

 public void pedidos(Set<Pedidos> pedidos) {
        this.pedidos = pedidos;
    }

public String getDireccion() {
        return direccion;
    }

 public void direccion(String direccion) {
        this.direccion = direccion;
    }

public float getPreciototal() {
        return preciototal;
    }

 public void preciototal(float preciototal) {
        this.preciototal = preciototal;
    }

public boolean getFormadepago() {
        return formaPago;
    }

 public void formadepago(boolean formadepago) {
        this.formaPago = formadepago;
    }

public Date getFechasolicitud() {
        return fechaSolicitud;
    }

 public void fechasolicitud(Date fechasolicitud) {
        this.fechaSolicitud = fechasolicitud;
    }
}
