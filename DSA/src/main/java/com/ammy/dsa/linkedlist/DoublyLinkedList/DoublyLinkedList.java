package com.ammy.dsa.linkedlist.DoublyLinkedList;

public class DoublyLinkedList {

    DoublyLinkedNode head;
    DoublyLinkedNode tail;
    DoublyLinkedNode prev;

    int totalNodes;

    // [1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9 -> 10]
    public void add(Object data) {
        DoublyLinkedNode node = new DoublyLinkedNode(data);
        if (head == null) {
            head = node;
            prev = node;
        } else {
            prev.next = node;
            node.prev = prev;
            prev = node;
            tail = node;
        }
        totalNodes++;
    }

    public int size() {
        return totalNodes;
    }

    public void addNode(Object data, int index) {
        DoublyLinkedNode node = head;
        DoublyLinkedNode newNode = new DoublyLinkedNode(data);
        for (int i = -1; i < index - 2; i++) {
            node = node.next;
        }
        DoublyLinkedNode nextNode = node.next;
        node.next = newNode;
        newNode.prev = node;
        newNode.next = nextNode;
        nextNode.prev = newNode;
        totalNodes++;
    }

    public void addTailNode(Object data) {
        DoublyLinkedNode node = head;
        DoublyLinkedNode newNode = new DoublyLinkedNode(data);
        while (node.next != null) {
            node = node.next;
        }
        node.next = newNode;
        newNode.prev = node;
        totalNodes++;
    }

    // [2 -> 3 -> 4 -> 5 -> 500 -> 100 -> 6 -> 7 -> 8 -> 9]
    public void deleteNode(int index) {
        if (index < 0 || index > size()) {
            throw new RuntimeException("Invalid index passed : " + index);
        }
        DoublyLinkedNode node = head;
        for (int i = 0; i < index - 1; i++) {
            node = node.next;
        }
        DoublyLinkedNode nextNode = node.next.next;
        nextNode.prev = node;
        node.next = nextNode;
        totalNodes--;
    }

    public DoublyLinkedNode get(int index) {
        DoublyLinkedNode node = head;
        for (int i = -1; i < index - 1; i++) {
            node = node.next;
        }
        return node;
    }

    public void removeHead() {
        DoublyLinkedNode second = head.next;
        second.prev = null;
        head = second;
        totalNodes--;
    }

    public void removeTail() {
        DoublyLinkedNode last = tail;
        DoublyLinkedNode secondLast = last.prev;
        secondLast.next = null;
        tail = secondLast;
        totalNodes--;
    }

    public Object toString(DoublyLinkedNode node) {
        System.out.println(node.data);
        return node.data;
    }

    @Override
    public String toString() {
        DoublyLinkedNode node = head;
        StringBuilder result = new StringBuilder();
        result.append("[");
        while (node != null) {
            result.append(node.data);
            if (node.next != null) {
                result.append(" -> ");
            }
            node = node.next;
        }
        result.append("]");
        System.out.println(result.toString());
        return result.toString();
    }

    public String reverse() {
        DoublyLinkedNode node = tail;
        StringBuilder result = new StringBuilder();
        result.append("[");
        while (node != null) {
            result.append(node.data);
            if (node.prev != null) {
                result.append(" -> ");
            }
            node = node.prev;
        }
        result.append("]");
        System.out.println(result.toString());
        return result.toString();
    }

    public int getCount(Object data) {
        int size = 0;
        DoublyLinkedNode node = head;
        while (node != null) {
            if (data.equals(node.data)) {
                size++;
            }
        }
        return size;
    }
}
