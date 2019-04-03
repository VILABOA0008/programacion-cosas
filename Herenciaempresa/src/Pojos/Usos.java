/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pojos;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author mi
 */
public class Usos implements Serializable{
   private Date FechaAlquiler;
private Date FechaEntrega;
private float importeAPagar;
private Alquiler codigoalquiler;

    public Usos() {
    }

    public Usos(Date FechaAlquiler, Date FechaEntrega, float importeAPagar, Alquiler codigoalquiler) {
        this.FechaAlquiler = FechaAlquiler;
        this.FechaEntrega = FechaEntrega;
        this.importeAPagar = importeAPagar;
        this.codigoalquiler = codigoalquiler;
    }

    public Alquiler getCodigoalquiler() {
        return codigoalquiler;
    }

    public void setCodigoalquiler(Alquiler codigoalquiler) {
        this.codigoalquiler = codigoalquiler;
    }

 

    public Date getFechaAlquiler() {
        return FechaAlquiler;
    }

    public void setFechaAlquiler(Date FechaAlquiler) {
        this.FechaAlquiler = FechaAlquiler;
    }

    public Date getFechaEntrega() {
        return FechaEntrega;
    }

    public void setFechaEntrega(Date FechaEntrega) {
        this.FechaEntrega = FechaEntrega;
    }

    public float getImporteAPagar() {
        return importeAPagar;
    }

    public void setImporteAPagar(float importeAPagar) {
        this.importeAPagar = importeAPagar;
    }


}
