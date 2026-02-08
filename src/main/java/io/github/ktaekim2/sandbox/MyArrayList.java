package io.github.ktaekim2.sandbox;

public class MyArrayList {
    private int[] data;
    private int size;

    public MyArrayList() {
        this.data = new int[10];
        this.size = 0;
    }

    public void add(int val) {
        if(data.length == size) {
            this.resize();
        }
        data[size] = val;
        size++;
    }

    public int get(int index) {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return data[index];
    }

    public int size() {
        return size;
    }

    public void resize() {
        int[] newData = new int[size * 2];
        for(int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        this.data = newData;
    }

}
