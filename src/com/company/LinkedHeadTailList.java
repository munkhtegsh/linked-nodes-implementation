package com.company;

import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.List;

public class LinkedHeadTailList<T extends Comparable<? super T>> implements HeadTailListInterface<T>, Comparable<LinkedHeadTailList<T>> {
    private Node head, tail;
    private int entries = 0;

    public LinkedHeadTailList() {
        this(null, null);
    }

    public LinkedHeadTailList(Node head, Node last) {
        this.head = head;
        this.tail = last;
    }

    @Override
    public void addFront(T newEntry) {
        Node newNode = new Node(newEntry);

        if (isEmpty()) {
            head = newNode;
            tail = newNode;
            entries++;
        } else {
            newNode.next = head;
            head.prev = new Node(newEntry);
            head = newNode;
            entries++;
        }
    }

    @Override
    public void addBack(T newEntry) {
        Node newNode = new Node(newEntry);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
            entries++;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
            entries++;
        }
    }

    @Override
    public T removeFront() {
        if (isEmpty()) {
            return null;
        } else if (isSingleton()) {
            T removedEntry = head.data;
            head = null;
            tail = null;
            entries--;
            return removedEntry;
        } else {
            T removedEntry = head.data;
            head = head.next;
            head.prev = null;
            entries--;
            return removedEntry;
        }
    }

    @Override
    public T removeBack() {
        if (isEmpty()) {
            return null;
        } else if (isSingleton()) {
            T removedEntry = head.data;
            head = null;
            tail = null;
            entries--;
            return removedEntry;
        } else {
            T removedEntry = tail.data;
            tail = tail.prev;
            tail.next = null;
            entries--;
            return removedEntry;
        }
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        entries = 0;
    }

    @Override
    public T getEntry(int givenPosition) {
        Node current = head;
        int idx = 0;

        while (current != null) {
            if (idx == givenPosition) {
                return current.data;
            }
            current = current.next;
            idx++;
        }
        return null;
    }

    @Override
    public void display() {
//        System.out.println("ENTRIES: " + entries);
        if (head == null) {
            System.out.println("[]");
        } else {
            List<T> data = new ArrayList<>();

            if (head != null) {
                Node current = head;
                while (current != null) {
                    data.add(current.data);
                    current = current.next;
                }
            }

            System.out.println(data + "   head=" + head.data + " tail=" + tail.data);
        }
    }

    @Override
    public int indexOf(T anEntry) {
        if (isEmpty()) {
            return -1;
        }

        Node current = head;
        int idx = 0; // is it ==>> Note: For full credit, do not add any additional instance data variables. In particular, do not add a counter variable! (The purpose of this project is to get more practice with  nodes, not keeping count!)
        while (current != null) {
            if (current.data.equals(anEntry)) {
                return idx;
            }
            current = current.next;
            idx++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(T anEntry) {
        if (isEmpty()) {
            return -1;
        }

        Node current = tail;
        int idx = entries - 1;
        while (current != null) {
            if (current.data.equals(anEntry)) {
                return idx;
            }
            current = current.prev;
            idx--;
        }
        return idx;
    }

    @Override
    public boolean contains(T anEntry) {
        Node current = head;
        while (current != null) {
            if (current.data.equals(anEntry)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public int size() {
        return entries;
    }

    @Override
    public boolean isEmpty() {
        if (head == null) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isSingleton() {
        if (head.next == null) {
            return true;
        } else {
            return false;
        }
    }

    public int compareTo(LinkedHeadTailList<T> obj) {
       return 0;
    }

    // YOUR CLASS HERE!


    private class Node {
        private T data;
        private Node next;
        private Node prev;

        private Node(T dataPortion) {
            data = dataPortion;
            next = null;
            prev = null;
        }

        private Node(T dataPortion, Node nextNode, Node prevNode) {
            data = dataPortion;
            next = nextNode;
            prev = prevNode;
        }

        private T getData() {
            return data;
        }

        private void setData(T newData) {
            data = newData;
        }

        private Node getNextNode() {
            return next;
        }

        private void setNextNode(Node nextNode) {
            next = nextNode;
        }

        private Node getPrevNode() {
            return prev;
        }

        private void setPrevNode(Node prevNode) {
            prev = prevNode;
        }
    }
}
