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
public class Institutos  implements Serializable{
    
    private int codinsti;
    private String telefono;
    private Set <Ciclos> ciclos; 

    
    public Institutos(int codinsti, String telefono) {
        this.codinsti = codinsti;
        this.telefono = telefono;
        this.ciclos=new HashSet<>();
    }
    
    public Institutos() {
    }

        public int getCodinsti() {
        return codinsti;
    }

    public void setCodinsti(int codinsti) {
        this.codinsti = codinsti;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Set<Ciclos> getCiclos() {
        return ciclos;
    }

    public void setCiclos(Set<Ciclos> ciclos) {
        this.ciclos = ciclos;
    }
    
    
    
    
    
   
}
