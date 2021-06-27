package cgg.a10;

import cgtools.Color;
import cgtools.ImageTexture;
// import cgtools.Point;
import cgtools.Sampler;

public class Texture implements Sampler{

    ImageTexture texture;

    public Texture(String filename) {
        this.texture = new ImageTexture(filename);
    }

    public Color getColor(double u, double v) {
        Color tColor = texture.getColor(u, v); 
        return new Color(Math.pow(tColor.r, 2.2),Math.pow(tColor.g, 2.2),Math.pow(tColor.b, 2.2));
    }

}
