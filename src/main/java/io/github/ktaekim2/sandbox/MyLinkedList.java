package io.github.ktaekim2.sandbox;

public class MyLinkedList {

    // inner class (data + next address)
    private static class Node {
        int item;
        Node next; // remote controller which indicates next node.

        Node(int item) {
            this.item = item;
            this.next = null;
        }
    }

    private Node head; // first node (head)
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

    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Node curr = this.head;

        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }

        return curr.item;
    }

    public void add(int index, int value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }

        Node prev = head;
        Node newNode = new Node(value);
        if(index == 0) {
            newNode.next = prev;
            this.head = newNode;
        } else {
        for (int i = 0; i < index - 1; i++) {
            prev = prev.next;
        }
        newNode.next = prev.next;
        prev.next = newNode;
    }
        size++;
    }

    public int size() {
        return size;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Node prev = head;

        if(index == 0) {
            this.head = head.next;
        } else {
        for (int i = 0; i < index - 1; i++) {
            prev = prev.next;
        }

        prev.next = prev.next.next;
    }
        size--;
    }}
