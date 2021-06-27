package cgg.a10;
import cgtools.Color;
import static cgtools.Vector.*;
import cgtools.Direction;
import cgtools.Util;
import static cgtools.Color.*;
import cgtools.Random;

public class Metal implements Material {
    
    public double roughness;
    public Color albedo = new Color(0.83,0.83,0.83);

    public Metal(double roughness, Color refkoffznt) {
        this.roughness = roughness;
        this.albedo = Color.add(albedo,refkoffznt);
    }

    public Metal(double roughness) {
        this.roughness = roughness;
    }

    @Override
    public Color emission(Hit hit) {
        return black; 
    }

    @Override
    public Color albedo(Hit hit) {
        return albedo;
    }

    @Override
    public Ray scatteredRay(Hit hit, Ray ray) {
        double x = dotProduct(ray.direction, hit.normaleN);
        Direction y = multiply(2 * x, hit.normaleN); 
        Direction m = subtract(ray.direction,y);
        if(roughness >0){
            m = add(m, multiply(roughness, randomDirection()));
            if(dotProduct(m, hit.normaleN) < 0){
                return null;
            }
        }
        return new Ray(hit.hitX,m,Util.EPSILON,Double.POSITIVE_INFINITY);
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
