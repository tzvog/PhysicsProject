package primitives;

/**
 * a class to represent a vector
 */
public class Vector {

    /* local variable declaration */
    private Point3D point;


    /* Getters */

    /**
     * gets the point
     * @return the point
     */
    public Point3D getPoint() {
        return point;
    }

    /* Constructors */

    /**
     * a constructor that receives three Coordinates
     * @param firstCoordinate the first coordinate we receive as x axis
     * @param secondCoordinate the second coordinate we receive as y axis
     * @param thirdCoordinate the third coordinate we receive as z axis
     */
    public Vector(Coordinate firstCoordinate, Coordinate secondCoordinate, Coordinate thirdCoordinate) {

        point = new Point3D(firstCoordinate, secondCoordinate, thirdCoordinate);

        if(point.equals(Point3D.ZERO)){
            throw new IllegalArgumentException();
        }
    }

    /**
     * a constructor that receives three doubles to represent point in the space
     * @param xLocation the first double we receive as x axis
     * @param yLocation the second double we receive as y axis
     * @param zLocation the third double we receive as x axis
     */
    public Vector(double xLocation, double yLocation, double zLocation){
        this(new Coordinate(xLocation), new Coordinate(yLocation), new Coordinate(zLocation));
    }

    /**
     * a constructor that receives a point3D
     * @param point the point we receive
     */
    public Vector(Point3D point)
    {
        this(point.get_firstCoordinate(), point.get_secondCoordinate(), point.get_thirdCoordinate());
    }

    /**
     * copy constructor
     * @param other the other vector we want to copy
     */
    public Vector(Vector other)
    {
        this.point = other.point;
    }
}
