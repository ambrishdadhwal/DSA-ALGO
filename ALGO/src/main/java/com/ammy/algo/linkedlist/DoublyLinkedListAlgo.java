package com.ammy.algo.linkedlist;

import com.ammy.dsa.linkedlist.DoublyLinkedList.DoublyLinkedList;

public class DoublyLinkedListAlgo {

    private static DoublyLinkedList dll = new DoublyLinkedList();

    public static void main(String[] args) {
        createDLL(1, 10);
        dll.toString();

        System.out.println("Print reverse Doubly Linked List...");
        dll.reverse();

        remove(5);

        remove(-1);
    }

    private static void remove(int index){
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
