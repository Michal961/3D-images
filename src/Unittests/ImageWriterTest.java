package Unittests;
import java.awt.Color;
import java.util.Random;

import org.junit.jupiter.api.Test;

import Renderer.ImageWriter;

class ImageWriterTest {

    @Test
    public void test1() {
        ImageWriter imageWriter = new ImageWriter("triangleInShadesOfRed", 1600, 1000, 500, 251);
        int nX = imageWriter.getNx();
        int nY = imageWriter.getNy();

        for (int i = 0; i < nY; ++i)
            for (int j = 0; j < nX; ++j)
                imageWriter.writePixel(j, i,new Color(255,230,240));
        
        drawRightAngledTriangle(imageWriter,250,new Color(255,0,0));
        drawRightAngledTriangle(imageWriter,200,new Color(220,0,0));
        drawRightAngledTriangle(imageWriter,150,new Color(200,0,0));
        drawRightAngledTriangle(imageWriter,100,new Color(170,0,0));
        drawRightAngledTriangle(imageWriter,50,new Color(150,0,0));
        imageWriter.writeToImage();
    }
    
    
    private void drawRightAngledTriangle(ImageWriter imageWriter,int size,Color color) {
    	 int i, j;
         for (i = size; i >= 0; i--) {
         for (j = 1; j <= ((i * 2) - 1); j++)
         	imageWriter.writePixel(j, i,color);

         }
    }
    
    @Test
    public void test2() {
        ImageWriter imageWriter = new ImageWriter("oldBrokenTV", 1000, 1000, 500, 251);
        int nX = imageWriter.getNx();
        int nY = imageWriter.getNy();
        Random rand = new Random(); 
        
        //background
        for (int i = 0; i < nY; ++i)
            for (int j = 0; j < nX; ++j)
                imageWriter.writePixel(j, i,new Color(255,255,255));
        
        
        //TV screen
        for (int i = 90; i < 220; ++i)
            for (int j = 30; j < 470; ++j)
                imageWriter.writePixel(j, i,new Color((rand.nextInt(255)),rand.nextInt(255),rand.nextInt(255)));
        
        //border - up
        for (int i = 60; i < 90; ++i)
            for (int j = 0; j < nX; ++j)
            	 imageWriter.writePixel(j, i,new Color(0,0,0));
        
      //border - down
        for (int i = 220; i < nY; ++i)
            for (int j = 0; j < nX; ++j)
            	 imageWriter.writePixel(j, i,new Color(0,0,0));
        
      //border - left
        for (int i = 60; i < nY; ++i)
            for (int j = 0; j < 30; ++j)
            	 imageWriter.writePixel(j, i,new Color(0,0,0));
        
      //border - right
        for (int i = 60; i < nY; ++i)
            for (int j = 470; j < nX; ++j)
            	 imageWriter.writePixel(j, i,new Color(0,0,0));
        
      //antenna
        for (int i = 0; i < 60; ++i)
            for (int j = 450; j < 455; ++j)
            	 imageWriter.writePixel(j, i,new Color(0,0,0));
        
        //buttons
        for (int i = 230; i < 240; ++i)
            for (int j = 460; j < 470; ++j)
            	 imageWriter.writePixel(j, i,new Color(255,0,0));
        
        for (int i = 233; i < 237; ++i)
            for (int j = 440; j < 450; ++j)
            	 imageWriter.writePixel(j, i,new Color(51,51,51));
        
        for (int i = 233; i < 237; ++i)
            for (int j = 420; j < 430; ++j)
            	 imageWriter.writePixel(j, i,new Color(51,51,51));
        

        imageWriter.writeToImage();
    }
    
}