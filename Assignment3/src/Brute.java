import java.util.Arrays;

public class Brute {

    public static void main(String[] args) {
        In in = new In();
        Out out = new Out();
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        StdDraw.setPenRadius(0.004);

        int n = in.readInt();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            points[i] = new Point(in.readInt(), in.readInt());
            points[i].draw();
        }

        doLogic(points, out);
    }

    private static void doLogic(Point[] points, Out out) {
        double pqSlope = 0;
        double prSlope = 0;
        double psSlope = 0;
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

        Point[] temp = new Point[] { points[p], points[q], points[r], points[s] };
        Arrays.sort(temp);
        temp[0].drawTo(temp[3]);
        temp[0].drawTo(temp[3]);
        out.println(temp[0].toString() + " -> " + temp[1].toString() + " -> "
                + temp[2].toString() + " -> " + temp[3].toString());
    }

    /**
     * Test Cases 6 19000 10000 18000 10000 32000 10000 21000 10000 1234 5678
     * 14000 10000
     * 
     * 8 10000 0 0 10000 3000 7000 7000 3000 20000 21000 3000 4000 14000 15000
     * 6000 7000
     * 
     * 
     */
}
