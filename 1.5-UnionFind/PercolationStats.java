import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
    private int trials;
    private double[] result;
    
    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials) {
        if (n <= 0 || trials <= 0) {
            throw new IllegalArgumentException("N and T must be positive number");
        }

        this.trials = trials;
        result = new double[trials];

        for (int i = 0; i < trials; i++) {
            Percolation percolation = new Percolation(n);
            int row, col;

            while (!percolation.percolates()) {
                row = StdRandom.uniformInt(0, n);
                col = StdRandom.uniformInt(0, n);

                if (percolation.isOpen(row, col)) {
                    continue;
                }

                percolation.open(row, col);
            }
            
            int openSite = percolation.numberOfOpenSites();
            result[i] = openSite / (n * n);
        }
    }

    // sample mean of percolation threshold
    public double mean() {
        return StdStats.mean(result);
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return StdStats.stddev(result);
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo() {
        return mean() - 1.96 * stddev() / Math.sqrt(trials);
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        return mean() + 1.96 * stddev() / Math.sqrt(trials);
    }

   // test client (see below)
   public static void main(String[] args) {
    
   }
}
