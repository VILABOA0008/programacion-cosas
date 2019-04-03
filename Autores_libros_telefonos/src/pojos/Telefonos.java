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
public class Telefonos implements java.io.Serializable{
    private String numero,autors;
    private Autores autor;

    public Telefonos() {
    }

    public Telefonos(String numero, Autores autor) {
        this.numero = numero;
        this.autor = autor;
        this.autors = autor.getDNI();
    }

        public String getAutors() {
        return autors;
    }

    public void setAutors(String autors) {
        this.autors = autors;
    }

    
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Autores getAutor() {
        return autor;
    }

    public void setAutor(Autores autor) {
        this.autor = autor;
    }
    
    
    
}
