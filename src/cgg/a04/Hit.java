package cgg.a04;
import cgtools.*;
//import static cgtools.Vector.*;

public class Hit {
    Double t;
    Point hitX;
    Direction normaleN;
    Color c;

    public Hit(Double t, Point hitX, Direction normaleN, Color c) {
        this.t = t;
        this.hitX = hitX;
        this.normaleN = normaleN;
        this.c = c;
    }

    public double getT() {
        return t;
    }

    // public Hit intersect(Ray r) {

    // }
}
