package unittests;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Test;

import geometries.Sphere;
import geometries.Triangle;
import primitives.Point3D;
import render.ImageWriter;
import render.Render;
import render.ImageWriter;
import render.Render;
import scene.Scene;

public class TestRenderer {

	@Test
	
		public void basicRendering(){
			
			Scene scene = new Scene();
			
			scene.addGeometry(new Sphere(Color.blue, 50, new Point3D(0.0, 0.0, -150)));
			
			Triangle triangle = new Triangle(Color.red,new Point3D( 100, 0, -149),
					 						 new Point3D(  0, 100, -149),
					 						 new Point3D( 100, 100, -149));
			
			Triangle triangle2 = new Triangle(Color.green,new Point3D( 100, 0, -149),
					 			 			  new Point3D(  0, -100, -149),
					 			 			  new Point3D( 100,-100, -149));
			
			Triangle triangle3 = new Triangle(Color.orange,new Point3D(-100, 0, -149),
					 						  new Point3D(  0, 100, -149),
					 						  new Point3D(-100, 100, -149));
			
			Triangle triangle4 = new Triangle(Color.pink,new Point3D(-100, 0, -149),
					 			 			  new Point3D(  0,  -100, -149),
					 			 			  new Point3D(-100, -100, -149));
			
			scene.addGeometry(triangle);
			scene.addGeometry(triangle2);
			scene.addGeometry(triangle3);
			scene.addGeometry(triangle4);
			
			ImageWriter imageWriter = new ImageWriter("Render test", 500, 500, 500, 500);
			
			Render render = new Render(scene, imageWriter);
			
			render.renderImage();
			render.printGrid(50);
			imageWriter.writeToimage();
	
			
		}

	}
