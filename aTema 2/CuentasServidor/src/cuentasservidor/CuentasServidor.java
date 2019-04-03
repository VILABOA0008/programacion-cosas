/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cuentasservidor;

import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.ODBServer;


/**
 *
 * @author a16pablovc
 */
public class CuentasServidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ODBServer server = ODBFactory.openServer(8000);
        server.addBase("cuentoscorrientes", "cuentoscorrientes.neo");
        server.startServer(true);
    }
    
}
