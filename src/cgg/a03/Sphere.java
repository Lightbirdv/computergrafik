package cgg.a03;
import cgtools.*;
import static cgtools.Vector.*;

public class Sphere {
    
    Point center;
    double radius;
    double x,y,z;

    public Sphere (Point center, double radius) {
        this.center = center;
        this.x = center.x;
        this.y = center.y;
        this.z = center.z;
        this.radius = radius;
    }

    public Hit intersect(Ray r) {
        Hit returnHit = null;
        double t = 0;
        
        Direction originDash = subtract(r.poorigin, center);
        double a = dotProduct(r.direction, r.direction);
        double b = 2*(dotProduct(originDash, r.direction));
        double c = (dotProduct(originDash, originDash) - radius*radius);

        double discriminant = b*b - (4 * a * c);
        t = (-b - Math.sqrt(discriminant))/2*a;

        if(t < r.tmax && t > r.tmin) {
            Point intersectPoint = add(multiply(r.direction,t), r.poorigin);
            Direction normal = normalize(divide(subtract(intersectPoint, center), radius));
            Color color = Color.blue;
            returnHit = new Hit(t, intersectPoint, normal, color);
        }

        return returnHit;
    }

}
