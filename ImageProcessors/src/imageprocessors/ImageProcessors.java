/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imageprocessors;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author sawye
 */
public class ImageProcessors {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        File f=new File("test.jpg");
        File w=new File("out.txt");
        try {
            FileWriter t=new FileWriter(w);
            BufferedImage o=ImageIO.read(f);
            
            for(int i=0;i<o.getHeight();i+=4){
                for(int j=0;j<o.getWidth();j+=4){
                    int rgb = o.getRGB(j, i);
                    int red =   (rgb >> 16) & 0xFF;
                    int green = (rgb >>  8) & 0xFF;
                    int blue =  (rgb      ) & 0xFF;
                    int b=(red+green+blue);
                    if(b<=153)
                        t.append("#");
                    else if(b<=306)
                        t.append("J");
                    else if(b<=459)
                        t.append("|");
                    else
                        t.append(".");
                }
                t.append(System.lineSeparator());
            }
            t.close();
        } catch (Exception ex) {
            Logger.getLogger(ImageProcessors.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
