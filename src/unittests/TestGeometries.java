package unittests;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Test;

import geometries.Plane;
import geometries.Sphere;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

public class TestGeometries {

	@Test
	public void testSphereNormal() {
		
		Vector answer = new Vector(0.7071067811865475, 0.7071067811865475, 0.0);
		
		Point3D p1 = new Point3D(0, 0, -400);
		Point3D p2 = new Point3D(1,1, -400);
		
		Sphere sphere = new Sphere(200, p1);
			
		Vector vector = sphere.getNormal(p2);
		assertEquals(answer, vector);
		
	}
	@Test
	public void testPlaneNormal() {
		Vector answer = new Vector(0,0, -1);

		Point3D directionPoint = new Point3D(0, 0, -1);
		Point3D planePoint = new Point3D(0, 100, -200);
		Point3D normalPoint = new Point3D(1, 1, -200);
		
		Vector direction = new Vector(directionPoint);
		
		Plane plane = new Plane(planePoint, direction);
				
		Vector vector = plane.getNormal(normalPoint);
		assertEquals(answer, vector);
		
	}
	
	@Test
	public void testTriangleNormal() {
		Vector answer = new Vector(0,0, -1);
		Point3D directionPoint = new Point3D(0, 0, -1);
		Point3D planePoint = new Point3D(0, 100, -200);
		Point3D normalPoint = new Point3D(1, 1, -200);
		
		Vector direction = new Vector(directionPoint);
		
		Plane plane = new Plane(planePoint, direction);
		
		Vector vector = plane.getNormal(normalPoint);
		assertEquals(answer, vector);
	
	}

}
