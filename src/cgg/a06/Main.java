package cgg.a06;
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
        Shape globe1 = new Sphere(point(-1.0, -0.25, -2.5), 0.7, red, new Metal(0));
        Shape globe2 = new Sphere(point(0.0, 0.75, -2.5), 0.5, green, new DiffuseMaterial(green));
        Shape globe3 = new Sphere(point(1.0, 0.25, -2.5), 0.7, blue, new DiffuseMaterial(blue));
        Shape globe4 = new Sphere(point(1.2, 0.25, -1.5), 0.3, orange, new DiffuseMaterial(orange));
        Shape globe5 = new Sphere(point(1.0, 1, -2.5), 0.2, cyan, new DiffuseMaterial(cyan));
        Shape globe6 = new Sphere(point(0.1, 0.3, -1.5), 0.5, green, new Glass());
        Shape globe7 = new Sphere(point(-1.0, 1, -2.5), 0.3, red, new Metal(0.4, color(0.2,0,0)));
        shapes.add(background);
        shapes.add(ground);
        shapes.add(globe1);
        shapes.add(globe2);
        shapes.add(globe3);
        shapes.add(globe4);
        shapes.add(globe5);
        shapes.add(globe6);
        shapes.add(globe7);
        //shapes.add(globe6);
        Group group = new Group(shapes);

        ArrayList<Shape> shapes2 = new ArrayList<Shape>();
        Shape background2 = new Background(multiply(2,color(0,1,1)), new BackgroundMaterial(white));
        Shape ground2 = new Plane(point(0.0, -0.5, 0.0), direction(0, 1, 0), color(0.2,0.8,0), Double.POSITIVE_INFINITY, new DiffuseMaterial(gray));
        Shape sphere1 = new Sphere(point(-2.0, -0.25, -2.5), 0.3, red, new Metal(0));
        Shape sphere2 = new Sphere(point(0.0, 0.75, -2.5), 0.2, green, new DiffuseMaterial(green));
        Shape sphere3 = new Sphere(point(1.0, 0.25, -2.5), 0.5, blue, new DiffuseMaterial(blue));
        Shape sphere4 = new Sphere(point(1.2, 0.25, -1.5), 0.1, orange, new DiffuseMaterial(orange));
        Shape sphere5 = new Sphere(point(1.0, 1, -2.5), 0.3, cyan, new DiffuseMaterial(cyan));
        Shape sphere6 = new Sphere(point(0.1, 0.3, -1.5), 0.4, green, new Glass());
        Shape sphere7 = new Sphere(point(-1.0, 1, -2.5), 0.2, red, new Metal(0.4, color(0.2,0,0)));
        shapes2.add(background2);
        shapes2.add(ground2);
        shapes2.add(sphere1);
        shapes2.add(sphere2);
        shapes2.add(sphere3);
        shapes2.add(sphere4);
        shapes2.add(sphere5);
        shapes2.add(sphere6);
        shapes2.add(sphere7);
        //shapes.add(globe6);
        Group group2 = new Group(shapes2);

        Image image = new Image(width, height);
        Camera cam = new Camera(Math.PI/2, width, height);
        Image image2 = new Image(width, height);
        Camera cam2 = new Camera(Math.PI/2, width, height);
       
        Raytracing raytraycing = new Raytracing(group, cam, 6);
        Raytracing raytraycing2 = new Raytracing(group2, cam2, 6);
        
        image.supersample(raytraycing, 10);
        image2.supersample(raytraycing2, 10);
        final String filename = "doc/a06-mirrors-glass-1.png";
        image.write(filename);
        System.out.println("Wrote image basic: " + filename);
        final String filename2 = "doc/a06-mirrors-glass-2.png";
        image2.write(filename2);
        System.out.println("Wrote image basic: " + filename2);
        //test();
    }

    // public static void test() {
    //     Glass glass = new Glass();
    //     System.out.println(glass.reflect(direction(0,0,0), direction(0,1,0)));
    //     System.out.println(glass.reflect(direction(0.707,-0.707,0), direction(0,1,0)));
    //     System.out.println(glass.reflect(direction(0.707,0.707,0), direction(0,1,0)));
    //     System.out.println(glass.schlick(direction(0.707,0.707,0), direction(0,1,0)));
    //     glass.swap(glass.n1,glass.n2);
    //     System.out.println(glass.schlick(direction(0.707,0.707,0), direction(0,1,0)));
    //     glass.swap(glass.n1,glass.n2);
    //     System.out.println(glass.schlick(direction(0.995,-0.1,0), direction(0,1,0)));
    //     glass.swap(glass.n1,glass.n2);
    //     System.out.println(glass.schlick(direction(0.995,-0.1,0), direction(0,1,0)));
    //     glass.swap(glass.n1,glass.n2);
    //     System.out.println(glass.refract(direction(0.707,0.707,0), direction(0,1,0)));
    //     glass.swap(glass.n1,glass.n2);
    //     System.out.println(glass.refract(direction(0.707,0.707,0), direction(0,1,0)));
    //     glass.swap(glass.n1,glass.n2);
    //     System.out.println(glass.refract(direction(0.995,-0.1,0), direction(0,1,0)));
    //     glass.swap(glass.n1,glass.n2);
    //     System.out.println(glass.refract(direction(0.995,-0.1,0), direction(0,1,0)));
    //     glass.swap(glass.n1,glass.n2);
    //     System.out.println(glass.refract(direction(0.1,-0.995,0), direction(0,1,0)));
    //     glass.swap(glass.n1,glass.n2);
    //     System.out.println(glass.refract(direction(0.1,-0.995,0), direction(0,1,0)));

    //}
}


