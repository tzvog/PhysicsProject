package geometries;

import java.awt.*;

public abstract class RadialGeometry extends Geometry {

    /* local variable declaration */
    private double _radius;


    /* Getters */

    /**
     * exampleClass getter for the radius
     * @return the radius
     */
    public double get_radius() {
        return _radius;
    }

    /* Constructors */

    public RadialGeometry(double radius)
    {
        this._radius = radius;
    }
}
