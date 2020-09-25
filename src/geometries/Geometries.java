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

        List<Point3D> intersections = null;
        for (Intersectable geometry : this.objList) {
            List<Point3D> tempIntersections = geometry.findIntersections(ray);
            if (tempIntersections != null) {
                if (intersections == null)
                    intersections = new ArrayList<Point3D>();
                intersections.addAll(tempIntersections);
            }
        }
        return intersections;

    }
}
