/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxcommoncolor;

/**
 *
 * @author chaz
 */
public class Pixel {
    private int a;
    private int r;
    private int g;
    private int b;
    
    public Pixel(int p){            //receives the pixel value as a single integer with rgb values bitshifted
        this.a = (p>>24) & 0xff;    //get alpha value
        this.r = (p>>16) & 0xff;    //get red value
        this.g = (p>>8) & 0xff;     //get green value
        this.b = p & 0xff;          //get blue value
    }
    
    public Pixel(int a, int r, int g, int b){
        this.a = a;
        this.r = r;
        this.g = g;
        this.b = b;
    }
    
    public Pixel(){ //if no arguments are passed, set all vals to 0
        this.a = 0;
        this.r = 0;
        this.g = 0;
        this.b = 0;
    }
    
    public void setPixel(int p){
        this.a = (p>>24) & 0xff;    //get alpha value
        this.r = (p>>16) & 0xff;    //get red value
        this.g = (p>>8) & 0xff;     //get green value
        this.b = p & 0xff;          //get blue value
    }
    
    public int getA(){
        return(a);
    }
    public int getR(){
        return(r);
    }
    
    public int getG(){
        return(g);
    }
    
    public int getB(){
        return(b);
    }
    
    public String getVals(){    //really just for testing
        return ("a: " + a + "\nr: " + r + "\nb: " + b + "\ng: " + g);
    }
}
