package io.github.ktaekim2.sandbox;

public class MyArrayList {
    private int[] data;
    private int size;

    public MyArrayList() {
        this.data = new int[10];
        this.size = 0;
    }

    public void add(int value) {
        if(data.length == size) {
            resize();
        }
        data[size] = value;
        size++;
    }

    public int size() {
        return size;
    }

    public int get(int index) {
        checkIndex(index);
        return data[index];
    }

    private void resize() {
        int[] newData = new int[data.length * 2];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        this.data = newData;
    }

    public int remove(int index) {
        checkIndex(index);
        int removed = data[index];

        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
        data[size] = 0;
        return removed;
    }

    public int set(int index, int value) {
        checkIndex(index);
        int oldValue = data[index];
        data[index] = value;
        return oldValue;
    }

    public void add(int index, int value) {
        checkPositionIndex(index); // 0 <= index <= size

        if (size == data.length) {
            resize();
        }

        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }


        data[index] = value;
        size++;

    }

    private void checkPositionIndex(int index) {
        if(index < 0 || index > size) {
            throw new IndexOutOfBoundsException("index: " + index + ", size: " + size);
        }
    }

    private void checkIndex(int index) {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("index: " + index + ", size: " + size);
        }
    }


}
