/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neodatis_libros_autores_servidor;

import java.util.Scanner;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.ODBServer;

/**
 *
 * @author a16pablovc
 */
public class Neodatis_libros_autores_servidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ODBServer server = ODBFactory.openServer(8000);
        server.addBase("libros_autores", "libros_autores.neo");
        Scanner s=new Scanner(System.in);
        server.startServer(true);
        
            int opc;
        do {
            System.out.println("-----------MENÚ-----------");
            System.out.println("1_Consultar jugadores");
            System.out.println("2_Cerrar server");
            System.out.println("         Elegir opción:");
            opc = s.nextInt();
        
        
        switch (opc) {
                case 1:
                    Visualizar.visualizar();
                    break;
                case 2:
                    server.close();
                    break;
        }
        }while (opc!=2);
                }
}
    
    
    
    
