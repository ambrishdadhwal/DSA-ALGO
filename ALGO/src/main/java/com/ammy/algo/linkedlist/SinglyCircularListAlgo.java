package com.ammy.algo.linkedlist;

import com.ammy.dsa.linkedlist.CircularLinkedList.CircularLinkedList;

public class SinglyCircularListAlgo {
    private static CircularLinkedList list = new CircularLinkedList();

    public static void main(String[] args) {
        createList(1, 15);
        checkIfListIsCircular();

        System.out.println("Reversing Circular Linked List...");
        list.reverseList();
        list.toString();

        System.out.println("Print Circular Linked List recursivly...");
        list.recursivePrint(list.getHead());

    }

    private static void checkIfListIsCircular() {
        boolean result = list.ifListIsCircular();
        System.out.println("Is List Circular : " + (result ? "YES" : "NO"));
    }

    private static void createList(int start, int end) {
        System.out.println("Creating circular Linked List");
        for (int i = start; i <= end; i++) {
            list.add(i);
        }

        list.toString();
    }

    public void ifListIsCircularOrNot() {

    }

}
