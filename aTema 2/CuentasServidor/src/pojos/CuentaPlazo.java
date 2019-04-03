/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojos;

import java.sql.Date;

/**
 *
 * @author a16pablovc
 */
public class CuentaPlazo extends Cuenta{
    
    private float intereses;
    private Date fecha;

    public CuentaPlazo(String numero, String sucursal, Cliente cliente, float saldo,float intereses,Date fecha) {
        super(numero, sucursal, cliente, saldo);
        this.intereses=intereses;
        this.fecha=fecha;
    }

    public float getIntereses() {
        return intereses;
    }

    public void setIntereses(float intereses) {
        this.intereses = intereses;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
     
}
