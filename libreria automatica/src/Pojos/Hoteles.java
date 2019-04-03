package Pojos;

import java.util.HashSet;
import java.util.Set;


 public class Hoteles{
 

private String nombre;
private String telefono;
private Set<Reservas> reservas;
private Set<Habitaciones> habitaciones;
private int idHotel;


public Hoteles(String nombre,String telefono,int idHotel){
this.nombre=nombre;
this.telefono=telefono;
this.reservas=new HashSet<>();
this.habitaciones=new HashSet<>();
this.idHotel=idHotel;
}
public Hoteles() {
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

public Set<Habitaciones> getHabitaciones() {
        return habitaciones;
    }

 public void setHabitaciones(Set<Habitaciones> habitaciones) {
        this.habitaciones = habitaciones;
    }

public int getIdHotel() {
        return idHotel;
    }

 public void setIdHotel(int idHotel) {
        this.idHotel = idHotel;
    }
}
