package misc;

import java.util.HashSet;

class DuplicateList {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Node head = new Node(3);
        head.next = new Node(1);
        head.next.next = new Node(3);
        head.next.next.next = new Node(5);
        head.next.next.next.next = new Node(1);
        print(head);
        removeDupliactes(head);
        System.out.println();
        print(head);
    }

    public static void removeDupliactes(Node head){
        HashSet<Integer> seen = new HashSet<>();
        Node current = head;
        Node previous = null;

        while(current!=null){
            if(seen.contains(current.data)){
                previous.next = current.next;
            }else{
                seen.add(current.data);
                previous = current;
            }
            current = current.next;
        }
    }

    public static void print(Node head){
        Node current = head;
        while(current!=null){
            System.out.print(current.data);
            current = current.next;
        }
    }

}

//class Node{
//    int data;
//    Node next;
//
//    public Node(int data){
//        this.data = data;
//        this.next = null;
//    }
//}