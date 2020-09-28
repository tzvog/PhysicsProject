package elements;

import primitives.Point3D;
import primitives.Vector;

import java.awt.*;

/**
 * a class of a spotlight
 */
public class SpotLight extends PointLight{

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
     * it receives all
     * @param _color    the color
     * @param _position the position
     * @param _kc       the kc
     * @param _kl       the kl
     * @param _kq       the kq
     */
    public SpotLight(Color _color, Point3D _position,
                     double _kc, double _kl, double _kq, Vector _direction) {
        super(_color, _position, _kc, _kl, _kq);
        this._direction = _direction;
    }

    /**
     * receives all but colors
     *
     * @param _position
     * @param _kc
     * @param _kl
     * @param _kq
     */
    public SpotLight(Point3D _position, double _kc, double _kl, double _kq, Vector _direction) {
        super(_position, _kc, _kl, _kq);
        this._direction = _direction;
    }

    /**
     * does not receive point light
     *
     * @param _kc
     * @param _kl
     * @param _kq
     */
    public SpotLight(double _kc, double _kl, double _kq, Vector _direction) {
        super(_kc, _kl, _kq);
        this._direction = _direction;
    }

    /**
     * constructor to only receive a point
     *
     * @param _position
     */
    public SpotLight(Point3D _position, Vector _direction) {
        super(_position);
        this._direction = _direction;
    }

    /**
     * constructor that receives a color
     * and the direction we want
     * @param _color the color
     */
    public SpotLight(Color _color, Vector _direction) {
        super();
        this._color = _color;
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
        super();
        this._color = _color;
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

    /**
     * gets the color of the light hitting the object
     * @param p the other point
     * @return the new color
     */
    @Override
    public Color getIntensity(Point3D p) {

        // gets the dot product and finds if the angle is big enough
        double dotProduct = this._direction.dotProduct(p.subtract(this.get_position()));
        double multVal = Math.max(dotProduct, 0);

        // calculates the distance
        double distance = Math.abs(this._position.distance(p));

        double divider = this._kc + (this._kl * distance) + (this._kq * distance * distance);

        return new Color((int)((this._color.getRed() * multVal)/ divider),
                (int)((this._color.getGreen() * multVal)/ divider),
                (int)((this._color.getBlue() * multVal) / divider));
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
