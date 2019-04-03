package Pojos;

import java.util.HashSet;
import java.util.Set;


 public class Proovedores{
 

private String DNI;
private String Nombre;
private String Direccion;
private String Telefono;
private String Email;
private Set<Cuenta> cuentas;
private Set<Compras> compras;


public Proovedores(String DNI,String Nombre,String Direccion,String Telefono,String Email,){
this.DNI=DNI;
this.Nombre=Nombre;
this.Direccion=Direccion;
this.Telefono=Telefono;
this.Email=Email;
this.cuentas=new HashSet<>();
this.compras=new HashSet<>();
}
public Proovedores() {
    }


public String getDNI() {
        return DNI;
    }

 public void DNI(String DNI) {
        this.DNI = DNI;
    }

public String getNombre() {
        return Nombre;
    }

 public void Nombre(String Nombre) {
        this.Nombre = Nombre;
    }

public String getDireccion() {
        return Direccion;
    }

 public void Direccion(String Direccion) {
        this.Direccion = Direccion;
    }

public String getTelefono() {
        return Telefono;
    }

 public void Telefono(String Telefono) {
        this.Telefono = Telefono;
    }

public String getEmail() {
        return Email;
    }

 public void Email(String Email) {
        this.Email = Email;
    }

public Set<Cuenta> getCuentas() {
        return cuentas;
    }

 public void cuentas(Set<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }

public Set<Compras> getCompras() {
        return compras;
    }

 public void compras(Set<Compras> compras) {
        this.compras = compras;
    }
}
