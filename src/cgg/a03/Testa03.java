package cgg.a03;
import cgtools.*;
import static cgtools.Vector.*;

public class Testa03 {
    public Testa03() {
        test();
    }

    public void test() {
        if(testCamera()) {
            System.out.println("Camera Test successful");
        } else  {
            System.out.println("Camera Test was not successful");
        }
    }

    public boolean testCamera() {
        Camera ca = new Camera(Math.PI/2, 10, 10);
        Direction d1 = ca.CalcPoint(0, 0);
        Direction d2 = ca.CalcPoint(5, 5);
        Direction d3 = ca.CalcPoint(10, 10);
        Direction d1test = direction(-0.58, 0.58, -0.58);
        Direction d2test = direction(0.00, 0.00, -1.00);
        Direction d3test = direction(0.58, -0.58, -0.58);
        if(d1==d1test&&d2==d2test&&d3==d3test){
            return true;
        }else return false;
    }

    public boolean testIntersect() {
        Ray ray1 = new Ray(point(0,0,0), direction(0,0,-1),0, Integer.MAX_VALUE);
        Ray ray2 = new Ray(point(0,0,0), direction(0,1,-1),0, Integer.MAX_VALUE);
        Ray ray3 = new Ray(point(0,0,0), direction(0,0,-1),0, Integer.MAX_VALUE);
        Ray ray4 = new Ray(point(0,0,-4), direction(0,0,-1),0, Integer.MAX_VALUE);
        Ray ray5 = new Ray(point(0,0,0), direction(0,0,-1),0, 2);

        Sphere sphere1 = new Sphere(point(0,0,-2), 1);
        Sphere sphere2 = new Sphere(point(0,0,-2), 1);
        Sphere sphere3 = new Sphere(point(0,-1,-2), 1);
        Sphere sphere4 = new Sphere(point(0,0,-2), 1);
        Sphere sphere5 = new Sphere(point(0,0,-4), 1);

        sphere1.intersect(ray1);
        sphere2.intersect(ray2);
        sphere3.intersect(ray3);
        sphere4.intersect(ray4);
        sphere5.intersect(ray5);

        return true;
    }
}
