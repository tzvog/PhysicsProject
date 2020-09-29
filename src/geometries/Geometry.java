package geometries;

import primitives.*;

import java.awt.*;

/**
 * an interface for geometry fields
 */
public abstract class Geometry implements Intersectable{

    /* local variable declaration */
    Color _emmission;
    Material _material;

    /* Getters */

    /**
     * gets the _material
     * @return the _material
     */
    public Material get_material() {
        return _material;
    }

    /**
     * sets the _material
     * @param _material the _material
     */
    public void set_material(Material _material) {
        this._material = _material;
    }

    /**
     * gets the color
     * @return the color
     */
    public Color get_emmission()
    {
        return this._emmission;
    }

    /**
     * sets the color
     * @param _emmission the color
     */
    public void set_emmission(Color _emmission) {
        this._emmission = _emmission;
    }

    /* Constructors */

    /**
     * full constructor
     * @param _emmission the color
     * @param _materiel the _material
     */
    public Geometry(Color _emmission, Material _materiel) {
        this._emmission = _emmission;
        this._material = _materiel;
    }

    /**
     * constructor that gets a color
     * @param _emmission the color
     */
    public Geometry(Color _emmission) {
        this(_emmission, new Material());
    }

    /**
     * a constructor that gets a _material
     * @param _materiel the _material
     */
    public Geometry(Material _materiel) {
        this(new Color(255,255,255), _materiel);
    }

    /**
     * default constructor
     */
    public Geometry() {
        this(new Color(255,255,255), new Material());
    }


    /* Functions */

    /**
     * abstract function to return the normal
     * @param point the point we are dealing with
     * @return the Vector
     */
    abstract public Vector getNormal(Point3D point);

    /**
     * checks if two points have the same values
     * @param obj the other point
     * @return if they are equal
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (!(obj instanceof Geometry)) return false;
        Geometry oth = (Geometry) obj;
        return this._emmission.equals(oth._emmission) &&
                this._material.equals(oth._material);
    }

    /**
     * overrides the toString function
     * @return the object as exampleClass string
     */
    @Override
    public String toString() {
        return this._emmission + " " + this._material;
    }
}
