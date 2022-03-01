package Lesson_5;

public class MyArrApp {
    public static void main(String[] args) {
        BinarySearchRec arr = new BinarySearchRec(10);
        arr.insert(-10);
        arr.insert(45);
        arr.insert(26);
        arr.insert(20);
        arr.insert(25);
        arr.insert(40);
        arr.insert(11);
        arr.insert(80);
        arr.insert(82);
        arr.insert(91);

        int search = 91;


        System.out.println(arr.binaryFind(search));
    }

}
