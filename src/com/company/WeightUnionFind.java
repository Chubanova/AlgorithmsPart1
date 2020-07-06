package com.company;

public class WeightUnionFind {
    Integer[] elements;

    public WeightUnionFind(int N) {
        elements = new Integer[N];
        for (int i = 0; i < N; i++) {
            elements[i]= i;
        }
    }

    public boolean isConnected(int p, int q){
        return isRoot(p)==isRoot(q);
    }

    public int isRoot(int p){
        while (p!=elements[p])
            p= elements[p];
        return p;
    }

    public void union(int p, int q){
       int i= isRoot(p);
       int j= isRoot(q);
       if(i==j)return;
       else {elements[i]<elements[j]}
       elements[i]=j;
    }
}
