package elements;

import primitives.Point3D;
import primitives.Vector;

import java.awt.*;

/**
 * a class to represent the point of a light
 */
public class PointLight extends Light{

    /* local variable declaration */
    private Point3D _position;
    private double _kc, _kq, _kl;

    /* Constructors */

    /**
     * constructor that receives a color
     * it receives all
     * @param _color the color
     */
    public PointLight(Color _color, Point3D _position, double _kc, double _kq, double _kl) {
        super(_color);
        this._position = _position;
        this._kc = _kc;
        this._kq = _kq;
        this._kl = _kl;
    }

    /**
     * receives all but colors
     */
    public PointLight(Point3D _position, double _kc, double _kq, double _kl) {
        this._position = _position;
        this._kc = _kc;
        this._kq = _kq;
        this._kl = _kl;
    }

    /**
     * does not receive point light
     */
    public PointLight(double _kc, double _kq, double _kl) {
        this._kc = _kc;
        this._kq = _kq;
        this._kl = _kl;
        this._position = new Point3D(0,0,0);
    }

    /**
     * constructor to only receive a point
     */
    public PointLight(Point3D _position) {
        this._position = _position;
        this._kc = 0.1;
        this._kq = 0.1;
        this._kl = 0.1;
    }

    /**
     * default constructor
     */
    public PointLight() {
        this._position = new Point3D(0,0,0);
        this._kc = 0.1;
        this._kq = 0.1;
        this._kl = 0.1;
    }

    /**
     * copy constructor
     */
    public PointLight(PointLight oth) {
        this._position = oth._position;
        this._kq = oth._kq;
        this._kl = oth._kl;
        this._kc = oth._kc;
        this._color = oth.get_color();
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
        if (!(obj instanceof PointLight)) return false;
        PointLight oth = (PointLight) obj;
        return super.equals(obj) &&
                this._position.equals(oth._position) &&
                this._kc == oth._kc && this._kl == oth._kl && this._kq == oth._kl;
    }

    /**
     * overrides the toString function
     * @return the object as exampleClass string
     */
    @Override
    public String toString() {
        return super.toString() + " " + this._position + " " + this._kc + " " +
                this._kl + " " + this._kq;
    }
}
