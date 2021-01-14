import java.awt.Graphics;
import java.awt.Color;
import java.awt.Polygon;

class Trapezoid extends Shape implements ShapeWithBaseAndHeight {
  private int base;
  private int height;
  
  public Trapezoid(Color colour, int xCoordinate, int yCoordinate, int base, int height) {
    this.type = "Trapezoid";
    this.colour = colour;
    this.xCoordinate = xCoordinate;
    this.yCoordinate = yCoordinate;
    this.base = base;
    this.height = height;
    this.area = (double) 0.5*((base/2) + base) * height; //Note: base/2 is the length of the top
  }
  
  public void draw (Graphics g) {
    Polygon trapezoid = new Polygon();
    trapezoid.addPoint(xCoordinate, yCoordinate);
    trapezoid.addPoint(xCoordinate + base/2, yCoordinate);
    trapezoid.addPoint(xCoordinate + ((3*base)/4) , yCoordinate + height);
    trapezoid.addPoint(xCoordinate - base/4, yCoordinate + height);
    
    g.setColor(colour);
    g.fillPolygon(trapezoid);
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