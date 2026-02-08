package io.github.ktaekim2.sandbox;

import java.util.ArrayList;
import java.util.List;

public class MyArrayList {
    private int[] data; // 진짜 데이터를 담을 기본 배열
    private int size; // 현재 몇 개 들어있는지

    public MyArrayList() {
        this.data = new int[10];
        this.size = 0;
    }

    public void add(int value) {

        // 1. check it is full
        if(size == data.length) {
            resize(); // move
        }
        data[size] = value;
        size++;
    }

    private void resize() {
        // 1. create two times bigger array
        int newCapacity = data.length * 2;
        int[] newData = new int[newCapacity];

        // 2. copy
        for (int i = 0; i < data.length; i++) {
            newData[i] = data[i];
        }

        List<Integer> a = new ArrayList<>();

        // 3. replace
        this.data = newData;
    }

    public int size() {
        return size;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return data[index];
    }
}
