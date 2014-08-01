/**
 * @author Ahmed Gaber
 *
 */
public class Percolation {

 private int N;
 private boolean[][] grid;
 private WeightedQuickUnionUF UFU;
 private WeightedQuickUnionUF UFL;
 private boolean percolates;

 /**
 * create N-by-N grid, with all sites blocked
 * 
 * @param N
 */
 public Percolation(int N) {
    if (N <= 0)
        throw new IllegalArgumentException("Wrong grid size!"); 
    this.N = N;
    this.grid = new boolean[N][N];
    this.UFU = new WeightedQuickUnionUF(N*N + 2);
    this.UFL = new WeightedQuickUnionUF(N*N + 2);
    this.percolates = false;
 }

 /**
 * open site (row i, column j) if it is not already
 * 
 * 
 * @param i
 * @param j
 */
 public void open(int i, int j) {
    checkValidity(i, j);
    if (!grid[i-1][j-1])
    grid[i-1][j-1] = true;
    checkAdjacents(i-1, j-1);
 }

/**
 * is site (row i, column j) open?
 * 
 * @param i
 * @param j
 * @return
 */
 public boolean isOpen(int i, int j) {
    checkValidity(i, j);
    return grid[i-1][j-1];
}

 /**
 * is site (row i, column j) full?
 * 
 * @param i
 * @param j
 * @return
 */
 public boolean isFull(int i, int j) {
    checkValidity(i, j);
    return UFU.connected(0, getID(i-1, j-1));
 }

 /**
 * does the system percolate?
 * 
 * @return
 */
 public boolean percolates() {
    percolates = UFU.connected(0, N*N+1);
    return percolates;
 }
 
 /**
  * Gets the right adjacent cell 
  * @param col
  * @return
  */
 private int getRight(int col) {
    if (col+1 < N)
        return col+1;
    return -1;
 }
 
 /**
  * Gets the left adjacent cell
  * @param col
  * @return
  */
 private int getLeft(int col) {
    if (col-1 >= 0)
        return col-1;
    return -1;
 }
 
 /**
  * Gets the upper adjacent cell
  * @param row
  * @return
  */
 private int getUpper(int row) {
    if (row-1 >= 0)
        return row-1;
    return -1;
 }
 
 /**
  * Gets the lower adjacent cell
  * @param row
  * @return
  */
 private int getlower(int row) {
    if (row+1 < N)
        return row+1;
    return -1;
 }
 
 /**
  * Converts the 2D array index into a 1D array index
  * @param row
  * @param col
  * @return
  */
 private int getID(int row, int col) {
     return row * N + col + 1;
 }
 
 /**
  * check the four adjacent cells, if any one is open, then do the union operation 
  * between current cell and it's open adjacent cell. If there is a path between
  * the first and the last rows, then the system percolates.
  * @param i row
  * @param j column
  */
 private void checkAdjacents(int i, int j) {
    int left = getLeft(j);
    int right = getRight(j);
    int upper = getUpper(i);
    int lower = getlower(i);
    int id = getID(i, j);

    if (left != -1 && grid[i][left]) {
        UFU.union(id, getID(i, left));
        UFL.union(id, getID(i, left));
    }
    if (right != -1 && grid[i][right]) {
        UFU.union(id, getID(i, right));
        UFL.union(id, getID(i, right));
    }
    if (upper != -1 && grid[upper][j]) {
        UFU.union(id, getID(upper, j));
        UFL.union(id, getID(upper, j));
    }
    if (lower != -1 && grid[lower][j]) {
        UFL.union(id, getID(lower, j));
        UFU.union(id, getID(lower, j));
    }
    if (i == 0)
        UFU.union(id, 0);
    if (i == N-1)
        UFL.union(id, N*N + 1);
    if (UFU.connected(id, 0) && UFL.connected(id, N*N+1))
        UFU.union(0, N*N+1);
 }
 
 private void checkValidity(int i, int j) {
    if (i <= 0 || i > N) 
        throw new IndexOutOfBoundsException("row index "+ i +" out of bounds");
    if (j <= 0 || j > N) 
         throw new IndexOutOfBoundsException("column index " + j +" out of bounds");
}
}
