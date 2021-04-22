package cgg.a01;

import cgtools.*;
import static cgtools.Color.*;

// Represents the contents of an image. Provides the same color for all pixels.
public class ConstantColorDots implements Sampler {
  Color color;
  int width;
  int height;
  double rows;
  double columns;
  double radius;

  public ConstantColorDots(Color color, int width, int height, int rows, int radius) {
    this.color = color;
    this.height = height;
    this.width = width;
    this.rows = rows;
    this.columns = rows;
    this.radius = radius;
  }


  // Returns the color for the given position.
  public Color getColor(double x, double y) {
    double r = radius/rows;
    double sx = width / rows;
    double sy = height / columns;
    double px = x/sx - Math.floor(x/sx);
    double py = y/sy - Math.floor(y/sy);
    double cx = 0.5; 
    double cy = 0.5;
    double d = Math.sqrt(Math.pow(px - cx,2) + Math.pow(py - cy,2));

    if(d < r) {
      return color;
    } else {
      return black;
    }
    

  }
}

