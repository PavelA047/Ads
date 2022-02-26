package Homework_3;

public class Search {

    public static int search(Integer[] arr) {
        int start = 0;
        int end = arr.length - 1;
        int base;

        int i = 0;

        while (end >= start) {
            i++;
            base = (start + end) / 2;
            System.out.println("Base: " + base);

            if (arr[base] == base + 1) {
                start = base + 1;
            } else {
                end = base - 1;
            }
        }

        System.out.println("Кол-во итераций: " + i);
        return start + 1;
    }
}
