/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojos;

/**
 *
 * @author mi
 */
public class Libros implements java.io.Serializable{
    private String idLibro,titulo;
    private float precio;
    private Autores autor;

    public Libros() {
    }

    
    
    public Libros(String idLibro, String titulo, float precio, Autores autor) {
        this.idLibro = idLibro;
        this.titulo = titulo;
        this.precio = precio;
        this.autor = autor;
    }

    
    
    public String getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(String idLibro) {
        this.idLibro = idLibro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public Autores getAutor() {
        return autor;
    }

    public void setAutor(Autores autor) {
        this.autor = autor;
    }
    
    
}
