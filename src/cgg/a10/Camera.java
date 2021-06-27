package cgg.a10;
import cgtools.*;
import static cgtools.Vector.*;
import static cgtools.Matrix.*;

public class Camera {
    double camanglephi;
    int width;
    int height;
    Matrix v;

    public Camera(double camanglephi, int width, int height) {
        this.camanglephi = camanglephi;
        this.width = width;
        this.height = height;
    }

    public Camera(double camanglephi, int width, int height, Matrix v) {
        this.camanglephi = camanglephi;
        this.width = width;
        this.height = height;
        this.v = v;
    }

    public Ray generateRay(double xp, double yp) {
        double x = xp - this.width/2;
        double y = -(yp - this.height/2);
        double z = -((this.width/2)/(Math.tan(this.camanglephi/2)));
        Direction d = normalize(direction(x,y,z));
        // Ray ray = new Ray(point(0, 0, 0), d, 0, Double.POSITIVE_INFINITY);
        // return ray;
        if(v==null) {
           return new Ray(point(0, 0, 0), d, 0, Double.POSITIVE_INFINITY);
        }
        return new Ray(Matrix.multiply(v, point(0, 0, 0)), multiply(v, d), 0, Double.POSITIVE_INFINITY); 
    }
}
