package Pojos;


 public class Productos{
 

private int ID;
private int Stockmin;
private int Stockmax;
private int Stockactual;
private String Nombre;
private float Precio;
private Proovedores proovedor;


public Productos(int ID,int Stockmin,int Stockmax,int Stockactual,String Nombre,float Precio,Proovedores proovedor){
this.ID=ID;
this.Stockmin=Stockmin;
this.Stockmax=Stockmax;
this.Stockactual=Stockactual;
this.Nombre=Nombre;
this.Precio=Precio;
this.proovedor=proovedor;
}
public Productos() {
    }


public int getID() {
        return ID;
    }

 public void ID(int ID) {
        this.ID = ID;
    }

public int getStockmin() {
        return Stockmin;
    }

 public void Stockmin(int Stockmin) {
        this.Stockmin = Stockmin;
    }

public int getStockmax() {
        return Stockmax;
    }

 public void Stockmax(int Stockmax) {
        this.Stockmax = Stockmax;
    }

public int getStockactual() {
        return Stockactual;
    }

 public void Stockactual(int Stockactual) {
        this.Stockactual = Stockactual;
    }

public String getNombre() {
        return Nombre;
    }

 public void Nombre(String Nombre) {
        this.Nombre = Nombre;
    }

public float getPrecio() {
        return Precio;
    }

 public void Precio(float Precio) {
        this.Precio = Precio;
    }

public Proovedores getProovedor() {
        return proovedor;
    }

 public void proovedor(Proovedores proovedor) {
        this.proovedor = proovedor;
    }
}
