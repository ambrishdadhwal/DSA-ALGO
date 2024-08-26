package com.ammy.algo.linkedlist;

import com.ammy.dsa.linkedlist.DoublyLinkedList.DoublyLinkedList;
import com.ammy.dsa.linkedlist.DoublyLinkedList.DoublyLinkedNode;

public class DoublyLinkedListAlgo {

    private static DoublyLinkedList dll = new DoublyLinkedList();

    public static void main(String[] args) {
        createDLL(1, 10);
        dll.toString();

        System.out.println("Print reverse Doubly Linked List...");
        dll.reverse();

        remove(5);

        // remove(-1);
        dll.reset();
        createDLL(1, 10);
        dll.addFirst(1);
        dll.addFirst(1);
        dll.addLast(10);
        dll.addLast(10);
        dll.toString();

        System.out.println("Removing duplicates :: removeDuplicates.....");
        dll.removeDuplicates();
        dll.toString();

        System.out.println("Reversing List.....");
        dll.reverse();
        dll.reverse();

        dll.addFirst(1);
        dll.addFirst(1);
        dll.addLast(10);
        dll.addLast(10);
        dll.toString();

        System.out.println("Removing duplicates :: removeDuplicates1.....");
        DoublyLinkedNode newHead = dll.removeDuplicates1();
        dll.toStringCustom(newHead);

        dll.removeDuplicates();

        dll.addFirst(1);
        dll.addFirst(1);
        dll.addLast(10);
        dll.addLast(10);
        dll.toString();

        System.out.println("Before removing duplicates....");
        dll.toString();
        System.out.println("Removing duplicates :: removeDupRecursive.....");
        dll.removeDupRecursive(dll.getHead());
        dll.toString();

        System.out.println("Finding pairs with Sum :- 7 --");
        dll.findPairsWithSum(7);

        System.out.println("Finding pairs with Sum ::: findPairsWithSumTwoPointers :- 7 --");
        dll.findPairsWithSumTwoPointers(7);

        System.out.println("Adding node 4 in sorted list...");
        dll.addNodeInSortedList(4);
        dll.toString();

        System.out.println("Resetting list...");
        dll.reset();

        createDLL(5, 10);
        dll.addNode(5, 2);
        dll.addNode(7, 3);
        dll.addNode(10, 1);
        dll.addNode(8, 4);
        dll.addLast(10);

        // dll.add(1);
        // dll.add(1);

        dll.toString();
        dll.removeDuplicatesFromUnSortedHash();
        System.out.println("After removing duplicates from list.....");
        dll.toString();

        dll.reset();
        System.out.println("Reset list and creating the list again...");
        createDLL(1, 5);
        dll.toString();

        int rightRotate = 3;
        System.out.println("Rotating the list ");
        dll.rotateLinkedList(rightRotate);
        dll.toString();

    }

    private static void remove(int index) {
        System.out.println("Removing node from index :- " + index);
        dll.deleteNode(index);
        dll.toString();
    }

    private static void createDLL(int start, int end) {
        System.out.println("List created : ");
        for (int i = start; i <= end; i++) {
            dll.add(i);
        }
    }
}
