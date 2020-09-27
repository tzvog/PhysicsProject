package geometries;

import primitives.*;

import java.awt.*;

/**
 * an interface for geometry fields
 */
public abstract class Geometry implements Intersectable{

    Color _emmission;

    /**
     * gets the color
     * @return the color
     */
    public Color get_emmission()
    {
        return this._emmission;
    }

    /**
     * abstract function to return the normal
     * @param point the point we are dealing with
     * @return the Vector
     */
    abstract Vector getNormal(Point3D point);

}
