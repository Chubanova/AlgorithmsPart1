package com.company.homework;


/**
 * Union-find with specific canonical element. Add a method \mathtt{find()}find() to the union-find data type so that
 * \mathtt{find(i)}find(i) returns the largest element in the connected component containing ii. The operations,
 * \mathtt{union()}union(), \mathtt{connected()}connected(), and \mathtt{find()}find() should all take logarithmic
 * time or better.
 * <p>
 * For example, if one of the connected components is \{1, 2, 6, 9\}{1,2,6,9},
 * then the \mathtt{find()}find() method should return 99 for each of the four elements in the connected components.
 */
public class WeightUnionUFLargest {
    public static void main(String[] args) {
        WeightUnionUFLargest w = new WeightUnionUFLargest(10);
        w.union(1,9);
        w.union(5,6);
        w.union(1,8);
        w.union(0,4);
        w.union(0,6);
        System.out.println(w.find(4));
        System.out.println(w.find(1));


    }

    int[] id;

    public WeightUnionUFLargest(int N) {
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    boolean isConnected(int p, int q) {
        return root(p) == root(q);
    }

    private int root(int q) {
        while (id[q] != q) {
            id[q] = id[id[q]];
            q = id[q];
        }
        return q;
    }

    void union(int p, int q) {
        int rootP = root(p);
        int rootQ = root(q);
        if (isConnected(p, q)) return;
        if (rootP > rootQ) {
            id[rootQ] = rootP;
        } else {
            id[rootP] = rootQ;
        }
    }

    int find(int p){
        return root(p);
    }

}
