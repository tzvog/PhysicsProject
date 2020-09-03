package primitives;

import java.lang.*;

/**
 * a class to represent a vector
 */
public class Vector {

    /* local variable declaration */
    private Point3D _point;


    /* Getters */

    /**
     * gets the _point
     * @return the _point
     */
    public Point3D get_point() {
        return _point;
    }

    /* Constructors */

    /**
     * a constructor that receives three Coordinates
     * @param firstCoordinate the first coordinate we receive as x axis
     * @param secondCoordinate the second coordinate we receive as y axis
     * @param thirdCoordinate the third coordinate we receive as z axis
     */
    public Vector(Coordinate firstCoordinate, Coordinate secondCoordinate, Coordinate thirdCoordinate) {

        _point = new Point3D(firstCoordinate, secondCoordinate, thirdCoordinate);

        if(_point.equals(Point3D.ZERO)){
            throw new IllegalArgumentException();
        }
    }

    /**
     * a constructor that receives three doubles to represent _point in the space
     * @param xLocation the first double we receive as x axis
     * @param yLocation the second double we receive as y axis
     * @param zLocation the third double we receive as x axis
     */
    public Vector(double xLocation, double yLocation, double zLocation){
        this(new Coordinate(xLocation), new Coordinate(yLocation), new Coordinate(zLocation));
    }

    /**
     * a constructor that receives a point3D
     * @param point the _point we receive
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
        this._point = other._point;
    }

    /* Functions */

    /**
     * adds our vector to another vector to create a new one
     * @param other the other vector
     * @return the new vector
     */
    Vector add(Vector other) {
        return new Vector((this.get_point().get_firstCoordinate().get() +
                        other.get_point().get_firstCoordinate().get()),
                        (this.get_point().get_secondCoordinate().get() +
                        other.get_point().get_secondCoordinate().get()),
                        (this.get_point().get_thirdCoordinate().get() +
                        other.get_point().get_thirdCoordinate().get()));
    }

    /**
     * creates a new vector by subtracting our vector from the new vector
     * @param other the other vector
     * @return the new subtracted vector
     */
    Vector subtract(Vector other){
        return new Vector((this.get_point().get_firstCoordinate().get() -
                        other.get_point().get_firstCoordinate().get()),
                        (this.get_point().get_secondCoordinate().get() -
                        other.get_point().get_secondCoordinate().get()),
                        (this.get_point().get_thirdCoordinate().get() -
                        other.get_point().get_thirdCoordinate().get()));
    }

    /**
     * creates a new vector with scaled
     * @param scalar the scalar
     * @return the new scaled vector
     */
    Vector scale(double scalar){
        return new Vector((scalar * this.get_point().get_firstCoordinate().get()),
                (scalar * this.get_point().get_secondCoordinate().get()),
                (scalar * this.get_point().get_thirdCoordinate().get()));
    }

    /**
     * creates a dot product with another vector
     * @param other the other vector to use for a dot product
     * @return the dot product
     */
    double dotProduct(Vector other){
        return ((this.get_point().get_firstCoordinate().get() *
                other.get_point().get_firstCoordinate().get()) +
                (this.get_point().get_secondCoordinate().get() *
                other.get_point().get_secondCoordinate().get()) +
                (this.get_point().get_thirdCoordinate().get() *
                 other.get_point().get_thirdCoordinate().get()));
    }

    /**
     * creates a new cross product vector
     * @param other the other vector to create a cross product with
     * @return the new vector
     */
    Vector crossProduct(Vector other){
        return new Vector((this.get_point().get_firstCoordinate().get() *
                        other.get_point().get_firstCoordinate().get()),
                        (this.get_point().get_secondCoordinate().get() *
                        other.get_point().get_secondCoordinate().get()),
                        (this.get_point().get_thirdCoordinate().get() *
                        other.get_point().get_thirdCoordinate().get()));
    }

    /***
     * gets the length squared of the vector
     * @return the length squared
     */
    double lengthSquared(){
        return this.get_point().distanceSquared(Point3D.ZERO);
    }

    /**
     * gets the distance from the axis base
     * @return the length of the vector
     */
    double length(){
        return this.get_point().distance(Point3D.ZERO);
    }

    /**
     * a function to normalize our vector
     * @return this vector
     */
    Vector normalize(){

        // finds what to multiply the vector by
        double scalar = (1 / Math.sqrt(dotProduct(this)));

        // creates a new point and sets it our point
        this._point = new Point3D((scalar * this.get_point().get_firstCoordinate().get()),
                (scalar * this.get_point().get_secondCoordinate().get()),
                (scalar * this.get_point().get_thirdCoordinate().get()));

        return this;
    }

    /**
     * a function to copy our vector and normalize it
     * @return the new normalized vector
     */
    Vector normalized(){

        // creates a new vector
        Vector newVec = new Vector(this.get_point().get_firstCoordinate(),
                this.get_point().get_secondCoordinate(), this._point.get_thirdCoordinate());

        // normalizes the new vector
        newVec.normalize();

        // returns the new vec
        return newVec;
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
        if (!(obj instanceof Vector)) return false;
        Vector oth = (Vector)obj;
        return this._point.equals(oth._point);
    }

    @Override
    public String toString() {
        return "" + this._point;
    }
}
