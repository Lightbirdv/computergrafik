package cgg.a10;
import cgtools.Color;
import cgtools.Sampler;

public class BackgroundMaterial implements Material {
    
    Ray scatteredRay;
    Sampler t;

    public BackgroundMaterial(Sampler texture) {
        this.t = texture;
    }

    @Override
    public Color emission(Hit hit) {
        return t.getColor(hit.u, hit.v);
    }

    @Override
    public Color albedo(Hit hit) {
        return t.getColor(hit.u, hit.v);
    }

    @Override
    public Ray scatteredRay(Hit hit, Ray ray) {
        return null;
    }
}
