import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private boolean[][] sites;
    private int rowCount;
    private int countSites;
    private int opens;
    private WeightedQuickUnionUF top;
    private WeightedQuickUnionUF all;
    private int sink;
    private int source;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        if (n > 0) {
            rowCount = n;
            countSites = n * n;
            sites = new boolean[rowCount][rowCount];
            all = new WeightedQuickUnionUF(countSites + 2); // includes virtual top bottom
            top = new WeightedQuickUnionUF(countSites + 1); // includes virtual top
            opens = 0;
            sink = countSites + 1;
            source = countSites;
        } else {
            throw new IllegalArgumentException();
        }
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        if (row > 0 && col > 0 && row <= rowCount && col <= rowCount) {
            if (!isOpen(row, col)) {
                sites[row - 1][col - 1] = true;
                opens++;
                int countOnOrder = encode(row, col);
                if (row == 1) {  // Top
                    all.union(source, countOnOrder);
                    top.union(source, countOnOrder);
                }

                if (row == rowCount) {  // Bottom
                    all.union(sink, countOnOrder);
                }

                // Left
                if (isActual(row, col - 1) && isOpen(row, col - 1)) {
                    all.union(countOnOrder, encode(row, col - 1));
                    top.union(countOnOrder, encode(row, col - 1));
                }

                //  Right
                if (isActual(row, col + 1) && isOpen(row, col + 1)) {
                    all.union(countOnOrder, encode(row, col + 1));
                    top.union(countOnOrder, encode(row, col + 1));
                }

                //  Up
                if (isActual(row - 1, col) && isOpen(row - 1, col)) {
                    all.union(countOnOrder, encode(row - 1, col));
                    top.union(countOnOrder, encode(row - 1, col));
                }

                //Down
                if (isActual(row + 1, col) && isOpen(row + 1, col)) {
                    all.union(countOnOrder, encode(row + 1, col));
                    top.union(countOnOrder, encode(row + 1, col));
                }


            } else {
                return;
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    private int encode(int row, int col) {
        return rowCount * (row - 1) + col-1;
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        if (row > 0 && col > 0 && row <= rowCount && col <= rowCount) {
            return sites[row - 1][col - 1];
        } else {
            throw new IllegalArgumentException();
        }
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        if (row > 0 && col > 0 && row <= rowCount && col <= rowCount) {
            return top.find(source) == top.find(encode(row, col)); // top.connected(source, encode(row,col));
        } else {
            throw new IllegalArgumentException();
        }
    }


    private boolean isActual(int row, int col) {
        return (row - 1 >= 0 && col - 1 >= 0 && row - 1 < rowCount && col - 1 < rowCount);
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return opens;
    }

    // does the system percolate?
    public boolean percolates() {
        return all.find(source) == all.find(sink);
    }


}