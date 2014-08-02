import java.util.Arrays;

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
                int col = (board[i][j] % N == 0 ? N : board[i][j] % N) - 1;
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
        int[][] twin = new int[N][N];
        for (int i = 0; i < twin.length; i++) {
            for (int j = 0; j < twin.length; j++) {
                twin[i][j] = board[i][j];
            }
        }

        int i = 0;
        int j = 1;
        int p = 1;
        int q = 1;
        if (twin[i][j] == 0) {
            i = 1;
            j = 0;
        }
        if (twin[p][q] == 0) {
            p = 0;
            q = 0;
        }
        int temp = twin[i][j];
        twin[i][j] = twin[p][q];
        twin[p][q] = temp;
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
        return Arrays.equals(this.board, that.board);
    }

    /**
     * All neighboring boards
     * 
     * @return
     */
    public Iterable<Board> neighbors() {
        Stack<Board> stk = new Stack<Board>();
        getNeighbors(stk);
        return stk;
    }

    /**
     * Find the four neighbor boards. I like this piece of code BTW! ^_^
     * 
     * @param stk
     */
    private void getNeighbors(Stack<Board> stk) {
        int[][] map = { { -1, 1, 0, 0 }, { 0, 0, -1, 1 } };
        int row = 0;
        int col = 0;
        boolean found = false;
        for (int i = 0; i < N && !found; i++)
            for (int j = 0; j < N && !found; j++)
                if (board[i][j] == 0) {
                    row = i;
                    col = j;
                    found = true;
                }
        int[][] temp = new int[N][N];
        for (int i = 0; i < 4; i++) {
            temp = new int[N][N];
            for (int j = 0; j < temp.length; j++) {
                for (int j2 = 0; j2 < temp.length; j2++) {
                    temp[j][j2] = board[j][j2];
                }
            }
            if ((row + map[0][i] > -1) && (row + map[0][i] < N)
                    && (col + map[1][i] > -1) && (col + map[1][i] < N)) {
                int swap = 0;
                temp[row][col] = temp[row + map[0][i]][col + map[1][i]];
                temp[row + map[0][i]][col + map[1][i]] = swap;
                stk.push(new Board(temp));
            }
        }
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