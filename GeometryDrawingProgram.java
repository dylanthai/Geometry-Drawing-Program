import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.PrintWriter;    //import for file write
import java.io.File;           //import for file I/O
import java.util.Collections;
// import java.util.Arrays;

/** Geometry Drawing Program
  * Program where user can create their own program with basic shapes
  * @version Date: 4/23/2020
  * @Author Dylan Thai
  */

class GeometryDrawingProgram {
  static JFrame frame; 
  static ArrayList<Shape> shapeList = new ArrayList<Shape>(); // Where shapes in drawing are stored
  static File file = new File("savedShapeList.txt"); 
  
  static Scanner keyboard = new Scanner(System.in);
  
  /** Displays all the shapes
    */
  private static void displayAllShapes() {
    frame.repaint(); //update the screen
  }
  
  /** gets the user to input a width for a shape
    */  
  private static int getWidth() {
    System.out.println("What do you want the width to be: ");
    int width = keyboard.nextInt();
    return width;
  }
  
  /** gets the user to input a base for a shape
    */
  private static int getBase() {
    System.out.println("What do you want the base to be: ");
    int base = keyboard.nextInt();
    return base;
  }
  
  /** gets the user to input a height for a shape
    */
  private static int getHeight() {
    System.out.println("What do you want the height to be: ");
    int height = keyboard.nextInt();
    return height;
  }
  
  /** Adds a shape to the Array List: shapeList
    */
  private static void addShape() {
    System.out.println(shapeList);
    System.out.println("ENTER INTEGERS ONLY!");
    System.out.println("Which shape do you want to create:\n1.Circle\n2.Square\n3.Rectangle\n4.Oval\n5.Parallelogram\n6.Rhombus\n7.Triangle\n8.Trapezoid");
    int choice = keyboard.nextInt();
    System.out.println("Where do you want to place your shape...");
    System.out.println("NOTE, THESE COORDINATE IS THE COORDINATE FOR THE TOP RIGHT CORNER OF YOUR SHAPE");
    System.out.println("Enter the X Coordinate:");
    int xCord = keyboard.nextInt() + 250;
    System.out.println("Enter the Y Coordinate:");
    int yCord = 250 - keyboard.nextInt();
    
    if(choice == 1){
      System.out.println("What do you want the radius to be:");
      int radius = keyboard.nextInt();
      Circle circle = new Circle(Color.GREEN, xCord , yCord, radius);
      shapeList.add(circle);
    } else if(choice == 2) {
      System.out.println("What do you want the side length to be:");
      int sideLength = keyboard.nextInt();
      Square square = new Square(Color.LIGHT_GRAY, xCord, yCord, sideLength);
      shapeList.add(square);
    } else if(choice == 3) {
      int width = getWidth();
      int height = getHeight();
      Rectangle rectangle = new Rectangle(Color.RED, xCord, yCord, width, height);
      shapeList.add(rectangle);
    } else if(choice == 4) {
      int width = getWidth();
      int height = getHeight();
      Oval oval = new Oval(Color.BLUE, xCord, yCord, width, height);
      shapeList.add(oval);
    }else if(choice == 5) {
      int base = getBase();
      int height = getHeight();
      Parallelogram parallelogram = new Parallelogram(Color.YELLOW, xCord, yCord, base, height);
      shapeList.add(parallelogram);
    } else if(choice == 6) {
      int width = getWidth();
      int height = getHeight();
      Rhombus rhombus = new Rhombus(Color.ORANGE, xCord, yCord, width, height);
      shapeList.add(rhombus);
    } else if(choice == 7) {
      int base = getBase();
      int height = getHeight();
      Triangle triangle = new Triangle(Color.MAGENTA, xCord, yCord, base, height);
      shapeList.add(triangle);
    } else if(choice == 8) {
      int base = getBase();
      int height = getHeight();
      Trapezoid trapezoid = new Trapezoid(Color.PINK, xCord, yCord, base, height);
      shapeList.add(trapezoid);
    }
  }
  
