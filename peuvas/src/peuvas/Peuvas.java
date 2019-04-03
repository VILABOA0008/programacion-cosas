/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peuvas;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author a16pablovc
 */
public class Peuvas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        Random r=new Random();
    cir cc=new cir();
        System.out.println(cc.getX());
        cc.setX(2);
       System.out.println(cc.getX());
    }
}
    /*    String a="";
        String ma[][]=new String[50][50];
        
        for(int i=0;i<ma.length;i++){
        for(int j=0;j<ma.length;j++){
            ma[i][j]="  ";}           
        }
        
        for(int i=0;i<ma.length;i++){
            if(i<10){ma[i][0]=a=a.valueOf(i)+" ";}else{
        ma[i][0]=a.valueOf(i);}}
        
            for(int i=0;i<ma.length;i++){
              ma[0][i]=a=a.valueOf(i)+" ";}
        
        for(int i=0;i<ma.length;i++){
        for(int j=0;j<ma.length;j++){
            System.out.print(ma[i][j]);
            
        }
            System.out.println("");}
        
        ArrayList <Integer> x =new ArrayList<>();
        ArrayList <Integer> y =new ArrayList<>();
        float x1,x2,x3,x4,y1,y2,y3,y4;
        float m1,m2;
//        x1=1f;x2=4f;y1=3f;y2=6f;
//        x3=8f;x4=12f;y3=8f;y4=1f;
        int c=0;
        do{
            x1=r.nextInt(50);x2=r.nextInt(50);y1=r.nextInt(50);y2=r.nextInt(50);
            x3=r.nextInt(50);x4=r.nextInt(50);y3=r.nextInt(50);y4=r.nextInt(50);
            
//            x1=s.nextFloat();x2=s.nextFloat(); y1=s.nextFloat();y2=s.nextFloat();
//            x3=s.nextFloat();x4=s.nextFloat();y3=s.nextFloat();y4=s.nextFloat();
            
            m1=(y2-y1)/(x2-x1);
             m2=(y4-y3)/(x4-x3);
             System.out.println("m1  "+m1+"  m2  "+m2);
      
            
            float rx=(m1*x1-y1-m2*x3+y3)/(m1-m2);
//            System.out.println(" rx =("+m1+"*"+x1+"-"+y1+"-"+m2+"*"+x3+"+"+y3+")/("+m1+"-"+m2+")");
            float ry=(m2*(rx-x3)+y3);
            
              System.out.println("rx  "+rx+"  ry  "+ry);
              if(x1<x2){if(x2>=rx&&x1<=rx){System.out.println("esta dentro");}else{System.out.println("esta fuera1");}}else{if(x2<=rx&&x1>=rx){System.out.println("esta dentro");}else{System.out.println("esta fuera2");}}
                 s.nextLine();
                 ma[(int)y1][(int)x1]="p1";
                 ma[(int)y2][(int)x2]="p1";
                 ma[(int)y3][(int)x3]="p2";
                 ma[(int)y4][(int)x4]="p2";
                 
                      for(int i=0;i<ma.length;i++){
        for(int j=0;j<ma.length;j++){
            System.out.print(ma[i][j]);          }
            System.out.println("");}
                 s.nextLine();
                            for(int i=1;i<ma.length;i++){
        for(int j=1;j<ma.length;j++){
         ma[i][j]="  ";      }
         }
                 
                  c++;
        }while(c<1000);
    }
        *//////////////////////////
    
    
/* public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        ArrayList <Integer> lx =new ArrayList<>();
        ArrayList <Integer> ly =new ArrayList<>();
           float mx,my;
                int ux,uy;
                
        int op=0;
        int x1=40,y1=20,xx=20,yy=50;
        
   
        

        
       
        
        
        do{
            lx.clear();
            ly.clear();
              System.out.println("x e y");
         x1=s.nextInt();
         y1=s.nextInt();
               System.out.println("x2 e y2");
         xx=s.nextInt();
         yy=s.nextInt();
        
        
            
            
             lx.add(x1);ly.add(y1);
                  ux=lx.get(lx.size()-1);
        uy=ly.get(lx.size()-1);
   
           mx=xx-ux;
        my=yy-uy;
//            System.out.println("mx  "+mx);
//              System.out.println("my  "+my);
         
                 if(Math.abs(mx)+Math.abs(my)>8){

            boolean esx=false;
             int cc=0,ccm;
             float cosa=0f,cosas=0f;
                    if(Math.abs(mx)>Math.abs(my)){ccm=Math.abs((int)mx/3);}else{ccm=Math.abs((int)(my/3));esx=true;}
                   
                    int sumax=Math.round(mx / ccm);
                      int sumay=Math.round(my/ ccm);
                       if(esx==true&&(mx / ccm)<1){cosa=((float)mx / ccm);System.out.println("cosamx"+cosa);}else if(esx==false&&(my / ccm)<1){cosa=(my / ccm);System.out.println("xosamt"+cosa);}
                       System.out.println("cosaaaaaa"+cosa);
                       System.out.println( mx / ccm+"  sumax   sumay  "+my/ ccm);
                    do {
                        
                          ux = lx.get(lx.size() - 1);
                        uy = ly.get(lx.size() - 1);
                        
                        if(cosa!=0){
                                System.out.println("cosaif  "+cosa);
                        if(esx==true){       
                          lx.add(ux +(int)cosas);    
                          ly.add(uy + sumay);   
                        }else{
                            lx.add(ux +sumax);
                            ly.add(uy + (int) cosas);
                        }
                        if(cosas>1){cosas=0;}
                        }
                        else{                            
                             lx.add(ux +sumax);
                        ly.add(uy + sumay);
                        }
                        
                 
                        cc++;
                              cosas+=cosa;
                              System.out.println("cosa  "+cosa);
                    }while(cc<ccm);
//                    System.out.println(ccm+"  ccm");
        }
       for(int i=0;i<lx.size();i++){
           System.out.println(lx.get(i)+"  lx   ly  "+ly.get(i)+"  Y "+i);}
  
        }while(op!=1);
    }
    
}
*/