import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Fast {

    public static void main(String[] args) {
        In in = new In();
        Out out = new Out();
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        
        int n = in.readInt();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            points[i] = new Point(in.readInt(), in.readInt());
            points[i].draw();
        }

        doLogic(points, out);
    }

    private static void doLogic(Point[] points, Out out) {
        ArrayList<Point> arr = new ArrayList<Point>();
        ArrayList<Point> doneArr = new ArrayList<Point>();
        for (int i = 0; i < points.length - 1; i++) {
            arr.clear();
            Point origin = points[i];
            Arrays.sort(points, i + 1, points.length, origin.SLOPE_ORDER);
            double slope = origin.slopeTo(points[i + 1]);
            arr.add(origin);
            for (int j = i + 1; j < points.length; j++) {
                if (origin.slopeTo(points[j]) == slope)
                    arr.add(points[j]);
                else
                    slope = origin.slopeTo(points[j]);
            }
            arr.removeAll(doneArr);
            if (arr.size() > 3)
                printResult(out, arr);
            for (int j = 0; j < arr.size(); j++) {
                doneArr.add(arr.get(j));
            }
        }
    }

    private static void printResult(Out out, ArrayList<Point> arr) {
        Collections.sort(arr);
        for (int i = 0; i < arr.size() - 1; i++) {
            out.print(arr.get(i).toString() + " -> ");
        }
        out.println(arr.get(arr.size() - 1).toString());
        arr.get(0).drawTo(arr.get(arr.size() - 1));
    }

    /**
     * Test Cases
     * 
     * 6 19000 10000 18000 10000 32000 10000 21000 10000 1234 5678 14000 10000
     * 
     * 8 10000 0 0 10000 3000 7000 7000 3000 20000 21000 3000 4000 14000 15000
     * 6000 7000
     * 
     * 
     */
}