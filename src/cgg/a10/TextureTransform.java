package cgg.a10;

import cgtools.Color;
import cgtools.Matrix;
import cgtools.Point;
import cgtools.Sampler;
import static cgtools.Vector.*;
import static cgtools.Matrix.*;

public class TextureTransform implements Sampler {
    Sampler source;
    Matrix transform;

    public TextureTransform(Sampler source, Matrix transform) {
        this.source = source;
        this.transform = transform;
    }

    public Color getColor(double u, double v) {
        Point uv = point(u,v,0);
        Point transformedUV = multiply(transform, uv);
        return source.getColor(transformedUV.x, transformedUV.y);
    }

}
