package cgg.a10;
import cgtools.Color;
import cgtools.Random;
import cgtools.Sampler;
import cgtools.Util;
import cgtools.Direction;
import static cgtools.Vector.*;

public class DiffuseMaterial implements Material{
    
    Sampler emission;
    Sampler albedo;
    Ray scatteredRay;
    Sampler texture;

    public DiffuseMaterial(Sampler t) {
        this.texture = t;
        this.albedo = t;
    }

    @Override
    public Color emission(Hit hit) {
        return Color.black;
    }

    // public void changeColor (Color color) {
    //     this.color = color;
    // }

    @Override
    public Color albedo(Hit hit) {
        if(albedo.getColor(hit.u,hit.v) == null) {
            return Color.white;
        }
        return albedo.getColor(hit.u,hit.v);
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
