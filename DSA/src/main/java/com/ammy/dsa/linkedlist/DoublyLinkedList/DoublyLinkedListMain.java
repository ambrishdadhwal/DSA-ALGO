package com.ammy.dsa.linkedlist.DoublyLinkedList;

public class DoublyLinkedListMain {
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        for (int i = 1; i <= 10; i++) {
            dll.add(i);
        }

        dll.toString();

        System.out.println("Printing Doubly Linked List reverse :-");
        dll.reverse();

        int index = 4;
        System.out.println("Double Linked List node at index :- " + index);
        DoublyLinkedNode node =  dll.get(4);
        dll.toString(node);

        System.out.println("Double Linked List - remove head -- ");
        dll.removeHead();
        dll.toString();

        System.out.println("Removing Tail node...");
        dll.removeTail();
        dll.toString();

        System.out.println("Adding new node at index -- " + index);
        dll.addNode(100, index);
        dll.toString();

        System.out.println("Adding new node at index -- " + index);
        dll.addNode(500, index);
        dll.toString();

        System.out.println("Deleting node at index -- " + 5);
        dll.deleteNode(5);
        dll.toString();

        System.out.println("Adding node at tail position");
        dll.addTailNode(700);
        dll.toString();
    }
}
