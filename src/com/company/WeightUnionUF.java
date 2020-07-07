package com.company;
// Third Algorithm
public class WeightUnionUF {
    int[] id;
    int[] sizes;

    public WeightUnionUF(int n) {
        id = new int[n];
        sizes = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
            sizes[i] = 1;
        }
    }

    boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    private int root(int p) {
        while (p != id[p]) {
            id[p]=id[id[p]]; //FOURTH ALGORITHM
            p = id[p];
        }
        return p;
    }

    void union(int p, int q) {
        int pRoot = root(p);
        int qRoot = root(q);
        if (connected(p, q)) return;
        if (sizes[pRoot] > sizes[qRoot]) {
            id[qRoot] = pRoot;
            sizes[pRoot]+=sizes[qRoot];
        }else{
            id[pRoot] = qRoot;
            sizes[qRoot]+=sizes[pRoot];
        }
    }
}
