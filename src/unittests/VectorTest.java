package unittests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import primitives.Coordinate;
import primitives.Point3D;
import primitives.Vector;

import static org.junit.Assert.*;

public class VectorTest {

    Vector v;

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
            Vector v2 = new Vector(-2, -3, -5);
            Vector v3 = v.add(v2);
            fail("bad zero vector");
        }
        catch (IllegalArgumentException ex){}

        Vector v4 = new Vector(1, 2, 3);
        Vector v5 = new Vector(v.add(v4));

        assertEquals(3 , v5.get_point().get_firstCoordinate().get(), 0.0);
        assertEquals(5 , v5.get_point().get_secondCoordinate().get(), 0.0);
        assertEquals(8 , v5.get_point().get_thirdCoordinate().get(), 0.0);

    }

    @Test
    public void subtract() {

        v = new Vector(2, 3, 5);

        try {
            Vector v2 = new Vector(2, 3, 5);
            Vector v3 = v.subtract(v2);
            fail("bad zero vector");
        }
        catch (IllegalArgumentException ex){}

        Vector v4 = new Vector(1, 2, 3);
        Vector v5 = new Vector(v.subtract(v4));

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
    }

    @Test
    public void crossProduct() {
    }

    @Test
    public void lengthSquared() {
    }

    @Test
    public void length() {
    }

    @Test
    public void normalize() {
    }

    @Test
    public void normalized() {
    }

    @Test
    public void equals1() {
    }

    @Test
    public void toString1() {
    }
}