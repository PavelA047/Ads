package Ads;

import java.util.Random;

public class IntArr {
    private static final Random random = new Random();
    public static boolean isRepeat = true;
    public static boolean isShuffle = true;

    public static Integer[] getArray(int length, int gapElements, int firstElement, int lastElement) {
        Integer[] arr = new Integer[length];
        arr[0] = firstElement;
        for (int i = 1; i < length; i++) {
            arr[i] = arr[i - 1] + random.nextInt(gapElements + 1) + ((isRepeat) ? 0 : 1);
            if (arr[i] > lastElement) {
                arr[i] = firstElement;
            }
        }
        if (isShuffle) {
            shuffleArray(arr);
        }
        return arr;
    }

    public static void shuffleArray(Integer[] arr) {
        if (!isShuffle) {
            return;
        }
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int change = i + random.nextInt(n - i);
            swap(arr, i, change);
        }
    }

    private static void swap(Integer[] a, int i, int change) {
        int temp = a[i];
        a[i] = a[change];
        a[change] = temp;
    }
}
