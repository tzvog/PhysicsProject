package primitives;

/**
 * a class to represent a material
 */
public class Material {

    /* local variable declaration */
    private double _kd;
    private double _ks;
    private double _nShininess;

    /* Getters */

    /**
     * gets the kd
     * @return the kd
     */
    public double get_kd() {
        return _kd;
    }

    /**
     * gets the ks
     * @return the ks
     */
    public double get_ks() {
        return _ks;
    }

    /**
     * gets the n shines
     * @return the n shines
     */
    public double get_nShininess() {
        return _nShininess;
    }

    /* Constructors */

    /**
     * default constructor
     */
    public Material() {
        this._nShininess = 0.0;
        this._ks = 0.0;
        this._kd = 0.0;
    }

    /* Functions */

    /**
     * checks if two points have the same values
     * @param obj the other point
     * @return if they are equal
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (!(obj instanceof Material)) return false;
        Material oth = (Material) obj;
        return this._kd == oth._kd && this._ks == oth._ks && this._nShininess == oth._nShininess;
    }

    /**
     * overrides the toString function
     * @return the object as exampleClass string
     */
    @Override
    public String toString() {
        return this._kd + " " + this._ks + " " + this._nShininess;
    }
}
