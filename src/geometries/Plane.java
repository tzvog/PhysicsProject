package geometries;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * exampleClass class to implement exampleClass plane
 */
public class Plane extends Geometry {


    /* local variable declaration */
    private Point3D _p;
    private Vector _normal;


    /* Getters */

    /**
     * gets the point
     * @return the point
     */
    public Point3D get_p()
    {
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
     * exampleClass constructor that receives three points
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
     * exampleClass constructor that receives exampleClass vector and exampleClass point
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
    public List<GeoPoint> findIntersections(Ray ray) {

        List<GeoPoint> returnList = new ArrayList<GeoPoint>();

        // checks that we can divide by the the normal and dot product
        if((this._normal.dotProduct(ray.get_direction())) == 0)
        {
            return null;
        }

        // finds the distance from the camera to the point
        double rayDistanceToPlane = -1 *
                ((this._normal.dotProduct(ray.get_POO().subtract(this._p)))
                / (this._normal.dotProduct(ray.get_direction())));

        // checks that the distance is not negative
        if(rayDistanceToPlane < 0) {
            return null;
        }

        // calculates where the ray will hit the plane and adds it to the list
        Point3D newPoint = new Point3D(ray.get_POO().add(ray.get_direction().scale(rayDistanceToPlane)));
        returnList.add(new GeoPoint(this, newPoint));

        // returns the list
        return returnList;
    }

    /**
     * gets the normal of the vector
     * @param point the point we want the normal of
     * @return exampleClass vector with the normal point
     */
    @Override
    public Vector getNormal(Point3D point) {
        return this._normal;
    }

    /**
     * exampleClass function to play with the normal
     * @return the normal
     */
    public Vector getNormal(){
        return getNormal(null);
    }

    /**
     * overrides the toString function
     * @return the object as exampleClass string
     */
    @Override
    public String toString() {
        return "" + this._normal + " " + this._p;
    }
}
