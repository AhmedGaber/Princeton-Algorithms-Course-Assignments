/**
 * 
 * @author Ahmed Gaber
 * 
 */
public class Board {
    private int[][] board;
    private int N;
    private int hamming;
    private int manhattan;

    /**
     * Construct a board from an N-by-N array of blocks (where blocks[i][j] =
     * block in row i, column j)
     * 
     * @param blocks
     */
    public Board(int[][] blocks) {
        this.board = blocks;
        this.N = board.length;
        this.hamming = -1;
        this.manhattan = -1;
    }

    /**
     * Board dimension N
     * 
     * @return
     */
    public int dimension() {
        return N;
    }

    /**
     * Number of blocks out of place
     * 
     * @return
     */
    public int hamming() {
        getHamming();
        return this.hamming;
    }

    /**
     * Gets the total hamming cost.
     */
    private void getHamming() {
        if (hamming != -1)
            return;
        hamming = 0;
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                if (board[i][j] != ((N * i) + (j + 1)))
                    hamming++;
        hamming--;

    }

    /**
     * Sum of Manhattan distances between blocks and goal
     * 
     * @return
     */
    public int manhattan() {
        return this.manhattan;
    }

    /**
     * Is this board the goal board?
     * 
     * @return
     */
    public boolean isGoal() {
    }

    /**
     * A board obtained by exchanging two adjacent blocks in the same row
     * 
     * @return
     */
    public Board twin() {
    }

    /**
     * Does this board equal y?
     */
    public boolean equals(Object y) {
    }

    /**
     * All neighboring boards
     * 
     * @return
     */
    public Iterable<Board> neighbors() {
    }

    /**
     * String representation of the board (in the output format specified below)
     */
    public String toString() {
        // StringBuilder s = new StringBuilder();
        // s.append(N + "\n");
        // for (int i = 0; i < N; i++) {
        // for (int j = 0; j < N; j++) {
        // s.append(String.format("%2d ", tiles[i][j]));
        // }
        // s.append("\n");
        // }
        // return s.toString();
    }
}