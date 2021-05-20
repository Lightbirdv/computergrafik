package cgg.a05;
import cgtools.Color;

public interface Material {
    public Color emission(Hit hit);
    public Color albedo(Hit hit);
    public Ray scatteredRay(Hit hit, Ray ray);
}
