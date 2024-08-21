package com.ammy.dsa.linkedlist.CircularDoublyLinkedList;

import com.ammy.dsa.linkedlist.DoublyLinkedList.DoublyLinkedNode;

public class CircularDoublyLinkedList {

    DoublyLinkedNode head;
    DoublyLinkedNode tail;
    DoublyLinkedNode prev;
    Integer totalNodes;

    CircularDoublyLinkedList() {
        head = null;
        tail = null;
        prev = null;
        totalNodes = 0;
    }

    // [1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9 -> 10]
    public void add(Object data) {
        DoublyLinkedNode node = new DoublyLinkedNode(data);
        if (head == null) {
            head = node;
            prev = node;
            head.next = node;
            node.next = head;
            tail = node;
        } else {
            prev.next = node;
            node.prev = prev;
            node.next = head;
            tail = node;
            prev = node;
        }
    }

    public void addFirst(Object data) {
        DoublyLinkedNode newNode = new DoublyLinkedNode(data);
        tail.next = newNode;
        newNode.prev = tail;
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    public void addLast(Object data) {
        DoublyLinkedNode newNode = new DoublyLinkedNode(data);
        tail.next = newNode;
        newNode.prev = tail;
        newNode.next = head;
        head.prev = newNode;
        tail = newNode;
    }

    public void deleteFirst() {
        DoublyLinkedNode nextNode = head.next;
        tail.next = nextNode;
        nextNode.prev = tail;
        head = nextNode;
    }

    public void deleteLast() {
        DoublyLinkedNode prevNode = tail.prev;
        prevNode.next = head;
        head.prev = prevNode;
        tail = prevNode;
    }

    @Override
    public String toString() {
        DoublyLinkedNode node = tail.next;
        StringBuilder result = new StringBuilder();
        result.append("[");
        while (node != null) {
            result.append(node.data);
            if (node.next != null) {
                result.append(" -> ");
            }
            node = node.next;
            if (node == head) {
                break;
            }
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
            if (node == tail) {
                break;
            }
        }
        result.append("]");
        System.out.println(result.toString());
        return result.toString();
    }
}
