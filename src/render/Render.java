package render;

import geometries.Geometries;
import geometries.Geometry;
import geometries.Intersectable;
import primitives.Point3D;
import primitives.Ray;
import scene.Scene;

import java.awt.*;
import java.util.*;
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
    public Render(ImageWriter _imageWriter, Scene _scene) {
        this._scene = _scene;
        this._imageWriter = _imageWriter;
    }

    /* Functions */

    /**
     * prints the grid
     */
    public void printGrid(int interval) {

        for (int j = 0; j < this._imageWriter.getHeight(); j++) {
            for (int k = 0; k <  this._imageWriter.getWidth(); k++) {

                // checks if we have reached a spot
                if(((k % interval) == 0) || (j % interval) == 0){
                    this._imageWriter.writePixel(j, k, new Color(255, 255,255));
                }

            }
        }
    }

    /**
     * renders the image
     */
    public void renderImage() {

        for (int i = 0; i < this._imageWriter.getHeight(); i++) {
            for (int j = 0; j < this._imageWriter.getWidth(); j++) {


                Ray ray = _scene.get_camera().constructRayThroughPixel(
                        this._imageWriter.getNx(),this. _imageWriter.getNy(), j, i,
                        this._scene.get_screenDistance(), this._imageWriter.getWidth(),
                        this._imageWriter.getHeight());

                Intersectable geometries = this._scene.get_geometries();
                List<Point3D> intersectionPoints = geometries.findIntersections(ray);

                if (intersectionPoints == null || intersectionPoints.size() == 0) {
                    _imageWriter.writePixel(j, i, new Color(0,0,0));
                } else {
                    Point3D closestPoint = getClosestPoint(intersectionPoints);
                    _imageWriter.writePixel(j, i, new Color(255, 255, 255));
                }
            }
        }

    }

    /**
     * uses the image writer
     */
    public void writeToImage(){
        this._imageWriter.writeToimage();
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

        return new Color(255, 255, 255);
//        return _scene.get_ambientLight().getIntesity(point);
    }
}
