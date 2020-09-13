/**
 * 
 */
package unittests;

import static org.junit.Assert.*;

import org.junit.Test;

import geometries.*;
import primitives.*;

/**
 * @author Dan
 *
 */
public class PlanesTests {

    /**
     * Test method for {@link Plane#getNormal(Point3D)}.
     */
    @Test
    public void testGetNormalPoint3D() {
        // ============ Equivalence Partitions Tests ==============
        // TC01: There is a simple single test here
        Plane pl = new Plane(new Point3D(0, 0, 1), new Point3D(1, 0, 0), new Point3D(0, 1, 0));
        double sqrt3 = Math.sqrt(1d/3);
         
        assertEquals("Bad normal to plane", new Vector(sqrt3, sqrt3, sqrt3), pl.getNormal(new Point3D(0, 0, 1)));
    }

}
