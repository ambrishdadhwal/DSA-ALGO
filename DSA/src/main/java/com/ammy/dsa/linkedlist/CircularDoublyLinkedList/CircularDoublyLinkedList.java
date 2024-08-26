package com.ammy.dsa.linkedlist.CircularDoublyLinkedList;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.ammy.dsa.linkedlist.DoublyLinkedList.DoublyLinkedNode;

public class CircularDoublyLinkedList {

    DoublyLinkedNode head;
    DoublyLinkedNode tail;
    DoublyLinkedNode prev;
    Integer totalNodes;

    public CircularDoublyLinkedList() {
        head = null;
        tail = null;
        prev = null;
        totalNodes = 0;
    }

    public void reset() {
        head = null;
        tail = null;
        prev = null;
        totalNodes = 0;
    }

    public DoublyLinkedNode getHead() {
        return head;
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

    public void add(DoublyLinkedNode node) {
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

    public boolean ifCircular() {
        boolean result = false;
        DoublyLinkedNode node = head;
        while (node != null) {
            if (node.next != null && node.next == head) {
                result = true;
                break;
            }
            node = node.next;
        }

        return result;
    }

    public boolean detechLoop() {
        boolean result = false;
        Set<DoublyLinkedNode> set = new HashSet<>();
        DoublyLinkedNode node = head;
        while (node != null) {
            if (set.contains(node)) {
                result = true;
                break;
            }
            set.add(node);
            node = node.next;
        }
        return result;
    }

    public boolean floydCycle() {
        DoublyLinkedNode singlePointer = head;
        DoublyLinkedNode doublePointer = head;
        boolean flag = false;

        while (singlePointer != null && doublePointer != null) {
            singlePointer = singlePointer.next;
            doublePointer = doublePointer.next.next;
            if (singlePointer == doublePointer) {
                flag = true;
                System.out.println("Size of loop is -- " + loopSize(singlePointer));
                break;
            }
        }

        return flag;
    }

    public int loopSize(DoublyLinkedNode node) {
        int size = 0;
        while (node.next != head) {
            node = node.next;
            size++;
        }
        return size;
    }

    public boolean detechLoop1() {
        DoublyLinkedNode node = head;
        boolean flag = false;
        DoublyLinkedNode temp = new DoublyLinkedNode(0);
        while (node != null) {
            if (node.next == null) {
                return false;
            }
            if (node.next == temp) {
                return true;
            }
            DoublyLinkedNode next = node.next;
            node.next = temp;
            node = next;
        }
        return flag;
    }

    /* Remove duplictes from sorted list */
    // [21 -> 21 -> 21 -> 22 -> 23 -> 24 -> 25 -> 26 -> 27 -> 28 -> 29 -> 30 -> 30
    // -> ]
    public void removeDuplicates() {
        DoublyLinkedNode node = head;
        Set<Object> set = new HashSet<>();
        while (node != null) {
            set.add(node.data);
            node = node.next;
        }
        this.head = null;
        set.forEach(n -> {
            this.add(n);
        });
    }
}
