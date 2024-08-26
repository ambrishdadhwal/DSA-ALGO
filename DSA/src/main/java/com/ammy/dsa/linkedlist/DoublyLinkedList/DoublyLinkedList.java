package com.ammy.dsa.linkedlist.DoublyLinkedList;

import java.util.HashSet;
import java.util.Set;

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

    public DoublyLinkedNode getHead() {
        return head;
    }

    public void addFirst(Object data) {
        if (head == null) {
            add(data);
            return;
        }
        DoublyLinkedNode node = new DoublyLinkedNode(data);
        node.next = head;
        head.prev = node;
        head = node;
        totalNodes++;
    }

    public void addLast(Object data) {
        DoublyLinkedNode node = new DoublyLinkedNode(data);
        tail.next = node;
        node.prev = tail;
        tail = node;
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

    public DoublyLinkedNode removeDuplicates1() {
        DoublyLinkedNode node = head;
        DoublyLinkedNode newHead = null;
        DoublyLinkedNode prev = null;
        Set<Object> set = new HashSet<>();

        while (node != null) {
            if (!set.contains(node.data)) {
                DoublyLinkedNode newNode = new DoublyLinkedNode(node.data);
                // first time
                if (newHead == null) {
                    newHead = newNode;
                    prev = newNode;
                } else {
                    prev.next = newNode;
                    newNode.prev = prev;
                    prev = newNode;
                }
                set.add(node.data);
            }
            node = node.next;
        }
        return newHead;
    }

    public void removeDuplicates2() {
        DoublyLinkedNode node = head;
        while (node != null && node.next != null) {
            if ((node.data == node.next.data)) {
                node.next = node.next.next;
            } else {
                node = node.next;
            }
        }
    }

    public void removeDupRecursive(DoublyLinkedNode node) {
        if (node == null) {
            return;
        }
        if (node.next != null) {
            if ((node.data == node.next.data)) {
                node.next = node.next.next;
                removeDupRecursive(node);
            } else {
                removeDupRecursive(node.next);
            }
        }
    }

    public void findPairsWithSum(int sum) {
        DoublyLinkedNode node = head;
        while (node != null) {
            DoublyLinkedNode nextNode = node.next;
            while (nextNode != null) {
                if ((int) (node.data) + (int) (nextNode.data) == sum) {
                    System.out.println("Sum found : Elements are :- " + node.data + " and " + nextNode.data);
                }
                nextNode = nextNode.next;
            }
            node = node.next;
        }
    }

    public void findPairsWithSumTwoPointers(int sum) {
        DoublyLinkedNode first = head;
        DoublyLinkedNode last = tail;
        while (first != last && first != null && last != null && last.next != first) {
            if ((int) (first.data) + (int) (last.data) == sum) {
                System.out.println("Sum found : Elements are :- " + first.data + " and " + last.data);
                first = first.next;
                last = last.prev;
            } else if ((int) (first.data) + (int) (last.data) < sum) {
                first = first.next;
            } else {
                last = last.prev;
            }
        }
    }

    public void addNodeInSortedList(Object data) {
        DoublyLinkedNode newNode = new DoublyLinkedNode(data);
        DoublyLinkedNode node = head;
        if (head == null) {
            head = node;
        } else if ((int) (head.data) >= (int) data) {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        } else {
            while (node.next != null && (int) (node.data) < (int) data) {
                node = node.next;
            }
            DoublyLinkedNode next = node.next;
            node.next = newNode;
            newNode.prev = node;
            newNode.next = next;
            next.prev = newNode;
            node = node.next;
        }
    }

    // [8 -> 500 -> 100 -> 400 -> 9 -> 10 -> 1 -> 300 -> 100 -> 10 -> 5 -> 6 -> 7 ->
    // 8 -> 9 -> 10 -> 1]
    public void removeDuplicatesFromUnSorted() {
        DoublyLinkedNode outside = head;
        DoublyLinkedNode inside = outside;
        Set<Integer> set = new HashSet<>();
        while (outside.next != null) {
            set.add((Integer) outside.data);
            outside = outside.next;
        }

        reset();
        set.forEach(n -> {
            add(n);
        });
    }

    // [5 -> 10 -> 6 -> 5 -> 8 -> 7 -> 7 -> 8 -> 9 -> 10 -> 10]
    public void removeDuplicatesFromUnSortedHash() {
        Set<Object> set = new HashSet<>();
        DoublyLinkedNode node = head;
        while (node != null) {
            if (set.contains(node.data)) {
                DoublyLinkedNode next = node.next;
                node.prev.next = next;
                if (next != null) {
                    next.prev = node.prev;
                }
                node = node.next;
            } else {
                set.add(node.data);
                node = node.next;
            }
        }
    }

    public void removeDuplicatesFromUnSorted1() {
        DoublyLinkedNode p1, p2;
        for (p1 = head; p1 != null && p1.next != null; p1 = p1.next) {
            p2 = p1.next;
            while (p2 != null) {
                if (p1.data == p2.data) {
                    DoublyLinkedNode next = p2.next;
                    p2.prev.next = next;
                    if (next != null) {
                        next.prev = p2.prev;
                    }
                    p2 = next;
                } else {
                    p2 = p2.next;
                }
            }
        }
    }

    private void delete(DoublyLinkedNode node) {

    }

    public void sortList() {

    }

    // [1 -> 2 -> 3 -> 4 -> 5]
    // -----> [4 -> 5 -> 1 -> 2 -> 3]
    public void rotateLinkedList(int times) {
        DoublyLinkedNode first = head;

        int count = 1;
        // after this loop first points to 4
        while (count < times && first != null) {
            first = first.next;
            count++;
        }

        DoublyLinkedNode nthNode = first;
        // after this loop first points to 5
        while (first.next != null) {
            first = first.next;
        }

        first.next = head;
        head.prev = first;

        head = nthNode.next;
        head.prev = null;
        nthNode.next = null;
    }

    // [1 -> 2 -> 3 -> 4 -> 5]
    public void rotateByN(int N) {
        DoublyLinkedNode current = head;
        while (N > 0) {
            current = current.next;
            N--;
        }

        DoublyLinkedNode tail = current.prev;
        DoublyLinkedNode newHead = current;
        tail.next = null;
        current.prev = null;

        while (current.next != null) {
            current = current.next;
        }
        current.next = head;
        head.prev = current;
        head = newHead;

    }

    public String toStringCustom(DoublyLinkedNode head) {
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

    public void reset() {
        head = null;
        tail = null;
        prev = null;
        totalNodes = 0;
    }
}
