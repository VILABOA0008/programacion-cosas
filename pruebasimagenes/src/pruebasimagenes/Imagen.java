/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebasimagenes;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author a16pablovc
 */
public class Imagen extends JPanel{
    int casa;
    public Imagen(int a){
    this.setSize(300, 400); //se selecciona el tamaño del panel

    casa=a;
    }
 
//Se crea un método cuyo parámetro debe ser un objeto Graphics
 
public void paint(Graphics grafico) {
    System.out.println("si="+casa);
Dimension height = getSize();
 ImageIcon Img;
//Se selecciona la imagen que tenemos en el paquete de la //ruta del programa
 //if(casa==0){ Img= new ImageIcon(getClass().getResource("/pruebasimagenes/esde.png")); }
 //else{
         Img = new ImageIcon(getClass().getResource("/pruebasimagenes/fotololi - copia.png"));
        // }

 
//se dibuja la imagen que tenemos en el paquete Images //dentro de un panel
 
grafico.drawImage(Img.getImage(), 0, 0, height.width, height.height, null);
 
setOpaque(false);
super.paintComponent(grafico);
}
}   

