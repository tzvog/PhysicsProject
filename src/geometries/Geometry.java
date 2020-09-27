package geometries;

import primitives.*;

import java.awt.*;

/**
 * an interface for geometry fields
 */
public interface Geometry extends Intersectable{

    Color get_color();
    Vector getNormal(Point3D point);

}
