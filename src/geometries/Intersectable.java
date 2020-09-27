package geometries;

import primitives.Point3D;
import primitives.Ray;
import java.util.List;

public interface Intersectable {

    List<GeoPoint> findIntersections(Ray ray);


    /**
     * inner class to hold a Point and geometry
     */
    public static class GeoPoint {
        public Geometry geometry;
        public Point3D point;


        /**
         * sets the point and geometry
         * @param geometry the geometry
         * @param point the point
         */
        public GeoPoint(Geometry geometry, Point3D point) {
            this.geometry = geometry;
            this.point = point;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            GeoPoint other = (GeoPoint) obj;
            if (geometry != other.geometry)
                return false;
            if (point == null) {
                if (other.point != null)
                    return false;
            } else if (!point.equals(other.point))
                return false;
            return true;
        }
    }
}
