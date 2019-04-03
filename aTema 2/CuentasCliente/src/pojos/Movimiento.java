/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojos;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author a16pablovc
 */
public class Movimiento {
    
    private CuentaCorriente numero;
    private Date fecha; 
    private Time hora;
    private float cantidad;
    private float saldo;

    public Movimiento(CuentaCorriente numero, Date fecha, Time hora, float cantidad, float saldo) {
        this.numero = numero;
        this.fecha = fecha;
        this.hora = hora;
        this.cantidad = cantidad;
        this.saldo = saldo;
    }

    public CuentaCorriente getNumero() {
        return numero;
    }

    public void setNumero(CuentaCorriente numero) {
        this.numero = numero;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public float getCantidad() {
        return cantidad;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

}