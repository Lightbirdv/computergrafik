package cgg.a04;
import cgg.*;
import static cgtools.Vector.*;
import static cgtools.Color.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        final int width = 1600;
        final int height = 900;
        
        // image 1
        ArrayList<Shape> shapes = new ArrayList<Shape>();
        Shape background = new Background(multiply(2,color(0,1,1)));
        Shape ground = new Plane(point(0.0, -0.5, 0.0), direction(0, 1, 0), color(0.2,0.8,0), Double.POSITIVE_INFINITY);
        Shape globe1 = new Sphere(point(-1.0, -0.25, -2.5), 0.7, red);
        Shape globe2 = new Sphere(point(0.0, -0.25, -2.5), 0.5, green);
        Shape globe3 = new Sphere(point(1.0, -0.25, -2.5), 0.7, blue);
        shapes.add(background);
        shapes.add(ground);
        shapes.add(globe1);
        shapes.add(globe2);
        shapes.add(globe3);
        Group group = new Group(shapes);
        Image image = new Image(width, height);
        Camera cam = new Camera(Math.PI/2, width, height);

        // image 2
        ArrayList<Shape> shapes2 = new ArrayList<Shape>();
        Shape background2 = new Background(multiply(2,color(0,1,1)));
        Shape water = new Plane(point(0.0, -0.5, 0.0), direction(0, 1, 0), blue, Double.POSITIVE_INFINITY);
        Shape island = new Sphere(point(0.0, -0.85, -1.8), 0.7, color(1,1,0));
        Shape palm1 = new Sphere(point(-0.2, -0.25, -1.5), 0.05, color(0.5,0.2,0.1));
        Shape palm2 = new Sphere(point(-0.21, -0.18, -1.5), 0.05, color(0.5,0.2,0.1));
        Shape palm3 = new Sphere(point(-0.22, -0.11, -1.5), 0.05, color(0.5,0.2,0.1));
        Shape palm4 = new Sphere(point(-0.23, -0.04, -1.5), 0.05, color(0.5,0.2,0.1));
        Shape palm5 = new Sphere(point(-0.22, 0.03, -1.5), 0.05, color(0.5,0.2,0.1));
        Shape palm6 = new Sphere(point(-0.21, 0.10, -1.5), 0.05, color(0.5,0.2,0.1));
        Shape palmleaf1 = new Sphere(point(-0.24, 0.13, -1.4), 0.05, color(0,0.6,0));
        Shape palmleaf2 = new Sphere(point(-0.27, 0.10, -1.3), 0.05, color(0,0.6,0));
        Shape palmleaf3 = new Sphere(point(-0.30, 0.05, -1.2), 0.04, color(0,0.6,0));
        Shape palmleaf4 = new Sphere(point(-0.24, 0.16, -1.5), 0.05, color(0,0.6,0));
        Shape palmleaf5 = new Sphere(point(-0.30, 0.18, -1.6), 0.05, color(0,0.6,0));
        Shape palmleaf6 = new Sphere(point(-0.33, 0.14, -1.7), 0.05, color(0,0.6,0));
        Shape palmleaf7 = new Sphere(point(-0.21, 0.16, -1.5), 0.05, color(0,0.6,0));
        Shape palmleaf8 = new Sphere(point(-0.18, 0.18, -1.6), 0.05, color(0,0.6,0));
        Shape palmleaf9 = new Sphere(point(-0.15, 0.14, -1.7), 0.04, color(0,0.6,0));
        Shape cloud1 = new Sphere(point(-2.5, 2.25, -6.0), 0.2, white);
        Shape cloud2 = new Sphere(point(-2.6, 2.2, -5.9), 0.15, white);
        Shape cloud3 = new Sphere(point(-2.7, 2.2, -5.85), 0.12, white);
        Shape cloud4 = new Sphere(point(-2.35, 2.3, -6.1), 0.15, white);
        Shape cloud5 = new Sphere(point(2.5, 2.25, -5.0), 0.2, white);
        Shape cloud6 = new Sphere(point(2.6, 2.2, -4.9), 0.15, white);
        Shape cloud7 = new Sphere(point(2.7, 2.2, -4.85), 0.12, white);
        Shape cloud8 = new Sphere(point(2.35, 2.3, -5.1), 0.15, white);
        shapes2.add(cloud1);
        shapes2.add(cloud2);
        shapes2.add(cloud3);
        shapes2.add(cloud4);
        shapes2.add(cloud5);
        shapes2.add(cloud6);
        shapes2.add(cloud7);
        shapes2.add(cloud8);
        shapes2.add(palmleaf1);
        shapes2.add(palmleaf2);
        shapes2.add(palmleaf3);
        shapes2.add(palmleaf4);
        shapes2.add(palmleaf5);
        shapes2.add(palmleaf6);
        shapes2.add(palmleaf7);
        shapes2.add(palmleaf8);
        shapes2.add(palmleaf9);
        shapes2.add(palm6);
        shapes2.add(palm5);
        shapes2.add(palm4);
        shapes2.add(palm3);
        shapes2.add(palm2);
        shapes2.add(palm1);
        shapes2.add(island);
        shapes2.add(background2);
        shapes2.add(water);
        Group group2 = new Group(shapes2);
        Image image2 = new Image(width, height);
        Camera cam2 = new Camera(Math.PI/2, width, height);

        Raytracing raytraycing = new Raytracing(group, cam);
        Raytracing raytraycing2 = new Raytracing(group2, cam2);
        image.supersample(raytraycing, 10);
        image2.supersample(raytraycing2, 10);

        final String filename = "doc/a04-3-spheres.png";
        image.write(filename);
        System.out.println("Wrote image basic: " + filename);
        final String filename2 = "doc/a04-scene.png";
        image2.write(filename2);
        System.out.println("Wrote image basic: " + filename2);
    }
}


