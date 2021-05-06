package cgg.a03;
import cgg.*;
import static cgtools.Vector.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        final int width = 1600;
        final int height = 900;
        
        Sphere sphere1 = new Sphere(point(-200,0,550),80);
        Sphere sphere2 = new Sphere(point(0,0,550),80);        
        Sphere sphere3 = new Sphere(point(200,0,550),80);
        
        Image image = new Image(width, height);
        ArrayList<Sphere> spheres = new ArrayList<>(Arrays.asList(sphere1,sphere2,sphere3));
        Camera cam = new Camera(200, width, height);

        Raytracing raytraycing = new Raytracing(spheres, cam);

        image.supersample(raytraycing, 10);

        final String filename = "doc/a03-three-spheres.png";
        image.write(filename);
        System.out.println("Wrote image basic: " + filename);
    }
}


