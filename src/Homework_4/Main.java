package Homework_4;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        //задание 1 - remove last
        TwoSideLinkedListImpl<Integer> linkedList = new TwoSideLinkedListImpl<>();
        linkedList.insertFirst(1);
        linkedList.insertFirst(2);
        linkedList.insertFirst(3);
        linkedList.insertFirst(4);
        linkedList.insertFirst(5);
        linkedList.insertFirst(6);
        linkedList.insertFirst(7);
        linkedList.insertFirst(8);
        linkedList.insertLast(9);
        linkedList.insertLast(10);
        linkedList.insertLast(11);
        linkedList.display();
        linkedList.removeLast();
        linkedList.display();
        linkedList.removeLast();
        linkedList.display();

        //задание 2 - insert (2 methods)
        TwoSideLinkedListImpl<Integer> linkedList2 = new TwoSideLinkedListImpl<>();
        linkedList2.insert(1);
        linkedList2.insert(2);
        linkedList2.insert(3);
        linkedList2.insert(4);
        linkedList2.insert(3, 5);
        linkedList2.insert(5, 6);
        linkedList2.insert(100, 6); //return
        linkedList2.display();

        LinkedDeque<Integer> linkedDeque = new LinkedDeque<>();
        linkedDeque.insert(1);
        linkedDeque.insert(2);
        linkedDeque.insert(3);
        linkedDeque.insertLeft(5);
        linkedDeque.insertRight(4);
        linkedDeque.display();
        linkedDeque.removeLeft();
        linkedDeque.removeRight();
        linkedDeque.display();
        linkedDeque.remove();
        linkedDeque.display();
        System.out.println(linkedDeque.peekFront());

        //3 задание - iterator
        SimpleLinkedListImpl<Integer> list = new SimpleLinkedListImpl<>();
        list.insertFirst(1);
        list.insertFirst(2);
        list.insertFirst(3);
        list.insertFirst(4);
        list.insertFirst(5);
        list.display();
        for (Integer integer : list) {
            System.out.println("value: " + integer);
        }
        Iterator<Integer> iterator = list.iterator();
        System.out.println(iterator.next()); //5
        System.out.println(iterator.hasNext()); //t
        System.out.println(iterator.next()); //4
        System.out.println(iterator.hasNext()); //t
        System.out.println(iterator.next()); //3
        System.out.println(iterator.hasNext()); //t
        System.out.println(iterator.next()); //2
        System.out.println(iterator.hasNext()); //t
        System.out.println(iterator.next()); //1
        System.out.println(iterator.hasNext()); // exception
        //iterator.reset(); ??????? (не работает метод)
    }
}
