package Exe;

import java.util.Arrays;
import java.util.Random;

public class Exe3 {
    public static void main(String[] args) {
        final int N = 100;
        int[] arr = new int[N];
        int[] arr2 = new int[N];
        int[] arr3 = new int[N];
        Random random = new Random();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(9);
            arr2[i] = random.nextInt(9);
        }

        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr2));

        for (int i = arr.length - 1; i >= 0; i--) {
            arr3[i] += arr[i] + arr2[i];
            if (arr3[i] > 9) {
                arr3[i] -= 10;
                try {
                    arr3[i - 1] += 1;
                } catch (ArrayIndexOutOfBoundsException e) {
                    int[] newArr = new int[N + 1];
                    newArr[0] = 1;
                    System.arraycopy(arr3, 0, newArr, 1, N);
                    arr3 = newArr;
                }
            }
        }
        System.out.println(Arrays.toString(arr3));
    }
}
