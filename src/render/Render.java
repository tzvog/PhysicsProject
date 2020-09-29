package render;

import elements.Light;
import elements.LightSource;
import geometries.Geometry;
import geometries.Intersectable;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;
import scene.Scene;

import java.awt.*;
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
                List<Intersectable.GeoPoint> intersectionPoints = geometries.findIntersections(ray);


                // checks that we have a point to intersect
                if (intersectionPoints == null || intersectionPoints.size() == 0) {
                    this._imageWriter.writePixel(j, i, this._scene.get_background());
                } else {
                    Intersectable.GeoPoint closestPoint = getClosestPoint(intersectionPoints);
                    this._imageWriter.writePixel(j, i, calcColor(closestPoint));
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
    private Intersectable.GeoPoint getClosestPoint(List<Intersectable.GeoPoint> intersectionPoints) {

        double distance = Double.MAX_VALUE;
        Point3D P0 = this._scene.get_camera().get_P0();
        Point3D minDistancePoint = null;
        Geometry minGeo = null;

        // goes through the points and finds the closest
        for (Intersectable.GeoPoint g: intersectionPoints) {
            if (P0.distance(g.point) < distance){
                minDistancePoint = new Point3D(g.point);
                distance = P0.distance(g.point);
                minGeo = g.geometry;
            }
        }

        return new Intersectable.GeoPoint(minGeo, minDistancePoint);
    }

    /**
     * calculates the color
     * @param geoPoint the geo point
     * @return the color calculated
     */
    private Color calcColor(Intersectable.GeoPoint geoPoint) {

        Color ambientLight = this._scene.get_ambientLight().getIntensity(geoPoint.point);
        Color emissionLight = geoPoint.geometry.get_emmission();

        Color diffuseLight = new Color(0,0,0);
        Color specularLight = new Color(0,0,0);

        for (LightSource l: this._scene.get_lights()) {

            Color defuseAdd = calcDiffuseComp(geoPoint.geometry.get_material().get_kd(),
                    geoPoint.geometry.getNormal(geoPoint.point), l.getL(geoPoint.point),
                    l.getIntensity(geoPoint.point));

            // TODO check if the second vector is what is needed
            Color SpecAdd = calcSpecularComp(geoPoint.geometry.get_material().get_ks(),
                    new Vector(geoPoint.point.add(new Vector(this._scene.get_camera().get_P0()))),
                    geoPoint.geometry.getNormal(geoPoint.point),
                    l.getL(geoPoint.point), geoPoint.geometry.get_material().get_nShininess(),
                    l.getIntensity(geoPoint.point));

            diffuseLight = new Color((diffuseLight.getRed() + defuseAdd.getRed()),
                    diffuseLight.getGreen() + defuseAdd.getGreen(),
                    diffuseLight.getBlue() + defuseAdd.getBlue());

            specularLight = new Color((specularLight.getRed() + SpecAdd.getRed()),
                    specularLight.getGreen() + SpecAdd.getGreen(),
                    specularLight.getBlue() + SpecAdd.getBlue());
        }

        // calculates the new vector
        return new Color (Math.min((ambientLight.getRed() + emissionLight.getRed() +
                diffuseLight.getRed() + specularLight.getRed()), 255),
                Math.min((ambientLight.getGreen() + emissionLight.getGreen() +
                        diffuseLight.getGreen() + specularLight.getGreen()), 255),
                Math.min((ambientLight.getBlue() + emissionLight.getBlue() +
                        diffuseLight.getBlue() + specularLight.getBlue()), 255));
    }

    /**
     * calculates the diffuse for the point
     * @param kd the kd
     * @param normal the normal of the vector
     * @param L the L vector
     * @param lightIntensity the intensity of the point
     * @return the intense point
     */
    private Color calcDiffuseComp(double kd, Vector normal, Vector L, Color lightIntensity){

        // calculates the amount
        double dotProductScalar = kd * normal.dotProduct(L);

        // returns the new color
        return new Color((int)(dotProductScalar * lightIntensity.getRed()),
                (int)(dotProductScalar * lightIntensity.getGreen()),
                (int)(dotProductScalar * lightIntensity.getBlue()));

    }

    /**
     * calculates the specular
     * @param ks the spec scalar
     * @param v the v scalar
     * @param normal the normalized vector
     * @param D the direction vector
     * @param shines the shines amount
     * @param lightIntensity the color
     * @return the new color
     */
    private Color calcSpecularComp(double ks, Vector v, Vector normal,
                                   Vector D, double shines, Color lightIntensity){

        // finds the R vector
        Vector R = D.subtract(normal.scale(D.dotProduct(normal) * 2));

        // calculates the new mult amount
        double multAmount = (Math.pow(v.dotProduct(R), shines)) * ks;


        // returns the new color
        return new Color((int)(multAmount * lightIntensity.getRed()),
                (int)(multAmount * lightIntensity.getGreen()),
                (int)(multAmount * lightIntensity.getBlue()));
    }
}
