package primitives;

/**
 * a class to represent a ray
 */
public class Ray {

    /* local variable declaration */

    Point3D _point;
    Vector _vec;

    /* Getters */

    /**
     * gets a point
     * @return the point
     */
    public Point3D get_point() {
        return _point;
    }

    /**
     * gets the vector
     * @return a vector
     */
    public Vector get_vec() {
        return _vec;
    }

    /* Constructors */

    /**
     * a constructor for the ray
     */
    public Ray(Point3D point, Vector vec){

        this._point = point;
        this._vec = vec.normalized();
    }


    /**
     * overrides the toString function
     * @return the object as a string
     */
    @Override
    public String toString() {
        return "" + this._vec + " " + this._point;
    }
}
