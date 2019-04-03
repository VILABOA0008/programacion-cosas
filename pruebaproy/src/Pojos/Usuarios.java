package Pojos;


 public class Usuarios{
 

private String Nombre;
private String Contraseña;


public Usuarios(String Nombre,String Contraseña){
this.Nombre=Nombre;
this.Contraseña=Contraseña;
}
public Usuarios() {
    }


public String getNombre() {
        return Nombre;
    }

 public void Nombre(String Nombre) {
        this.Nombre = Nombre;
    }

public String getContraseña() {
        return Contraseña;
    }

 public void Contraseña(String Contraseña) {
        this.Contraseña = Contraseña;
    }
}
