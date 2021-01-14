import java.awt.Graphics;
import java.awt.Color;

class Oval extends Shape implements ShapeWithWidthAndHeight {
  private int width;
  private int height;
  
  public Oval(Color colour, int xCoordinate, int yCoordinate, int width, int height) {
    this.type = "Oval";
    this.colour = colour;
    this.xCoordinate = xCoordinate;
    this.yCoordinate = yCoordinate;
    this.width = width;
    this.height = height;
    this.perimeter = 2*Math.PI*Math.sqrt(((height/2)+(width/2))/2);
    this.area = Math.PI * (height/2) * (width/2);
  }
  
  public void draw (Graphics g) {
    g.setColor(colour);
    g.fillOval(xCoordinate, yCoordinate, width, height);
  }
  public String getShapeData() {
    String data = String.format("%s %d %d %d %d", type, width, height, xCoordinate, yCoordinate);
    return data;
  }
  public void displayShapeData() {
    System.out.printf("%s Width: %d Height: %d XCoordinate: %d YCoordinate: %d Area %.2f",type, width, height,
                      xCoordinate, yCoordinate, area);
  }
  
  public void setWidth(int newWidth) {
    width = newWidth;
  }
  public void setHeight(int newHeight) {
    height = newHeight;
  }
  public void printWidth() {
    System.out.println("The current width is: " + this.width);
  }
  public void printHeight() {
    System.out.println("The current height is: " + this.height);
  }
}