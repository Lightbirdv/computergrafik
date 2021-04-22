package cgg.a01;

import cgtools.*;
import static cgtools.Color.*;

// Represents the contents of an image. Provides the same color for all pixels.
public class ConstantColorCircle implements Sampler {
  Color color;
  int width;
  int height;

  public ConstantColorCircle(Color color, int width, int height) {
    this.color = color;
    this.height = height;
    this.width = width;
  }

  // Returns the color for the given position.
  public Color getColor(double x, double y) {
    double w2 = width / 2.0;
    double h2 = height / 2.0;
    double radius = h2 / 2.0;
    double dx = Math.abs(w2 - x);
    double dy = Math.abs(h2 - y);


    //math equation source: https://math.stackexchange.com/questions/198764/how-to-know-if-a-point-is-inside-a-circle
    if (Math.pow(dx, 2) + Math.pow(dy, 2) <= Math.pow(radius, 2)) {
      return color;
    } else {
      return black;
    }
  }
}
