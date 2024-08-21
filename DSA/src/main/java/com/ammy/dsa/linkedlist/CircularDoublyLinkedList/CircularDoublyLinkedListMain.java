package com.ammy.dsa.linkedlist.CircularDoublyLinkedList;

public class CircularDoublyLinkedListMain {

    public static void main(String[] args) {
        CircularDoublyLinkedList cDll = new CircularDoublyLinkedList();
        for (int i = 1; i <= 10; i++) {
            cDll.add(i);
        }

        cDll.toString();

        System.out.println("Printing in reverse order ... ");
        cDll.reverse();

        System.out.println("Adding node in front ... ");
        cDll.addFirst(200);
        cDll.addFirst(300);
        cDll.toString();

        System.out.println("Adding node in last ... ");
        cDll.addLast(2100);
        cDll.addLast(3100);
        cDll.toString();

        System.out.println("Removing first node...");
        cDll.deleteFirst();
        cDll.toString();

        System.out.println("Removing Last node...");
        cDll.deleteLast();
        cDll.deleteLast();
        cDll.toString();
    }
}
