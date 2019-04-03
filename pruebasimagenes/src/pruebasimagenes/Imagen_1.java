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
public class Imagen_1 extends JPanel{
    int casa;
    public Imagen_1(int a){
    this.setSize(300, 400); //se selecciona el tamaño del panel

    casa=a;
    System.out.println("casa" +casa);
    }
 
//Se crea un método cuyo parámetro debe ser un objeto Graphics
 
public void paint(Graphics grafico) {
    System.out.println("si2="+casa);
Dimension height = getSize();
 ImageIcon Img;
//Se selecciona la imagen que tenemos en el paquete de la //ruta del programa
//Img= new ImageIcon(getClass().getResource("/pruebasimagenes/esde.png")); 

Img= new ImageIcon(getClass().getResource("/pruebasimagenes/esde.png"));
switch(casa){
    case 0:Img= new ImageIcon(getClass().getResource("/pruebasimagenes/esde.png")); break;
     case 1:Img = new ImageIcon(getClass().getResource("/pruebasimagenes/fotololi - copia.png"));break; 
      case 2:break;


}

 
//se dibuja la imagen que tenemos en el paquete Images //dentro de un panel
 
grafico.drawImage(Img.getImage(), 0, 0, height.width, height.height, null);
 
setOpaque(false);
super.paintComponent(grafico);
}
}   

