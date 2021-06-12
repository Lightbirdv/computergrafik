package cgg.a08;

import cgtools.Matrix;
import static cgtools.Matrix.*;
import cgtools.Point;
import cgtools.Direction;

public class Transformation {

    Matrix i, t, v;

    public Transformation(Matrix v) {
        this.v = v;
        this.i = invert(v);
        this.t = transpose(i);
    }

    public Ray transformRay(Ray ray) {

        Point invertedPoorigin = multiply(i, ray.poorigin);
        Direction invertedDirection = multiply(i, ray.direction);

        return new Ray(invertedPoorigin, invertedDirection, 0, Double.POSITIVE_INFINITY);
    }

    public Hit transformHit(Hit hit) {

        Point transformedHitX = multiply(v, hit.hitX);
        // normalvector should be transformed with the transposed version of the Inversed M_n = (M^-1)^T
        Direction transpositionedNormaleN = multiply(t, hit.normaleN);

        return new Hit(hit.getT(), transformedHitX, transpositionedNormaleN, hit.material);
    }

}