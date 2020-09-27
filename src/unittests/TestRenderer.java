package unittests;

import static org.junit.Assert.*;

import java.awt.Color;

import elements.AmbientLight;
import elements.Camera;
import org.junit.Test;

import geometries.Sphere;
import geometries.Triangle;
import primitives.Point3D;
import primitives.Vector;
import render.ImageWriter;
import render.Render;
import scene.Scene;

public class TestRenderer {
	@Test
	public void basicRenderTwoColorTest() {
		Scene scene = new Scene("Test scene");
		scene.set_camera(new Camera(Point3D.ZERO, new Vector(0, 0, 1),
				new Vector(0, -1, 0)));
		scene.set_screenDistance(100);
//		scene.set_background(new Color(75, 127, 90));
		scene.set_background(new Color(0, 0, 0));
		scene.set_ambientLight(new AmbientLight(new Color(255, 191, 191), 1));

		scene.addGeometries(new Sphere(Color.blue, 50, new Point3D(0, 0, 100)));

		scene.addGeometries(
				new Triangle(Color.red, new Point3D(100, 0, 100), new Point3D(0, 100, 100), new Point3D(100, 100, 100)),
				new Triangle(Color.green, new Point3D(100, 0, 100), new Point3D(0, -100, 100), new Point3D(100, -100, 100)),
				new Triangle(Color.orange, new Point3D(-100, 0, 100), new Point3D(0, 100, 100), new Point3D(-100, 100, 100)),
				new Triangle(Color.pink, new Point3D(-100, 0, 100), new Point3D(0, -100, 100), new Point3D(-100, -100, 100)));

		ImageWriter imageWriter = new ImageWriter("base render 3 test", 500, 500, 500, 500);
		Render render = new Render(imageWriter, scene);

		render.renderImage();
		render.printGrid(50);
		render.writeToImage();
	}

	}


