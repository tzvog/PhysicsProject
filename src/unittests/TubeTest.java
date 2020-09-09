package unittests;

import geometries.Tube;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TubeTest {

    Tube t;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void get_radius() {
        t = new Tube(4);
        assertEquals(4.0, t.get_radius(), 0.0);
    }

    @Test
    public void get_axisRay() {
    }

    @Test
    public void getNormal() {
    }
}