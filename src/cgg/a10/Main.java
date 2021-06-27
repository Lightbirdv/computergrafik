package cgg.a10;
import cgg.*;
import static cgtools.Vector.*;
import static cgtools.Color.*;
import static cgtools.Matrix.*;
import cgtools.Color;
import cgtools.Matrix;
// import cgtools.Point;

public class Main {

    public static void main(String[] args) {
        final int width = 1600;
        final int height = 900;
        Texture backgroundTexture = new Texture("doc/background.jpg");
        Texture earthTexture = new Texture("doc/earthmap1k.jpg");
        // image 1
        // sky color rgb(26, 40, 87)
        Group scene = new Group();
        // Group basic = new Group(
        // new Background(multiply(2,color(0,1,1)), new BackgroundMaterial(new Constant(orange))),
        // new Plane(point(0.0, -0.5, 0.0), direction(0, 1, 0), color(0.2,0.8,0), Double.POSITIVE_INFINITY, new DiffuseMaterial(new Color(0.20,0.4,0.17))));
        // scene.addShape(basic);
        // scene.addShape(new Sphere(point(0.0, -0.5, -10.0), 4, new DiffuseMaterial(new Constant(yellow))));
        // Matrix imageR = rotation(direction(1, 1, 1), 0);
        // Matrix imageT = translation(direction(backgroundTexture.texture.width / 2 + 0.5, backgroundTexture.texture.height / 2, 40));
        // Matrix imagePos = multiply(imageT,imageR);
        scene.addShape(new Background(new BackgroundMaterial(backgroundTexture)));
        scene.addShape(new Plane(point(10.0, -0.5, 0.0), direction(0, 1, 0), Double.POSITIVE_INFINITY, new Metal(0.0)));
        scene.addShape(new Sphere(point(10.0, 1, -15.0), 1, new DiffuseMaterial(new CheckerboardTexture(20, green, black))));
        scene.addShape(new Sphere(point(7, 1, -15.0), 1, new DiffuseMaterial(earthTexture)));
        scene.addShape(new Cylinder(0.3, 1, direction(12, 1, -13.0), new DiffuseMaterial(new CheckerboardTexture(10,new Color(0.6470,0.1647,0.1647),white))));
        Image image = new Image(width, height);
        // camera on top
        Matrix cameraR1 = rotation(direction(1, 1, 1), 0);
        Matrix cameraT1 = translation(direction(10, 0, -10));
        Matrix cameraR = rotation(direction(1, 0, 0), -20);
        Matrix cameraT = translation(direction(10, 4, -10));

        Matrix cameraPos1 = multiply(cameraT1,cameraR1);
        Matrix cameraPos = multiply(cameraT,cameraR);
        Camera cam = new Camera(Math.PI/2, width, height, cameraPos1);
        Camera cam2 = new Camera(Math.PI/2, width, height, cameraPos);
        
        // Raytracing raytraycing = new Raytracing(scene, cam, 6);
        Raytracing raytraycing2 = new Raytracing(scene, cam2, 6);


        // image.supersample(raytraycing, 10);
        // final String filename = "doc/a10-1.png";
        // image.write(filename);
        // System.out.println("Wrote image basic: " + filename);
        image.supersample(raytraycing2, 10);
        final String filename2 = "doc/a10-2.png";
        image.write(filename2);
        System.out.println("Wrote image basic: " + filename2);
        
    } 
}


