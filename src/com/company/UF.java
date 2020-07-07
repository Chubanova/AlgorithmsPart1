package com.company;
// First Algorhytm
public class UF {
    private int[]p;
    public UF(int n) {
        p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i]=i;
        }
    }

    boolean isConnected(int r, int t){
        return p[r]==p[t];
    }

    void union(int r, int t){
        int rid = p[r];
        int tid = p[t];
        for (int i = 0; i < p.length; i++) {
            if(p[i]==rid){
                p[i]=tid;
            }
        }
    }
}
