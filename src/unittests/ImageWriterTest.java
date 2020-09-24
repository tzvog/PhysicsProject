package unittests;

import org.junit.Test;
import render.ImageWriter;

import java.awt.*;

import static org.junit.Assert.*;

public class ImageWriterTest {

    @Test
    public void makeImage()
    {
        ImageWriter i = new ImageWriter("IM", 500, 500, 500, 500);


        for (int j = 0; j < 500; j++) {
            for (int k = 0; k < 500; k++) {

                Color c = new Color(0,0,0);

                // checks if we have reached a spot
                if(((k % 50) == 0) || (j % 50) == 0){
                    c = new Color(255, 255,255);
                }

                i.writePixel(j, k, c);
            }
        }

        i.writeToimage();
    }

}