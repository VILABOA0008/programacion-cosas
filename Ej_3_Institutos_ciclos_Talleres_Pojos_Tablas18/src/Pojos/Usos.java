/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pojos;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author a16pablovc
 */
public class Usos implements Serializable{
    private Date fecha;
    private Time hora;
    private Set <Talleres> talleres;
     private Set <Ciclos> ciclos;

    public Usos(Date fecha, Time hora) {
        this.fecha = fecha;
        this.hora = hora;
        this.talleres=new HashSet<>();
        this.ciclos=new HashSet<>();
    }

    public Set<Ciclos> getCiclos() {
        return ciclos;
    }

    public void setCiclos(Set<Ciclos> ciclos) {
        this.ciclos = ciclos;
    }

    
    public Usos() {
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

    public Set<Talleres> getTalleres() {
        return talleres;
    }

    public void setTalleres(Set<Talleres> talleres) {
        this.talleres = talleres;
    }
    
    
   
    
}
