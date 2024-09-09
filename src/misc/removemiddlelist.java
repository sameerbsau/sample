package misc;
/*
Online Java - IDE, Code Editor, Compiler

Online Java is a quick and easy tool that helps you to build, compile, test your programs online.
*/

class LinkedList
{

    Node head;
    public static void main(String[] args) {

        LinkedList list = new LinkedList();
        list.head = new Node(1);
        list.head.next = new Node(2);
        list.head.next.next = new Node(3);
        list.head.next.next.next = new Node(4);
        list.head.next.next.next.next = new Node(5);

        Node middleNode = list.head.next.next;
        list.printlist();
        list.deleteMiddleNode(middleNode);
        list.printlist();



    }

    public void deleteMiddleNode(Node m){
        if(m ==null || m.next ==null){
            System.out.println("cannot delete last node or null node");
        }

        Node nextNode = m.next;
        m.data = nextNode.data;
        m.next = nextNode.next;
    }

    public void printlist(){
        Node current = head;

        while(current !=null){
            System.out.print(current.data);
            current = current.next;
        }
        System.out.println();
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






