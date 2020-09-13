package geometries;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import java.util.ArrayList;
import java.util.List;

/**
 * an object to represent a triangle in the plane
 */
public class Triangle extends Polygon{

    /**
     * a constructor to create a triangle
     * @param firstPoint the first point
     * @param secondPoint the second point
     * @param thirdPoint the third point
     */
    public Triangle(Point3D firstPoint, Point3D secondPoint, Point3D thirdPoint){
        super(firstPoint, secondPoint, thirdPoint);
    }

    @Override
    public List<Point3D> findIntersections(Ray ray) {

        List<Point3D> returnList = new ArrayList<Point3D>();

        // create vectors that touch the points of the triangle
        Vector v1 = new Vector(this._vertices.get(0).subtract(ray.get_POO()));
        Vector v2 = new Vector(this._vertices.get(1).subtract(ray.get_POO()));
        Vector v3 = new Vector(this._vertices.get(2).subtract(ray.get_POO()));

        // find the normals with each of the planes
        Vector N1 = new Vector(v2.crossProduct(v1)).normalize();
        Vector N2 = new Vector(v3.crossProduct(v2)).normalize();
        Vector N3 = new Vector(v1.crossProduct(v3)).normalize();

        Vector v = ray.get_direction().subtract(new Vector(ray.get_POO()));

        // checks if we are within the range of the triangle
        if(((v.dotProduct(N1) > 0) && (v.dotProduct(N2) > 0) && (v.dotProduct(N3) > 0)) ||
                ((v.dotProduct(N1) < 0) && (v.dotProduct(N2) < 0) && (v.dotProduct(N3) < 0))){

            // gets the point the intersections with the plane
            returnList = this._plane.findIntersections(ray);
        }


        return returnList;
    }
}
