package elements;

import primitives.Point3D;
import primitives.Vector;

import java.awt.*;

/**
 * a class of a spotlight
 */
public class SpotLight extends Light{

    /* local variable declaration */
    private Vector _direction;


    /* Getters */
    /**
     * a getter for the direction vector
     * @return the vector
     */
    public Vector get_direction() {
        return _direction;
    }


    /* Constructors */

    /**
     * constructor that receives a color
     * and the direction we want
     * @param _color the color
     */
    public SpotLight(Color _color, Vector _direction) {
        super(_color);
        this._direction = _direction;
    }

    /**
     * a constructor to receive the direction vector
     */
    public SpotLight(Vector _direction) {
        this._direction = _direction;
    }

    /**
     * constructor that receives a color
     * @param _color the color
     */
    public SpotLight(Color _color) {
        super(_color);
    }

    /**
     * default constructor
     */
    public SpotLight() {
        super();
        this._direction = new Vector(0,0,1);
    }

    /**
     * copy constructor
     */
    public SpotLight(SpotLight oth) {
        this._color = oth._color;
        this._direction = oth._direction;
    }

    /* Functions */

    @Override
    public Color getIntensity(Point3D p) {
        return null;
    }

    @Override
    public Vector getL(Point3D p) {
        return null;
    }

    /**
     * checks if two points have the same values
     * @param obj the other point
     * @return if they are equal
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (!(obj instanceof SpotLight)) return false;
        SpotLight oth = (SpotLight) obj;
        return super.equals(obj) && this._direction.equals(oth._direction);
    }

    /**
     * overrides the toString function
     * @return the object as exampleClass string
     */
    @Override
    public String toString() {
        return super.toString() + " " + this._direction;
    }
}
