package cgg.a10;
import cgtools.*;
import static cgtools.Vector.*;

public class Background implements Shape {
    
    Point center;
    double radius;
    Material material;

    public Background (Material material) {
        this.center = point(0, 0, 0);
        this.radius = Double.POSITIVE_INFINITY;
        this.material = material;
    }

    @Override
    public Hit intersect(Ray r) {
        Point position = r.pointAt(Double.POSITIVE_INFINITY);
        double inclination = Math.acos(r.direction.y);
        double azimuth = Math.PI + Math.atan2(r.direction.x, r.direction.z);
        double u = azimuth / (2 * Math.PI);
        double v = inclination / Math.PI;
        //Direction n = normalize(r.direction);
        Hit returnHit = new Hit(Double.POSITIVE_INFINITY, position , direction(0,0,0), u, v, material); 
        return returnHit;
    }

}
