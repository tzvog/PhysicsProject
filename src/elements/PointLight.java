package elements;

import primitives.Point3D;
import primitives.Vector;

import java.awt.*;

/**
 * a class to represent the point of a light
 */
public class PointLight extends Light implements LightSource{

    /* local variable declaration */
    protected Point3D _position;
    protected double _kc, _kl, _kq;

    /* getters */
    public Point3D get_position() {
        return _position;
    }
    /* Constructors */

    /**
     * constructor that receives a color
     * it receives all
     * @param _color the color
     * @param _kc the kc
     * @param _position the position
     * @param _kl the kl
     * @param _kq the kq
     */
    public PointLight(Color _color, Point3D _position, double _kc, double _kl, double _kq) {
        super(_color);
        this._position = _position;
        this._kc = _kc;
        this._kq = _kq;
        this._kl = _kl;
    }

    /**
     * receives all but colors
     */
    public PointLight(Point3D _position, double _kc, double _kl, double _kq) {
        this._position = _position;
        this._kc = _kc;
        this._kq = _kq;
        this._kl = _kl;
    }

    /**
     * does not receive point light
     */
    public PointLight(double _kc, double _kl, double _kq) {
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

    /**
     * gets the intensity
     * @param p the other point
     * @return the new color
     */
    @Override
    public Color getIntensity(Point3D p) {

        double distance = Math.abs(this._position.distance(p));

        double divider = this._kc + (this._kl * distance) + (this._kq * distance * distance);

        return new Color((int)(this._color.getRed() / divider),
                (int)(this._color.getGreen() / divider),
                (int)(this._color.getBlue() / divider));
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
