package cgg.a03;
import cgtools.*;
import static cgtools.Vector.*;

public class Ray {
    Point poorigin;
    Direction direction;
    Integer tmin, tmax;

    public Ray(Point poorigin, Direction direction, Integer tmin, Integer tmax) {
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
        else return true;
    }
}
