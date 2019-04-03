package Pojos;


 public class Cuentas{
 

private String Numero;
private float Saldo;
private Cliente cliente;
private Tarjetas tarjeta;


public Cuentas(String Numero,float Saldo){
this.Numero=Numero;
this.Saldo=Saldo;
}
public Cuentas() {
    }


public String getNumero() {
        return Numero;
    }

 public void Numero(String Numero) {
        this.Numero = Numero;
    }

public float getSaldo() {
        return Saldo;
    }

 public void Saldo(float Saldo) {
        this.Saldo = Saldo;
    }

public Cliente getCliente() {
        return cliente;
    }

 public void cliente(Cliente cliente) {
        this.cliente = cliente;
    }

public Tarjetas getTarjeta() {
        return tarjeta;
    }

 public void tarjeta(Tarjetas tarjeta) {
        this.tarjeta = tarjeta;
    }
}
