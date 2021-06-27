package cgg.a10;
import cgtools.*;
//import static cgtools.Vector.*;

public class Hit {
    Double t,u,v;
    Point hitX;
    Direction normaleN;
    Material material;

    public Hit(Double t, Point hitX, Direction normaleN, Material material) {
        this.t = t;
        this.hitX = hitX;
        this.normaleN = normaleN;
        this.material = material;
    }

    public Hit(Double t, Point hitX, Direction normaleN, Double u, Double v, Material material) {
        this.t = t;
        this.hitX = hitX;
        this.normaleN = normaleN;
        this.u = u;
        this.v = v;
        this.material = material;
    }

    public double getT() {
        return t;
    }

    // public Hit intersect(Ray r) {

    // }
}
