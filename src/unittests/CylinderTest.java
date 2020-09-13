package unittests;

import geometries.Cylinder;
import geometries.Plane;
import geometries.Tube;
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

    /**
     * Test method for {@link Tube#getNormal(Point3D)}.
     */
    @Test
    public void testGetNormal() {
        Cylinder cyl = new Cylinder(1.0, new Ray(new Point3D(0, 0, 1), new Vector(0, 1, 0)), 1d);

        // ============ Equivalence Partitions Tests ==============
        // TC01: Point at a side of the cylinder
        assertEquals("Bad normal to cylinder", new Vector(0, 0, 1), cyl.getNormal(new Point3D(0, 0.5, 2)));

        // TC02: Point at a 1st base of the cylinder
        assertEquals("Bad normal to lower base of cylinder", new Vector(0, 1, 0), cyl.getNormal(new Point3D(0, 0, 1.5)));

        // TC03: Point at a 2nd base of the cylinder
        assertEquals("Bad normal to upper base of cylinder", new Vector(0, 1, 0), cyl.getNormal(new Point3D(0, 1, 0.5)));

        // =============== Boundary Values Tests ==================
        // TC11: Point at the center of 1st base
        assertEquals("Bad normal to center of lower base", new Vector(0, 1, 0), cyl.getNormal(new Point3D(0, 0, 1)));

        // TC12: Point at the center of 2nd base
        assertEquals("Bad normal to center of upper base", new Vector(0, 1, 0), cyl.getNormal(new Point3D(0, 1, 1)));

        // TC13: Point at the edge with 1st base
        assertEquals("Bad normal to edge with lower base", new Vector(0, 1, 0), cyl.getNormal(new Point3D(0, 0, 2)));

        // TC14: Point at the edge with 2nd base
        assertEquals("Bad normal to edge with upper base", new Vector(0, 1, 0), cyl.getNormal(new Point3D(0, 1, 2)));

    }


    @Test
    public void testGetNormalPoint3D() {
        // ============ Equivalence Partitions Tests ==============
        // TC01: There is a simple single test here
        Plane pl = new Plane(new Point3D(0, 0, 1), new Point3D(1, 0, 0), new Point3D(0, 1, 0));
        double sqrt3 = Math.sqrt(1d/3);

        assertEquals("Bad normal to plane", new Vector(sqrt3, sqrt3, sqrt3), pl.getNormal(new Point3D(0, 0, 1)));
    }

}