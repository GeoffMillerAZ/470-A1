/***************************************************************** 
 * Author:   Geoffrey Miller
 * Zid:      z1644162
 * Due Date: Sept 18th 2013
 *
 * Description:
 *  This program demonstrates a simple "Line" class. 
 *  Here, a Line class is defined with its properties and 
 *  interface (i.e., its methods). 
 *  A main method (in TestLine) then creates instances of this Line class 
 *  and calls on the methods to demonstrate its behavior. 
 ******************************************************************/
import java.io.*;
import java.lang.Math;

@SuppressWarnings("unused")
public class Line {
    private int x1, y1, x2, y2; // coordinates of the line
    private int lThick; // line thickness

    // Constructor
    // Receives 4 integers which are the Line's start and end points.
    public Line(int xOne, int yOne, int xTwo, int yTwo)
            throws InvalidValueException {
        // each of these validates its argument - see below.
        setXOne(xOne);
        setYOne(yOne);
        setXTwo(xTwo);
        setYTwo(yTwo);
    } // end constructor

    // Constructor (alternative)
    public Line(TwoDPoint lineOne, TwoDPoint lineTwo)
            throws InvalidValueException {
        this(lineOne.x, lineOne.y, lineTwo.x, lineTwo.y);
    } // end constructor

    // *************************************
    // method draw() calls another method called drawLine(),
    // which is assumed to be a graphics primitive on the
    // system. However, since this program will be
    // run in console mode, a text description of the Line
    // will be displayed.
    //
    public void draw() {
        drawLine(x1, y1, x2, y2);
    }

    // *************************************
    // method drawLine() simulates drawing of a line for console mode.
    // It should describe all the important attributes of the line.
    // In a graphics mode program, we would delete this and use the
    // system's Graphics library drawLine().
    //
    private void drawLine(int x1, int y1, int x2, int y2) {
        System.out.println("Draw a line from x of " + x1 + " and y of " + y1);
        System.out.println("to x of " + x2 + " and y of " + y2 + "\n");
    }

    // *************************************
    // Method setLine() allows user to change the points of the
    // already existing Line.
    //
    public void setLine(int xOne, int yOne, int xTwo, int yTwo)
            throws InvalidValueException {
        setXOne(xOne);
        setYOne(yOne);
        setXTwo(xTwo);
        setYTwo(yTwo);
    }

    // -- the individual setXXXX methods that prevent
    // any line's coordinate from being offscreen.
    // In the event of an invalid (offscreen) value,
    // that value is (silently) set to 0.
    // **************************
    public void setXOne(int xOne) throws InvalidValueException {
        if (xOne < 0 || xOne > 639) {
            throw new InvalidValueException("An invalid coordinate was given.");
        }

        else
            x1 = xOne;
    }

    // **************************
    public void setYOne(int yOne) throws InvalidValueException {
        if (yOne < 0 || yOne > 479) {
            throw new InvalidValueException("An invalid coordinate was given.");
        } else
            y1 = yOne;
    }

    // **************************
    public void setXTwo(int xTwo) throws InvalidValueException {
        if (xTwo > 639 || xTwo < 0) {
            throw new InvalidValueException("An invalid coordinate was given.");
        } else
            x2 = xTwo;
    }

    // **************************
    public void setYTwo(int yTwo) throws InvalidValueException {
        if (yTwo > 479 || yTwo < 0) {
            throw new InvalidValueException("An invalid coordinate was given.");
        }

        else
            y2 = yTwo;
    }

    // Now for some "get" Access methods to get individual values
    // **************************
    public int getXOne() {
        return x1;
    }

    // **************************
    public int getYOne() {
        return y1;
    }

    // **************************
    public int getXTwo() {
        return x2;
    }

    // **************************
    public int getYTwo() {
        return y2;
    }

    // *************************************
    // BEGIN ENHANCEMENTS
    // *************************************
    // A set method for Line Thickness
    public void setThickness(int lThick_input) {
        lThick = lThick_input;
    }

    // An access method to the line thickness data member
    public int getThickness() {
        return lThick;
    }

    // Calculates and returns a double representing line length
    public double getLineLength() {
        return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
    }

    // Calculates and returns a double representing line angle
    // to the horizon.
    public double getLineAngle() {
        if (y1 - y2 < 0)
            return -1 * Math.asin((y1 - y2) / getLineLength());
        else
            return Math.asin((y1 - y2) / getLineLength());
    }

} // end class Line

// This class is an exception for invalid values. This exception
// will be thrown when a value has been entered that is out-of-range
// of the line draw area.
class InvalidValueException extends Exception {
    private static final long serialVersionUID = 1L;

    public InvalidValueException(String message) {
        super(message);
    }

} // end class Line