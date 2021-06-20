package cgg.a09;
import cgtools.Color;
import static cgtools.Color.*;
import static cgtools.Vector.*;

import cgtools.Direction;
import cgtools.Random;
import cgtools.Util;

public class Glass implements Material{
    
    public double n1 = 1.0; // luft
    public double n2 = 1.5; // glass

    @Override
    public Color emission(Hit hit) {
        return black; 
    }

    @Override
    public Color albedo(Hit hit) {
        return darkerWhite;
    }

    @Override
    public Ray scatteredRay(Hit hit, Ray ray) {
        if(dotProduct(hit.normaleN,ray.direction) > 0){
            hit.normaleN = negate(hit.normaleN);
            swap(n1, n2);
        }
        if (refract(ray.direction, hit.normaleN) != null) {
            if (Random.random() < schlick(ray.direction, hit.normaleN)) {
                return new Ray(hit.hitX, refract(ray.direction, hit.normaleN), Util.EPSILON, Double.POSITIVE_INFINITY);
            } else {
                return new Ray(hit.hitX, reflect(ray.direction, hit.normaleN), Util.EPSILON, Double.POSITIVE_INFINITY);
            }
        } else {
            return new Ray(hit.hitX, reflect(ray.direction, hit.normaleN), Util.EPSILON, Double.POSITIVE_INFINITY);
        }
    }

    public void swap(double n1, double n2) {
        double swap = n1;
        this.n1 = n2;
        this.n2 = swap;
    }

    public Direction reflect(Direction d, Direction n) {
        return normalize(subtract(multiply(2 * dotProduct(n, d), n),d));
    }

    public double schlick(Direction d, Direction n) {
        double r0 = Math.pow((n1 - n2)/(n1 + n2),2);
        return r0 + (1 - r0) * Math.pow((1 + dotProduct(n, d)), 5);
    }

    public Direction refract(Direction d, Direction n) {
        double r = n1 / n2;
        double c = dotProduct(negate(n), d);
        double disc = 1- Math.pow(r, 2) * (1 - Math.pow(c , 2));
        if (disc < 0) {
            //return reflect(ray, hit);
            return null;
        }
        return add(multiply(r, d), multiply((r * c - Math.sqrt(disc)), n));
    }

}
