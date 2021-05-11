package cgg.a04;
import cgtools.*;
import static cgtools.Color.*;
import static cgtools.Vector.*;

public class Raytracing implements Sampler{

    Camera camera;
    Group group;

    public Raytracing(Group group, Camera cam) {
        this.camera = cam;
        this.group = group;
    }

    public Color getColor(double x, double y) {
        Direction d = camera.CalcPoint( x, y);
        Ray ray = new Ray(point(0, 0, 0), d, 0, Double.POSITIVE_INFINITY);
        Hit returnHit = group.intersect(ray);
        return shade(returnHit.normaleN, returnHit.c);
    }

    static Color shade(Direction normal, Color color) {
        Direction lightDir = normalize(direction(1,1,0.5));
        Color ambient = multiply(0.1,color);
        Color diffuse = multiply(0.9 * Math.max(0, dotProduct(lightDir, normal)),color);
        return add(ambient, diffuse);
    }
}
