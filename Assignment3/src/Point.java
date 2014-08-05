import java.util.Comparator;

public class Point implements Comparable<Point> {

    // compare points by slope
    public final Comparator<Point> SLOPE_ORDER = null; // YOUR DEFINITION HERE

    private final int x; // x coordinate
    private final int y; // y coordinate

    /**
     * Create the point (x, y)
     * 
     * @param x
     * @param y
     */
    public Point(int x, int y) {
        /* DO NOT MODIFY */
        this.x = x;
        this.y = y;
    }

    /**
     * Plot this point to standard drawing
     */
    public void draw() {
        StdDraw.point(x, y);
    }

    /**
     * Draw line between this point and that point to standard drawing
     * 
     * @param that
     */
    public void drawTo(Point that) {
        StdDraw.line(this.x, this.y, that.x, that.y);
    }

    /**
     * Slope between this point and that point
     * 
     * @param that
     * @return
     */
    public double slopeTo(Point that) {
        /* YOUR CODE HERE */
    }

    /**
     * Is this point lexicographically smaller than that one? comparing
     * y-coordinates and breaking ties by x-coordinates
     */
    public int compareTo(Point that) {
        /* YOUR CODE HERE */
    }

    /**
     * Return string representation of this point
     */
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    /**
     * Unit test
     * 
     * @param args
     */
    public static void main(String[] args) {
        /* YOUR CODE HERE */
    }
}