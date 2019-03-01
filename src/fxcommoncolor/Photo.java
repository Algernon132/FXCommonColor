/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxcommoncolor;
import java.awt.image.BufferedImage;
/**
 *
 * @author chaz
 */
public class Photo {
    private final int height;
    private final int width;
    private final BufferedImage image;
    
    //constructor
    public Photo(BufferedImage image){  //recieves an image. Sets height and width and stores the image
        this.image = image;
        this.height = image.getHeight();
        this.width = image.getWidth();
    }
    
    public int getHeight(){
        return this.height;
    }
    
    public int getWidth(){
        return this.width;
    }
    
    public int getRGB(int x, int y){
        return this.image.getRGB(x, y);
    }
}
