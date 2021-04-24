package cgg.a02;

import cgtools.*;

public class Disc {
    
    double xmid;
    double ymid;
    double radius;
    Color color;

    public Disc(double x, double y, double radius, Color color) {
        this.xmid = x;
        this.ymid = y;
        this.radius = radius;
        this.color = color;
    }

    public double getRadius() {
        return radius;
    }
}