  /** test function to add multiple shapes quickly (one of each shape is added)
    */  
  private static void testAddShape() {
    Circle circle = new Circle(Color.GREEN, 30 + 250 , 250 - 50, 20);
    shapeList.add(circle);
    Square square = new Square(Color.LIGHT_GRAY, 90 + 250, 250 - 50, 40);
    shapeList.add(square);
    Rectangle rectangle = new Rectangle(Color.RED, -30 + 250, 250 - (-60), 100, 30);
    shapeList.add(rectangle);
    Oval oval = new Oval(Color.BLUE, -50 + 250, 250 - 60, 30, 50);
    shapeList.add(oval);
    Parallelogram parallelogram = new Parallelogram(Color.YELLOW, -70 + 250, 250 - (-100), 60, 30);
    shapeList.add(parallelogram);
    Rhombus rhombus = new Rhombus(Color.ORANGE, -90 + 250, 250 - 0, 60, 30);
    shapeList.add(rhombus);
    Triangle triangle = new Triangle(Color.MAGENTA, -100 + 250, 250 - 100, 70, 70);
    shapeList.add(triangle);
    Trapezoid trapezoid = new Trapezoid(Color.PINK, 110 + 250, 250-(-170), 100, 50);
    shapeList.add(trapezoid);
  }
  
  /** Removes a shape from the Array List: shapeList
    */
  private static void removeShape() {
    if (shapeList.size() < 1){
      System.out.println("There are no shapes to remove");
      return;
    } 
    System.out.println("Index Shape");
    for (int i = 0; i < shapeList.size(); i++) {
      System.out.printf("%5d %s%n",i, shapeList.get(i).getType());
    }
    System.out.println("Which index do you want to remove: ");
    int indexToRemove = keyboard.nextInt();
    if (indexToRemove < 0 ||indexToRemove > shapeList.size()) {
      System.out.println("Invalid Index");
      return;
    }
    shapeList.remove(indexToRemove); // removes the shape in the given index
  }
  
  private static void modifyCircleDimension(int indexToModify) {
    System.out.println("What do you want the new radius for the circle to be: ");
    ((Circle) (shapeList.get(indexToModify))).printRadius();
    int newRadius = keyboard.nextInt();
    ((Circle) (shapeList.get(indexToModify))).setRadius(newRadius);
  }
  
  private static void modifyDimensionWidthAndHeight(int indexToModify) {
    System.out.println("What do you want to modify the:\n1. width\n2. height\n3. both");
    int widthOrHeight = keyboard.nextInt();
    ShapeWithWidthAndHeight shapeWH = (ShapeWithWidthAndHeight) (shapeList.get(indexToModify));
    if (widthOrHeight == 1){
      shapeWH.printWidth();
      System.out.println("What do you want to change the width to?: ");
      int newWidth = keyboard.nextInt();
      shapeWH.setWidth(newWidth);
    } else if (widthOrHeight == 2){
      shapeWH.printHeight();
      System.out.println("What do you want to change the height to?: ");
      int newHeight = keyboard.nextInt();
      shapeWH.setHeight(newHeight);
    } else if (widthOrHeight == 3){
      shapeWH.printWidth();
      System.out.println("What do you want to change the width to?: ");
      int newWidth = keyboard.nextInt();
      shapeWH.setWidth(newWidth);
      shapeWH.printHeight();
      System.out.println("What do you want to change the height to?: ");
      int newHeight = keyboard.nextInt();
      shapeWH.setHeight(newHeight);
    } else {
      System.out.println("Invalid Input");
      return;
    }
  }
  private static void modifySquareDimension(int indexToModify) {
    ((Square) (shapeList.get(indexToModify))).printLength();
    System.out.println("What do you want the side lengths of the square to be: ");
    int newSideLength = keyboard.nextInt();
    ((Square) (shapeList.get(indexToModify))).setLength(newSideLength);
  }
  
  private static void modifyDimensionBaseAndHeight(int indexToModify) {
    System.out.println("What do you want to modify the:\n1. base\n2. height\n3. base and height");
    int baseOrHeight = keyboard.nextInt();
    ShapeWithBaseAndHeight shapeBH = (ShapeWithBaseAndHeight) (shapeList.get(indexToModify));
    if (baseOrHeight == 1){
      shapeBH.printBase();
      System.out.println("What do you want to change the base to?: ");
      int newBase = keyboard.nextInt();
      shapeBH.setBase(newBase);
    } else if (baseOrHeight == 2){
      shapeBH.printHeight();
      System.out.println("What do you want to change the height to?: ");
      int newHeight = keyboard.nextInt();
      shapeBH.setHeight(newHeight);
    }  else if (baseOrHeight == 3){
      shapeBH.printBase();
      System.out.println("What do you want to change the base to?: ");
      int newBase = keyboard.nextInt();
      shapeBH.setBase(newBase);
      shapeBH.printHeight();
      System.out.println("What do you want to change the height to?: ");
      int newHeight = keyboard.nextInt();
      shapeBH.setHeight(newHeight);
    } 
  }
  private static void modifyPostionOfShape(int indexToModify) {
    shapeList.get(indexToModify).printXCord();
    System.out.println("Enter a new x coordinate: ");
    int newXCord = keyboard.nextInt() + 250;
    shapeList.get(indexToModify).setXCord(newXCord);
    shapeList.get(indexToModify).printYCord();
    System.out.println("Enter a new y coordinate: ");
    int newYCord = 250 - keyboard.nextInt();
    shapeList.get(indexToModify).setYCord(newYCord);
  }
  
