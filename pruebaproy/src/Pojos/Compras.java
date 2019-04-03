package Pojos;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


 public class Compras{
 

private int ID;
private Cuenta cuentas;
private Set<Pedidos> pedidos;
private String direccion;
private float precioTotal;
private boolean formaPago;
private Date fechaSolicitud;


public Compras(int ID,Cuenta cuentas,String direccion,float precioTotal,boolean FormadePago,Date fechaSolicitud){
this.ID=ID;
this.cuentas=cuentas;
this.pedidos=new HashSet<>();
this.direccion=direccion;
this.precioTotal=precioTotal;
this.FoformaPagoormadePago;
this.fechaSolicitud=fechaSolicitud;
}
public Compras() {
    }


public int getID() {
        return ID;
    }

 public void ID(int ID) {
        this.ID = ID;
    }

public Cuenta getCuentas() {
        return cuentas;
    }

 public void cuentas(Cuenta cuentas) {
        this.cuentas = cuentas;
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
        return precioTotal;
    }

 public void preciototal(float preciototal) {
        this.precioTotal = preciototal;
    }

public boolean getFormadePago() {
        return FormformaPago  }

 public void FormadePago(boolean FormadePago) {
        this.FormadformaPagomadePago;
    }

public Date getFechaSolicitud() {
        return fechaSolicitud;
    }

 public void fechaSolicitud(Date fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }
}
