package pojoss;


 public class Pedidos{
 

private int ID;
private int cantidad;
private float preciototal;
private Productos productos;


public Pedidos(int ID,int cantidad,float preciototal,Productos productos){
this.ID=ID;
this.cantidad=cantidad;
this.preciototal=preciototal;
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
        return cantidad;
    }

 public void cantidad(int cantidad) {
        this.cantidad = cantidad;
    }

public float getPreciototal() {
        return preciototal;
    }

 public void preciototal(float preciototal) {
        this.preciototal = preciototal;
    }

public Productos getProductos() {
        return productos;
    }

 public void productos(Productos productos) {
        this.productos = productos;
    }
}
