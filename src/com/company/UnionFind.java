package com.company;


public class UnionFind {
    Integer[] elements;

    public UnionFind(int n) {
        elements = new Integer[n];
        for (int i = 0; i < n; i++) {
            elements[i] = i;
        }
    }

    public boolean isConnected(int p, int q) {
        return root(p) == root(q);
    }

    public void union(int p, int q) {
        int i = root(p);
        int j = root(q);
        elements[i]= j;
    }

    public int root(int p) {
        while (p != elements[p])
            p = elements[p];
        return p;
    }
}
