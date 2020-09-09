package geometries;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

/**
 * creates a tube object
 */
public class Tube extends RadialGeometry {

    /* local variable declaration */
    private Ray _axisRay;

    /* Getters */
    public Ray get_axisRay() {
        return _axisRay;
    }

    /* Constructors */

    /**
     * a constructor for the Tube object
     */
    public Tube(double radius) {
        super(radius);
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
