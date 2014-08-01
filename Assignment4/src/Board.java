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
    private boolean isGoal;

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
        isGoal = false;
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
     * Gets the total hamming distances
     */
    private void getHamming() {
        if (hamming != -1)
            return;
        hamming = 0;
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                if (board[i][j] == 0)
                    continue;
                else if (board[i][j] != ((N * i) + (j + 1)))
                    hamming++;
    }

    /**
     * Sum of Manhattan distances between blocks and goal
     * 
     * @return
     */
    public int manhattan() {
        getManhattan();
        return this.manhattan;
    }

    /**
     * Gets the total manhattan distances
     */
    private void getManhattan() {
        if (manhattan != -1)
            return;
        manhattan = 0;
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 0)
                    continue;
                int row = (int) Math.ceil(board[i][j] * 1.0 / N) - 1;
                int col = (board[i][j] % N == 0 ? N : board[i][j] % 3) - 1;
                manhattan += Math.abs((row - i) + (col - j));
            }
    }

    /**
     * Is this board the goal board?
     * 
     * @return
     */
    public boolean isGoal() {
        checkBoard();
        return isGoal;
    }

    /**
     * Checks if the board is a goal board
     */
    private void checkBoard() {
        if (isGoal == true)
            return;
        if (manhattan() == 0)
            isGoal = true;
        else
            isGoal = false;
    }

    /**
     * A board obtained by exchanging two adjacent blocks in the same row
     * 
     * @return
     */
    public Board twin() {
        int[][] twin = this.board;
        int temp = twin[2][1];
        twin[2][1] = twin[2][2];
        twin[2][2] = temp;
        return new Board(twin);
    }

    /**
     * Does this board equal y?
     */
    public boolean equals(Object y) {
        if (y == this)
            return true;
        if (y == null)
            return false;
        if (y.getClass() != this.getClass())
            return false;
        Board that = (Board) y;
        return this.board == that.board;
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
        StringBuilder s = new StringBuilder();
        s.append(N + "\n");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                s.append(String.format("%2d ", board[i][j]));
            }
            s.append("\n");
        }
        return s.toString();
    }
}