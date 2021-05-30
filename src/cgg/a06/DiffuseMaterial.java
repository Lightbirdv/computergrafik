package cgg.a06;
import cgtools.Color;
import cgtools.Random;
import cgtools.Util;
import cgtools.Direction;
import static cgtools.Color.*;
import static cgtools.Vector.*;

public class DiffuseMaterial implements Material{
    
    Color emission;
    Color albedo;
    Ray scatteredRay;
    Color color;

    public DiffuseMaterial(Color color) {
        this.color = color;
    }

    @Override
    public Color emission(Hit hit) {
        return black;
    }

    @Override
    public Color albedo(Hit hit) {
        return color;
    }

    @Override
    public Ray scatteredRay(Hit hit, Ray ray) {
        return new Ray(hit.hitX, normalize(add(hit.normaleN, randomDirection())) , Util.EPSILON, Double.POSITIVE_INFINITY);
    }

    public Direction randomDirection() {
        Direction d = direction(Random.random() * 2 - 1, Random.random() * 2 - 1, Random.random() * 2 - 1);

        if (Math.pow(d.x, 2) + Math.pow(d.y, 2) < 1) {
            return d;
        } else {
            return randomDirection();
        }
    }
}
