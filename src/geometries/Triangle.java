package geometries;

import primitives.Point3D;

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
}
