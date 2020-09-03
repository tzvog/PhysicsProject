package primitives;

/***
 * a class to represent a point in the space
 */
public class Point3D {

    /**
     * a static point to repress the starting axes point
     */
    private static Point3D ZERO = new Point3D(0,0,0);
    private Coordinate firstCoordinate, secondCoordinate, thirdCoordinate;

    /***
     * a constructor that receives three Coordinates
     * @param firstCoordinate the first coordinate we receive as x axis
     * @param secondCoordinate the second coordinate we receive as y axis
     * @param thirdCoordinate the third coordinate we receive as z axis
     */
    Point3D(Coordinate firstCoordinate, Coordinate secondCoordinate, Coordinate thirdCoordinate)
    {
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
    Point3D(double xLocation, double yLocation, double zLocation)
    {
        this(new Coordinate(xLocation), new Coordinate(yLocation), new Coordinate(zLocation));
    }

    /**
     * copy constructor
     * @param other the Point3D we want to copy
     */
    Point3D(Point3D other)
    {
        this(other.firstCoordinate, other.secondCoordinate, other.thirdCoordinate);
    }
}