  /** Modify any shape
    */  
  private static void modifyShape() {
    if (shapeList.size() < 1){
      System.out.println("There are no shapes to modify");
      return;
    } 
    System.out.println("Index Shape");
    for (int i = 0; i < shapeList.size(); i++) {
      System.out.printf("%5d %s%n",i, shapeList.get(i).getType());
    }
    System.out.println("Which index do you want to modify: ");
    int indexToModify = keyboard.nextInt();
    if (indexToModify < 0 || indexToModify > shapeList.size()) {
      System.out.println("Invalid Index");
      return;
    }
    String type = shapeList.get(indexToModify).getType();
    System.out.println("Do you want to modify the shape's dimensions:\n1. Yes\n2. No");
    int choice = keyboard.nextInt();
    if(choice == 1) {
      if(type == "Circle") {
        modifyCircleDimension(indexToModify);
      } else if (type == "Oval" ||type == "Rectangle" || type == "Rhombus") {
        modifyDimensionWidthAndHeight(indexToModify);
      } else if (type == "Square"){
        modifySquareDimension(indexToModify);
      } 
      else if (type == "Triangle" || type == "Trapezoid" || type == "Parallelogram"){
        modifyDimensionBaseAndHeight(indexToModify);
      } else {
        System.out.println("Invalid Input");
        return; 
      }
    }
    System.out.println("Do you want to change the positon of the shape?:\n1. Yes\n2. No");
    int newPos = keyboard.nextInt();
    if (newPos == 1) {
      modifyPostionOfShape(indexToModify);
    } else {
      return;
    }
  } // End modifyShape
  
  /** Translates all the shapes in the shapeList
    */
  private static void translateAllShapes() {
    if (shapeList.size() < 1){
      System.out.println("There are no shapes to translate");
      return;
    }
    System.out.println("Do you want to move all shapes\n1. Up or Down\n2. Left or Right\n");
    int direction = keyboard.nextInt();
    int amount;
    if(direction == 1) {
      System.out.println("How many pixels do you want to translate all the shapes by...");
      System.out.println("Enter POSITIVE Value for UP and NEGATIVE Value for DOWN: ");
      amount = keyboard.nextInt();
      int currentYCord;
      int newYCord;
      for (int i = 0; i < shapeList.size(); i++) {
        currentYCord = shapeList.get(i).getYCord();
        newYCord = currentYCord - amount;
        shapeList.get(i).setYCord(newYCord);
      }
    } else if(direction == 2) {
      System.out.println("How many pixels do you want to translate all the shapes by...");
      System.out.println("Enter POSITIVE Value for RIGHT and NEGATIVE Value for LEFT: ");
      amount = keyboard.nextInt();
      int currentXCord;
      int newXCord;
      for (int i = 0; i < shapeList.size(); i++) {
        currentXCord = shapeList.get(i).getXCord();
        newXCord = currentXCord + amount;
        shapeList.get(i).setXCord(newXCord);
      }
    }
  } // end translate all shapes
  
  private static void saveShapeList(File file) {
    
    try {
      PrintWriter printWriter = new PrintWriter(file);     //*All data in the file will be overwritten (not added to)
      System.out.println("Saving . . .");
      for (int i = 0; i < shapeList.size(); i++) {
        shapeList.get(i).printShapeDataToFile(printWriter);
      }
      printWriter.close();
      System.out.println("Saving Complete!");
    } catch(Exception e) {
      System.out.println("No file was found for saveShapeList");
      return;
    }
    createCopyOfShapeList(file);
  }
  
