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
    private Talleres taller;
     private Ciclos ciclo;




    
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

    public Usos(Date fecha, Time hora, Talleres taller, Ciclos ciclo) {
        this.fecha = fecha;
        this.hora = hora;
        this.taller = taller;
        this.ciclo = ciclo;
    }

    public Talleres getTaller() {
        return taller;
    }

    public void setTaller(Talleres taller) {
        this.taller = taller;
    }

    public Ciclos getCiclo() {
        return ciclo;
    }

    public void setCiclo(Ciclos ciclo) {
        this.ciclo = ciclo;
    }


    
   
    
}
