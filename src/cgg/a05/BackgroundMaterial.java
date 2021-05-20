package cgg.a05;
import cgtools.Color;
import static cgtools.Color.*;

public class BackgroundMaterial implements Material {
    
    Color emission;
    Color albedo;
    Ray scatteredRay;
    Color color;

    public BackgroundMaterial(Color color) {
        this.color = color;
    }

    @Override
    public Color emission(Hit hit) {
        return color;
    }

    @Override
    public Color albedo(Hit hit) {
        return black;
    }

    @Override
    public Ray scatteredRay(Hit hit, Ray ray) {
        return null;
    }
}
