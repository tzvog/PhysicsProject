public class exampleClass {

    /* local variable declaration */
    /* Getters */
    /* Constructors */
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
        if (!(obj instanceof exampleClass)) return false;
        exampleClass oth = (exampleClass) obj;
        return true;
    }

    /**
     * overrides the toString function
     * @return the object as exampleClass string
     */
    @Override
    public String toString() {
        return "";
    }
}
