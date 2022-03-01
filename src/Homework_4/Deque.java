package Homework_4;

import Homework_3.Queue;

public interface Deque<E> extends Queue<E> {
    boolean insertLeft(E value);

    boolean insertRight(E value);

    E removeLeft();

    E removeRight();
}
