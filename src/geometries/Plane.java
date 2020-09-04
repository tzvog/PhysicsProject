package geometries;

import primitives.Point3D;
import primitives.Vector;

/**
 * a class to implement a plane
 */
public class Plane implements Geometry {


    /* local variable declaration */
    private Point3D _p;
    private Vector _normal;


    /* Getters */

    /**
     * gets the point
     * @return the point
     */
    public Point3D get_p() {
        return _p;
    }

    /**
     * gets the vector
     * @return the normal vector
     */
    public Vector get_normal() {
        return _normal;
    }

    /* Constructors */

    /**
     * a constructor that receives three points
     * @param firstPoint the first point
     * @param secondPoint the second point
     * @param thirdPoint the third point
     */
    public Plane(Point3D firstPoint, Point3D secondPoint, Point3D thirdPoint){

    }

    /**
     * a constructor that receives a vector and a point
     * @param point the point we want to work with
     * @param vector the vector we want to work with
     */
    public Plane(Point3D point, Vector vector){
        this._p = point;
        this._normal = vector;
    }

    /* Functions */

    /**
     * gets the normal of the vector
     * @param point the point we want the normal of
     * @return a vector with the normal point
     */
    @Override
    public Vector getNormal(Point3D point) {
        return this._normal;
    }

    /**
     * a function to play with the normal
     * @return the normal
     */
    public Vector getNormal(){
        return getNormal(null);
    }

    /**
     * overrides the toString function
     * @return the object as a string
     */
    @Override
    public String toString() {
        return "" + this._normal + " " + this._p;
    }
}
