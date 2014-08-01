/**
 * @author Ahmed Gaber
 * 
 */
 public class PercolationStats {
 private double[] fractions;
 private int T;
 private double mean;
 private double stddev;
 private double confidenceLo;
 private double confidenceHi;
 
 /**
 * perform T independent computational experiments on an N-by-N grid
 * 
 * @param N
 * @param T
 */
 public PercolationStats(int N, int T) {
    if (N <= 0 || T <= 0)
        throw new java.lang.IllegalArgumentException(
                "Invalid input, N and T must be > 0");
    // this.N = N;
    this.T = T;
    this.mean = 0.0;
    this.stddev = 0.0;
    this.confidenceLo = 0;
    this.confidenceHi = 0;
    this.fractions = new double[T]; 
 }

 /**
 * sample mean of percolation threshold
 * 
 * @return
 */
 public double mean() {
    mean =  StdStats.mean(fractions);
    return mean;
 }

 /**
 * sample standard deviation of percolation threshold
 * 
 * @return
 */
 public double stddev() {
     stddev = StdStats.stddev(fractions);
     return stddev;
 }

 /**
 * returns lower bound of the 95% confidence interval
 * 
 * @return
 */
 public double confidenceLo() {
     confidenceLo = mean - ((1.96 * Math.sqrt(stddev)) / Math.sqrt(T));
     return confidenceLo;
 }
 
 /**
 * returns upper bound of the 95% confidence interval
 * 
 * @return
 */
 public double confidenceHi() {
     confidenceHi = mean + ((1.96 * Math.sqrt(stddev)) / Math.sqrt(T));
     return confidenceHi;
 }

 /**
 * test client, takes two inputs, N and T, and do T runs on a N*N grid
 * then calculates the mean standard devision and confidence interval.
 * 
 * @param args
 */
 public static void main(String[] args) { 
    while (StdIn.hasNextChar()) {
           int n = StdIn.readInt();
           int t = StdIn.readInt();
           PercolationStats ps = new PercolationStats(n, t);
                doLogic(n, t, ps);  
           StdOut.println("mean                    = " + ps.mean());
           StdOut.println("stddev                  = " + ps.stddev());
           StdOut.println("95% confidence interval = " 
           + ps.confidenceLo() + ", " + ps.confidenceHi());
    } 
 }
 
 
 private static void doLogic(int n, int t, PercolationStats ps) {
          int opensiets = 0;
          for (int i = 0; i < t; i++) {
               Percolation per = new Percolation(n);
               while (!per.percolates()) {
                      int p = StdRandom.uniform(1, n+1);
                      int q = StdRandom.uniform(1, n+1);
                      if (!per.isOpen(p, q))
                          opensiets++;
                      per.open(p, q);
               }
               ps.fractions[i] = opensiets * 1.0 / (n*n);
          }
 }
 
}