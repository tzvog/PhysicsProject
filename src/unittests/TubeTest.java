package unittests;

import geometries.Tube;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import static org.junit.Assert.*;

public class TubeTest {

    Tube t;


    @Test
    public void get_radius() {
        t = new Tube(4, new Ray(new Point3D(0,0,0),
                new Vector(1,0,0)));
        assertEquals(4.0, t.get_radius(), 0.0);
    }

    @Test
    public void get_axisRay() {
    }

    @Test
    public void getNormal() {
    }
}