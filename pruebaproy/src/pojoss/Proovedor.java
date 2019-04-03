package pojoss;


 public class Proovedor{
 

private String CIF;
private String email;
private String telefono;
private String direccion;


public Proovedor(String CIF,String email,String telefono,String direccion){
this.CIF=CIF;
this.email=email;
this.telefono=telefono;
this.direccion=direccion;
}
public Proovedor() {
    }


public String getCIF() {
        return CIF;
    }

 public void CIF(String CIF) {
        this.CIF = CIF;
    }

public String getEmail() {
        return email;
    }

 public void email(String email) {
        this.email = email;
    }

public String getTelefono() {
        return telefono;
    }

 public void telefono(String telefono) {
        this.telefono = telefono;
    }

public String getDireccion() {
        return direccion;
    }

 public void direccion(String direccion) {
        this.direccion = direccion;
    }
}
