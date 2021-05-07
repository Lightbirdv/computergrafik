package cgg.a04;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Group implements Shape {
    
    ArrayList<Shape> shapes;

    public Group(ArrayList<Shape> shapes) {
        this.shapes = shapes;
    }

    @Override
    public Hit intersect(Ray r) {
        ArrayList<Hit> hitlist = new ArrayList<Hit>();

        for (Shape s : shapes) {
            Hit returnHit = s.intersect(r);
            if (returnHit!=null) {
                hitlist.add(returnHit);
            }
        }
        Collections.sort(hitlist, Comparator.comparing(Hit::getT));
        return hitlist.get(0);
    }
}
