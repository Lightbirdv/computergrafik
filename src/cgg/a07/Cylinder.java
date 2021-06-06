package cgg.a07;

import cgtools.Direction;
import cgtools.Point;
import static cgtools.Vector.*;
import java.util.Collections;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;


public class Cylinder implements Shape {

    private double rad;
    private double height;
    private Direction center;
    private Material material;
    private Direction norm;

    Cylinder(double r, double height, Direction center, Material material) {
        this.rad = r;
        this.height = height;
        this.center = center;
        this.material = material;
    }

    public Hit intersect(Ray r) {

        Hit returnHit = null;

        double x0x = subtract(r.poorigin, center).x;
        double x0y = subtract(r.poorigin, center).y;
        double x0z = subtract(r.poorigin, center).z;

        double a = r.direction.x * r.direction.x + r.direction.z * r.direction.z;
        double b = 2 * x0x * r.direction.x + 2 * x0z * r.direction.z;
        double c = x0x * x0x + x0z * x0z - rad * rad;

        double denominator = 2 * a;
        if (denominator == 0) 
            return returnHit;

        double dis = (Math.pow(b, 2) - (4 * a * c));

        double t1 = Math.min((-b + Math.sqrt(dis)) / (2 * a), (-b - Math.sqrt(dis)) / (2 * a));
        double t2 = (height / 2.0 - x0y) / r.direction.y;
        double t3 = (-height / 2.0 - x0y) / r.direction.y;

        List<Double> elementslist = Arrays.asList(t1, t2, t3);
        ArrayList<Double> elements = new ArrayList<>();
        elements.addAll(elementslist);
        Collections.sort(elements);

        double t = 0;
        Point sch = null;
        for (double x : elements) {
            sch = r.pointAt(x);
            if (x == t1) {
                if (Math.abs(sch.y - center.y) < height / 2.0) {
                    t = x;
                    Point px = subtract(r.pointAt(x), center);
                    norm = divide(direction(px.x,px.y,px.z), rad);
                    break;
                }
            } else {
                if (Math.pow(sch.x - center.x, 2) + Math.pow(sch.z - center.z, 2) - Math.pow(rad, 2) <= 0) {
                    if (x == t2) {
                         norm = direction(0, 1, 0);
                    } else if (x == t3) {
                        norm = direction(0, -1, 0);
                    }
                    t = x;
                    break;
                }
            }
        }

        if (t > r.tmin && t < r.tmax) {
            returnHit = new Hit(t, sch, normalize(norm), material);
        }

        return returnHit;
    }

}