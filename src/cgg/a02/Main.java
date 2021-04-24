package cgg.a02;

import java.util.Collections;
import java.util.Comparator;
import java.util.ArrayList;

import cgg.*;
import cgtools.Color;

public class Main {

  public static void main(String[] args) {
    final int width = 480;
    final int height = 270;

    // This class instance defines the contents of the image.
    ArrayList<Disc> discs = new ArrayList<Disc>();
    int numberOfDiscs = 500;
    int maxRadius = height ;
    for (int d = 0; d < numberOfDiscs; d++) {
      discs.add(new Disc(Math.random() * width, Math.random() * height, (Math.random() * maxRadius) + 1, 
      new Color(Math.random(), Math.random(), Math.random())));
    }

    Collections.sort(discs, Comparator.comparing(Disc::getRadius));
    ColoredDisc coloredDisc = new ColoredDisc(discs);

    // Creates an image and iterates over all pixel positions inside the image.
    Image image = new Image(width, height);
    image.sample(coloredDisc);
    Image imagegamma = new Image(width, height);
    imagegamma.samplegamma(coloredDisc);
    Image imagesuper = new Image(width, height);
    imagesuper.supersample(coloredDisc, 10);


    // Write the image to disk.
    final String filename = "doc/a02-discs.png";
    image.write(filename);
    System.out.println("Wrote image basic: " + filename);
    final String filenamegamma = "doc/a02-discs-gamma.png";
    imagegamma.write(filenamegamma);
    System.out.println("Wrote image basic: " + filenamegamma);
    final String filenamesuper = "doc/a02-discs-supersampling.png";
    imagesuper.write(filenamesuper);
    System.out.println("Wrote image basic: " + filenamesuper);
  }
}
