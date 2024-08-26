package com.ammy.algo.linkedlist;

import com.ammy.dsa.linkedlist.SinglyLinkedList.SinglyLinkedList;
import com.ammy.dsa.linkedlist.SinglyLinkedList.SinglyLinkedNode;

public class SinglyLinkedListAlgo {

    private static SinglyLinkedList list = new SinglyLinkedList();

    public static void main(String[] args) {
        createList(1, 10);
        search(5);
        searchRecursive(5);
        System.out.println("Total size of list - " + size());
        System.out.println("Removing from Index - 5 - ");
        remove(5);

        System.out.println("Removing from Index - 2 - ");
        remove(2);

        System.out.println("Resetting Singly Linked List...");
        list.reset();

        createList(1, 10);
        System.out.println("Getting node from end index - 5 - ");
        getFromTail(5);

        // createList(40, 60);

        System.out.println("Getting node from middle -- ");
        middleNode();
        list.toString();

        // checkIfListIsCircular();

        // reverse a list
        // list.reverseList();
        // list.toString();

        // print reverse a list
        // list.printReverseListRecursive(list.getHead());

        // checkIfListContainsLoop();

        System.out.println("Adding node to tail of Singly Linked List....");
        list.insertAtTail1(100);
        list.toString();

    }

    private static void checkIfListIsCircular() {
        boolean result = list.ifListIsCircular();
        System.out.println("Is List Circular : " + (result ? "YES" : "NO"));
    }

    private static void createList(int start, int end) {
        for (int i = start; i <= end; i++) {
            list.add(i);
        }

        list.toString();
    }

    private static void remove(int index) {
        list.remove(index);
        list.toString();
    }

    private static int size() {
        return list.size();
    }

    private static void search(int index) {
        SinglyLinkedNode node = list.get(index);
        System.out.println("search : Node present at index {" + index + "} is  --> {" + node.data + "}");
    }

    private static void getFromTail(int index) {
        SinglyLinkedNode node = list.getFromTail(index);
        System.out.println("search : Node present at index from last {" + index + "} is  --> {" + node.data + "}");
    }

    private static void middleNode() {
        SinglyLinkedNode node = list.middleNode();
        System.out.println("search : Middle Node is  --> {" + node.data + "}");
    }

    private static void searchRecursive(int index) {
        SinglyLinkedNode node = list.getRecursive(index);
        System.out.println("searchRecursive : Node present at index {" + index + "} is  --> {" + node.data + "}");
    }

    private static void checkIfListContainsLoop() {
        boolean result = list.detechLoop();
        System.out.println("\n\nIs List contain loop : " + (result ? "YES" : "NO"));
    }
}
