package elements;

import primitives.Point3D;

import java.awt.Color;

/**
 * exampleClass class to represent exampleClass Ambient Light
 */
public class AmbientLight {


    /* local variable declaration */
    private Color _color;
    private Double _ka;

    /* Getters */

    /**
     * gets  the color
     * @return the color
     */
    public Color get_color() {
        return _color;
    }

    /**
     * gets the ka
     * @return the ka
     */
    public Double get_ka() {
        return _ka;
    }

    /* Constructors */

    /**
     * exampleClass constructor that receives two values
     * @param c the color we receive
     * @param ka gets the intensity
     */
    public AmbientLight(Color c, double ka)
    {
        this._color = c;
        this._ka = ka;
    }

    /**
     * exampleClass constructor that gets the light
     * @param a red intensity
     * @param b green intensity
     * @param c blue intensity
     */
    public AmbientLight(int a, int b, int c){
        this(new Color(a, b, c), 1.0);
    }

    /**
     * default constructor
     */
    public AmbientLight(){
        this(new Color(255, 255, 255), 0.1);
    }

    /* Functions */

    /**
     * gets the intensity of the light times the color
     * @param point the point we need
     * @return the color
     */
    public Color getIntesity(Point3D point){

        return new Color((int)(this._color.getRed() * this._ka),
                (int)(this._color.getGreen() * this._ka),
                (int)(this._color.getBlue() * this._ka));
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
        if (!(obj instanceof AmbientLight)) return false;
        AmbientLight oth = (AmbientLight) obj;
        return this._color.equals(oth._color) && this._ka.equals(oth._color);
    }

    /**
     * overrides the toString function
     * @return the object as exampleClass string
     */
    @Override
    public String toString() {
        return "" + this._ka + " " + this._color;
    }
}
