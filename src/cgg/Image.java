package cgg;

import cgtools.*;
import cgtools.Color;

public class Image {

  int imageWidth;
  int imageHeight;
  int imageX;
  int imageY;
  double[] imageData;
  Color average;

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

  public void setPixelGamma(int x, int y, Color color) {
    int saveIndex= (3 * (y * imageWidth + x));
    imageData[saveIndex + 0] = Math.pow(color.r, 1/2.2);
    imageData[saveIndex + 1] = Math.pow(color.g, 1/2.2);
    imageData[saveIndex + 2] = Math.pow(color.b, 1/2.2);
  }

  public void write(String filename) {
    ImageWriter.write(filename, imageData, imageWidth, imageHeight);
  }

  public void sample(Sampler s) {
    for (int x = 0; x != imageWidth; x++) {
      for (int y = 0; y != imageHeight; y++) {
        // Sets the color for one particular pixel.
        setPixel(x, y, s.getColor(x, y));
      }
    }
  }

  public void samplegamma(Sampler s) {
    for (int x = 0; x != imageWidth; x++) {
      for (int y = 0; y != imageHeight; y++) {
        // Sets the color for one particular pixel.
        setPixelGamma(x, y,  s.getColor(x, y));
      }
    }
    
  }

  public void supersample(Sampler s, int n) {
    int cores = Runtime.getRuntime().availableProcessors();
    System.out.println(cores);
    Thread[] threads = new Thread[cores];
    double start = System.currentTimeMillis();
    for (int i=0; i != cores; i++) {
      final int core = i;
      threads[i] = new Thread() {
        public void run() {
          for (int x = (imageWidth/cores) * core; x != (imageWidth/cores) * core + (imageWidth/cores); x++) {
            for (int y = 0; y != imageHeight; y++) {
              Color average = s.getColor(x, y);
              // Sets the color for one particular pixel.
              //setPixel(x, y, CD.getColor(x, y));
              for (int xi = 0; xi < n; xi++) {
                for (int yi = 0; yi < n; yi++) {
                  double rx = Random.random();
                  double ry = Random.random();
                  double xs = x + (xi + rx) / n;
                  double ys = y + (yi + ry) / n;
                  average = Color.add(average,s.getColor(xs, ys));
                }
              }
              setPixelGamma(x, y, Color.divide(average, n*n));
            }
          }
        }
      };
      threads[i].start();
    } 
  
    for (int iz=0; iz!= cores;iz++) {
      try {
        threads[iz].join();
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }

    }
    double end = System.currentTimeMillis() - start;
    System.out.println(end);
  }

}
