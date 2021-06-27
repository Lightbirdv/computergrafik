package cgg.a10;
import cgtools.*;
import static cgtools.Vector.*;

public class Sphere implements Shape {
    
    Point center;
    double radius;
    double x,y,z;
    Material material;

    public Sphere (Point center, double radius, Material material) {
        this.center = center;
        this.x = center.x;
        this.y = center.y;
        this.z = center.z;
        this.radius = radius;
        this.material = material;
    }

    @Override
    public Hit intersect(Ray r) {
        Hit returnHit = null;
        
        Direction originDash = subtract(r.poorigin, center);
        double a = dotProduct(r.direction, r.direction);
        double b = 2*(dotProduct(originDash, r.direction));
        double c = (dotProduct(originDash, originDash) - radius*radius);

        double discriminant = b*b - (4 * a * c);
        double t0 = (-b - Math.sqrt(discriminant))/2*a;
        double t1 = (-b + Math.sqrt(discriminant))/2*a;
        if (discriminant == 0 || discriminant > 0) {
            if(r.isValid(t0)) {
                Point position = r.pointAt(t0);
                Direction normal = divide(subtract(position, center), radius);
                double inclination = Math.acos(normal.y);
                double azimuth = Math.PI + Math.atan2(normal.x, normal.z);
                double u = azimuth / (2 * Math.PI);
                double v = inclination / Math.PI;
                returnHit = new Hit(t0, position, normal, u, v, material);
            } else if (r.isValid(t1)) {
                Point position = r.pointAt(t1);
                Direction normal = divide(subtract(position, center), radius);
                double inclination = Math.acos(normal.y);
                double azimuth = Math.PI + Math.atan2(normal.x, normal.z);
                double u = azimuth / (2 * Math.PI);
                double v = inclination / Math.PI;
                returnHit = new Hit(t1, position, normalize(normal), u, v, material);
            } else {
                return returnHit;
            }
        }    
        return returnHit;
    }

}
