package Homework_5;

import java.util.ArrayList;

public class Bag {

    public static ArrayList<Integer> fillTheBag(int capacity, Things... things) {
        int[] weights = new int[capacity];
        int[] prices = new int[capacity];
        int l = 0;

        for (Things t : things) {
            weights[l] = t.weight;
            prices[l] = t.cost;
            l++;
        }

        int count = things.length;

        int[][] A;
        A = new int[count + 1][];
        for (int i = 0; i < count + 1; i++) {
            A[i] = new int[capacity + 1];
        }

        for (int k = 0; k <= count; k++) {
            for (int s = 0; s <= capacity; s++) {
                if (k == 0 || s == 0) {
                    A[k][s] = 0;
                } else {
                    if (s >= weights[k - 1]) {
                        A[k][s] = Math.max(A[k - 1][s], A[k - 1][s - weights[k - 1]] + prices[k - 1]);
                    } else {
                        A[k][s] = A[k - 1][s];
                    }
                }
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        traceResult(A, weights, count, capacity, result);
        return result;
    }

    private static void traceResult(int[][] A, int[] weight, int k, int s, ArrayList<Integer> result) {
        if (A[k][s] == 0) {
            return;
        }
        if (A[k - 1][s] == A[k][s]) {
            traceResult(A, weight, k - 1, s, result);
        } else {
            traceResult(A, weight, k - 1, s - weight[k - 1], result);
            result.add(0, k);
        }
    }
}
