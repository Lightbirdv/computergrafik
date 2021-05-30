package cgg.a06;
import cgtools.*;
import static cgtools.Vector.*;

public class Sphere implements Shape {
    
    Point center;
    double radius;
    double x,y,z;
    Color color;
    Material material;

    public Sphere (Point center, double radius, Color color, Material material) {
        this.center = center;
        this.x = center.x;
        this.y = center.y;
        this.z = center.z;
        this.radius = radius;
        this.color = color;
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
                Point intersectPoint = add(multiply(r.direction,t0), r.poorigin);
                Direction normal = normalize(divide(subtract(intersectPoint, center), radius));
                returnHit = new Hit(t0, intersectPoint, normal, material);
            } else if (r.isValid(t1)) {
                Point intersectPoint = add(multiply(r.direction,t1), r.poorigin);
                Direction normal = normalize(divide(subtract(intersectPoint, center), radius));
                returnHit = new Hit(t1, intersectPoint, normal, material);
            } else {
                return returnHit;
            }
        }    
        return returnHit;
    }

}
