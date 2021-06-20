package cgg.a09;
import cgtools.*;
import static cgtools.Vector.*;

public class Background implements Shape {
    
    Point center;
    double radius;
    Color color;
    Material material;

    public Background (Color color, Material material) {
        this.center = point(0, 0, 0);
        this.radius = Double.POSITIVE_INFINITY;
        this.color = color;
        this.material = material;
    }

    @Override
    public Hit intersect(Ray r) {
        Point x = r.pointAt(Double.POSITIVE_INFINITY);
        //Direction n = normalize(r.direction);
        Hit returnHit = new Hit(Double.POSITIVE_INFINITY, x, direction(0,0,0), material); 
        return returnHit;
    }

}
