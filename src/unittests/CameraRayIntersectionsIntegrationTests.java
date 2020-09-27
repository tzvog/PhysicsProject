///**
// *
// */
//package unittests;
//
//import static org.junit.Assert.*;
//import org.junit.Test;
//
//import java.util.List;
//
//import elements.Camera;
//import primitives.*;
//import geometries.*;
//
///**
// *
// */
//public class CameraRayIntersectionsIntegrationTests {
//
//    /**
//     * Integration tests of Camera Ray construction with Ray-Sphere intersections
//     */
//    @Test
//    public void CameraRaySphereIntegration() {
//        Camera cam1 = new Camera(new Vector(0, 0, 1), new Vector(0, -1, 0));
//        Camera cam2 = new Camera(new Point3D(0, 0, -0.5),
//                new Vector(0, 0, 1),
//                new Vector(0, -1, 0),
//                new Vector(0, 0,
//                        1).crossProduct(new Vector(0, -1, 0)));
//        Sphere sphere;
//        List<Point3D> intersections;
//        int count;
//
//        // TC01: Small Sphere 2 points
//        sphere = new Sphere(1, new Point3D(0, 0, 3));
//        count = 0;
//        for (int i = 0; i < 3; ++i)
//            for (int j = 0; j < 3; ++j) {
//                intersections = sphere.findIntersections(cam1.constructRayThroughPixel(3, 3, j, i, 1, 3, 3));
//                if (intersections != null)
//                    count += intersections.size();
//            }
//        assertEquals("Wrong amount of intersections", 2, count);
//
//        // TC02: Big Sphere 18 points
//        sphere = new Sphere(2.5, new Point3D(0, 0, 2.5));
//        count = 0;
//        for (int i = 0; i < 3; ++i)
//            for (int j = 0; j < 3; ++j) {
//                intersections = sphere.findIntersections(cam2.constructRayThroughPixel(
//                        3, 3, j, i, 1, 3, 3));
//                if (intersections != null)
//                    count += intersections.size();
//            }
//        assertEquals("Wrong amount of intersections", 18, count);
//
//        // TC03: Medium Sphere 10 points
//        sphere = new Sphere(2, new Point3D(0, 0, 2));
//        count = 0;
//        for (int i = 0; i < 3; ++i)
//            for (int j = 0; j < 3; ++j) {
//                intersections = sphere.findIntersections(cam2.constructRayThroughPixel(3, 3, j, i, 1, 3, 3));
//                if (intersections != null)
//                    count += intersections.size();
//            }
//        assertEquals("Wrong amount of intersections", 10, count);
//
//        // TC04: Inside Sphere 9 points
//        sphere = new Sphere(4, new Point3D(0, 0, 1));
//        count = 0;
//        for (int i = 0; i < 3; ++i)
//            for (int j = 0; j < 3; ++j) {
//                intersections = sphere.findIntersections(cam2.constructRayThroughPixel(3, 3, j, i, 1, 3, 3));
//                if (intersections != null)
//                    count += intersections.size();
//            }
//        assertEquals("Wrong amount of intersections", 9, count);
//
//        // TC05: Beyond Sphere 0 points
//        sphere = new Sphere(0.5, new Point3D(0, 0, -1));
//        count = 0;
//        for (int i = 0; i < 3; ++i)
//            for (int j = 0; j < 3; ++j) {
//                intersections = sphere.findIntersections(cam1.constructRayThroughPixel(3, 3, j, i, 1, 3, 3));
//                if (intersections != null)
//                    count += intersections.size();
//            }
//        assertEquals("Wrong amount of intersections", 0, count);
//    }
//
//    /**
//     * Integration tests of Camera Ray construction with Ray-Plane intersections
//     */
//    @Test
//    public void CameraRayPlaneIntegration() {
//        Camera cam = new Camera(new Vector(0, 0, 1),
//                new Vector(0, -1, 0));
//        Plane plane;
//        List<Point3D> intersections;
//        int count;
//
//        // TC01: Plane against camera 9 points
//        plane = new Plane(new Point3D(0, 0, 5), new Vector(0, 0, 1));
//        count = 0;
//        for (int i = 0; i < 3; ++i)
//            for (int j = 0; j < 3; ++j) {
//                intersections = plane.findIntersections(new Intersectable.GeoPoint(this, cam.constructRayThroughPixel(3, 3, j, i, 1, 3, 3)));
//                if (intersections != null)
//                    count += intersections.size();
//            }
//        assertEquals("Wrong amount of intersections", 9, count);
//
//        // TC02: Plane with small angle 9 points
//        plane = new Plane(new Point3D(0, 0, 5), new Vector(0, -1, 2));
//        count = 0;
//        for (int i = 0; i < 3; ++i)
//            for (int j = 0; j < 3; ++j) {
//                intersections = plane.findIntersections(cam.constructRayThroughPixel(3, 3, j, i, 1, 3, 3));
//                if (intersections != null)
//                    count += intersections.size();
//            }
//        assertEquals("Wrong amount of intersections", 9, count);
//
//        // TC03: Plane parallel to lower rays 6 points
//        plane = new Plane(new Point3D(0, 0, 5), new Vector(0, -1, 1));
//        count = 0;
//        for (int i = 0; i < 3; ++i)
//            for (int j = 0; j < 3; ++j) {
//                intersections = plane.findIntersections(cam.constructRayThroughPixel(3, 3, j, i, 1, 3, 3));
//                if (intersections != null)
//                    count += intersections.size();
//            }
//        assertEquals("Wrong amount of intersections", 6, count);
//
//        // TC04: Beyond Plane 0 points
//        plane = new Plane(new Point3D(0, 0, -5), new Vector(0, 0, 1));
//        count = 0;
//        for (int i = 0; i < 3; ++i)
//            for (int j = 0; j < 3; ++j) {
//                intersections = plane.findIntersections(cam.constructRayThroughPixel(3, 3, j, i, 1, 3, 3));
//                if (intersections != null)
//                    count += intersections.size();
//            }
//        assertEquals("Wrong amount of intersections", 0, count);
//    }
//
//    /**
//     * Integration tests of Camera Ray construction with Ray-Triangle intersections
//     */
//    @Test
//    public void CameraRayTriangleIntegration() {
//        Camera cam = new Camera(new Vector(0, 0, 1),
//                new Vector(0, -1, 0));
//        Triangle tr;
//        List<Point3D> intersections;
//        int count;
//
//        // TC01: Small triangle 1 point
//        tr = new Triangle(new Point3D(1, 1, 2), new Point3D(-1, 1, 2), new Point3D(0, -1, 2));
//        count = 0;
//        for (int i = 0; i < 3; ++i)
//            for (int j = 0; j < 3; ++j) {
//                intersections = tr.findIntersections(cam.constructRayThroughPixel(3, 3, j, i, 1, 3, 3));
//                if (intersections != null)
//                    count += intersections.size();
//            }
//        assertEquals("Wrong amount of intersections", 1, count);
//
//        // TC02: Medium triangle 2 points
//        tr = new Triangle(new Point3D(1, 1, 2), new Point3D(-1, 1, 2), new Point3D(0, -20, 2));
//        count = 0;
//        for (int i = 0; i < 3; ++i)
//            for (int j = 0; j < 3; ++j) {
//                intersections = tr.findIntersections(cam.constructRayThroughPixel(3, 3, j, i, 1, 3, 3));
//                if (intersections != null)
//                    count += intersections.size();
//            }
//        assertEquals("Wrong amount of intersections", 2, count);
//
//    }
//
//}
