package cgg.a10;
import cgtools.*;
import static cgtools.Vector.*;

public class Plane implements Shape {
    
    Point pAnkerpoint;
    Direction nNormalvector;
    double rlimit;
    Material material;

    public Plane (Point ankerpoint, Direction normalevector, double rlimit, Material material) {
        this.pAnkerpoint = ankerpoint;
        this.nNormalvector = normalevector;
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
            return new Hit(t, r.pointAt(t), nNormalvector,r.pointAt(t).x + 0.5, r.pointAt(t).z + 0.5 , material);
        } else {
            return null;
        }
    }

}
