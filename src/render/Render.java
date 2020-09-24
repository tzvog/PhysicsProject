package render;

import geometries.Geometry;
import primitives.Point3D;
import primitives.Ray;
import scene.Scene;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * a class to represent the render
 */
public class Render {

    /* local variable declaration */
    private Scene _scene;
    private ImageWriter _imageWriter;

    /* Getters */

    /**
     * gets the scene
     * @return the scene
     */
    public Scene get_scene() {
        return _scene;
    }

    /**
     * gets the image writer
     * @return the image writer
     */
    public ImageWriter get_imageWriter() {
        return _imageWriter;
    }

    /* Constructors */

    /**
     * constructor that receives all parameters
     * @param _scene the scene
     * @param _imageWriter the image writer
     */
    public Render(Scene _scene, ImageWriter _imageWriter) {
        this._scene = _scene;
        this._imageWriter = _imageWriter;
    }

    /* Functions */

    /**
     * prints the grid
     */
    public void printGrid(int interval) {

    }

    /**
     * renders the image
     */
    public void renderImage(){

    }

    /**
     * gets the intersection of the scene with the ray
     * @param ray the ray
     * @return the list of points that have an intersection
     */
    private List<Point3D> getSceneRayIntersections(Ray ray) {

        Iterator<Geometry> geometries = _scene.getGeometriesIterator();
        List<Point3D> intersectionPoints = new ArrayList<Point3D>();

        // checks with the next geometry where we have an intersection
        while (geometries.hasNext())
        {
            Geometry geometry = geometries.next();
            List<Point3D> geometryIntersectionPoints = geometry.findIntersections(ray);
            intersectionPoints.addAll(geometryIntersectionPoints);
        }

        return intersectionPoints;
    }


    /**
     * gets the closest points
     * @param intersectionPoints a list of intersection points
     * @return a point with the closest point
     */
    private Point3D getClosestPoint(List<Point3D> intersectionPoints) {

        double distance = Double.MAX_VALUE;
        Point3D P0 = this._scene.get_camera().get_P0();
        Point3D minDistancePoint = null;

        // goes through the points and finds the closest
        for (Point3D point: intersectionPoints) {
            if (P0.distance(point) < distance){
                minDistancePoint = new Point3D(point);
                distance = P0.distance(point);
            }
        }

        return minDistancePoint;
    }

    /**
     * calculates the color
     * @param point the point
     * @return the color calculated
     */
    private Color calcColor(Point3D point) {

        return _scene.get_ambientLight().getIntesity(point);
    }
}
