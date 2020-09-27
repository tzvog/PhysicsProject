package geometries;

import primitives.*;

import java.awt.*;

/**
 * an interface for geometry fields
 */
public abstract class Geometry implements Intersectable{

    /* local variable declaration */
    Color _emmission;
    Material _materiel;

    /* Getters */

    /**
     * gets the material
     * @return the material
     */
    public Material get_materiel() {
        return _materiel;
    }

    /**
     * sets the material
     * @param _materiel the material
     */
    public void set_materiel(Material _materiel) {
        this._materiel = _materiel;
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
     * @param _materiel the material
     */
    public Geometry(Color _emmission, Material _materiel) {
        this._emmission = _emmission;
        this._materiel = _materiel;
    }

    /**
     * constructor that gets a color
     * @param _emmission the color
     */
    public Geometry(Color _emmission) {
        this(_emmission, new Material());
    }

    /**
     * a constructor that gets a material
     * @param _materiel the material
     */
    public Geometry(Material _materiel) {
        this(new Color(0,0,0), _materiel);
    }

    /**
     * default constructor
     */
    public Geometry() {
        this(new Color(0,0,0), new Material());
    }


    /* Functions */

    /**
     * abstract function to return the normal
     * @param point the point we are dealing with
     * @return the Vector
     */
    abstract Vector getNormal(Point3D point);

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
                this._materiel.equals(oth._materiel);
    }

    /**
     * overrides the toString function
     * @return the object as exampleClass string
     */
    @Override
    public String toString() {
        return this._emmission + " " + this._materiel;
    }
}
