package com.ammy.algo.linkedlist;

import com.ammy.dsa.linkedlist.CircularDoublyLinkedList.CircularDoublyLinkedList;

public class DoublyCircularListAlgo {

    private static CircularDoublyLinkedList dcll = new CircularDoublyLinkedList();

    public static void main(String[] args) {
        createDCLL(1, 10);
        checkIfListIsCircular();
        checkIfListContainsLoop();

        //
        System.out.println("find loop using Flyod Cycle...");
        boolean result = dcll.floydCycle();
        System.out.println("floydCycle :: Is List contain loop : " + (result ? "YES" : "NO"));

        result = dcll.detechLoop1();
        System.out.println("detechLoop1 :: Is List contain loop : " + (result ? "YES" : "NO"));

        System.out.println("######Resetting List######");
        dcll.reset();
        createDCLL(21, 30);
        dcll.addFirst(21);
        dcll.addFirst(21);
        dcll.addLast(30);
        dcll.toString();

        System.out.println("Removing duplicates.....");
        dcll.removeDuplicates();
        dcll.toString();
    }

    private static void createDCLL(int start, int end) {
        System.out.println("Creating Circular Doubly Linked List...");
        for (int i = start; i <= end; i++) {
            dcll.add(i);
        }
        dcll.toString();
    }

    private static void checkIfListIsCircular() {
        boolean result = dcll.ifCircular();
        System.out.println("Is List Circular : " + (result ? "YES" : "NO"));
    }

    private static void checkIfListContainsLoop() {
        boolean result = dcll.detechLoop();
        System.out.println("Is List contain loop : " + (result ? "YES" : "NO"));
    }
}
