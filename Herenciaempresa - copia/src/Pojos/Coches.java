/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pojos;

import java.io.Serializable;

/**
 *
 * @author a16pablovc
 */
public class Coches implements Serializable {
        private String codigocoche,marca,modelo;
        private Empresas empresa;

    public Coches(String codigocoche, String marca, String modelo, Empresas empresa) {
        this.codigocoche = codigocoche;
        this.marca = marca;
        this.modelo = modelo;
        this.empresa = empresa;
    }

   

    public Coches() {
    }

    public Empresas getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresas empresa) {
        this.empresa = empresa;
    }

        
        
    public String getCodigocoche() {
        return codigocoche;
    }

    public void setCodigocoche(String codigocoche) {
        this.codigocoche = codigocoche;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

        
    
}
