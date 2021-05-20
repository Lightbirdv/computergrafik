package cgg.a05;
import cgtools.*;
import static cgtools.Vector.*;

public class Ray {
    Point poorigin;
    Direction direction;
    double tmin, tmax;

    public Ray(Point poorigin, Direction direction, double tmin, double tmax) {
        this.poorigin = poorigin;
        this.direction = direction;
        this.tmin = tmin;
        this.tmax = tmax;
    }

    public Point pointAt(double t) {
        Direction d = multiply(t, direction);
        Point p = add(poorigin, d);
        return p;
    }

    public boolean isValid(double t) {
        if (t < tmin || t > tmax) {
            return false;
        }
        return true;
    }
}
