package Pojos;

import java.util.Date;


 public class Reservas{
 

private Hoteles idHotel;
private Habitaciones habitaciones;
private Date fechaEntrada;
private Date fechaSalida;
private Clientes cliente;


public Reservas(Hoteles idHotel,Habitaciones habitaciones,Date fechaEntrada,Date fechaSalida,Clientes cliente){
this.idHotel=idHotel;
this.habitaciones=habitaciones;
this.fechaEntrada=fechaEntrada;
this.fechaSalida=fechaSalida;
this.cliente=cliente;
}
public Reservas() {
    }


public Hoteles getIdHotel() {
        return idHotel;
    }

 public void setIdHotel(Hoteles idHotel) {
        this.idHotel = idHotel;
    }

public Habitaciones getHabitaciones() {
        return habitaciones;
    }

 public void setHabitaciones(Habitaciones habitaciones) {
        this.habitaciones = habitaciones;
    }

public Date getFechaEntrada() {
        return fechaEntrada;
    }

 public void setFechaEntrada(Date fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

public Date getFechaSalida() {
        return fechaSalida;
    }

 public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

public Clientes getCliente() {
        return cliente;
    }

 public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }
}
