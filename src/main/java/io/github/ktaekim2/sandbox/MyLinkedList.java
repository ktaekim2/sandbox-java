package io.github.ktaekim2.sandbox;

public class MyLinkedList {

    private static class Node {
        int item;
        Node next;

        Node(int item) {
            this.item = item;
            this.next = null;
        }
    }

    private Node head;
    private int size;

    public MyLinkedList() {
        this.head = null;
        this.size = 0;
    }

    public void add(int value) {
        if (head == null) {
            head = new Node(value);
        } else {
            Node curr = head;

            while (curr.next != null) {
                curr = curr.next;
            }

            curr.next = new Node(value);
        }

        size++;
    }

    public int size() {
        return size;
    }

    public int get(int index) {
        checkIndex(index);

        Node curr = this.head;

        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }

        return curr.item;

    }

    private void checkIndex(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException();
        }
    }

    public void remove(int index) {
        checkIndex(index);

        if (index == 0) {
            head = head.next;
            size--;
            return;
        }

        Node curr = this.head;

        for (int i = 0; i < index - 1; i++) {
            curr = curr.next;
        }

        curr.next = curr.next.next;
        size--;
    }
}
