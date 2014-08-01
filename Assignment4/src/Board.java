/**
 * 
 * @author Ahmed Gaber
 * 
 */
public class Board {
    /**
     * Construct a board from an N-by-N array of blocks (where blocks[i][j] =
     * block in row i, column j)
     * 
     * @param blocks
     */
    public Board(int[][] blocks) {
    }

    /**
     * board dimension N
     * 
     * @return
     */
    public int dimension() {
    }

    /**
     * number of blocks out of place
     * 
     * @return
     */
    public int hamming() {
    }

    /**
     * sum of Manhattan distances between blocks and goal
     * 
     * @return
     */
    public int manhattan() {
    }

    /**
     * is this board the goal board?
     * 
     * @return
     */
    public boolean isGoal() {
    }

    /**
     * a board obtained by exchanging two adjacent blocks in the same row
     * 
     * @return
     */
    public Board twin() {
    }

    /**
     * does this board equal y?
     */
    public boolean equals(Object y) {
    }

    /**
     * all neighboring boards
     * 
     * @return
     */
    public Iterable<Board> neighbors() {
    }

    /**
     * string representation of the board (in the output format specified below)
     */
    public String toString() {
    }
}