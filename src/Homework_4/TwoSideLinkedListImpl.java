package Homework_4;

public class TwoSideLinkedListImpl<E> extends SimpleLinkedListImpl<E> implements TwoSideLinkedList<E> {

    protected Node<E> last;

    @Override
    public void insertFirst(E value) {
        super.insertFirst(value);
        if (size == 1) {
            last = first;
        }
    }

    @Override
    public void insertLast(E value) {
        if (isEmpty()) {
            insertFirst(value);
            return;
        }

        last.next = last = new Node<>(value, null);
        size++;
    }

    @Override
    public E removeFirst() {
        E removedValue = super.removeFirst();

        if (isEmpty()) {
            last = null;
        }

        return removedValue;
    }

    public E removeLast() {
        Node<E> prev = null;
        Node<E> current = first;

        if (isEmpty()) {
            return null;
        }

        while (current != last) {
            prev = current;
            current = current.next;
        }

        if (current == first) {
            return removeFirst();
        }

        last = prev;
        last.next = null;
        size--;
        return current.item;
    }

    public void insert(E valueToAdd) {
        super.insertFirst(valueToAdd);
        if (size == 1) {
            last = first;
        }
    }

    public void insert(E value, E valueToAdd) {
        Node<E> current;
        if (isEmpty()) {
            super.insertFirst(valueToAdd);
            if (size == 1) {
                last = first;
            }
        } else {
            current = first;
            while (current != null) {
                if (current.item.equals(value)) {
                    break;
                }
                current = current.next;
            }
            if (current == null) {
                return;
            }
            current.next = new Node<>(valueToAdd, current.next);
            size++;
        }
    }

    @Override
    public boolean remove(E value) {
        Node<E> prev = null;
        Node<E> current = first;

        while (current != null) {
            if (current.item.equals(value)) {
                break;
            }
            prev = current;
            current = current.next;
        }

        if (current == null) {
            return false;
        }

        if (current == first) {
            removeFirst();
            return true;
        }
        if (current == last) {
            last = prev;
            last.next = null;
        }

        prev.next = current.next;
        current.next = null;
        size--;

        return true;
    }

    @Override
    public E getLast() {
        return last.item;
    }
}
