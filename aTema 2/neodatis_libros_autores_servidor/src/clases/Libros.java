/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.sql.Date;

/**
 *
 * @author a16pablovc
 */
public class Libros {
    
    
    private int isbn;
   private String titulo,catyegoria;
   private float precio;
    private Date fecha;

    public Libros(int isbn, String titulo, String catyegoria, float precio, Date fecha) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.catyegoria = catyegoria;
        this.precio = precio;
        this.fecha = fecha;
    }

    public Libros() {
    }

    
    
    
    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCatyegoria() {
        return catyegoria;
    }

    public void setCatyegoria(String catyegoria) {
        this.catyegoria = catyegoria;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }



}
