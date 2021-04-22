package cgg.a01;

import cgtools.*;

// Represents the contents of an image. Provides the same color for all pixels.
public class ConstantColor implements Sampler {
  Color color;

  public ConstantColor(Color color) {
    this.color = color;
  }

  // Returns the color for the given position.
  public Color getColor(double x, double y) {
      return color;
  }
}
