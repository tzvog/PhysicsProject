package geometries;

import primitives.Point3D;
import primitives.Vector;

/**
 * creates a tube object
 */
public class Tube extends RadialGeometry {

    /* local variable declaration */

    /* Getters */

    /* Constructors */

    /**
     * a constructor for the Tube object
     */
    public Tube() {
        super(0.0);
    }


    /* Functions */


    /**
     * implements the get normal function
     * @param point the point we want the normal from
     * @return the normalized vector
     */
    @Override
    public Vector getNormal(Point3D point) {
        return null;
    }

    /**
     * overrides the toString function
     * @return the toString
     */
    @Override
    public String toString() {
        return "";
    }
}
