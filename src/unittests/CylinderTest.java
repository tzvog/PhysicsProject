package unittests;

import geometries.Cylinder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import static org.junit.Assert.*;

public class CylinderTest {

    Cylinder c;

    @Before
    public void setUp()
    {
        c = new Cylinder(1.0, new Ray(new Point3D(0,0,0),
                new Vector(1,0,0)), 2.0);
    }

    @Test
    public void get_axisRay() {
    }

    @Test
    public void getNormal() {
    }

    @Test
    public void get_radius() {
        assertEquals(1.0, c.get_radius(), 0);
    }

    @Test
    public void get_height() {
        assertEquals(2.0, c.get_height(), 0);
    }

}