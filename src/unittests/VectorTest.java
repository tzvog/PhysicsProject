package unittests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import primitives.Coordinate;
import primitives.Point3D;
import primitives.Vector;

import static org.junit.Assert.*;

public class VectorTest {

    Vector v, v2, v3, v4, v5;


    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void constructorTest(){

        try {
            v = new Vector(new Coordinate(0), new Coordinate(0), new Coordinate(0));
            fail("bad on zero vector constructor with coordinate");
        }
        catch (IllegalArgumentException ex)
        { }

        try {
            v = new Vector(0, 0, 0);
            fail("bad on zero vector constructor with doubles");
        }
        catch (IllegalArgumentException ex)
        { }

        try {
            Point3D p = new Point3D(0,0,0);
            v = new Vector(p);
            fail("bad on zero vector constructor with Point3D");
        }
        catch (IllegalArgumentException ex)
        { }


        try {
            v = new Vector(new Coordinate(2), new Coordinate(5), new Coordinate(7));
        }
        catch (IllegalArgumentException ex)
        {
            fail("bad on constructor with coordinates");
        }

        try {
            v = new Vector(2, 5, 7);
        }
        catch (IllegalArgumentException ex)
        {
            fail("bad on constructor with double");
        }

        try {
            Point3D p = new Point3D(2,5,7);
            v = new Vector(p);
        }
        catch (IllegalArgumentException ex)
        {
            fail("bad on vector constructor with Point3D");
        }

        try {
            Vector p = new Vector(2,5,7);
            v = new Vector(p);
        }
        catch (IllegalArgumentException ex)
        {
            fail("bad on vector constructor with that receives another vector");
        }

    }

    @Test
    public void get_point() {

        v = new Vector(2, 3, 5);

        assertEquals(2.0, v.get_point().get_firstCoordinate().get(), 0);
        assertEquals(3.0, v.get_point().get_secondCoordinate().get(), 0);
        assertEquals(5.0, v.get_point().get_thirdCoordinate().get(), 0);


        assertNotEquals(6.0, v.get_point().get_firstCoordinate().get(), 0);
        assertNotEquals(6.0, v.get_point().get_secondCoordinate().get(), 0);
        assertNotEquals(6.0, v.get_point().get_thirdCoordinate().get(), 0);

    }

    @Test
    public void add() {

        v = new Vector(2, 3, 5);

        try {
            v2 = new Vector(-2, -3, -5);
            v3 = v.add(v2);
            fail("bad zero vector");
        }
        catch (IllegalArgumentException ex){}

        v4 = new Vector(1, 2, 3);
        v5 = new Vector(v.add(v4));

        assertEquals(3 , v5.get_point().get_firstCoordinate().get(), 0.0);
        assertEquals(5 , v5.get_point().get_secondCoordinate().get(), 0.0);
        assertEquals(8 , v5.get_point().get_thirdCoordinate().get(), 0.0);

    }

    @Test
    public void subtract() {

        v = new Vector(2, 3, 5);

        try {
            v2 = new Vector(2, 3, 5);
            v3 = v.subtract(v2);
            fail("bad zero vector");
        }
        catch (IllegalArgumentException ex){}

        v4 = new Vector(1, 2, 3);
        v5 = new Vector(v.subtract(v4));

        assertEquals(1 , v5.get_point().get_firstCoordinate().get(), 0.0);
        assertEquals(1 , v5.get_point().get_secondCoordinate().get(), 0.0);
        assertEquals(2 , v5.get_point().get_thirdCoordinate().get(), 0.0);
    }

    @Test
    public void scale() {

        v = new Vector(2, 3, 5);

        try {
            v.scale(0);
            fail("bad zero vector");
        }
        catch (IllegalArgumentException ex){}

        Vector v2 = v.scale(-1);
        assertEquals(-2 , v2.get_point().get_firstCoordinate().get(), 0.0);
        assertEquals(-3 , v2.get_point().get_secondCoordinate().get(), 0.0);
        assertEquals(-5, v2.get_point().get_thirdCoordinate().get(), 0.0);

        Vector v3 = v.scale(3);
        assertEquals(6 , v3.get_point().get_firstCoordinate().get(), 0.0);
        assertEquals(9 , v3.get_point().get_secondCoordinate().get(), 0.0);
        assertEquals(15, v3.get_point().get_thirdCoordinate().get(), 0.0);

    }

    @Test
    public void dotProduct() {

        v = new Vector(2, 3, 5);
        v2 = new Vector(2, 3, 5);
        assertEquals(38 , v.dotProduct(v2), 0.0);

        v = new Vector(1, 0, 0);
        v2 = new Vector(0,1,1);
        assertEquals(0 , v.dotProduct(v2), 0.0);

    }

    @Test
    public void crossProduct() {

        v = new Vector(1, 0, 0);
        v2 = new Vector(0, 1, 0);
        v3 = v.crossProduct(v2);

        assertEquals("basic cross product",
                new Point3D(0,0,1), v3.get_point());
    }

    @Test
    public void lengthSquared() {

        v = new Vector(1, 0, 0);
        assertEquals(1, v.lengthSquared(), 0);

        v2 = new Vector(2,3,5);
        assertEquals(38, v2.lengthSquared(), 0);

        v3 = new Vector(-2,-3,-5);
        assertEquals(38, v3.lengthSquared(), 0);
    }

    @Test
    public void length() {

        v = new Vector(1, 0, 0);
        assertEquals(1, v.length(), 0);

        v2 = new Vector(-2,-3,-5);
        assertEquals(Math.sqrt(38), v2.length(), 0);

        v3 = new Vector(2,3,5);
        assertEquals(Math.sqrt(38), v3.length(), 0);
    }

    @Test
    public void normalize() {

        v = new Vector(1, 0, 0);
        assertEquals(1, v.normalize().length(), 0);

        v2 = new Vector(-2,-3,-5);
        assertEquals(1, v2.normalize().length(), 0);

        v3 = new Vector(2,3,5);
        assertEquals(1, v3.normalize().length(), 0);
    }

    @Test
    public void normalized() {

        v = new Vector(1, 0, 0);
        assertEquals(1, v.normalized().length(), 0);

        v2 = new Vector(-2,-3,-5);
        assertEquals(1, v2.normalized().length(), 0);

        v3 = new Vector(2,3,5);
        assertEquals(1, v3.normalized().length(), 0);
    }
}