package misc;

//class Node{
//    int data;
//    Node next;
//
//    public Node(int data){
//        this.data = data;
//        this.next = null;
//    }
//}

 class LinkedListFind{
    public static void main(String[] args){
        LinkedListFind list = new LinkedListFind();
        list.node = new Node(1);
        list.node.next = new Node(2);
        list.node.next.next = new Node(3);
        list.node.next.next.next = new Node(4);
        list.node.next.next.next.next = new Node(5);

        int k = 2;
        int kthElement = list.findKElement(k);

        if(kthElement ==-1){
            System.out.print("list size is less");
        }else{
            System.out.println("kth element is "+ kthElement);
        }

    }

    Node node;


    public  int findKElement(int k ){
        Node fast = node;
        Node slow = node;

        for(int i = 0; i<k; i++){
            if(fast.next == null){
                return -1;
            }
            fast = fast.next;
        }

        while(fast!=null){
            fast = fast.next;
            slow = slow.next;
        }

        return slow.data;
    }
}