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
public class Empresas implements Serializable{
    private String cif,nombre,tlf;
    private Set<Coches> coches;

    public Empresas(String cif, String nombre, String tlf) {
        this.cif = cif;
        this.nombre = nombre;
        this.tlf = tlf;
        this.coches=new HashSet<>();
    }

    public Set<Coches> getCoches() {
        return coches;
    }

    public void setCoches(Set<Coches> coches) {
        this.coches = coches;
    }
    

    public Empresas() {
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTlf() {
        return tlf;
    }

    public void setTlf(String tlf) {
        this.tlf = tlf;
    }
 
    
}
