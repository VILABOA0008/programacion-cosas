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
public class Alquiler extends Coches implements Serializable {

private char tipo;
private float precio;
private Set<Usos> usos;
    public Alquiler() {
    }

    public Alquiler(char tipo, float precio, String codigocoche, String marca, String modelo, Empresas empresa) {
        super(codigocoche, marca, modelo, empresa);
  
        this.tipo = tipo;
        this.precio = precio;
            this.usos=new HashSet<>();
    }




    public Set<Usos> getUsos() {
        return usos;
    }

    public void setUsos(Set<Usos> usos) {
        this.usos = usos;
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

 
    
}
