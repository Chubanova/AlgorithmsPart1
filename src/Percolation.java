public class Percolation {
    boolean[][] sites;
    int size;
    int opens = 0;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        if (n > 0) {
            size = n;
            sites = new boolean[n][n];
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    sites[i][j] = false;
                }
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        if (row > 0 && col > 0 && row <= size && col <= size) {
            if (!isOpen(row, col)) {
                sites[row][col] = true;
                opens++;
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        if (row > 0 && col > 0 && row <= size && col <= size) {
            return sites[row][col];
        } else {
            throw new IllegalArgumentException();
        }
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        if (row > 0 && col > 0 && row <= size && col <= size) {
            return false;
        } else {
            throw new IllegalArgumentException();
        }
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return opens;
    }

    // does the system percolate?
    public boolean percolates() {
        return false;
    }



    // test client (optional)
    public static void main(String[] args) {


    }
}