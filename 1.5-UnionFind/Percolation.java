import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private boolean[] grid;
    private WeightedQuickUnionUF wqfGrid;
    private int gridSize;
    private int openSite;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        openSite = 0;
        grid = new boolean[n * n];
        gridSize = n;
        wqfGrid = new WeightedQuickUnionUF(n * n + 2);  // includes two 

        for (int i = 0; i < n * n; i++)
            grid[i] = false;
        
        for (int i = 0; i < n; i++) {
            wqfGrid.union(0, i);
            wqfGrid.union(n * n + 1, n * (n - 1) + i);
        }
    }
    
    private boolean isValidSite(int row, int col) {
        return (0 <= row && row < gridSize)
            && (0 <= col && col < gridSize);
    }

    private int getIndex(int row, int col) {
        return (row - 1) * gridSize + col - 1;
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        if (!isValidSite(row, col))             return;
        if (isOpen(row, col))                   return;

        openSite++;
        int center = getIndex(row, col);
        grid[center] = true;

        if (isValidSite(row - 1, col) && isOpen(row - 1, col)) {
            int above = getIndex(row - 1, col);
            wqfGrid.union(above, center);
        }
        
        if (isValidSite(row + 1, col) && isOpen(row + 1, col)) {
            int below = getIndex(row + 1, col);
            wqfGrid.union(below, center);
        }

        if (isValidSite(row, col - 1) && isOpen(row, col - 1)) {
            int left = getIndex(row, col - 1);
            wqfGrid.union(left, center);
        }
        
        if (isValidSite(row, col + 1) && isOpen(row, col + 1)) {
            int right = getIndex(row, col + 1);
            wqfGrid.union(right, center);
        }
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        if (!isValidSite(row, col))             return false;
        
        int index = getIndex(row, col);
        return grid[index];
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        if (!isValidSite(row, col))             return false;

        int index = getIndex(row, col);
        return wqfGrid.find(index) == wqfGrid.find(0);
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return openSite;
    }

    // does the system percolate?
    public boolean percolates() {
        return wqfGrid.find(0) == wqfGrid.find(gridSize * gridSize + 1);
    }

    // test client (optional)
    public static void main(String[] args) {

    }
}