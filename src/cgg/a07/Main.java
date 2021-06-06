package cgg.a07;
import cgg.*;
import static cgtools.Vector.*;
import static cgtools.Color.*;
import static cgtools.Matrix.*;
import cgtools.Color;
import java.util.ArrayList;
import cgtools.Matrix;

public class Main {

    public static void main(String[] args) {
        final int width = 1600;
        final int height = 900;
        // image 1
        // sky color rgb(26, 40, 87)
        ArrayList<Shape> shapes = new ArrayList<Shape>();
        Shape background = new Background(multiply(2,color(0,1,1)), new BackgroundMaterial(new Color(0.1,0.15,0.34)));
        Shape ground = new Plane(point(0.0, -0.5, 0.0), direction(0, 1, 0), color(0.2,0.8,0), Double.POSITIVE_INFINITY, new DiffuseMaterial(new Color(0.20,0.4,0.17)));
        //tree1
        Shape cylinder = new Cylinder(0.5, 2, direction(-3.5, 0, -10), new DiffuseMaterial(new Color(0.647,0.16,0.16)));
        Shape treesphere = new Sphere(point(-3.5, 2, -10), 1.5, red, new DiffuseMaterial(green));
        Shape treesphere2 = new Sphere(point(-3.5, 2.5, -10), 1.3, red, new DiffuseMaterial(green));
        Shape treesphere3 = new Sphere(point(-3.5, 3, -10), 1.0, red, new DiffuseMaterial(green));
        //tree2
        Shape cylinder2 = new Cylinder(0.5, 2, direction(-5, 0, -6), new DiffuseMaterial(new Color(0.647,0.16,0.16)));
        Shape treesphere4 = new Sphere(point(-5, 2, -6), 1.5, red, new DiffuseMaterial(new Color(0.33,0.84,0.33)));
        Shape treesphere5 = new Sphere(point(-5, 2.5, -6), 1.3, red, new DiffuseMaterial(new Color(0.33,0.84,0.33)));
        Shape treesphere6 = new Sphere(point(-5, 3, -6), 1.0, red, new DiffuseMaterial(new Color(0.33,0.84,0.33)));

        //tree3
        Shape cylinder3 = new Cylinder(0.5, 2, direction(-7, 0, -15), new DiffuseMaterial(new Color(0.647,0.16,0.16)));
        Shape treesphere7 = new Sphere(point(-7, 2, -15), 1.5, red, new DiffuseMaterial(new Color(0.33,1,0.33)));
        Shape treesphere8 = new Sphere(point(-7, 2.5, -15), 1.3, red, new DiffuseMaterial(new Color(0.33,1,0.33)));
        Shape treesphere9 = new Sphere(point(-7, 3, -15), 1.0, red, new DiffuseMaterial(new Color(0.33,1,0.33)));

        //tree4
        Shape cylinder4 = new Cylinder(0.5, 2, direction(-10, 0, -12), new DiffuseMaterial(new Color(0.647,0.16,0.16)));
        Shape treesphere10 = new Sphere(point(-10, 2, -12), 1.5, red, new DiffuseMaterial(green));
        Shape treesphere11 = new Sphere(point(-10, 2.5, -12), 1.3, red, new DiffuseMaterial(green));
        Shape treesphere12 = new Sphere(point(-10, 3, -12), 1.0, red, new DiffuseMaterial(green));

        //tree5
        Shape cylinder5 = new Cylinder(0.5, 2, direction(3.5, 0, -10), new DiffuseMaterial(new Color(0.647,0.16,0.16)));
        Shape treesphere13 = new Sphere(point(3.5, 2, -10), 1.5, red, new DiffuseMaterial(green));
        Shape treesphere14 = new Sphere(point(3.5, 2.5, -10), 1.3, red, new DiffuseMaterial(green));
        Shape treesphere15 = new Sphere(point(3.5, 3, -10), 1.0, red, new DiffuseMaterial(green));
        
        //tree6
        Shape cylinder6 = new Cylinder(0.5, 2, direction(5, 0, -6), new DiffuseMaterial(new Color(0.647,0.16,0.16)));
        Shape treesphere16 = new Sphere(point(5, 2, -6), 1.5, red, new DiffuseMaterial(new Color(0.33,0.84,0.33)));
        Shape treesphere17 = new Sphere(point(5, 2.5, -6), 1.3, red, new DiffuseMaterial(new Color(0.33,0.84,0.33)));
        Shape treesphere18 = new Sphere(point(5, 3, -6), 1.0, red, new DiffuseMaterial(new Color(0.33,0.84,0.33)));
 
        //tree7
        Shape cylinder7 = new Cylinder(0.5, 2, direction(7, 0, -15), new DiffuseMaterial(new Color(0.647,0.16,0.16)));
        Shape treesphere19 = new Sphere(point(7, 2, -15), 1.5, red, new DiffuseMaterial(new Color(0.33,1,0.33)));
        Shape treesphere20 = new Sphere(point(7, 2.5, -15), 1.3, red, new DiffuseMaterial(new Color(0.33,1,0.33)));
        Shape treesphere21 = new Sphere(point(7, 3, -15), 1.0, red, new DiffuseMaterial(new Color(0.33,1,0.33)));
 
        //tree8
        Shape cylinder8 = new Cylinder(0.5, 2, direction(10, 0, -12), new DiffuseMaterial(new Color(0.647,0.16,0.16)));
        Shape treesphere22 = new Sphere(point(10, 2, -12), 1.5, red, new DiffuseMaterial(green));
        Shape treesphere23 = new Sphere(point(10, 2.5, -12), 1.3, red, new DiffuseMaterial(green));
        Shape treesphere24 = new Sphere(point(10, 3, -12), 1.0, red, new DiffuseMaterial(green));

        //path
        Shape path1 = new Cylinder(1, 0.1, direction(0.2, -0.5, -4), new DiffuseMaterial(new Color(0.647,0.16,0.16)));
        Shape path2 = new Cylinder(0.8, 0.1, direction(-0.3, -0.5, -5), new DiffuseMaterial(new Color(0.647,0.16,0.16)));
        Shape path3 = new Cylinder(0.7, 0.1, direction(0.3, -0.5, -6), new DiffuseMaterial(new Color(0.647,0.16,0.16)));
        Shape path4 = new Cylinder(0.7, 0.1, direction(0, -0.5, -7), new DiffuseMaterial(new Color(0.647,0.16,0.16)));
        Shape path5 = new Cylinder(0.6, 0.1, direction(-0.2, -0.5, -8), new DiffuseMaterial(new Color(0.647,0.16,0.16)));
        Shape path6 = new Cylinder(0.8, 0.1, direction(0.5, -0.5, -9), new DiffuseMaterial(new Color(0.647,0.16,0.16)));

        //stars
        Shape star1 = new Sphere(point(0, 20, -100), 1.0, red, new BackgroundMaterial(new Color(1,0.93,0.87)));
        Shape star2 = new Sphere(point(-10, 18, -100), 0.8, red, new BackgroundMaterial(new Color(1,0.93,0.87)));
        Shape star3 = new Sphere(point(-15, 25, -100), 1.2, red, new BackgroundMaterial(new Color(1,0.93,0.87)));
        Shape star4 = new Sphere(point(-20, 9, -100), 0.6, red, new BackgroundMaterial(new Color(1,0.93,0.87)));
        Shape star5 = new Sphere(point(-18, 16, -100), 0.5, red, new BackgroundMaterial(new Color(1,0.93,0.87)));
        Shape star6 = new Sphere(point(5, 8, -100), 0.3, red, new BackgroundMaterial(new Color(1,0.93,0.87)));
        Shape star7 = new Sphere(point(8, 25, -100), 0.9, red, new BackgroundMaterial(new Color(1,0.93,0.87)));
        Shape star8 = new Sphere(point(14, 18, -100), 0.1, red, new BackgroundMaterial(new Color(1,0.93,0.87)));
        Shape star9 = new Sphere(point(18, 13, -100), 0.7, red, new BackgroundMaterial(new Color(1,0.93,0.87)));
        Shape star10 = new Sphere(point(23, 7, -100), 1.0, red, new BackgroundMaterial(new Color(1,0.93,0.87)));
        Shape star11 = new Sphere(point(-25, 18, -100), 0.8, red, new BackgroundMaterial(new Color(1,0.93,0.87)));
        Shape star12 = new Sphere(point(-35, 25, -100), 1.2, red, new BackgroundMaterial(new Color(1,0.93,0.87)));
        Shape star13 = new Sphere(point(-40, 9, -100), 0.6, red, new BackgroundMaterial(new Color(1,0.93,0.87)));
        Shape star14 = new Sphere(point(-48, 16, -100), 0.5, red, new BackgroundMaterial(new Color(1,0.93,0.87)));
        Shape star15 = new Sphere(point(-56, 18, -100), 0.8, red, new BackgroundMaterial(new Color(1,0.93,0.87)));
        Shape star16 = new Sphere(point(-67, 25, -100), 1.2, red, new BackgroundMaterial(new Color(1,0.93,0.87)));
        Shape star17 = new Sphere(point(-88, 9, -100), 0.6, red, new BackgroundMaterial(new Color(1,0.93,0.87)));
        Shape star18 = new Sphere(point(-100, 16, -100), 0.5, red, new BackgroundMaterial(new Color(1,0.93,0.87)));
        Shape star19 = new Sphere(point(-25, 40, -100), 1.0, red, new BackgroundMaterial(new Color(1,0.93,0.87)));
        Shape star20 = new Sphere(point(-33, 53, -100), 0.8, red, new BackgroundMaterial(new Color(1,0.93,0.87)));
        Shape star21 = new Sphere(point(-38, 60, -100), 1.2, red, new BackgroundMaterial(new Color(1,0.93,0.87)));
        Shape star22 = new Sphere(point(-44, 53, -100), 0.6, red, new BackgroundMaterial(new Color(1,0.93,0.87)));
        Shape star23 = new Sphere(point(-48, 56, -100), 0.5, red, new BackgroundMaterial(new Color(1,0.93,0.87)));
        Shape star24 = new Sphere(point(-56, 65, -100), 0.8, red, new BackgroundMaterial(new Color(1,0.93,0.87)));
        Shape star25 = new Sphere(point(-67, 75, -100), 1.2, red, new BackgroundMaterial(new Color(1,0.93,0.87)));
        Shape star26 = new Sphere(point(-88, 38, -100), 0.6, red, new BackgroundMaterial(new Color(1,0.93,0.87)));
        Shape star27 = new Sphere(point(-100, 56, -100), 0.5, red, new BackgroundMaterial(new Color(1,0.93,0.87)));
        Shape star28 = new Sphere(point(25, 18, -100), 0.8, red, new BackgroundMaterial(new Color(1,0.93,0.87)));
        Shape star29 = new Sphere(point(35, 25, -100), 1.2, red, new BackgroundMaterial(new Color(1,0.93,0.87)));
        Shape star30 = new Sphere(point(40, 9, -100), 0.6, red, new BackgroundMaterial(new Color(1,0.93,0.87)));
        Shape star31 = new Sphere(point(48, 16, -100), 0.5, red, new BackgroundMaterial(new Color(1,0.93,0.87)));
        Shape star32 = new Sphere(point(56, 18, -100), 0.8, red, new BackgroundMaterial(new Color(1,0.93,0.87)));
        Shape star33 = new Sphere(point(67, 25, -100), 1.2, red, new BackgroundMaterial(new Color(1,0.93,0.87)));
        Shape star34 = new Sphere(point(88, 9, -100), 0.6, red, new BackgroundMaterial(new Color(1,0.93,0.87)));
        Shape star35 = new Sphere(point(100, 16, -100), 0.5, red, new BackgroundMaterial(new Color(1,0.93,0.87)));
        Shape star36 = new Sphere(point(25, 40, -100), 1.0, red, new BackgroundMaterial(new Color(1,0.93,0.87)));
        Shape star37 = new Sphere(point(33, 53, -100), 0.8, red, new BackgroundMaterial(new Color(1,0.93,0.87)));
        Shape star38 = new Sphere(point(38, 60, -100), 1.2, red, new BackgroundMaterial(new Color(1,0.93,0.87)));
        Shape star39 = new Sphere(point(44, 53, -100), 0.6, red, new BackgroundMaterial(new Color(1,0.93,0.87)));
        Shape star40 = new Sphere(point(48, 56, -100), 0.5, red, new BackgroundMaterial(new Color(1,0.93,0.87)));
        Shape star41 = new Sphere(point(56, 65, -100), 0.8, red, new BackgroundMaterial(new Color(1,0.93,0.87)));
        Shape star42 = new Sphere(point(67, 75, -100), 1.2, red, new BackgroundMaterial(new Color(1,0.93,0.87)));
        Shape star43 = new Sphere(point(88, 38, -100), 0.6, red, new BackgroundMaterial(new Color(1,0.93,0.87)));
        Shape star44 = new Sphere(point(100, 56, -100), 0.5, red, new BackgroundMaterial(new Color(1,0.93,0.87)));



        Shape globe1 = new Sphere(point(0.2, 0.3, -4), 0.7, red, new Metal(0));
       
        shapes.add(background);
        shapes.add(ground);
        //tree 1
        shapes.add(cylinder);
        shapes.add(treesphere);
        shapes.add(treesphere2);
        shapes.add(treesphere3);

        //tree 2
        shapes.add(cylinder2);
        shapes.add(treesphere4);
        shapes.add(treesphere5);
        shapes.add(treesphere6);

        //tree 3
        shapes.add(cylinder3);
        shapes.add(treesphere7);
        shapes.add(treesphere8);
        shapes.add(treesphere9);
        
        //tree 4
        shapes.add(cylinder4);
        shapes.add(treesphere10);
        shapes.add(treesphere11);
        shapes.add(treesphere12);

        //tree 5
        shapes.add(cylinder5);
        shapes.add(treesphere13);
        shapes.add(treesphere14);
        shapes.add(treesphere15);

        //tree 6
        shapes.add(cylinder6);
        shapes.add(treesphere16);
        shapes.add(treesphere17);
        shapes.add(treesphere18);

        //tree 7
        shapes.add(cylinder7);
        shapes.add(treesphere19);
        shapes.add(treesphere20);
        shapes.add(treesphere21);

        //tree 8
        shapes.add(cylinder8);
        shapes.add(treesphere22);
        shapes.add(treesphere23);
        shapes.add(treesphere24);

        //path
        shapes.add(path1);
        shapes.add(path2);
        shapes.add(path3);
        shapes.add(path4);
        shapes.add(path5);
        shapes.add(path6);

        //stars
        shapes.add(star1);
        shapes.add(star2);
        shapes.add(star3);
        shapes.add(star4);
        shapes.add(star5);
        shapes.add(star6);
        shapes.add(star7);
        shapes.add(star8);
        shapes.add(star9);
        shapes.add(star10);
        shapes.add(star11);
        shapes.add(star12);
        shapes.add(star13);
        shapes.add(star14);
        shapes.add(star15);
        shapes.add(star16);
        shapes.add(star17);
        shapes.add(star18);
        shapes.add(star19);
        shapes.add(star20);
        shapes.add(star21);
        shapes.add(star22);
        shapes.add(star23);
        shapes.add(star24);
        shapes.add(star25);
        shapes.add(star26);
        shapes.add(star28);
        shapes.add(star29);
        shapes.add(star30);
        shapes.add(star31);
        shapes.add(star32);
        shapes.add(star33);
        shapes.add(star34);
        shapes.add(star35);
        shapes.add(star36);
        shapes.add(star37);
        shapes.add(star38);
        shapes.add(star39);
        shapes.add(star40);
        shapes.add(star41);
        shapes.add(star42);
        shapes.add(star43);
        shapes.add(star44);




        shapes.add(globe1);
        
        Group group = new Group(shapes);

        Image image = new Image(width, height);
        // camera on top
        Matrix cameraR = rotation(direction(1, 0, 0), -30);
        Matrix cameraT = translation(direction(1, 4, 0));

        Matrix cameraPos = multiply(cameraT,cameraR);
        Camera cam = new Camera(Math.PI/2, width, height, cameraPos);
        Matrix cameraT2 = translation(direction(1, 0, -2));
        Camera cam2 = new Camera(Math.PI/2, width, height, cameraT2);
       
        Raytracing raytraycing = new Raytracing(group, cam, 6);
        Raytracing raytraycing2 = new Raytracing(group, cam2, 6);
        
        image.supersample(raytraycing, 10);
        final String filename = "doc/a07-1.png";
        image.write(filename);
        System.out.println("Wrote image basic: " + filename);
        image.supersample(raytraycing2, 10);
        final String filename2 = "doc/a07-2.png";
        image.write(filename2);
        System.out.println("Wrote image basic: " + filename2);
    } 
}


