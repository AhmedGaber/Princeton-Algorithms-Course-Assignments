public class Fast {

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

    }

    private static void drawPoint() {

    }

    private static void drawLine() {

    }

    private static void printResult() {

    }

}
