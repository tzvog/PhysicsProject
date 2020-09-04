package unittests;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(Arquillian.class)
public class VectorTest {
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(primitives.Vector.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @org.junit.Test
    public void get_point() {
    }

    @org.junit.Test
    public void add() {
    }

    @org.junit.Test
    public void subtract() {
    }

    @org.junit.Test
    public void scale() {
    }

    @org.junit.Test
    public void dotProduct() {
    }

    @org.junit.Test
    public void crossProduct() {
    }

    @org.junit.Test
    public void lengthSquared() {
    }

    @org.junit.Test
    public void length() {
    }

    @org.junit.Test
    public void normalize() {
    }

    @org.junit.Test
    public void normalized() {
    }

    @org.junit.Test
    public void equals1() {
    }

    @org.junit.Test
    public void toString1() {
    }
}
