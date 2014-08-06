import java.util.Arrays;

public class Brute {

    public static void main(String[] args) {
        In in = new In();
        Draw draw = new Draw();
        draw.setXscale(0, 32768);
        Out out = new Out();
        Point[] points = getInput(in);
        doLogic(points, draw, out);
    }

    private static Point[] getInput(In in) {
        int n = in.readInt();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            points[i] = new Point(in.readInt(), in.readInt());
        }
        return points;
    }

    private static void doLogic(Point[] points, Draw draw, Out out) {
        double pqSlope = 0;
        double prSlope = 0;
        double psSlope = 0;
        Arrays.sort(points);
        for (int p = 0; p < points.length; p++) {
            for (int q = p + 1; q < points.length; q++) {
                pqSlope = points[p].slopeTo(points[q]);
                for (int r = q + 1; r < points.length; r++) {
                    prSlope = points[p].slopeTo(points[r]);
                    if (pqSlope != prSlope)
                        continue;
                    for (int s = r + 1; s < points.length; s++) {
                        psSlope = points[p].slopeTo(points[s]);
                        if (prSlope != psSlope)
                            continue;
                        printResult(out, points, p, q, r, s);
                    }
                }
            }
        }
    }

    private static void printResult(Out out, Point[] points, int p, int q,
            int r, int s) {
        out.println(points[p].toString() + " -> " + points[q].toString()
                + " -> " + points[r].toString() + " -> " + points[s].toString());
    }

    private static void drawPoint() {

    }

    private static void drawLine() {

    }

    /**
     * Test Cases 6 19000 10000 18000 10000 32000 10000 21000 10000 1234 5678
     * 14000 10000
     * 
     * 8 10000 0 0 10000 3000 7000 7000 3000 20000 21000 3000 4000 14000 15000
     6000 7000
     * 
     * 
     */
}
