package geometries;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Sphere extends RadialGeometry{

    /* local variable declaration */
    private Point3D _center;
    private Color _color;

    /* Getters */

    /**
     * exampleClass getter for the center
     * @return the center
     */
    public Point3D get_center() {
        return _center;
    }

    @Override
    /**
     * returns the color
     */
    public Color get_color() {
        return this._color;
    }

    /* Constructors */

    /**
     * exampleClass constructor for the sphere
     */
    public Sphere(Color color, double radius, Point3D p){
        super(radius);
        this._center = p;
        _color = color;
    }

    /**
     * exampleClass constructor for the sphere
     */
    public Sphere(double radius, Point3D p){
        this(new Color(0,0,0), radius, p);
    }


    /* Functions */

    /***
     * fins the intersection of the ray with the Sphere
     * @param ray the ray we want hitting the object
     * @return the list of points where an intersection happens
     */
    public List<GeoPoint> findIntersections(Ray ray){

        List<GeoPoint> returnList = new ArrayList<>();

        // checks what happens when the vector starts through the center spot
        if(this.get_center().equals(ray.get_POO())){
            returnList.add(new GeoPoint(this,
                    new Point3D(ray.get_POO().add(ray.get_direction().normalized()))));
            return returnList;
        }

        // find the vector that goes through the sphere
        Vector vectorBetweenCenterAndRay = this._center.subtract(ray.get_POO());
        double triangleFirstLegLength = vectorBetweenCenterAndRay.dotProduct(ray.get_direction());

        // finds the distance between dot and center
        double triangleSecondLegLength = Math.sqrt(
                vectorBetweenCenterAndRay.lengthSquared()
                - Math.pow(triangleFirstLegLength, 2.0));

        // checks that we are not less than the radius
        if(triangleSecondLegLength >= this.get_radius())
        {
            return null;
        }


        // fins the actual intersection points
        double withinSphereTriangleLeg = Math.sqrt(Math.pow(this.get_radius(), 2) -
                Math.pow(triangleSecondLegLength,2));

        // checks if we intersect with the sphere and if so where
        if((triangleFirstLegLength - withinSphereTriangleLeg) > 0){
            Point3D p1 = new Point3D(ray.get_POO().add(ray.get_direction().scale(
                    (triangleFirstLegLength - withinSphereTriangleLeg))));
            returnList.add(new GeoPoint(this ,p1));
        }

        if ((triangleFirstLegLength + withinSphereTriangleLeg) > 0){
            Point3D p2 = new Point3D(ray.get_POO().add(ray.get_direction().scale(
                    (triangleFirstLegLength + withinSphereTriangleLeg))));
            returnList.add(new GeoPoint(this, p2));
        }

        return  (returnList.size() != 0) ? returnList : null ;
    }

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
     * @return exampleClass string version of the object
     */
    @Override
    public String toString() {
        return "" + this.get_center();
    }

}
