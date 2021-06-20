package cgg.a09;
import cgtools.*;
import static cgtools.Vector.*;

public class Plane implements Shape {
    
    Point pAnkerpoint;
    Direction nNormalvector;
    Color color;
    double rlimit;
    Material material;

    public Plane (Point ankerpoint, Direction normalevector, Color color, double rlimit, Material material) {
        this.pAnkerpoint = ankerpoint;
        this.nNormalvector = normalevector;
        this.color = color;
        this.rlimit = rlimit;
        this.material = material;
    }

    @Override
    public Hit intersect(Ray r) {

        Direction a = subtract(pAnkerpoint, r.poorigin);
        double b = dotProduct(a, nNormalvector);
        double c = dotProduct(r.direction, nNormalvector);
        
        double t = b/c;
        
        Point x = r.pointAt(t);
        
        double dist = length(subtract(x,pAnkerpoint));
        
        if (dist <= rlimit && r.isValid(t)) {
            return new Hit(t, r.pointAt(t), nNormalvector, material);
        } else {
            return null;
        }
    }

}
