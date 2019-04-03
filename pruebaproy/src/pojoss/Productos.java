package pojoss;


 public class Productos{
 

private int ID;
private int stockmin;
private int stockmax;
private int stockactual;
private String nombre;
private float precio;
private Proovedor proovedores;


public Productos(int ID,int stockmin,int stockmax,int stockactual,String nombre,float precio,Proovedor proovedores){
this.ID=ID;
this.stockmin=stockmin;
this.stockmax=stockmax;
this.stockactual=stockactual;
this.nombre=nombre;
this.precio=precio;
this.proovedores=proovedores;
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
        return stockmin;
    }

 public void stockmin(int stockmin) {
        this.stockmin = stockmin;
    }

public int getStockmax() {
        return stockmax;
    }

 public void stockmax(int stockmax) {
        this.stockmax = stockmax;
    }

public int getStockactual() {
        return stockactual;
    }

 public void stockactual(int stockactual) {
        this.stockactual = stockactual;
    }

public String getNombre() {
        return nombre;
    }

 public void nombre(String nombre) {
        this.nombre = nombre;
    }

public float getPrecio() {
        return precio;
    }

 public void precio(float precio) {
        this.precio = precio;
    }

public Proovedor getProovedores() {
        return proovedores;
    }

 public void proovedores(Proovedor proovedores) {
        this.proovedores = proovedores;
    }
}
