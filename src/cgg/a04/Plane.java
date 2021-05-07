package cgg.a04;
import cgtools.*;
import static cgtools.Vector.*;

public class Plane implements Shape {
    
    Point pAnkerpoint;
    Direction nNormalvector;
    Color color;
    double rlimit;

    public Plane (Point ankerpoint, Direction normalevector, Color color, double rlimit) {
        this.pAnkerpoint = ankerpoint;
        this.nNormalvector = normalevector;
        this.color = color;
        this.rlimit = rlimit;
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
            return new Hit(t, r.pointAt(t), nNormalvector, color);
        } else {
            return null;
        }
    }

}
