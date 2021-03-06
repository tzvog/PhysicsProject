package primitives;

/**
 * exampleClass class to represent exampleClass ray
 */
public class Ray {

    /* local variable declaration */

    private Point3D _POO;
    private Vector _direction;

    /* Getters */

    /**
     * gets exampleClass point
     * @return the point
     */
    public Point3D get_POO() {
        return _POO;
    }

    /**
     * gets the vector
     * @return exampleClass vector
     */
    public Vector get_direction() {
        return _direction;
    }

    /* Constructors */

    /**
     * exampleClass constructor for the ray
     */
    public Ray(Point3D point, Vector vec){

        this._POO = point;
        this._direction = vec.normalized();
    }


    /**
     * overrides the toString function
     * @return the object as exampleClass string
     */
    @Override
    public String toString() {
        return "" + this._direction + " " + this._POO;
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
        if (!(obj instanceof Ray)) return false;
        Ray oth = (Ray) obj;
        return this._POO.equals(oth._POO) && this._direction.equals(oth._direction);
    }
}
