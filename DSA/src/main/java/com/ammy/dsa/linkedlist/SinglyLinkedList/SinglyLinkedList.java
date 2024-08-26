package com.ammy.dsa.linkedlist.SinglyLinkedList;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

import com.ammy.dsa.linkedlist.DoublyLinkedList.DoublyLinkedNode;

public class SinglyLinkedList {

    SinglyLinkedNode head;

    SinglyLinkedNode prev;

    int totalNodes;

    public SinglyLinkedList() {
        head = null;
        totalNodes = 0;
    }

    public int size() {
        return totalNodes;
    }

    // [5 -> 4 -> 3 -> 2 -> 1]
    public void insertAtEnd(Object data) {
        SinglyLinkedNode node = new SinglyLinkedNode();
        node.data = data;
        if (head == null) {
            head = node;
        } else {
            node.next = head;
            head = node;
        }
        totalNodes++;
    }

    // [1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9 -> 10 ]
    public void add(Object data) {
        SinglyLinkedNode node = new SinglyLinkedNode();
        node.data = data;
        if (head == null) {
            head = node;
            prev = node;
        } else {
            prev.next = node;
            prev = node;
        }
        totalNodes++;
    }

    public void insertAt(Object data, int index) {
        SinglyLinkedNode newNode = new SinglyLinkedNode();
        newNode.data = data;
        SinglyLinkedNode node = head;
        for (int i = 0; i < index - 1; i++) {
            node = node.next;
        }
        SinglyLinkedNode nextNode = node.next.next;
        node.next = newNode;
        newNode.next = nextNode;
        totalNodes++;
    }

    // [1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9 -> 10 ]
    public void insertAtTail(Object data) {
        SinglyLinkedNode newNode = new SinglyLinkedNode();
        newNode.data = data;
        SinglyLinkedNode node = head;
        while (node != null && node.next != null) {
            node = node.next;
        }
        node.next = newNode;
        totalNodes++;
    }

    public void insertAtTail1(Object data) {
        SinglyLinkedNode newNode = new SinglyLinkedNode();
        SinglyLinkedNode node = head;
        newNode.data = data;
        SinglyLinkedNode p, q;
        for (p = node; (q = p.next) != null; p = q)
            ;
        p.next = newNode;
        totalNodes++;
    }

    public SinglyLinkedNode get(int index) {
        SinglyLinkedNode node = head;
        for (int i = -1; i < index - 1; i++) {
            node = node.next;
        }
        return node;
    }

    public boolean ifListIsCircular() {
        boolean flag = false;
        SinglyLinkedNode node = head;
        while (node != null) {
            node = node.next;
            if (node != null && node.next != null && node.next == head) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    public SinglyLinkedNode getFromTail(int index) {
        int remainedNodes = size() - 1 - index;
        if (remainedNodes < 0 || index < 0) {
            throw new RuntimeException("Index - " + index + " is wrong ");
        }
        return getRecursive(remainedNodes);
    }

    public SinglyLinkedNode middleNode() {
        return getRecursive(size() / 2);
    }

    public SinglyLinkedNode getRecursive(int index) {
        int counter = 0;
        return getRecursive(head, index, counter);
    }

    public SinglyLinkedNode getRecursive(SinglyLinkedNode node, int index, int counter) {
        if (node != null && node.next != null && (counter == index)) {
            return node;
        }

        return getRecursive(node.next, index, (counter = counter + 1));
    }

    public void remove(int index) {
        SinglyLinkedNode node = head;
        if (index == 0) {
            removeFirst();
        }
        for (int i = -1; i < index - 2; i++) {
            node = node.next;
        }
        SinglyLinkedNode nextNode = node.next.next;
        node.next = nextNode;
        totalNodes--;
    }

    // [1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9 -> 10 ]
    public void removeLast() {
        SinglyLinkedNode node = head;
        for (int i = -1; i < totalNodes - 2; i++) {
            if (node != null && node.next != null && node.next.next != null) {
                node = node.next;
            }
        }
        // SinglyLinkedNode nextNode = node.next.next;
        node.next = null;
        totalNodes--;
    }

    public SinglyLinkedNode removeLast1() {
        SinglyLinkedNode p = head, q = null, next = head.next;
        if (next == null) {
            head = null;
            return p;
        }
        while ((next = p.next) != null) {
            q = p; // 1, 2, 3, 4
            p = next; // 2, 3, 4, 5
        }
        q.next = null;
        return p;
    }

    public SinglyLinkedNode removeFirst() {
        head = head.next;
        totalNodes--;
        return head;
    }

    public void reset() {
        head = null;
        prev = null;
        totalNodes = 0;
    }

    @Override
    public String toString() {
        SinglyLinkedNode node = head;
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

    public Object toString(SinglyLinkedNode node) {
        return node.data;
    }

    public void reverseList() {
        SinglyLinkedNode node = head;
        Stack<Object> stack = new Stack<>();
        while (node != null) {
            stack.push(node.data);
            node = node.next;
        }

        head = null;
        while (!stack.isEmpty()) {
            add(stack.pop());
        }
    }

    public void printReverseListRecursive(SinglyLinkedNode node) {
        if (node == null) {
            return;
        }
        printReverseListRecursive(node.next);
        System.out.print(node.data + " -> ");
    }

    public SinglyLinkedNode getHead() {
        return head;
    }

    public boolean detechLoop() {
        boolean result = false;
        Set<SinglyLinkedNode> set = new HashSet<>();
        SinglyLinkedNode node = head;
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
}
