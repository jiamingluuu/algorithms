import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private boolean[][] grid;
    private WeightedQuickUnionUF wqfGrid;
    private int gridSize;
    private int openSite;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        this.grid = new boolean[n][n];
        this.wqfGrid = new WeightedQuickUnionUF(n * n + 2);  // includes virtual top and bottom 
        this.gridSize = n;
        this.openSite = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = false;
            }
        }
    }
    
    private boolean isValidSite(int row, int col) {
        return (0 <= row && row < gridSize) && (0 <= col && col < gridSize);
    }

    private int getIndex(int row, int col) {
        return row * gridSize + col + 1;
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        if (!isValidSite(row, col))             return;
        if (isOpen(row, col))                   return;

        int center = getIndex(row, col);
        openSite++;
        grid[row][col] = true;
        
        if (row == 0) {
            wqfGrid.union(0, center);
        }
        
        if (row == gridSize - 1) {
            wqfGrid.union(gridSize * gridSize + 1, center);
        }

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
        
        return grid[row][col];
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
//        StdOut.println(wqfGrid.find(0) == wqfGrid.find(gridSize * gridSize + 1));
//        StdOut.println(this);
//        StdOut.println("-------------------------------");
        return wqfGrid.find(0) == wqfGrid.find(gridSize * gridSize + 1);
    }
    
//    @Override
//    public String toString() {
//        String str = "";
//        for (int i = 0; i < gridSize; i++) {
//            for (int j = 0; j < gridSize; j++) {
//                if (grid[i][j]) {
//                    str += "1 ";
//                }
//                else {
//                    str += "0 ";
//                }
//            }
//            str += "\n";
//        }
//
//        return str;
//    }
//    
//    public static void main(String[] args) {
//        Percolation p = new Percolation(3);
//        p.open(0, 0);
//        p.percolates();
//        p.open(1, 0);
//        p.percolates();
//        p.open(1, 1);
//        p.percolates();
//        p.open(2, 1);
//        p.percolates();
//        
//    }
}