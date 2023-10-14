package linkedlists;




public class LinkedListPartition {
    public Node partition(Node head, int x){

        if(head ==null || head.next == null){
            return  head;
        }
int ax = 0;
        Node lessHead = new Node(0);
        Node lessTail = lessHead;
        Node greaterHead = new Node(0);
        Node greaterTail = greaterHead;
        while (head!=null){
            if(head.data<x){
                lessTail.next = head;
                lessTail = lessTail.next;
            }else{
                greaterTail.next = head;
                greaterTail= greaterTail.next;
            }
            head = head.next;


        }
        greaterTail.next = null;
        lessTail.next = greaterHead.next;
        return lessHead.next;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(4);
        head.next.next = new Node(3);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(2);

        int x = 3;

        LinkedListPartition partitioner = new LinkedListPartition();
        Node result = partitioner.partition(head, x);

        while (result != null) {
            System.out.print(result.data + " ");
            result = result.next;
        }
    }

}
