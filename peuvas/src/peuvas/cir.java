/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peuvas;

import java.util.Random;

/**
 *
 * @author mi
 */
public class cir {
    Random r=new Random();
    int x=r.nextInt(5);

    public Random getR() {
        return r;
    }

    public void setR(Random r) {
        this.r = r;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }
    
    
}
