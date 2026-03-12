package io.github.ktaekim2.sandbox;

public class MyHashMap {

    private static final int BUCKET_SIZE = 769; // prime number
    private final Node[] buckets = new Node[BUCKET_SIZE];

    private static class Node {
        int key;
        int value;
        Node next;

        Node(int key, int value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    private int index(int key) {
        return Math.floorMod(key, BUCKET_SIZE);
    }

    public MyHashMap() {
    }

    public void put(int key, int value) {
        int idx = index(key);
        Node cur = buckets[idx];

        while (cur != null) {
            if (cur.key == key) {
                cur.value = value;
                return;
            }
            cur = cur.next;
        }

        buckets[idx] = new Node(key, value, buckets[idx]);
    }

    public int get(int key) {
        int idx = index(key);
        Node cur = buckets[idx];

        while (cur != null) {
            if (cur.key == key) {
                return cur.value;
            }
            cur = cur.next;
        }

        return -1;
    }

    public void remove(int key) {
        int idx = index(key);
        Node cur = buckets[idx];
        Node prev = null;

        while (cur != null) {

            if (cur.key == key) {
                if (prev == null) {
                    buckets[idx] = cur.next;
                } else {
                    prev.next = cur.next;
                }

                return;
            }

            prev = cur;
            cur = cur.next;

        }

    }
}
