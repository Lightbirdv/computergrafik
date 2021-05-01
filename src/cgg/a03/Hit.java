package cgg.a03;
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

    // public Hit intersect(Ray r) {

    // }
}
