/**
 * 
 */
package unittests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import geometries.*;
import primitives.*;

/**
 * Sphere class tests
 *
 */
public class SpheresTests {

    /**
     * Test method for {@link Sphere#getNormal(Point3D)}.
     */
    @Test
    public void testGetNormal() {
        // ============ Equivalence Partitions Tests ==============
        // TC01: There is a simple single test here
        Sphere sph = new Sphere(1.0, new Point3D(0, 0, 1));
        assertEquals("Bad normal to sphere", new Vector(0, 0, 1), sph.getNormal(new Point3D(0, 0, 2)));
    }

    /**
     * Test method for {@link Sphere#findIntersections(Ray)}.
     */
    
    /*
     * 
     * JV In shlav 2 we are not testing findIntersections just yet
     */

    @Test
    public void testFindIntersections() {
        // ============ Equivalence Partitions Tests ==============
        Point3D p1 = new Point3D(0.0651530771650466, 0.355051025721682, 0);
        Point3D p2 = new Point3D(1.53484692283495, 0.844948974278318, 0);
       // List<Point3D> exp = List.of(p1, p2);
        List<Point3D> exp = new ArrayList<Point3D>();
        exp.add(p1);
        exp.add(p2);

        // TC01: Ray's line is outside the sphere (0 points)
        assertEquals("Ray's line out of sphere", null,
                new Sphere(1d, new Point3D(1, 0, 0))
                                .findIntersections(new Ray(new Point3D(-1, 0, 0), new Vector(1, 1, 0))));
        // TC02: Ray starts before and crosses the sphere (2 points)
        List<Point3D> result = new Sphere(1d, new Point3D(1, 0, 0))
                .findIntersections(new Ray(new Point3D(-1, 0, 0), new Vector(3, 1, 0)));
        assertEquals("Wrong number of points", 2, result.size());
        if (result.get(0).get_x().get() > result.get(1).get_x().get())
            result = List.of(result.get(1), result.get(0));
        assertEquals("Ray crosses sphere", exp, result);
        // TC03: Ray starts inside the sphere (1 point)
        assertEquals("Ray from inside sphere", List.of(p2),
                new Sphere(1d, new Point3D(1, 0, 0))
                        .findIntersections(new Ray(new Point3D(0.5, 0.5, 0), new Vector(3, 1, 0))));
        // TC04: Ray starts after the sphere (0 points)
        assertEquals("Sphere behind Ray", null,
                new Sphere(1d, new Point3D(1, 0, 0))
                        .findIntersections(new Ray(new Point3D(2, 1, 0), new Vector(3, 1, 0))));
        // =============== Boundary Values Tests ==================
        // **** Group: Ray's line crosses the sphere (but not the center)
        // TC11: Ray starts at sphere and goes inside (1 points)
        assertEquals("Ray from sphere inside", List.of(new Point3D(2, 0, 0)),
                new Sphere(1d, new Point3D(1, 0, 0))
                        .findIntersections(new Ray(new Point3D(1, -1, 0), new Vector(1, 1, 0))));
        // TC12: Ray starts at sphere and goes outside (0 points)
        assertEquals("Ray from sphere outside", null,
                new Sphere(1d, new Point3D(1, 0, 0))
                        .findIntersections(new Ray(new Point3D(2, 0, 0), new Vector(1, 1, 0))));

        // **** Group: Ray's line goes through the center
        // TC13: Ray starts before the sphere (2 points)
        result = new Sphere(1d, new Point3D(1, 0, 0))
                .findIntersections(new Ray(new Point3D(1, -2, 0), new Vector(0, 1, 0)));
        assertEquals("Wrong number of points", 2, result.size());
        if (result.get(0).get_y().get() > result.get(1).get_y().get())
            result = List.of(result.get(1), result.get(0));
        assertEquals("Line through O, ray crosses sphere",
                List.of(new Point3D(1, -1, 0), new Point3D(1, 1, 0)), result);
        // TC14: Ray starts at sphere and goes inside (1 points)
        assertEquals("Line through O, ray from and crosses sphere", List.of(new Point3D(1, 1, 0)),
                new Sphere(1d, new Point3D(1, 0, 0))
                        .findIntersections(new Ray(new Point3D(1, -1, 0), new Vector(0, 1, 0))));
        // TC15: Ray starts inside (1 points)
        assertEquals("Line through O, ray from inside sphere", List.of(new Point3D(1, 1, 0)),
                new Sphere(1d, new Point3D(1, 0, 0))
                        .findIntersections(new Ray(new Point3D(1, 0.5, 0), new Vector(0, 1, 0))));
        // TC16: Ray starts at the center (1 points)
        assertEquals("Line through O, ray from O", List.of(new Point3D(1, 1, 0)),
                new Sphere(1d, new Point3D(1, 0, 0))
                        .findIntersections(new Ray(new Point3D(1, 0, 0), new Vector(0, 1, 0))));
        // TC17: Ray starts at sphere and goes outside (0 points)
        assertEquals("Line through O, ray from sphere outside", null,
                new Sphere(1d, new Point3D(1, 0, 0))
                        .findIntersections(new Ray(new Point3D(1, 1, 0), new Vector(0, 1, 0))));
        // TC18: Ray starts after sphere (0 points)
        assertEquals("Line through O, ray outside sphere", null,
                new Sphere(1d, new Point3D(1, 0, 0))
                        .findIntersections(new Ray(new Point3D(1, 2, 0), new Vector(0, 1, 0))));

        // **** Group: Ray's line is tangent to the sphere (all tests 0 points)
        // TC19: Ray starts before the tangent point
        assertEquals("Tangent line, ray before sphere", null,
                new Sphere(1d, new Point3D(1, 0, 0))
                        .findIntersections(new Ray(new Point3D(0, 1, 0), new Vector(1, 0, 0))));
        // TC20: Ray starts at the tangent point
        assertEquals("Tangent line, ray at sphere", null,
                new Sphere(1d, new Point3D(1, 0, 0))
                        .findIntersections(new Ray(new Point3D(1, 1, 0), new Vector(1, 0, 0))));
        // TC21: Ray starts after the tangent point
        assertEquals("Tangent line, ray after sphere", null,
                new Sphere(1d, new Point3D(1, 0, 0))
                        .findIntersections(new Ray(new Point3D(2, 1, 0), new Vector(1, 0, 0))));

        // **** Group: Special cases
        // TC19: Ray's line is outside, ray is orthogonal to ray start to sphere's
        // center line
        assertEquals("Ray orthogonal to ray head -> O line", null,
                new Sphere(1d, new Point3D(1, 0, 0))
                        .findIntersections(new Ray(new Point3D(-1, 0, 0), new Vector(0, 0, 1))));

    }


}
