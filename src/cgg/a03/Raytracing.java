package cgg.a03;
import cgtools.*;
import static cgtools.Color.*;
import static cgtools.Vector.*;
import java.util.ArrayList;

public class Raytracing implements Sampler{

    Camera camera;
    ArrayList<Sphere> spheres;

    public Raytracing(ArrayList<Sphere> spheres, Camera cam) {
        this.camera = cam;
        this.spheres = spheres;
    }

    public Color getColor(double x, double y) {
        Direction d = camera.CalcPoint((int) x,(int) y);
        Ray ray = new Ray(point(0, 0, 0), d, 0, 1600);
        for (int s = 0; s < spheres.size(); s++) {
            Hit returnHit = spheres.get(s).intersect(ray);
            if(returnHit != null) {
                if(s==0) returnHit.c = red;
                if(s==1) returnHit.c = green;
                if(s==2) returnHit.c = blue; 
                return shade(returnHit.normaleN, returnHit.c);
            }
        }
        return black;
    }

    static Color shade(Direction normal, Color color) {
        Direction lightDir = normalize(direction(1,1,0.5));
        Color ambient = multiply(0.1,color);
        Color diffuse = multiply(0.9 * Math.max(0, dotProduct(lightDir, normal)),color);
        return add(ambient, diffuse);
    }
}
