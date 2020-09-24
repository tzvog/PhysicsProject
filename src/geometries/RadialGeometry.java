package geometries;

public abstract class RadialGeometry implements Geometry {

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