  private static void createCopyOfShapeList(File file) {
    try {
      Scanner scanner = new Scanner(file);
      while (scanner.hasNextLine()) {   
        String shapeData = scanner.nextLine();
        String shapeName = shapeData.substring(0, shapeData.indexOf(' '));
        
        if(shapeName.equals("Circle")) {
          loadCircle(shapeData);
        } else if (shapeName.equals("Square")) {
          loadSquare(shapeData);
        } else if (shapeName.equals("Rectangle")) {
          loadRectangle(shapeData);
        } else if (shapeName.equals("Oval")) {
          loadOval(shapeData);
        } else if (shapeName.equals("Parallelogram")) {
          loadParallelogram(shapeData);
        } else if (shapeName.equals("Rhombus")) {
          loadRhombus(shapeData);
        } else if (shapeName.equals("Triangle")) {
          loadTriangle(shapeData);
        } else if (shapeName.equals("Trapezoid")) {
          loadTrapezoid(shapeData);
        }
      }
      scanner.close();   
    } catch (Exception e) {
      System.out.println("No file was found for createCopyOfShapeList");
      return;
    }
  }
  
  private static void loadCircle(String shape) {
    Scanner scanner = new Scanner(shape);
    String shapeName = scanner.next(); // not used because not need to load shape
    int radius = scanner.nextInt();
    int xCoordinate = scanner.nextInt();
    int yCoordinate = scanner.nextInt();
    Circle circle = new Circle(Color.GREEN, xCoordinate , yCoordinate, radius);
    shapeList.add(circle);
    scanner.close();
  }
  
  private static void loadSquare(String shape) {
    Scanner scanner = new Scanner(shape); 
    String shapeName = scanner.next(); // not used because not need to load shape
    int length = scanner.nextInt();
    int xCoordinate = scanner.nextInt();
    int yCoordinate = scanner.nextInt();
    Shape square = new Square(Color.LIGHT_GRAY, xCoordinate , yCoordinate, length);
    shapeList.add(square);
    scanner.close();
  }
  
  private static void loadRectangle(String shape) {
    Scanner scanner = new Scanner(shape);
    String shapeName = scanner.next(); // not used because not need to load shape
    int width = scanner.nextInt();
    int height = scanner.nextInt();
    int xCoordinate = scanner.nextInt();
    int yCoordinate = scanner.nextInt();
    Shape rectangle = new Rectangle(Color.RED, xCoordinate , yCoordinate, width, height);
    shapeList.add(rectangle);
    scanner.close();
  }  
  
  private static void loadOval(String shape) {
    Scanner scanner = new Scanner(shape);
    String shapeName = scanner.next(); // not used because not need to load shape
    int width = scanner.nextInt();
    int height = scanner.nextInt();
    int xCoordinate = scanner.nextInt();
    int yCoordinate = scanner.nextInt();
    Shape oval = new Oval(Color.BLUE, xCoordinate , yCoordinate, width, height);
    shapeList.add(oval);
    scanner.close();
  }
  
  private static void loadParallelogram(String shape) {
    Scanner scanner = new Scanner(shape); 
    String shapeName = scanner.next(); // not used because not need to load shape
    int base = scanner.nextInt();
    int height = scanner.nextInt();
    int xCoordinate = scanner.nextInt();
    int yCoordinate = scanner.nextInt();
    Shape parallelogram = new Parallelogram(Color.YELLOW, xCoordinate , yCoordinate, base, height);
    shapeList.add(parallelogram);
    scanner.close();
  }
  
  private static void loadRhombus(String shape) {
    Scanner scanner = new Scanner(shape);
    String shapeName = scanner.next(); // not used because not need to load shape
    int width = scanner.nextInt();
    int height = scanner.nextInt();
    int xCoordinate = scanner.nextInt();
    int yCoordinate = scanner.nextInt();
    Shape rhombus = new Rhombus(Color.ORANGE, xCoordinate , yCoordinate, width, height);
    shapeList.add(rhombus);
    scanner.close();
  } 
  
  private static void loadTriangle(String shape) {
    Scanner scanner = new Scanner(shape);
    String shapeName = scanner.next(); // not used because not need to load shape
    int base = scanner.nextInt();
    int height = scanner.nextInt();
    int xCoordinate = scanner.nextInt();;
    int yCoordinate = scanner.nextInt();
    Shape triangle = new Triangle(Color.YELLOW, xCoordinate , yCoordinate, base, height);
    shapeList.add(triangle);
    scanner.close();
  }
  
