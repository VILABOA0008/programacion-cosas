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
public class Ciclos implements Serializable{
    
    private int codciclo;
    private String nombre;
    Set <Talleres> talleres;
    Set <Institutos> institutos;
   private Set <Usos> usos;
    
    
    
    public Ciclos(int codciclo, String nombre) {
        this.codciclo = codciclo;
        this.nombre = nombre;
        this.talleres=new HashSet<>();
        this.institutos=new HashSet<>();
          this.usos=new HashSet<>();
    }

    public Set<Usos> getUsos() {
        return usos;
    }

    public void setUsos(Set<Usos> usos) {
        this.usos = usos;
    }
    
    

    public Set<Institutos> getInstitutos() {
        return institutos;
    }

    public void setInstitutos(Set<Institutos> institutos) {
        this.institutos = institutos;
    }

    
    
    
    public Ciclos() {
    }


    public int getCodciclo() {
        return codciclo;
    }

    public void setCodciclo(int codciclo) {
        this.codciclo = codciclo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<Talleres> getTalleres() {
        return talleres;
    }

    public void setTalleres(Set<Talleres> talleres) {
        this.talleres = talleres;
    }


}
