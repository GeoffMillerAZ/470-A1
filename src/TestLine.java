/***************************************************************
 * Author: Geoffrey Miller Zid: z1644162 Due Date: Sept 18th 2013
 * 
 * Description: Now we will define a class with main() where execution will
 * begin. It is this class, and this code, that will create instances of the
 * Line and call its methods. As a test module, this code would be improved with
 * additional System.out.println() statements that explain what is being
 * attempted and what the results should be, for example: "About to change l1 to
 * an invalid value and then redraw it. Line position should not change: "
 ******************************************************************/
class TestLine {
    public static void main(String args[]) {
        Line l1 = null, l2 = null; // declare 2 instances of Line class
        // create 1 Line object
        try {
            l1 = new Line(10, 10, 100, 100);
        } catch (InvalidValueException e) {
            System.out.println("Exception: " + e.getMessage()
                    + " Line was not altered.");
        }
        // draw it
        l1.draw();
        // change start point with valid values
        try {
            l1.setLine(5, 5, l1.getXTwo(), l1.getYTwo());
        } catch (InvalidValueException e) {
            System.out.println("Exception: " + e.getMessage()
                    + " Line was not altered.");
        }
        // draw it again with new start point
        l1.draw();
        // try to change xOne (x1) to an illegal value
        try {
            l1.setXOne(3000);
        } catch (InvalidValueException e) {
            System.out.println("Exception: " + e.getMessage()
                    + " Line was not altered.");
        }
        // draw the line...x1 should now be zero
        l1.draw();
        // create a second Line instance, or object
        try {
            l2 = new Line(100, 100, 400, 400);
        } catch (InvalidValueException e) {
            System.out.println("Exception: " + e.getMessage()
                    + " Line was not altered.");
        }
        // draw 2nd line
        l2.draw();
        // set a new valid yTwo for line 2
        try {
            l2.setYTwo(479);
        } catch (InvalidValueException e) {
            System.out.println("Exception: " + e.getMessage()
                    + " Line was not altered.");
        }

        // draw 2nd line again
        l2.draw();

        // *************************************
        // BEGIN ENHANCEMENTS
        // *************************************

        System.out.println("Testing setting thickness to 10.\n");
        l2.setThickness(10);

        System.out.println("Testing getters:");
        System.out.println("The line's thickness is " + l2.getThickness()
                + ".\n");

        System.out.println("Testing length calculation:");
        System.out.println("The line's length is " + l2.getLineLength() + "\n");

        System.out.println("Testing angle calculation:");
        System.out
                .println("The angle between the line and horizontal line starts from (x1, y1) is "
                        + l2.getLineAngle() + "\n");

        System.out
                .println("------------------------------------------------------------------------------------------------");
        System.out
                .println("Testing constructor: Line(TwoDPoint point1, TwoDPoint point2).");
        System.out.println("The TwoDPoints are (20,30) and (40, 50).");

        @SuppressWarnings("unused")
        // This only exists to test the constructor. So the variable itself will
        // never be used.
        Line l3 = null;
        TwoDPoint tdp1 = null, tdp2 = null;
        tdp1 = new TwoDPoint(20, 30);
        tdp2 = new TwoDPoint(40, 50);
        try {
            l3 = new Line(tdp1, tdp2);
        } catch (InvalidValueException e) {
            System.out.println("Exception: " + e.getMessage()
                    + " Line was not altered.");
        }

        System.out.println("Constructor has created the line successfully.");
        System.out
                .println("------------------------------------------------------------------------------------------------");
        System.out
                .println("Testing setter exception handling by calling setLine() with an invalid integer. (-5, 5, 10, 10)");
        try {
            l2.setLine(-5, 5, 10, 10);
        } catch (InvalidValueException e) {
            System.out.println("Exception: " + e.getMessage()
                    + " Line was not altered");
        }
        System.out
                .println("------------------------------------------------------------------------------------------------");
        System.out
                .println("Testing constructor exception handling by calling Line() with an invalid integer");
        @SuppressWarnings("unused")
        // This only exists to test the constructor. So the variable itself will
        // never be used.
        Line l4 = null;
        try {
            l4 = new Line(-5, 5, 10, 10);
        } catch (InvalidValueException e) {
            System.out.println("Exception: " + e.getMessage()
                    + " Exiting program...");
            System.out
                    .println("------------------------------------------------------------------------------------------------");
            System.exit(0);
        }
        // If this next line doesn't print, it proves the exception properly
        // handled exiting the application.
        System.out
                .println("-------------------THIS LINE SHOULD NOT PRINT---------------------------------------------------");

    } // end of main
} // end class TestLine