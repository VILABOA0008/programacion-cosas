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
public class Venta extends Coches implements Serializable {
  
private float precio;

    public Venta( float precio, String codigocoche, String marca, String modelo, Empresas empresa) {
        super(codigocoche, marca, modelo, empresa);
   
        this.precio = precio;
    }

  

    public Venta() {
    }



    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }


}
