/**
 * 
 */
package unittests;

import static org.junit.Assert.*;

import org.junit.Test;

import geometries.*;
import primitives.*;

/**
 * Tube class tests
 * 
 * @author Dan
 *
 */
public class TubesTests {

    /**
     * Test method for {@link Tube#getNormal(Point3D)}.
     */
    @Test
    public void testGetNormal() {
        // ============ Equivalence Partitions Tests ==============
        // TC01: There is a simple single test here
        Tube tube = new Tube(1.0, new Ray(new Point3D(0, 0, 1), new Vector(0, 1, 0)));
        assertEquals("Bad normal to tube", new Vector(0, 0, 1), 
        		tube.getNormal(new Point3D(0, 0.5, 2)));
    }

}
