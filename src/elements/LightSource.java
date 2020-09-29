package elements;

import primitives.Point3D;
import primitives.Vector;

import java.awt.*;

/**
 * an interface to represent a Light source
 */
public interface LightSource {

    Color getIntensity(Point3D p);
    Vector getL(Point3D p);

}
