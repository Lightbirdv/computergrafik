package cgg.a10;

import cgtools.Color;
import cgtools.Sampler;

public class Constant implements Sampler{
    Color color;

    public Constant(Color color) {
        this.color = color;
    }

    public Color getColor(double u, double v) {
        return color;
    }
    
}
