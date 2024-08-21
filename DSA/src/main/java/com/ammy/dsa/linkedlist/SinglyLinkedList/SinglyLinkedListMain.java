package com.ammy.dsa.linkedlist.SinglyLinkedList;

public class SinglyLinkedListMain {
    public static void main(String[] args) {
        System.out.println("Insert at last ----- ");
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.insertAtEnd(1);
        singlyLinkedList.insertAtEnd(2);
        singlyLinkedList.insertAtEnd(3);
        singlyLinkedList.insertAtEnd(4);
        singlyLinkedList.insertAtEnd(5);
        singlyLinkedList.insertAtEnd(6);
        singlyLinkedList.insertAtEnd(7);

       // System.out.println(singlyLinkedList.toString());

        int index = 5;
        SinglyLinkedNode node = singlyLinkedList.get(index);
       // System.out.println("Node at index - "+index+" :  " + singlyLinkedList.toString(node));

        //
        System.out.println("\nInsert at first ----- ");
        singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.add(1);
        singlyLinkedList.add(2);
        singlyLinkedList.add(3);
        singlyLinkedList.add(4);
        singlyLinkedList.add(5);
        singlyLinkedList.add(6);
        singlyLinkedList.add(7);
        singlyLinkedList.add(8);
        singlyLinkedList.add(9);
        singlyLinkedList.add(10);
        singlyLinkedList.toString();
        node = singlyLinkedList.get(index);
        System.out.println("Node at index - "+index+" :  " + singlyLinkedList.toString(node));

        int removeIndex = 5;
        System.out.println("Removing node at index - " + removeIndex);
        singlyLinkedList.remove(removeIndex);
        singlyLinkedList.toString();

        System.out.println("Removing node at first position - ");
        singlyLinkedList.removeFirst();
        singlyLinkedList.toString();

        System.out.println("Removing node at last position - ");
        singlyLinkedList.removeLast();
        singlyLinkedList.toString();

        singlyLinkedList.insertAt(600 ,4);
        System.out.println("Inserting node at index ---" + 4);
        singlyLinkedList.toString();

        singlyLinkedList.insertAtTail(4000);
        System.out.println("Inserting node at tail --- ");
        singlyLinkedList.toString();

    }
}
