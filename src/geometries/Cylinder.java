package geometries;

import primitives.Ray;

/**
 * exampleClass class to implement exampleClass cylinder
 */
public class Cylinder extends Tube {

    /* local variable declaration */
    double _height;

    /* Getters */

    /**
     * exampleClass function to get the height
     * @return the height
     */
    public double get_height() {
        return _height;
    }

    /* Constructors */

    /**
     * exampleClass constructor for exampleClass cylinder
     * @param radius the radius of the cylinder
     */
    public Cylinder(double radius, Ray axis, double height)
    {
        super(radius, axis);
        this._height = height;
    }


    /* Functions */

    /**
     * overrides the toString function
     * @return the toString
     */
    @Override
    public String toString() {
        return "";
    }

}
