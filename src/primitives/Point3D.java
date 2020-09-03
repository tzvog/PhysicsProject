package primitives;

import java.lang.*;

/***
 * a class to represent a point in the space
 */
public class Point3D {

    /* Static variable declaration */
    static Point3D ZERO = new Point3D(0, 0, 0);

    /* local variable declaration */
    private Coordinate _firstCoordinate;
    private Coordinate _secondCoordinate;
    private Coordinate _thirdCoordinate;


    /* Getters */

    /**
     * gets the first coordinate
     * @return the first coordinate
     */
    public Coordinate get_firstCoordinate() {
        return _firstCoordinate;
    }

    /**
     * gets the Second coordinate
     * @return the Second coordinate
     */
    public Coordinate get_secondCoordinate() {
        return _secondCoordinate;
    }

    /**
     * gets the third coordinate
     * @return the third coordinate
     */
    public Coordinate get_thirdCoordinate() {
        return _thirdCoordinate;
    }

    /* Constructors */

    /***
     * a constructor that receives three Coordinates
     * @param firstCoordinate the first coordinate we receive as x axis
     * @param secondCoordinate the second coordinate we receive as y axis
     * @param thirdCoordinate the third coordinate we receive as z axis
     */
    public Point3D(Coordinate firstCoordinate, Coordinate secondCoordinate, Coordinate thirdCoordinate) {
        this._firstCoordinate = new Coordinate(firstCoordinate);
        this._secondCoordinate = new Coordinate(secondCoordinate);
        this._thirdCoordinate = new Coordinate(thirdCoordinate);
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
        this(other.get_firstCoordinate(), other.get_secondCoordinate(), other.get_thirdCoordinate());
    }


    /* Functions */

    /**
     * creates a vector using another point in the space
     * @param other the other point we are working with
     * @return a new vector with the two points
     */
    Vector subtract(Point3D other) {

        return new Vector((this.get_firstCoordinate().get() - other.get_firstCoordinate().get()),
                (this.get_secondCoordinate().get() - other.get_secondCoordinate().get()),
                (this.get_thirdCoordinate().get() - other.get_thirdCoordinate().get()));
    }

    /**
     * creates a new point3D using a Vector
     * @return a new Point3D moved by the vector
     */
    Point3D add(Vector vec) {

        return new Point3D((this.get_firstCoordinate().get() + vec.get_point().get_firstCoordinate().get()),
                (this.get_secondCoordinate().get() + vec.get_point().get_secondCoordinate().get()),
                (this.get_thirdCoordinate().get() + vec.get_point().get_thirdCoordinate().get()));
    }

    /**
     * finds the distance between this point and another squared
     * @param other the other point
     * @return the distance
     */
    double distanceSquared(Point3D other)
    {
        return  (((this.get_firstCoordinate().get() - other.get_firstCoordinate().get()) *
                 (this.get_firstCoordinate().get() - other.get_firstCoordinate().get()))  +
                ((this.get_secondCoordinate().get() - other.get_secondCoordinate().get()) *
                 (this.get_secondCoordinate().get() - other.get_secondCoordinate().get())) +
                ((this.get_thirdCoordinate().get() - other.get_thirdCoordinate().get()) *
                 (this.get_thirdCoordinate().get() - other.get_thirdCoordinate().get()))
        );
    }

    /**
     * a function to get the actual distance with another point
     * @param other the other point
     * @return the distance
     */
    double distance(Point3D other)
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
        return _firstCoordinate.equals(oth._firstCoordinate) &&
                _secondCoordinate.equals(oth._secondCoordinate) &&
                _thirdCoordinate.equals(oth._thirdCoordinate);
    }

    @Override
    public String toString() {
        return "" + this.get_firstCoordinate() + " " +
                this.get_secondCoordinate() + " " +
                this.get_thirdCoordinate();
    }
}
