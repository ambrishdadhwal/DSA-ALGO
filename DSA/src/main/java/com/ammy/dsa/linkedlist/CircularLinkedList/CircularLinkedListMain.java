package com.ammy.dsa.linkedlist.CircularLinkedList;

import com.ammy.dsa.linkedlist.SinglyLinkedList.SinglyLinkedNode;

public class CircularLinkedListMain {
    public static void main(String[] args) {
        CircularLinkedList cList = new CircularLinkedList();
        for (int i = 1; i <= 10; i++) {
            cList.add(i);
        }
        cList.toString();

        System.out.println("Adding node infront...");
        cList.addFirst(400);
        cList.toString();

        System.out.println("Adding node tolast...");
        cList.addLast(600);
        cList.toString();

        System.out.println("Deleting first Node...");
        cList.deleteFirst();
        cList.toString();

        System.out.println("Deleting last Node...");
        cList.deleteLast();
        cList.toString();

        System.out.println("Deleting last Node...");
        cList.deleteLast();
        cList.toString();

        int index = 4;
        System.out.println("Adding Node at index - "+ index);
        cList.addAtLocation(300, index);
        cList.toString();

        System.out.println("Get Node from index - "+ index);
        SinglyLinkedNode node = cList.get(index);
        cList.toString(node);
    }
}
