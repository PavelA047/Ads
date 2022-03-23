package Homework_6;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    private static int balancedCount;
    private static boolean balanced;

    public static void main(String[] args) {
        Random random = new Random();

        List<TreeImpl<Integer>> treeList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            treeList.add(new TreeImpl<>());
        }

        treeList.forEach(e -> {
            for (int i = 0; i < 15; i++) {
                e.add(random.nextInt(51) - 25);
            }
        });

        treeList.forEach(e -> {
            e.display();
            balanced = Node.isBalanced(e.getRoot());
            if (balanced) {
                balancedCount++;
            }
            System.out.println(balanced);
        });
        System.out.println("___________________________________________________________________");
        System.out.println("Balanced trees: " + balancedCount * 100 / treeList.size() + "%");
    }
}
