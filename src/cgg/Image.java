package cgg;

import cgtools.*;

public class Image {

  int imageWidth;
  int imageHeight;
  int imageX;
  int imageY;
  double[] imageData;

  public Image(int width, int height) {
    this.imageWidth = width;
    this.imageHeight = height;
    this.imageData = new double[(width * height * 3)];
  }

  public void setPixel(int x, int y, Color color) {
    int saveIndex= (3 * (y * imageWidth + x));
    imageData[saveIndex + 0] = color.r;
    imageData[saveIndex + 1] = color.g;
    imageData[saveIndex + 2] = color.b;
  }

  public void write(String filename) {
    ImageWriter.write(filename, imageData, imageWidth, imageHeight);
  }

  public void sample(Sampler s) {
    notYetImplemented();
  }

  private void notYetImplemented() {
    System.err.println("Please complete the implementation of class cgg.Image as part of assignment 1.");
    System.exit(1);
  }
}
