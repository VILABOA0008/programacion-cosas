/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojos;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author a16pablovc
 */
public class CuentaCorriente extends Cuenta{
    
    
    private Set<Movimiento> movimientos;

    public CuentaCorriente(String numero, String sucursal, Cliente cliente, float saldo) {
        super(numero, sucursal, cliente, saldo);
               this.movimientos = new HashSet<>();
        
    }



    public Set<Movimiento> getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(Set<Movimiento> movimientos) {
        this.movimientos = movimientos;
    }

    

    
    
}
