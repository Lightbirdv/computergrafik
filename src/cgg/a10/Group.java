package cgg.a10;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Group implements Shape {
    
    ArrayList<Shape> shapes;
    Transformation transattr;

    public Group(Shape...s) {
        this.shapes = new ArrayList<>();
        this.shapes.addAll(Arrays.asList(s));
    }

    public Group(Transformation transattr, Shape...s) {
        this.transattr = transattr;
        this.shapes = new ArrayList<>();
        this.shapes.addAll(Arrays.asList(s));
    }

    public void addShape(Shape shape) {
        this.shapes.add(shape);
    }

    public void moveShape(Transformation t) {
        this.transattr = t;
    }

    @Override
    public Hit intersect(Ray ray) {
        ArrayList<Hit> hitlist = new ArrayList<Hit>();
        if(transattr != null) {
            ray = transattr.transformRay(ray);
        }

        for (Shape s : shapes) {
            Hit returnHit = s.intersect(ray);
            if (returnHit!=null) {
                hitlist.add(returnHit);
            }
        }
        if(hitlist.size() == 0) {
            return null;
        }
        Collections.sort(hitlist, Comparator.comparing(Hit::getT));
        Hit returnHit = hitlist.get(0);
        if(transattr != null) {
            returnHit = transattr.transformHit(returnHit);
        } 
        return returnHit;
    }
}
