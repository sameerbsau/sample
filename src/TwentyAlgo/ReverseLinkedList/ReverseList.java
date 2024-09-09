package TwentyAlgo.ReverseLinkedList;



class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        this.next = null;
    }

}

public class ReverseList {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        System.out.println("given linked list");

        printList(head);
        System.out.println("After reverse");

      // head =  reverseIterative(head);
      // printList(head);

      head =  reverseRecursive(head);
        printList(head);
    }

    private static Node reverseRecursive(Node head) {
        if(head ==null|| head.next == null){
            return  head;
        }

        Node rest = reverseRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return  rest;
    }

    private static Node reverseIterative(Node head) {
        Node curr = head;
        Node prev = null;

        while (curr!=null){
            Node next = curr.next;

            curr.next = prev;

            prev = curr;
            curr = next;
        }
        return prev;
    }

    private static void printList(Node head) {
        while (head!=null){
            System.out.print(" "+head.data);
            head=head.next;
        }
    }
}
