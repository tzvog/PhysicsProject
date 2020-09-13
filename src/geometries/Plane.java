package geometries;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import java.util.ArrayList;
import java.util.List;

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

        // checks that vectors are not the same
        if(firstPoint.equals(secondPoint) || firstPoint.equals(thirdPoint))
        {
            throw new IllegalArgumentException("two of the same vector");
        }

        Vector v1 = firstPoint.subtract(secondPoint);
        Vector v2 = firstPoint.subtract(thirdPoint);

        this._normal = v1.crossProduct(v2).normalize();
        this._p = new Point3D(firstPoint);

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
     * gets the intersection with the plane
     * @param ray the ray we are aiming towards the plane
     * @return the point it has reached
     */
    @Override
    public List<Point3D> findIntersections(Ray ray) {

        List<Point3D> returnList = new ArrayList<Point3D>();

        // finds the distance from the camera to the point
        double rayDistanceToPlane = (this._normal.dotProduct(ray.get_POO().subtract(this._p)))
                / (this._normal.dotProduct(ray.get_direction()));

        // calculates where the ray will hit the plane and adds it to the list
        Point3D newPoint = new Point3D(ray.get_POO().add(ray.get_direction().scale(rayDistanceToPlane)));
        returnList.add(newPoint);

        // returns the list
        return returnList;
    }

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
