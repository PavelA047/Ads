package Lesson_5;

public class BinarySearchRec {
    private int[] arr;
    private int size;

    public BinarySearchRec(int size) {
        this.size = 0;
        this.arr = new int[size];
    }

    public int binaryFind(int search) {
        return recBinaryFind(search, 0, size - 1);
    }

    private int recBinaryFind(int searchKey, int low, int high) {
        int curIn;
        curIn = (low + high) / 2;
        if (arr[curIn] == searchKey)
            return curIn;
        else if (low > high)
            return size;
        else {
            if (arr[curIn] < searchKey)
                return recBinaryFind(searchKey, curIn + 1, high);
            else
                return recBinaryFind(searchKey, low, curIn - 1);
        }
    }


    public void insert(int value) {
        int i;
        for (i = 0; i < this.size; i++) {
            if (this.arr[i] > value)
                break;
        }
        for (int j = this.size; j > i; j--) {
            this.arr[j] = this.arr[j - 1];
        }
        this.arr[i] = value;
        this.size++;
    }
}

