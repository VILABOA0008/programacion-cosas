/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojos;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author a16pablovc
 */
public class Cliente {
    
    private String dni,nombre,direccion;
    private Set<Cuenta> cuentas;

    public Cliente(String dni, String nombre, String direccion) {
        this.dni = dni;
        this.nombre = nombre;
        this.direccion = direccion;
        this.cuentas = new HashSet<>();
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Set<Cuenta> getCuentas() {
        return cuentas;
    }

    public void setCuentas(Set<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }
    
    
    
}
