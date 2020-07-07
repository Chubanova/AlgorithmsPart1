package com.company;

import java.util.Scanner;
//Second algorithm
public class QuickUnionUF {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int Connections = in.nextInt();
        QuickUnionUF unionUF = new QuickUnionUF(10);
        for (int i = 0; i < Connections; i++) {
            unionUF.union(in.nextInt(), in.nextInt());

        }
    }

    public int[] id;

    public QuickUnionUF(int n) {
        id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
    }

    int root(int i) {
        while (id[i] != i) {
            i=id[i];
        }
        return i;
    }


    boolean isConnected(int p, int q) {
        return root(p) == root(q);
    }

    void union(int p, int q) {
        int pRoot = root(p);
        int qRoot = root(q);
        id[pRoot] = qRoot;

    }
}
