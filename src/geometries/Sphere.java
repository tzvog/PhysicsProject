package geometries;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import java.util.ArrayList;
import java.util.List;

public class Sphere extends RadialGeometry{

    /* local variable declaration */
    private Point3D _center;

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
    public Sphere(double radius, Point3D p){
        super(radius);
        this._center = p;
    }


    /* Functions */

    /***
     * fins the intersection of the ray with the Sphere
     * @param ray the ray we want hitting the object
     * @return the list of points where an intersection happens
     */
    public List<Point3D> findIntersections(Ray ray){

        List<Point3D> returnList = new ArrayList<>();

        // find the vector that goes through the sphere
        Vector vectorBetweenCenterAndRay = this._center.subtract(ray.get_POO());
        double triangleFirstLegLength = vectorBetweenCenterAndRay.dotProduct(ray.get_direction());
        double triangleSecondLegLength = Math.sqrt(Math.abs(vectorBetweenCenterAndRay.lengthSquared())
                - Math.pow(triangleFirstLegLength, 2.0));

        // checks that we are not less than the radius
        if(triangleSecondLegLength > this.get_radius())
        {
            return returnList;
        }


        // fins the actual intersection points
        double withinSphereTriangleLeg = Math.abs(Math.pow(this.get_radius(), 2) -
                Math.pow(triangleSecondLegLength,2));

        // checks if we intersect with the sphere
        if((triangleFirstLegLength - withinSphereTriangleLeg) > 0){
            Point3D p1 = new Point3D(ray.get_POO().add(ray.get_direction().scale((triangleFirstLegLength
                    - withinSphereTriangleLeg))));
            returnList.add(p1);
        }

        if ((triangleFirstLegLength + withinSphereTriangleLeg) > 0){
            Point3D p2 = new Point3D(ray.get_POO().add(ray.get_direction().scale((triangleFirstLegLength
                    + withinSphereTriangleLeg))));
            returnList.add(p2);
        }

        return returnList;
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
     * @return a string version of the object
     */
    @Override
    public String toString() {
        return "" + this.get_center();
    }

}
