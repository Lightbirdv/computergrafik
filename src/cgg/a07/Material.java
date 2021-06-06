package cgg.a07;
import cgtools.Color;

public interface Material {

    public Color color = Color.white;

    public Color emission(Hit hit);
    public Color albedo(Hit hit);
    public Ray scatteredRay(Hit hit, Ray ray);
}
