package unittests;

import geometries.Sphere;
import org.junit.Before;
import org.junit.Test;
import primitives.Point3D;
import primitives.Vector;

import java.awt.*;

import static org.junit.Assert.*;

public class SphereTest {

    Sphere s;

    @Before
    public void start()
    {
        s = new Sphere(new Point3D(0,0, 0), 1);
    }


    @Test
    public void get_radius() {
        assertEquals(1, s.get_radius(), 0);
    }

    @Test
    public void get_center() {
        assertEquals(new Point3D(0,0,0), s.get_center());
    }

    @Test
    public void getNormal() {
        assertEquals(new Vector(1,0,0),
                s.getNormal(new Point3D(1,0,0)));
    }
}