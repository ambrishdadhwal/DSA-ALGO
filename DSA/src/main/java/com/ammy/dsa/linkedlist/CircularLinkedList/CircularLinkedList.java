package com.ammy.dsa.linkedlist.CircularLinkedList;

import java.util.Stack;

import com.ammy.dsa.linkedlist.DoublyLinkedList.DoublyLinkedNode;
import com.ammy.dsa.linkedlist.SinglyLinkedList.SinglyLinkedNode;

public class CircularLinkedList {
    SinglyLinkedNode head;

    SinglyLinkedNode prev;

    SinglyLinkedNode tail;

    int totalNodes;

    public CircularLinkedList() {
        head = null;
        prev = null;
        totalNodes = 0;
    }

    public SinglyLinkedNode getHead() {
        return head;
    }

    public void add(Object data) {
        SinglyLinkedNode node = new SinglyLinkedNode();
        node.data = data;
        if (head == null) {
            head = node;
            prev = node;
            head.next = node;
            node.next = head;
        } else {
            prev.next = node;
            prev = node;
            node.next = head;
            tail = node;
        }
    }

    public boolean ifListIsCircular() {
        boolean flag = false;
        SinglyLinkedNode node = head;
        while (node != null) {
            node = node.next;
            if (node.next == head) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    public void addFirst(Object data) {
        SinglyLinkedNode node = new SinglyLinkedNode();
        node.data = data;
        SinglyLinkedNode lastNode = tail;
        lastNode.next = node;
        node.next = head;
        head = node;
        totalNodes++;
    }

    public SinglyLinkedNode getSecondLastNode() {
        SinglyLinkedNode last = head;
        while (last != null) {
            if (last.next.next == head) {
                break;
            }
            last = last.next;
        }
        return last;
    }

    public void addAtLocation(Object data, int index) {
        SinglyLinkedNode newNode = new SinglyLinkedNode();
        newNode.data = data;
        SinglyLinkedNode node = head;
        for (int i = -1; i < index - 1; i++) {
            node = node.next;
        }
        SinglyLinkedNode secondNode = node.next;
        node.next = newNode;
        newNode.next = secondNode;
        totalNodes++;
    }

    // [400 -> 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9 -> 10]
    public void addLast(Object data) {
        SinglyLinkedNode node = new SinglyLinkedNode();
        node.data = data;
        if (tail == null) {
            tail = node;
            node.next = node;
        }
        // SinglyLinkedNode lastNode = tail;
        tail.next = node;
        node.next = head;
        tail = node;
        totalNodes++;
    }

    public void deleteFirst() {
        SinglyLinkedNode node = tail;
        node.next = node.next.next;
        head = node.next;
        totalNodes--;
    }

    public void deleteLast() {
        SinglyLinkedNode secondLastNode = getSecondLastNode();
        secondLastNode.next = secondLastNode.next.next;
        tail = secondLastNode.next;
        totalNodes--;
    }

    public SinglyLinkedNode get(int index) {
        SinglyLinkedNode node = head;
        for (int i = -1; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    @Override
    public String toString() {
        SinglyLinkedNode node = tail.next;
        StringBuilder result = new StringBuilder();
        result.append("[");
        while (node != null) {
            result.append(node.data);
            if (node.next != null) {
                result.append(" -> ");
            }
            node = node.next;
            if (node.next == head) {
                result.append(node.data);
                break;
            }
        }
        result.append("]");
        System.out.println(result.toString());
        return result.toString();
    }

    public Object toString(SinglyLinkedNode node) {
        System.out.println(node.data);
        return node.data;
    }

    public int getCount(Object data) {
        int size = 0;
        SinglyLinkedNode node = head;
        while (node != null) {
            if (node.next == head) {
                break;
            }
            if (data.equals(node.data)) {
                size++;
            }
        }
        return size;
    }

    public void reverseList() {
        SinglyLinkedNode node = head;
        Stack<Object> stack = new Stack<>();
        while (node != null) {
            if (node.next == head) {
                break;
            }
            stack.push(node.data);
            node = node.next;
        }

        head = null;
        while (!stack.isEmpty()) {
            add(stack.pop());
        }
    }

    public void recursivePrint(SinglyLinkedNode node) {
        if (node == null) {
            return;
        }

        if (node.next == head) {
            System.out.print(node.data + " -> ");
            return;
        }

        System.out.print(node.data + " -> ");
        recursivePrint(node.next);
    }
}
