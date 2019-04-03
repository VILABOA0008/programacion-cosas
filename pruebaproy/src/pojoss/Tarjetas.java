package pojoss;

import java.util.Date;


 public class Tarjetas{
 

private String numero;
private Date fechacaducidad;
private String CVV;


public Tarjetas(String numero,Date fechacaducidad,String CVV){
this.numero=numero;
this.fechacaducidad=fechacaducidad;
this.CVV=CVV;
}


public String getNumero() {
        return numero;
    }

 public void numero(String numero) {
        this.numero = numero;
    }

public Date getFechacaducidad() {
        return fechacaducidad;
    }

 public void fechacaducidad(Date fechacaducidad) {
        this.fechacaducidad = fechacaducidad;
    }

public String getCVV() {
        return CVV;
    }

 public void CVV(String CVV) {
        this.CVV = CVV;
    }
}
