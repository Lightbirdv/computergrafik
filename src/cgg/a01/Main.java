package cgg.a01;

import static cgtools.Color.*;

import cgg.*;

public class Main {

  public static void main(String[] args) {
    final int width = 480;
    final int height = 270;

    // This class instance defines the contents of the image.
    ConstantColor content = new ConstantColor(gray);
    ConstantColorCircle contentcircle = new ConstantColorCircle(blue, width, height);
    ConstantColorDots contentdots = new ConstantColorDots(blue, width, height, 12, 4);

    // Creates an image and iterates over all pixel positions inside the image.
    Image image = new Image(width, height);
    Image imagecircle = new Image(width,height);
    Image imagedots  = new Image(width,height);
    for (int x = 0; x != width; x++) {
      for (int y = 0; y != height; y++) {
        // Sets the color for one particular pixel.
        image.setPixel(x, y, content.getColor(x, y));
        imagecircle.setPixel(x, y, contentcircle.getColor(x, y));
        imagedots.setPixel(x, y, contentdots.getColor(x, y));
      }
    }


    // Write the image to disk.
    final String filenamebasic = "doc/a01-image.png";
    image.write(filenamebasic);
    System.out.println("Wrote image basic: " + filenamebasic);
    final String filenamecircle = "doc/a01-disc.png";
    imagecircle.write(filenamecircle);
    System.out.println("Wrote image circle: " + filenamecircle);
    final String filenamedots = "doc/a01-polka-dots.png";
    imagedots.write(filenamedots);
    System.out.println("Wrote image circle: " + filenamedots);
  }
}
