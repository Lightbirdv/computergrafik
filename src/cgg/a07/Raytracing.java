package cgg.a07;
import cgtools.*;
import static cgtools.Color.*;
import static cgtools.Vector.*;

public class Raytracing implements Sampler{

    Camera camera;
    Group group;
    int depth;

    public Raytracing(Group group, Camera cam, int depth) {
        this.camera = cam;
        this.group = group;
        this.depth = depth;
    }

    public Color getColor(double x, double y) {
        Ray ray = camera.generateRay( x, y);
        return radiance(ray, group, depth);
    }

    static Color shade(Direction normal, Color color) {
        Direction lightDir = normalize(direction(1,1,0.5));
        Color ambient = multiply(0.1,color);
        Color diffuse = multiply(0.9 * Math.max(0, dotProduct(lightDir, normal)),color);
        return add(ambient, diffuse);
    }

    public Color radiance(Ray ray, Shape shape, double depth){
        if(depth == 0) {
            return black;
        }

        Hit hit = shape.intersect(ray);
        Material material = hit.material;
        Color emission = black;
        Color albedo = white;
        Ray scatteredRay = null;

        if(hit != null) {
            emission = material.emission(hit);
            albedo = material.albedo(hit);
            scatteredRay = material.scatteredRay(hit, ray);
        }

        if(scatteredRay != null) {
            return Color.add(emission, multiply(albedo, radiance(scatteredRay, shape, depth-1)));
        }
        return emission;
    }
}
