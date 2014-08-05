/**
 * 
 * @author Ahmed Gaber
 *
 */
import java.util.Comparator;

public class Point implements Comparable<Point> {

    // compare points by slope
    public final Comparator<Point> SLOPE_ORDER = new Comparator<Point>() {

        @Override
        public int compare(Point q, Point r) {
            // TODO Auto-generated method stub
            return 0;
        }
    };

    private final int x; // x coordinate
    private final int y; // y coordinate

    /**
     * Create the point (x, y)
     * 
     * @param x
     * @param y
     */
    public Point(int x, int y) {
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
     * Slope between this point and that point which is given by the formula (y1
     * - y0) / (x1 - x0). Slope of a horizontal line segment is positive zero;
     * slope of a vertical line segment is positive infinity; slope of a
     * degenerate line segment (between a point and itself) is negative
     * infinity.
     * 
     * @param that
     * @return
     */
    public double slopeTo(Point that) {
        if ((this.x == that.x) && (this.y == that.y))
            return Double.NEGATIVE_INFINITY;
        else if (this.x == that.x)
            return 0.0;
        else if (this.y == that.y)
            return Double.POSITIVE_INFINITY;
        return (Math.abs(this.y - that.y) * 1.0)
                / (Math.abs(this.x - that.x) * 1.0);
    }

    /**
     * Is this point lexicographically smaller than that one? comparing
     * y-coordinates and breaking ties by x-coordinate. The invoking point (x0,
     * y0) is less than the argument point (x1, y1) if and only if either y0 <
     * y1 or if y0 = y1 and x0 < x1.
     */
    public int compareTo(Point that) {
        if ((this.x == that.x) && (this.y == that.y))
            return 0;
        else if ((this.y < that.y) || ((this.y == that.y) && (this.x < that.x)))
            return -1;
        return 1;
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