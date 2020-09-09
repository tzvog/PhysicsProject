package geometries;

/**
 * a class to implement a cylinder
 */
public class Cylinder extends Tube {

    /* local variable declaration */
    double _height;

    /* Getters */

    /**
     * a function to get the height
     * @return the height
     */
    public double get_height() {
        return _height;
    }

    /* Constructors */

    /**
     * a constructor for a cylinder
     * @param radius the radius of the cylinder
     */
    public Cylinder(double radius)
    {
        super(radius);
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
