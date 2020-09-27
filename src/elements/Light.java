package elements;

import primitives.Point3D;
import primitives.Vector;

import java.awt.*;

/**
 * a class to represent a light
 */
public abstract class Light {

    /* local variable declaration */
    Color _color;

    /* Getters */

    /**
     * gets the color
     * @return the color
     */
    public Color get_color() {
        return _color;
    }



    /* Constructors */

    /**
     * constructor that receives a color
     * @param _color the color
     */
    public Light(Color _color) {
        this._color = _color;
    }

    /**
     * default constructor
     */
    public Light() {
        this(new Color(255, 255, 255));
    }

    /* Functions */

    abstract public Color getIntersity(Point3D p);
    abstract public Vector getL(Point3D p);

    /**
     * checks if two points have the same values
     * @param obj the other point
     * @return if they are equal
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (!(obj instanceof Light)) return false;
        Light oth = (Light) obj;
        return this._color.equals(oth._color);
    }

    /**
     * overrides the toString function
     * @return the object as exampleClass string
     */
    @Override
    public String toString() {
        return this._color.toString();
    }
}
