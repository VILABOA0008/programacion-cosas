/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojos;

import java.util.Set;
import java.util.HashSet;
/**
 *
 * @author mi
 */
public class Autores implements java.io.Serializable {
   private String DNI,nombre,nacionalidad;
   private Set <Libros> libros;
    private Telefonos telefono;

    public Autores() {
    }
    
    

    public Autores(String DNI, String nombre, String nacionalidad) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.libros = new HashSet<Libros>();
    }

    public Telefonos getTelefono() {
        return telefono;
    }

    public Set<Libros> getLibros() {
        return libros;
    }

    public void setLibros(Set<Libros> libros) {
        this.libros = libros;
    }


    
    
    public void setTelefono(Telefonos telefono) {
        this.telefono = telefono;
    }
   
   

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

   
   
}
