/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pojos;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author a16pablovc
 */
public class Talleres implements Serializable {
    
    private int codtaller;
    private String nombre;
    private Set <Ciclos> ciclos;
        private Set <Usos> usos;

    
    
    
    
    public Talleres(int codtaller, String nombre) {
        this.codtaller = codtaller;
        this.nombre = nombre;
        this.ciclos=new HashSet<>();
         this.usos=new HashSet<>();
    }

    public Set<Usos> getUsos() {
        return usos;
    }

    public void setUsos(Set<Usos> usos) {
        this.usos = usos;
    }
    
    
        public Talleres() {
    }    
    
    
    public int getCodtaller() {
        return codtaller;
    }

    public void setCodtaller(int codtaller) {
        this.codtaller = codtaller;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<Ciclos> getCiclos() {
        return ciclos;
    }

    public void setCiclos(Set<Ciclos> ciclos) {
        this.ciclos = ciclos;
    }
    
    

}
