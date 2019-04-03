package pojoss;

import java.util.HashSet;
import java.util.Set;


 public class Clientes{
 

private String dni;
private String nombre;
private String direccion;
private String telefono;
private String email;
private Set<Compras> compras;
private Set<Cuentas> cuentas;


public Clientes(String DNI,String Nombre,String Direccion,String Telefono,String Email){
this.dni=DNI;
this.nombre=Nombre;
this.direccion=Direccion;
this.telefono=Telefono;
this.email=Email;
this.compras=new HashSet<>();
this.cuentas=new HashSet<>();
}
public Clientes() {
    }


public String getDNI() {
        return dni;
    }

 public void DNI(String DNI) {
        this.dni = DNI;
    }

public String getNombre() {
        return nombre;
    }

 public void Nombre(String Nombre) {
        this.nombre = Nombre;
    }

public String getDireccion() {
        return direccion;
    }

 public void Direccion(String Direccion) {
        this.direccion = Direccion;
    }

public String getTelefono() {
        return telefono;
    }

 public void Telefono(String Telefono) {
        this.telefono = Telefono;
    }

public String getEmail() {
        return email;
    }

 public void Email(String Email) {
        this.email = Email;
    }

public Set<Compras> getCompras() {
        return compras;
    }

 public void compras(Set<Compras> compras) {
        this.compras = compras;
    }

public Set<Cuentas> getCuentas() {
        return cuentas;
    }

 public void cuentas(Set<Cuentas> cuentas) {
        this.cuentas = cuentas;
    }
}
