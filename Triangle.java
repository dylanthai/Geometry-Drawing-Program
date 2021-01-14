import java.awt.Graphics;
import java.awt.Color;
import java.awt.Polygon;

class Triangle extends Shape implements ShapeWithBaseAndHeight {
  private int base;
  private int height;
  
  public Triangle(Color colour, int xCoordinate, int yCoordinate, int base, int height) {
    this.type = "Triangle";
    this.colour = colour;
    this.xCoordinate = xCoordinate;
    this.yCoordinate = yCoordinate;
    this.base = base;
    this.height = height;
    this.area = (double)((base*height)/2);
  }
  
  public void draw (Graphics g) {
    Polygon triangle = new Polygon();
    triangle.addPoint(xCoordinate, yCoordinate);
    triangle.addPoint(xCoordinate - base/2, yCoordinate + height);
    triangle.addPoint(xCoordinate + base/2, yCoordinate + height);
    
    g.setColor(colour);
    g.fillPolygon(triangle);
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