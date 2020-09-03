package primitives;

/***
 * a class to represent a point in the space
 */
public class Point3D {

    /* Static variable declaration */
    private static Point3D ZERO = new Point3D(0, 0, 0);

    /* local variable declaration */
    private Coordinate firstCoordinate;
    private Coordinate secondCoordinate;
    private Coordinate thirdCoordinate;


    /* Getters */

    /**
     * gets the first coordinate
     * @return the first coordinate
     */
    public Coordinate getFirstCoordinate() {
        return firstCoordinate;
    }

    /**
     * gets the Second coordinate
     * @return the Second coordinate
     */
    public Coordinate getSecondCoordinate() {
        return secondCoordinate;
    }

    /**
     * gets the third coordinate
     * @return the third coordinate
     */
    public Coordinate getThirdCoordinate() {
        return thirdCoordinate;
    }

    /* Constructors */

    /***
     * a constructor that receives three Coordinates
     * @param firstCoordinate the first coordinate we receive as x axis
     * @param secondCoordinate the second coordinate we receive as y axis
     * @param thirdCoordinate the third coordinate we receive as z axis
     */
    public Point3D(Coordinate firstCoordinate, Coordinate secondCoordinate, Coordinate thirdCoordinate) {
        this.firstCoordinate = new Coordinate(firstCoordinate);
        this.secondCoordinate = new Coordinate(secondCoordinate);
        this.thirdCoordinate = new Coordinate(thirdCoordinate);
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
        this(other.getFirstCoordinate(), other.getSecondCoordinate(), other.getThirdCoordinate());
    }


    /* Functions */

    /**
     * creates a vector using another point in the space
     * @param other the other point we are working with
     * @return a new vector with the two points
     */
    Vector subtract(Point3D other) {

        return new Vector((this.getFirstCoordinate().get() - other.getFirstCoordinate().get()),
                (this.getSecondCoordinate().get() - other.getSecondCoordinate().get()),
                (this.getThirdCoordinate().get() - other.getThirdCoordinate().get()));
    }

    /**
     * creates a new point3D using a Vector
     * @return a new Point3D moved by the vector
     */
    Point3D add(Vector vec) {

        return new Point3D((this.getFirstCoordinate().get() + vec.getPoint().getFirstCoordinate().get()),
                (this.getSecondCoordinate().get() + vec.getPoint().getSecondCoordinate().get()),
                (this.getThirdCoordinate().get() + vec.getPoint().getThirdCoordinate().get()));
    }

    /**
     * finds the distance between this point and another squared
     * @param other the other point
     * @return the distance
     */
    double distanceSquared(Point3D other)
    {
        return (((this.getFirstCoordinate().get() - other.getFirstCoordinate().get()) *
                 (this.getFirstCoordinate().get() - other.getFirstCoordinate().get()))  +
                ((this.getSecondCoordinate().get() - other.getSecondCoordinate().get()) *
                 (this.getSecondCoordinate().get() - other.getSecondCoordinate().get())) +
                ((this.getThirdCoordinate().get() - other.getThirdCoordinate().get()) *
                 (this.getThirdCoordinate().get() - other.getThirdCoordinate().get()))
        );
    }

    /**
     * a function to get the actual distance with another point
     * @param other the other point
     * @return the distance
     */
    double distance(Point3D other)
    {
        double disSquared = distanceSquared(other);
        return (disSquared * disSquared);
    }

}
