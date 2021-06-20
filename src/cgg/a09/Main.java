package cgg.a09;
import cgg.*;
import static cgtools.Vector.*;
import static cgtools.Color.*;
import static cgtools.Matrix.*;
import cgtools.Color;
import cgtools.Matrix;
import cgtools.Point;

public class Main {

    public static void main(String[] args) {
        final int width = 1600;
        final int height = 900;
        // image 1
        // sky color rgb(26, 40, 87)
        Group scene = new Group();
        Group basic = new Group(
        new Background(multiply(2,color(0,1,1)), new BackgroundMaterial(new Color(0.1,0.15,0.34))),
        new Plane(point(0.0, -0.5, 0.0), direction(0, 1, 0), color(0.2,0.8,0), Double.POSITIVE_INFINITY, new DiffuseMaterial(new Color(0.20,0.4,0.17))));
        scene.addShape(basic);
        scene.addShape(makeSpheres(point(0, 0, -20), 4));
        
        Image image = new Image(width, height);
        // camera on top
        Matrix cameraR = rotation(direction(1, 0, 0), -30);
        Matrix cameraT = translation(direction(0, 6, 4));

        Matrix cameraPos = multiply(cameraT,cameraR);
        Camera cam = new Camera(Math.PI/2, width, height, cameraPos);
        
        Raytracing raytraycing = new Raytracing(scene, cam, 6);

        image.supersample(raytraycing, 10);
        final String filename = "doc/a09-benchmark-scene.png";
        image.write(filename);
        System.out.println("Wrote image basic: " + filename);
        
    } 

    static Shape makeSpheres(Point position, int exponent) {
        if (exponent <= 0) {
          return new Sphere(position, 0.5,
              new DiffuseMaterial(new Color(cgtools.Random.random(), cgtools.Random.random(), cgtools.Random.random())));
        } else {
            var offset = Math.pow(2.0, exponent) / 2;
            return new Group(
                makeSpheres(add(position, direction(-offset, 0.0, -offset)), exponent - 1),
                makeSpheres(add(position, direction(-offset, 0.0, +offset)), exponent - 1),
                makeSpheres(add(position, direction(+offset, 0.0, -offset)), exponent - 1),
                makeSpheres(add(position, direction(+offset, 0.0, +offset)), exponent - 1)
            );
         
        }
    
    }
}


