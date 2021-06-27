package cgg.a10;

import cgtools.Color;
import cgtools.Sampler;

public class CheckerboardTexture implements Sampler{

    int checkersize;
    Color onColor;
    Color offColor;

    public CheckerboardTexture(int n, Color onColor, Color offColor) {
        this.checkersize = n;
        this.onColor = onColor;
        this.offColor = offColor;
    }
    
    public Color getColor(double u, double v) {

        double ui = (int) ((u % 1) * checkersize);
        double vi = (int) ((v % 1) * checkersize);
        if ((ui + vi) % 2 == 0) {
            return this.offColor;
        } else {
            return this.onColor;
        }

    }

}