  private static void loadTrapezoid(String shape) {
    Scanner scanner = new Scanner(shape);
    String shapeName = scanner.next(); // not used because not need to load shape
    int base = scanner.nextInt();
    int height = scanner.nextInt();
    int xCoordinate = scanner.nextInt();
    int yCoordinate = scanner.nextInt();
    Shape trapezoid = new Trapezoid(Color.PINK, xCoordinate , yCoordinate, base, height);
    shapeList.add(trapezoid);
    scanner.close();
  }
  
  private static void loadShapeList(File file) {
    shapeList = new ArrayList<Shape>();
    createCopyOfShapeList(file);
  }
  
  private static void outputShapeData() {
    if (shapeList.size() < 1){
      System.out.println("There is no data because there are no shapes in shapeList");
      return;
    }
    for (int i = 0; i < shapeList.size(); i++) {
      shapeList.get(i).displayShapeData();
      System.out.println("\n");
    }
  }
  private static void sortListandDisplay() { 
    if (shapeList.size() < 0) {
      return;
    } 
    System.out.println("Sorting shape list by area by ascending area ...");
    Collections.sort(shapeList);
    System.out.println("Sorting Complete!");
    System.out.println("Printing in console all shapes from smallest to greatest area ...\n");
    outputShapeData();
    displayAllShapes();
  }
  
  public static void main(String[] args) {  
    GeometryScreen gs = new GeometryScreen();
    
    boolean continueUsing = true;
    int option = 0;
    
    do {
      System.out.printf("%10s%n%s%n%s%n%s%n%s%n%s%n%s%n%s%n%s%n%s%n%s%n","MENU","1. Display all Shapes and its data",
                        "2. Add Shape","3. Remove Shape","4. Modify Shape","5. Translate all Shapes","6. Save Drawing",
                        "7. Load Drawing", "8. Sort Shapes by Area","9. Delete Current Drawing","10. Quit");
      System.out.println("Select an option from above . . .");
      option = keyboard.nextInt();
      
      //menu options: Add shape, Remove shape, Modify Shape, Translate Drawing, Save Drawing, Load Drawing, Quit.
      if (option == 1){
        outputShapeData();
        displayAllShapes();
      } else if (option == 2) {
        addShape();
        //testAddShape(); // Test Function
        displayAllShapes();
      } else if(option == 3) {
        removeShape();
        displayAllShapes();
      }else if(option == 4) {
        modifyShape(); 
        displayAllShapes();
      } else if (option == 5){
        translateAllShapes();
        displayAllShapes();
      } else if (option == 6) { 
        saveShapeList(file);
      } else if (option == 7) {
        loadShapeList(file);
        displayAllShapes();
      } else if (option == 8) {
        sortListandDisplay();
      } else if (option == 9) {
        shapeList = new ArrayList<Shape>();
        displayAllShapes();
      }else if (option == 10) {
        continueUsing = false;
      } else {
        System.out.println("Invalid Option ... pick other option:");
        option = keyboard.nextInt();
      } 
    }while(continueUsing == true);
    System.out.print("Thanks for using the Program!");
    keyboard.close();
  } // End of Main
  
  //This is an inner class - it has access to the static variables defined above
  public static class GeometryScreen {
    //constructor - do no modify
    GeometryScreen() {
      frame = new JFrame("Geometry Drawing Program 1.0");
      
      //Create a new "custom" panel for graphics based on the inner class below
      JPanel graphicsPanel = new GraphicsPanel();
      
      //Add the panel and the frame to the window
      frame.getContentPane().add(graphicsPanel);
      
      // Set the frame to full screen 
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(520,540);
      frame.setUndecorated(false);  //Set to true to remove title bar
      frame.setVisible(true);
    } 
    
//This is an inner class which contains all the details about drawing to screen.
    public static class GraphicsPanel extends JPanel {
      
      //The method that draws to the screen - you will need to add.modify code here
      public void paintComponent(Graphics g) {          
        setDoubleBuffered(true);   
        g.setColor(Color.BLACK);
        //draw the X/Y Axis
        g.drawLine(250, 0, 250, 500);
        g.drawLine(0, 250, 500, 250);
        
        //You will need to draw each of the Shapes contained in your Arraylist here
        //This screen will update everytime the menu loop completes
        for (int i = 0; i < shapeList.size(); i++) {
          shapeList.get(i).draw(g);
        }
      }
    }
  }
}