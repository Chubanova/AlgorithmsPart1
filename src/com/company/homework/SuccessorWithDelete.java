package com.company.homework;

/**
 * Successor with delete. Given a set of nn integers S = \{ 0, 1, ... , n-1 \}S={0,1,...,n−1} and a sequence of requests of the following form:
 * <p>
 * Remove xx from SS
 * Find the successor of xx: the smallest yy in SS such that y \ge xy≥x.
 * design a data type so that all operations (except construction) take logarithmic time or better in the worst case.
 */
public class SuccessorWithDelete {
    int[] id;

    public SuccessorWithDelete(int N) {
        id= new int[N];
        for (int i = 0; i < N; i++) {
            id[i]=i;
        }
    }

    int removeX(int x){

        return 0;
    }
}
