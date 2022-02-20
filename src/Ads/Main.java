package Ads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    private static Long time;
    private static final int COUNT = 10000;

    public static void startTime() {
        time = System.currentTimeMillis();
    }

    public static void endTime() {
        time = System.currentTimeMillis() - time;
        System.out.println("time of sort: " + time);
    }

    public static void main(String[] args) {
        Integer[] arrCost = IntArr.getArray(COUNT, 50, 500, 2000);
        Integer[] arrMemory = IntArr.getArray(COUNT, 4, 4, 24);
        List<Manufacturer> manufacturerList = new ArrayList<>(Arrays.asList(Manufacturer.values()));
        int n = 0;

        Notebook[] notebooks = new Notebook[COUNT];
        for (int i = 0; i < COUNT; i++) {
            notebooks[i] = new Notebook();
        }

        for (int i = 0; i < notebooks.length; i++) {
            notebooks[i].setCost(arrCost[i]);
        }
        for (int i = 0; i < notebooks.length; i++) {
            notebooks[i].setMemory(arrMemory[i]);
        }
        for (Notebook notebook : notebooks) {
            if (n >= manufacturerList.size()) {
                n = 0;
            }
            notebook.setManufacturer(manufacturerList.get(n));
            n++;
        }

        // 1 задание
        Arrays.sort(notebooks);
        Arrays.stream(notebooks).forEach(System.out::println);

        // 2 задание
        Integer[] arrSelectionSort = IntArr.getArray(20, 2, 0, 20);
        startTime();
        MySelectionSort.sort(arrSelectionSort);
        endTime();
    }
}
