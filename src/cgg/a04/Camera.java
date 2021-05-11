package cgg.a04;
import cgtools.*;
import static cgtools.Vector.*;

public class Camera {
    double camanglephi;
    int width;
    int height;

    public Camera(double camanglephi, int width, int height) {
        this.camanglephi = camanglephi;
        this.width = width;
        this.height = height;
    }

    public Direction CalcPoint(double xp, double yp) {
        double x = xp - this.width/2;
        double y = -(yp - this.height/2);
        double z = -((this.width/2)/(Math.tan(this.camanglephi/2)));
        Direction d = normalize(direction(x,y,z));
        return d;  
    }
}
