/**
 * 
 * @author Ahmed Gaber
 * 
 */
public class Solver {
    private Node result;

    private class Node implements Comparable<Node> {
        private final Board board;
        private final Node previous;
        private final int moves;
        private final int priority;

        public Node(Board board, Node prev) {
            this.board = board;
            this.previous = prev;
            if (previous == null)
                this.moves = 0;
            else
                this.moves = previous.moves + 1;
            this.priority = board.manhattan() + moves;
        }

        public int compareTo(Node that) {
            if (this.priority > that.priority)
                return 1;
            else if (this.priority < that.priority)
                return -1;
            return 0;
        }
    }

    /**
     * Find a solution to the initial board (using the A* algorithm)
     * 
     * @param initial
     */
    public Solver(Board initial) {

    }

    /**
     * Is the initial board solvable?
     * 
     * @return
     */
    public boolean isSolvable() {
        return result != null;
    }

    /**
     * Min number of moves to solve initial board; -1 if no solution
     * 
     * @return
     */
    public int moves() {
        if (result != null)
            return result.moves;
        return -1;
    }

    /**
     * Sequence of boards in a shortest solution; null if no solution
     * 
     * @return
     */
    public Iterable<Board> solution() {
        if (result == null)
            return null;
        Stack<Board> stk = new Stack<Board>();
        for (Node i = result; i != null; i = i.previous) {
            stk.push(i.board);
        }
        return stk;
    }

    /**
     * Solve a slider puzzle (given below)
     * 
     * @param args
     */
    public static void main(String[] args) {
        // create initial board from file
        In in = new In(args[0]);
        int N = in.readInt();
        int[][] blocks = new int[N][N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                blocks[i][j] = in.readInt();
        Board initial = new Board(blocks);

        // solve the puzzle
        Solver solver = new Solver(initial);

        // print solution to standard output
        if (!solver.isSolvable())
            StdOut.println("No solution possible");
        else {
            StdOut.println("Minimum number of moves = " + solver.moves());
            for (Board board : solver.solution())
                StdOut.println(board);
        }
    }
}