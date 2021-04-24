package cgg.a02;

import cgtools.*;
import static cgtools.Color.*;
import java.util.ArrayList;

public class ColoredDisc implements Sampler{
    
    ArrayList<Disc> discs;

    public ColoredDisc(ArrayList<Disc> discs) {
        this.discs =  discs;
    }

    public boolean isPointInDisc (double x, double y ,Disc disc) {
        double x1 = disc.xmid;
        double y1 = disc.ymid;
        double r = Math.pow(disc.radius,2);
        double d = Math.pow(Math.abs(x1 - x), 2) + Math.pow(Math.abs(y1 - y), 2);

        if(d < r) {
            return true;
        } else {
            return false;
        }
    }


    public Color getColor(double x, double y) {
        for (int d = 0; d < discs.size(); d++) {
            if(isPointInDisc(x,y,discs.get(d))) {
                return discs.get(d).color;
            } 
        }
        return black;
    }
}
