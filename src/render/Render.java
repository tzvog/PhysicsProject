package render;

import scene.Scene;

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
}
