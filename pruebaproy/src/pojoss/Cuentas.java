package pojoss;


 public class Cuentas{
 

private String numero;
private float saldo;
private float cliente;
private Tarjetas tarjeta;


public Cuentas(String numero,float saldo,float cliente,Tarjetas tarjeta){
this.numero=numero;
this.saldo=saldo;
this.cliente=cliente;
this.tarjeta=tarjeta;
}
public Cuentas() {
    }


public String getNumero() {
        return numero;
    }

 public void numero(String numero) {
        this.numero = numero;
    }

public float getSaldo() {
        return saldo;
    }

 public void saldo(float saldo) {
        this.saldo = saldo;
    }

public float getCliente() {
        return cliente;
    }

 public void cliente(float cliente) {
        this.cliente = cliente;
    }

public Tarjetas getTarjeta() {
        return tarjeta;
    }

 public void tarjeta(Tarjetas tarjeta) {
        this.tarjeta = tarjeta;
    }
}
