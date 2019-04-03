package Pojos;

import java.util.HashSet;
import java.util.Set;


 public class Clientes{
 

private String dni;
private String nombre;
private String telefono;
private Set<Reservas> reservas;


public Clientes(String dni,String nombre,String telefono){
this.dni=dni;
this.nombre=nombre;
this.telefono=telefono;
this.reservas=new HashSet<>();
}
public Clientes() {
    }


public String getDni() {
        return dni;
    }

 public void setDni(String dni) {
        this.dni = dni;
    }

public String getNombre() {
        return nombre;
    }

 public void setNombre(String nombre) {
        this.nombre = nombre;
    }

public String getTelefono() {
        return telefono;
    }

 public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

public Set<Reservas> getReservas() {
        return reservas;
    }

 public void setReservas(Set<Reservas> reservas) {
        this.reservas = reservas;
    }
}
