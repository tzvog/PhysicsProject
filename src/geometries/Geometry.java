package geometries;

import primitives.*;

/**
 * an interface for geometry fields
 */
public interface Geometry {

    Vector getNormal(Point3D point);
}
