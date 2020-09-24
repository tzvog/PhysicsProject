package scene;

import elements.AmbientLight;
import elements.Camera;
import geometries.Geometry;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * exampleClass class to represent exampleClass scene
 */
public class Scene {

    /* local variable declaration */
    private String _sceneName;
    private Color _background;
    private AmbientLight _ambientLight;
    private List<Geometry> _geometries;
    private Camera _camera;
    private double _screenDistance;

    /* Getters */

    /**
     * gets the scene name
     * @return the scene name
     */
    public String get_sceneName() {
        return _sceneName;
    }

    /**
     * gets the background
     * @return the background
     */
    public Color get_background() {
        return _background;
    }

    /**
     * gets the ambient light
     * @return the ambient light
     */
    public AmbientLight get_ambientLight() {
        return _ambientLight;
    }

    /**
     * gets the geometries
     * @return the geometries
     */
    public List<Geometry> get_geometries() {
        return _geometries;
    }

    /**
     * gets the camera
     * @return the camera
     */
    public Camera get_camera() {
        return _camera;
    }

    /**
     * gets the screen distance
     * @return the screen distance
     */
    public double get_screenDistance() {
        return _screenDistance;
    }

    /* Constructors */

    /**
     * full constructor
     * @param _sceneName the scene name
     * @param _background the background color
     * @param _ambientLight the ambient light
     * @param _camera the camera
     * @param _screenDistance the distance to the screen
     */
    public Scene(String _sceneName, Color _background,
                 AmbientLight _ambientLight, Camera _camera, double _screenDistance) {
        this._sceneName = _sceneName;
        this._background = _background;
        this._ambientLight = _ambientLight;
        this._camera = _camera;
        this._screenDistance = _screenDistance;
        this._geometries = new ArrayList<>();
    }

    /**
     * default constructor
     */
    public Scene() {
        this(new String(), new Color(0,0,0),
                new AmbientLight(), new Camera(), 150);
    }

    /**
     * copy constructor
     * @param other the object we want to copy
     */
    public Scene(Scene other){
        this._sceneName = other.get_sceneName();
        this._background = other.get_background();
        this._ambientLight = other.get_ambientLight();
        this._camera = other.get_camera();
        this._screenDistance = other.get_screenDistance();
        this._geometries = other.get_geometries();
    }

    /* Functions */

    /**
     * a function to add geometries
     * @param g the geometry to add
     */
    public void addGeometry(Geometry g){
        this._geometries.add(g);
    }

    /**
     * a function to get the geometries iterator
     * @return the iterator of geometries
     */
    public Iterator<Geometry> getGeometriesIterator(){
        return this._geometries.iterator();
    }
}
