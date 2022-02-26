package Homework_3;

public class Main {
    public static void main(String[] args) {
        //задание 1
        Integer[] arr = {1, 2, 3, 4, 5, 6};
        Integer[] arr1 = {};
        Integer[] arr2 = {2, 3, 4, 5, 6};
        Integer[] arr3 = {1, 2, 3, 4, 5, 6, 8, 9, 10, 11, 12, 13};
        System.out.println("Missed number is " + Search.search(arr));
        System.out.println("Missed number is " + Search.search(arr1));
        System.out.println("Missed number is " + Search.search(arr2));
        System.out.println("Missed number is " + Search.search(arr3));

        //задание 2
        QueueImpl<Integer> queue = new QueueImpl<>(5);
        System.out.println(queue.insert(1));
        System.out.println(queue.insert(2));
        System.out.println(queue.insert(3));
        System.out.println(queue.insert(4));
        System.out.println(queue.insert(5));
        System.out.println(queue.insert(6));
        System.out.println(queue.insert(7));
        queue.remove();
        queue.remove();
        queue.remove();
        System.out.println(queue.insert(8));
        System.out.println(queue.insert(9));
        System.out.println(queue.insert(10));
        System.out.println(queue.insert(11));
        queue.display();
        //t, t, t, t, t, f, f, t, t, t, f, итог: [8, 9, 10, 4, 5]
        queue.remove();
        queue.remove();
        queue.remove();
        queue.display();
        //итог: [n, 9, 10, n, n]
    }
}
