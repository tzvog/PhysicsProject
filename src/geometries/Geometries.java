package geometries;

import primitives.Point3D;
import primitives.Ray;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Geometries implements Intersectable {

    private List<Intersectable> objList;

    public Geometries()
    {
        this.objList = new ArrayList<Intersectable>();
    }

    public Geometries(Intersectable ... geometries)
    {
        this.objList = new ArrayList<Intersectable>();
        this.add(geometries);
    }

    public void add(Intersectable ... geometries)
    {
        Collections.addAll(objList, geometries);
    }

    @Override
    public List<Point3D> findIntersections(Ray ray) {
        return null;
    }
}
