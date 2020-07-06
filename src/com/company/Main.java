package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        UnionFind unionFind = new UnionFind(10);
        Scanner in = new Scanner(System.in);
        int Connections = in.nextInt();
        for (int i = 0; i < Connections; i++) {
            unionFind.union(in.nextInt(), in.nextInt());
            System.out.println(unionFind.howManyComponents());

        }
        System.out.println(unionFind.howManyComponents());
        System.out.println(unionFind.elements);

    }
}
