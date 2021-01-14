import java.awt.Graphics;
import java.awt.Color;
import java.awt.Polygon;

class Rhombus extends Shape implements ShapeWithWidthAndHeight {
  private int width;
  private int height;
  
  public Rhombus(Color colour, int xCoordinate, int yCoordinate, int width, int height) {
    this.type = "Rhombus";
    this.colour = colour;
    this.xCoordinate = xCoordinate;
    this.yCoordinate = yCoordinate;
    this.width = width;
    this.height = height;
    this.area = (double) width*height;
  }
  
  
  public void draw (Graphics g) {
    Polygon rhombus = new Polygon();
    rhombus.addPoint(xCoordinate, yCoordinate);
    rhombus.addPoint(xCoordinate + width/2, yCoordinate + height/2);
    rhombus.addPoint(xCoordinate, yCoordinate + height);
    rhombus.addPoint(xCoordinate - width/2, yCoordinate + height/2);
    
    g.setColor(colour);
    g.fillPolygon(rhombus);
  }
  public String getShapeData() {
    String data = String.format("%s %d %d %d %d", type, width, height, xCoordinate, yCoordinate);
    return data;
  }
  public void displayShapeData() {
    System.out.printf("%s Width: %d Height: %d XCoordinate: %d YCoordinate: %d Area: %.2f",type, width, height,
                      xCoordinate, yCoordinate, area);
  }
  public void setHeight(int newHeight) {
    height = newHeight;
  }
  public void setWidth(int newWidth) {
    width = newWidth;
  }
  public void printWidth() {
    System.out.println("The current width is: " + this.width);
  }
  public void printHeight() {
    System.out.println("The current height is: " + this.height);
  }
}