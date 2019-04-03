package Pojos;

import java.util.HashSet;
import java.util.Set;


 public class Habitaciones{
 

private float precio;
private int idHabitacion;
private Hoteles idHotel;
private Set<Reservas> reservas;
private boolean ocupado;


public Habitaciones(float precio,int idHabitacion,Hoteles idHotel,boolean ocupado){
this.precio=precio;
this.idHabitacion=idHabitacion;
this.idHotel=idHotel;
this.reservas=new HashSet<>();
this.ocupado=ocupado;
}


public float getPrecio() {
        return precio;
    }

 public void setPrecio(float precio) {
        this.precio = precio;
    }

public int getIdHabitacion() {
        return idHabitacion;
    }

 public void setIdHabitacion(int idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

public Hoteles getIdHotel() {
        return idHotel;
    }

 public void setIdHotel(Hoteles idHotel) {
        this.idHotel = idHotel;
    }

public Set<Reservas> getReservas() {
        return reservas;
    }

 public void setReservas(Set<Reservas> reservas) {
        this.reservas = reservas;
    }

public boolean getOcupado() {
        return ocupado;
    }

 public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }
}
