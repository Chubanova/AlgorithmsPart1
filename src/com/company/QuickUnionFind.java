package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class QuickUnionFind {
    List<Integer> elements = new ArrayList<>();

    public QuickUnionFind(int N) {
        for (int i = 0; i < N; i++) {
            elements.add(i);
        }
    }
 // Quick find
    public void union(int p, int q) {
        if (isConnected(p, q)) ;
        else {
            int p_components = elements.get(p);
            int q_components = elements.get(q);
            for (int i = 0; i < elements.size(); i++) {
                if(elements.get(i)==p_components){
                    elements.set(i, q_components);
                }
            }
        }

    }

    public int howManyComponents(){
        Set<Integer> uniqe = new TreeSet<>();
        uniqe.addAll(elements);
        return uniqe.size();
    }


    public boolean isConnected(int p, int q) {
        return elements.get(p) == elements.get(q);
    }

}
