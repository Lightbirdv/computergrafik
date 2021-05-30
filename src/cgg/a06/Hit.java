package cgg.a06;
import cgtools.*;
//import static cgtools.Vector.*;

public class Hit {
    Double t;
    Point hitX;
    Direction normaleN;
    Material material;

    public Hit(Double t, Point hitX, Direction normaleN, Material material) {
        this.t = t;
        this.hitX = hitX;
        this.normaleN = normaleN;
        this.material = material;
    }

    public double getT() {
        return t;
    }

    // public Hit intersect(Ray r) {

    // }
}
