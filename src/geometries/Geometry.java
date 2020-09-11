package geometries;

import primitives.*;

/**
 * an interface for geometry fields
 */
public interface Geometry extends Intersectable{

    Vector getNormal(Point3D point);
}
