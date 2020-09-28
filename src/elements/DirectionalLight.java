package elements;

import primitives.Point3D;
import primitives.Vector;

import java.awt.*;

/**
 * a class to represent a directional light
 */
public class DirectionalLight extends Light {

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
     * and a direction vector
     * @param _color the color
     */
    public DirectionalLight(Color _color, Vector _direction) {
        super(_color);
        this._direction = _direction;
    }

    /**
     * constructor that receives a color
     * but no vector
     * @param _color the color
     */
    public DirectionalLight(Color _color) {
        super(_color);
        this._direction = new Vector(0,0,1);
    }

    /**
     * a constructor that gets the direction
     */
    public DirectionalLight(Vector _direction) {
        this._direction = _direction;
    }

    /**
     * default constructor
     */
    public DirectionalLight() {
        this._direction = new Vector(0,0,1);
    }

    /**
     * copy constructor
     */
    public DirectionalLight(DirectionalLight oth) {
        this._direction = oth._direction;
        this._color = oth.get_color();
    }

    /* Functions */

    /**
     * gets the color
     * @param p the point
     * @return the color
     */
    @Override
    public Color getIntensity(Point3D p) {
        return this._color;
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
        if (!(obj instanceof DirectionalLight)) return false;
        DirectionalLight oth = (DirectionalLight) obj;
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
