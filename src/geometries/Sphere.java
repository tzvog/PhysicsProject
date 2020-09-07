package geometries;

import primitives.Point3D;
import primitives.Vector;

public class Sphere extends RadialGeometry{

    /* local variable declaration */
    Point3D _center;

    /* Getters */

    /**
     * a getter for the center
     * @return the center
     */
    public Point3D get_center() {
        return _center;
    }


    /* Constructors */

    /**
     * a constructor for the sphere
     */
    public Sphere(){
        super(0.0);
    }


    /* Functions */

    /**
     * implements the get normal function
     * @param point the point
     * @return the normalized vector
     */
    @Override
    public Vector getNormal(Point3D point) {

        // as taught in the presentation
        Vector v = point.subtract(this._center);
        return v.normalize();
    }

    /**
     * override the toString function
     * @return a string version of the object
     */
    @Override
    public String toString() {
        return "" + this.get_center();
    }

}
