package cgg.a05;
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
        Shape background = new Background(multiply(2,color(0,1,1)), new BackgroundMaterial(white));
        Shape ground = new Plane(point(0.0, -0.5, 0.0), direction(0, 1, 0), color(0.2,0.8,0), Double.POSITIVE_INFINITY, new DiffuseMaterial(gray));
        Shape globe1 = new Sphere(point(-1.0, -0.25, -2.5), 0.7, red, new DiffuseMaterial(red));
        Shape globe2 = new Sphere(point(0.0, 0.75, -2.5), 0.5, green, new DiffuseMaterial(green));
        Shape globe3 = new Sphere(point(1.0, 0.25, -2.5), 0.7, blue, new DiffuseMaterial(blue));
        Shape globe4 = new Sphere(point(1.2, 0.25, -1.5), 0.3, orange, new DiffuseMaterial(orange));
        Shape globe5 = new Sphere(point(1.0, 1, -2.5), 0.2, cyan, new DiffuseMaterial(cyan));
        // Shape globe6 = new Sphere(point(-1.0, 1.1, -2.5), 0.3, yellow, new DiffuseMaterial(yellow));
        shapes.add(background);
        shapes.add(ground);
        shapes.add(globe1);
        shapes.add(globe2);
        shapes.add(globe3);
        shapes.add(globe4);
        shapes.add(globe5);
        //shapes.add(globe6);
        Group group = new Group(shapes);
        Image image = new Image(width, height);
        Camera cam = new Camera(Math.PI/2, width, height);

       
        Raytracing raytraycing = new Raytracing(group, cam, 6);
        
        image.supersample(raytraycing, 10);
        
        final String filename = "doc/a05-diffuse-spheres.png";
        image.write(filename);
        System.out.println("Wrote image basic: " + filename);
    }
}


