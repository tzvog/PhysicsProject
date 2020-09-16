package elements;

import primitives.Point3D;
import primitives.Vector;
import primitives.Ray;

/**
 * a class to represent a Camera
 */
public class Camera {

    /* local variable declaration */
    private Point3D _P0;
    private Vector _vUp, _vRight, _vTo;

    /* Getters */

    /**
     * gets the center point
     * @return the center point
     */
    public Point3D get_P0() {
        return _P0;
    }

    /**
     * gets the up vector
     * @return the up vector
     */
    public Vector get_vUp() {
        return _vUp;
    }

    /**
     * gets the right vector
     * @return the right vector
     */
    public Vector get_vRight() {
        return _vRight;
    }

    /**
     * gets the towards vector
     * @return the towards vector
     */
    public Vector get_vTo() {
        return _vTo;
    }

    /* Constructors */

    /**
     * constructor to receive all inputs
     * @param p the point
     * @param vTo the towards vector
     * @param vUp the up vector
     * @param vRight the right angle vector
     */
    public Camera(Point3D p ,Vector vTo, Vector vUp, Vector vRight)
    {
        this._P0 = p;
        this._vTo = vTo;
        this._vUp = vUp;
        this._vRight = vRight;
    }


    /**
     * a constructor to get only two vectors
     * @param vTo the towards vectors
     * @param vUp the up vector
     */
    public Camera(Vector vTo, Vector vUp){
        this(new Point3D(0,0,0), vTo, vUp,
                vTo.crossProduct(vUp));
    }

    /**
     * default constructor
     */
    public Camera() {
        this(new Vector(0,0,-1), new Vector(0,1,0));
    }

    /**
     * copy constructor
     * @param other the objet to copy
     */
    public Camera(Camera other) {
        this._P0 = other.get_P0();
        this._vTo = other.get_vTo();
        this._vUp = other.get_vUp();
        this._vRight = other.get_vRight();
    }

    /* Functions */


    /**
     * this function finds the ray through the pixel
     * @param Nx amount of pixels in height
     * @param Ny amount of pixels in length
     * @param x height of pixel
     * @param y width of pixel
     * @param screenDist the distance to the screen
     * @param screenWidth the width of the screen
     * @param screenHeight the height of the screen
     * @return a ray
     */
    public Ray constructRayThroughPixel (int Nx, int Ny, double x, double y,
                                  double screenDist, double screenWidth,
                                  double screenHeight){

        Point3D pointCenter = this._P0.add(this._vTo.scale(screenDist));
        double RX = screenWidth / Nx;
        double RY = screenHeight / Ny;

        Ray t = new Ray(new Point3D(0,0,0), new Vector(0,0,0));

        // TODO check that we want is the point center and the vector
        Ray n =  new Ray(this.get_P0(),
                new Vector(pointCenter.add(this._vRight.scale((x - (Nx/2)) + (RX/2)).subtract(
                                this._vUp.scale((y - (Ny/2)) + (RY/2))))));

        return null;
    }



    /**
     * checks if two points have the same values
     * @param obj the other point
     * @return if they are equal
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (!(obj instanceof Camera)) return false;
        Camera oth = (Camera) obj;
        return this._P0.equals(oth._P0) && this._vTo.equals(oth._vTo) &&
                this._vUp.equals(oth._vUp) && this._vRight.equals(oth._vRight);
    }

    /**
     * overrides the toString function
     * @return the object as a string
     */
    @Override
    public String toString() {
        return "" + this._P0 + " " + this._vRight
                + " " + this._vUp + " " + this._vTo;
    }
}
