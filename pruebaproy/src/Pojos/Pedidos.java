package Pojos;


 public class Pedidos{
 

private int ID;
private int Cantidad;
private float Preciototal;
private Productos productos;


public Pedidos(int ID,int Cantidad,float Preciototal,Productos productos){
this.ID=ID;
this.Cantidad=Cantidad;
this.Preciototal=Preciototal;
this.productos=productos;
}
public Pedidos() {
    }


public int getID() {
        return ID;
    }

 public void ID(int ID) {
        this.ID = ID;
    }

public int getCantidad() {
        return Cantidad;
    }

 public void Cantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

public float getPreciototal() {
        return Preciototal;
    }

 public void Preciototal(float Preciototal) {
        this.Preciototal = Preciototal;
    }

public Productos getProductos() {
        return productos;
    }

 public void productos(Productos productos) {
        this.productos = productos;
    }
}
