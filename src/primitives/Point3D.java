package primitives;

import java.lang.*;

/***
 * a class to represent a point in the space
 */
public class Point3D {

    /* Static variable declaration */
    public static Point3D ZERO = new Point3D(0, 0, 0);

    /* local variable declaration */
    private Coordinate _x;
    private Coordinate _y;
    private Coordinate _z;


    /* Getters */

    /**
     * gets the first coordinate
     * @return the first coordinate
     */
    public Coordinate get_x() {
        return _x;
    }

    /**
     * gets the Second coordinate
     * @return the Second coordinate
     */
    public Coordinate get_y() {
        return _y;
    }

    /**
     * gets the third coordinate
     * @return the third coordinate
     */
    public Coordinate get_z() {
        return _z;
    }

    /* Constructors */

    /***
     * a constructor that receives three Coordinates
     * @param firstCoordinate the first coordinate we receive as x axis
     * @param secondCoordinate the second coordinate we receive as y axis
     * @param thirdCoordinate the third coordinate we receive as z axis
     */
    public Point3D(Coordinate firstCoordinate, Coordinate secondCoordinate, Coordinate thirdCoordinate) {
        this._x = firstCoordinate;
        this._y = secondCoordinate;
        this._z = thirdCoordinate;
    }

    /**
     * a constructor that receives three doubles to represent point in the space
     * @param xLocation the first double we receive as x axis
     * @param yLocation the second double we receive as y axis
     * @param zLocation the third double we receive as x axis
     */
    public Point3D(double xLocation, double yLocation, double zLocation) {
        this(new Coordinate(xLocation), new Coordinate(yLocation), new Coordinate(zLocation));
    }

    /**
     * copy constructor
     *
     * @param other the Point3D we want to copy
     */
    public Point3D(Point3D other) {
        this(other.get_x(), other.get_y(), other.get_z());
    }


    /* Functions */

    /**
     * creates a vector using another point in the space
     * @param other the other point we are working with
     * @return a new vector with the two points
     */
    public Vector subtract(Point3D other) {

        return new Vector((this.get_x().get() - other.get_x().get()),
                (this.get_y().get() - other.get_y().get()),
                (this.get_z().get() - other.get_z().get()));
    }

    /**
     * creates a new point3D using a Vector
     * @param vec the vector to do the moving
     * @return a point moved by the vector
     */
    public Point3D add(Vector vec) {

        return new Point3D((this.get_x().get() + vec.get_point().get_x().get()),
                (this.get_y().get() + vec.get_point().get_y().get()),
                (this.get_z().get() + vec.get_point().get_z().get()));
    }

    /**
     * finds the distance between this point and another squared
     * @param other the other point
     * @return the distance
     */
    public double distanceSquared(Point3D other)
    {
        return  (((this.get_x().get() - other.get_x().get()) *
                 (this.get_x().get() - other.get_x().get()))  +
                ((this.get_y().get() - other.get_y().get()) *
                 (this.get_y().get() - other.get_y().get())) +
                ((this.get_z().get() - other.get_z().get()) *
                 (this.get_z().get() - other.get_z().get()))
        );
    }

    /**
     * a function to get the actual distance with another point
     * @param other the other point
     * @return the distance
     */
    public double distance(Point3D other)
    {
      return Math.sqrt(distanceSquared(other));
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
        if (!(obj instanceof Point3D)) return false;
        Point3D oth = (Point3D)obj;
        return _x.equals(oth._x) &&
                _y.equals(oth._y) &&
                _z.equals(oth._z);
    }

    @Override
    public String toString() {
        return "" + this.get_x() + " " +
                this.get_y() + " " +
                this.get_z();
    }
}
