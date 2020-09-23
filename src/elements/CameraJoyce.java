/**
 * 
 */
package elements;

import primitives.*;
import static primitives.Util.*;

/**
 * Class representing Camera (from the point of view to a picture)
 */
public class CameraJoyce {
    private Point3D _p0;
    private Vector _vUp, _vTo, _vRight;

    /**
     * Constructor for camera according to its position and orientation NB: RIGHT
     * direction is calculated automatically
     * 
     * @param p0  camera location
     * @param vTo camera TOWARDS direction
     * @param vUp camera UP direction
     */
    public CameraJoyce(Point3D p0, Vector vTo, Vector vUp) {
        if (!isZero(vTo.dotProduct(vUp)))
            throw new IllegalArgumentException("Camera UP and TOWARDS dirtection aren't orthogonal");
        _p0 = new Point3D(p0);
        _vTo = vTo.normalized();
        _vUp = vUp.normalized();
        _vRight = _vTo.crossProduct(_vUp);
    }

    /**
     * The function constructs a ray from Camera location throw the center of a
     * pixel (i,j) in the view plane
     * 
     * @param nX             number of pixels in a row of view plane
     * @param nY             number of pixels in a column of view plane
     * @param j              number of the pixel in a row
     * @param i              number of the pixel in a column
     * @param screenDistance distance from the camera to the view plane
     * @param screenWidth    view plane width
     * @param screenHeight   view plane height
     * @return the ray through pixel's center
     */
    public Ray constructRayThroughPixel(int nX, int nY, int j, int i,
            double screenDistance, double screenWidth, double screenHeight) {
        double rX = screenWidth / nX;
        double rY = screenHeight / nY;
        double xJ = (j - (nX - 1) / 2d) * rX;
        double yI = (i - (nY - 1) / 2d) * rY;
        
        Point3D pIJ = _p0.add(_vTo.scale(screenDistance)); // the view plane center point
        if (xJ != 0) pIJ = pIJ.add(_vRight.scale(xJ));
        if (yI != 0) pIJ = pIJ.add(_vUp.scale(-yI)); // it's possible pIJ.subtract(_vUp.scale(yI));
        
        return new Ray(_p0, pIJ.subtract(_p0));
    }

    /**
     * Getter for camera location
     * 
     * @return the location point
     */
    public Point3D getP0() { return _p0; }

    /**
     * Getter for the UP direction vector
     * 
     * @return the up vector
     */
    public Vector getVUp() { return _vUp; }

    /**
     * Getter for the TOWARDS direction vector
     * 
     * @return the the to vector
     */
    public Vector getVTo() { return _vTo; }

    /**
     * Getter for the RIGHT direction vector
     * 
     * @return the right vector
     */
    public Vector getVRight() { return _vRight; }

}
