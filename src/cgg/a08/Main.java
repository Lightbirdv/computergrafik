package cgg.a08;
import cgg.*;
import static cgtools.Vector.*;
import static cgtools.Color.*;
import static cgtools.Matrix.*;
import cgtools.Color;
import cgtools.Matrix;
import cgtools.Random;

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

        //tree1
        Matrix treeR = translation(direction(5, 0, 0));
        Group tree = new Group(new Transformation(treeR),
        new Cylinder(0.5, 2, direction(0, 0, -10), new DiffuseMaterial(new Color(0.647,0.16,0.16))),
        new Sphere(point(0, 2, -10), 1.5, new DiffuseMaterial(green)),
        new Sphere(point(0, 2.5, -10), 1.3, new DiffuseMaterial(green)),
        new Sphere(point(0, 3, -10), 1.0, new DiffuseMaterial(green)));
        
        Group treegroup = new Group();
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            int x = random.nextInt(30)-15;
            int z = -(random.nextInt(20))+5;
            if(-1.5 < x && x < 1.5) {
                Transformation t = new Transformation(translation(direction(x+1.5,0,z)));
                treegroup.addShape(new Group(t, tree));
            } else {
                Transformation t = new Transformation(translation(direction(x,0,z)));
                treegroup.addShape(new Group(t, tree));
            }
        }
        Group path = new Group(new Cylinder(1, 0.1, direction(0.2, -0.5, -4), new DiffuseMaterial(new Color(0.647,0.16,0.16))),
        new Cylinder(0.8, 0.1, direction(-0.3, -0.5, -5), new DiffuseMaterial(new Color(0.647,0.16,0.16))),
        new Cylinder(0.7, 0.1, direction(0.3, -0.5, -6), new DiffuseMaterial(new Color(0.647,0.16,0.16))),
        new Cylinder(0.7, 0.1, direction(0, -0.5, -7), new DiffuseMaterial(new Color(0.647,0.16,0.16))),
        new Cylinder(0.6, 0.1, direction(-0.2, -0.5, -8), new DiffuseMaterial(new Color(0.647,0.16,0.16))),
        new Cylinder(0.8, 0.1, direction(0.5, -0.5, -9), new DiffuseMaterial(new Color(0.647,0.16,0.16))));

        Group lantern = new Group(new Cylinder(0.1, 4, direction(1.2, -0.5, -9.5), new DiffuseMaterial(new Color(0.6,0.6,0.6))),new Cylinder(0.3, 0.5, direction(1.2, -0.5, -9.5), new DiffuseMaterial(new Color(0.6,0.6,0.6))),new Cylinder(0.2, 0.1, direction(1.2, 1.3, -9.5), new DiffuseMaterial(new Color(0.6,0.6,0.6))),new Sphere(point(1.2, 1.5, -9.5), 0.2, new BackgroundMaterial(new Color(1,0.93,0.87))));
        Group lanterngroup = new Group();
        Transformation t = new Transformation(translation(direction(0.6,0,0)));
        lanterngroup.addShape(new Group(t,lantern));
        t = new Transformation(translation(direction(-2,0,0)));
        lanterngroup.addShape(new Group(t,lantern));
        t = new Transformation(translation(direction(-2.1,0,3.2)));
        lanterngroup.addShape(new Group(t,lantern));
        t = new Transformation(translation(direction(0.3,0,3.2)));
        lanterngroup.addShape(new Group(t,lantern));
        t = new Transformation(translation(direction(-2.3,0,6.4)));
        lanterngroup.addShape(new Group(t,lantern));
        t = new Transformation(translation(direction(0.5,0,6.4)));
        lanterngroup.addShape(new Group(t,lantern));
        scene.addShape(lanterngroup);
        scene.addShape(path);
        scene.addShape(treegroup);
        Image image = new Image(width, height);
        // camera on top
        Matrix cameraR = rotation(direction(1, 0, 0), -30);
        Matrix cameraT = translation(direction(0, 6, 4));

        Matrix cameraPos = multiply(cameraT,cameraR);
        Camera cam = new Camera(Math.PI/2, width, height, cameraPos);
        Camera cam2 = new Camera(Math.PI/2, width, height);
        
        Raytracing raytraycing = new Raytracing(scene, cam, 6);
        Raytracing raytraycing2 = new Raytracing(scene, cam2, 6);

        image.supersample(raytraycing, 10);
        final String filename = "doc/a08-1.png";
        image.write(filename);
        System.out.println("Wrote image basic: " + filename);
        image.supersample(raytraycing2, 10);
        final String filename2 = "doc/a08-2.png";
        image.write(filename2);
        System.out.println("Wrote image basic: " + filename2);
        
    } 
}


