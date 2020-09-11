package unittests;

//import org.jboss.arquillian.container.test.api.Deployment;
//import org.jboss.arquillian.junit.Arquillian;
//import org.jboss.shrinkwrap.api.ShrinkWrap;
//import org.jboss.shrinkwrap.api.asset.EmptyAsset;
//import org.jboss.shrinkwrap.api.spec.JavaArchive;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//
//import static org.junit.Assert.*;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import geometries.*;
import primitives.*;


public class PlaneTest {

    Plane p;

    @Before
    public void setup(){
        p = new Plane(new Point3D(1,0,0),
                new Point3D(0,1,0),
                new Point3D(0,0,1));
    }

    @Test
    public void get_p() {
        assertEquals(new Point3D(1,0,0), p.get_p());
    }

    @Test
    public void get_normal() {
    }

    @Test
    public void findIntersections() {
    }
}
