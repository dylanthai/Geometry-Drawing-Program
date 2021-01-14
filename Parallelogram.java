import java.awt.Graphics;
import java.awt.Color;
import java.awt.Polygon;

class Parallelogram extends Shape implements ShapeWithBaseAndHeight {
  private int base;
  private int height;
  
  public Parallelogram(Color colour, int xCoordinate, int yCoordinate, int base, int height) {
    this.type = "Parallelogram";
    this.colour = colour;
    this.xCoordinate = xCoordinate;
    this.yCoordinate = yCoordinate;
    this.base = base;
    this.height = height;
    this.area = (double) base*height;
  }
  
  public void draw (Graphics g) {
    Polygon paralellogram = new Polygon();
    paralellogram.addPoint(xCoordinate, yCoordinate);
    paralellogram.addPoint(xCoordinate + base, yCoordinate);
    paralellogram.addPoint(xCoordinate - base/3 + base, yCoordinate + height);
    paralellogram.addPoint(xCoordinate - base/3, yCoordinate + height);
    
    
    g.setColor(colour);
    g.fillPolygon(paralellogram);
  }
  public String getShapeData() {
    String data = String.format("%s %d %d %d %d", type, base, height, xCoordinate, yCoordinate);
    return data;
  }
  public void displayShapeData() {
    System.out.printf("%s Base: %d Height: %d XCoordinate: %d YCoordinate: %d Area %.2f", type, base, height,
                      xCoordinate, yCoordinate, area);
  }
  
  public void setBase(int newBase) {
    base = newBase;
  }
  public void setHeight(int newHeight) {
    height = newHeight;
  }   
  
  public void printBase() {
    System.out.println("The current base is: " + this.base);
  }
  public void printHeight() {
    System.out.println("The current height is: " + this.height);
  }
}