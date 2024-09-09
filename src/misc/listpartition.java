package misc;//class Node{
//    int data;
//    Node next;
//
//    public Node(int data){
//        this.data = data;
//        this.next = null;
//    }
//}

class LinkedListPartition {
    Node head;

    public static void main (String[] args) {
        LinkedListPartition list = new LinkedListPartition();
        list.head = new Node(3);
        list.head.next = new Node(5);
        list.head.next.next = new Node(8);
        list.head.next.next.next = new Node(5);
        list.head.next.next.next.next = new Node(10);
        list.head.next.next.next.next.next = new Node(2);
        list.head.next.next.next.next.next.next = new Node(1);

        System.out.print("original list");
        list.print();
        int partitionValue = 5;
        list.parition(5);
        list.print();
    }

    public void print(){
        Node current = head;
        while(current!=null){
            System.out.print(current.data+ " ");
            current = current.next;
        }
        System.out.println();
    }

    public void parition(int partitionValue){
        if(head == null || head.next == null){
            return;
        }

        Node beforeStart = null;
        Node beforeEnd = null;
        Node afterStart = null;
        Node afterEnd = null;
        Node current = head;

        while(current!=null){
            Node next = current.next;
            current.next = null;

            if(current.data < partitionValue){
                if(beforeStart == null){
                    beforeStart = current;
                    beforeEnd = beforeStart;
                }else{
                    beforeEnd.next = current;
                    beforeEnd = current;
                }
            }else{
                if(afterStart == null){
                    afterStart = current;
                    afterEnd = afterStart;
                }else{
                    afterEnd.next = current;
                    afterEnd = current;
                }
            }
            current = next;
        }

        if(beforeStart == null){
            head = afterStart;
        }else{
            beforeEnd.next = afterStart;
            head = beforeStart;
        }
    }
}