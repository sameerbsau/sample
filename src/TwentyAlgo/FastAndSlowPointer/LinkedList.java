package TwentyAlgo.FastAndSlowPointer;
//https://medium.com/@arifimran5/fast-and-slow-pointer-pattern-in-linked-list-43647869ac99
public class LinkedList {
    // Inner class to represent a node in the list
    private static class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Field to keep track of the head of the list
    private Node head;

    // Constructor to initialize an empty linked list
    public LinkedList() {
        this.head = null;
    }

    // Method to add a new element to the end of the list
    public void add(int data) {
        // Create a new node to hold the data
        Node newNode = new Node(data);

        // If the list is empty, set the new node as the head of the list
        if (head == null) {
            head = newNode;
        }
        // Otherwise, find the last node in the list and set its next reference
        // to the new node
        else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public Node middleNode(Node head) {
        Node temp = head;
        int length = 0;

        //loop over till our pointer become null
        while(temp!=null){
            temp = temp.next;
            length++; //increase length by one
        }

        Node mid = head;
        for(int i=0;i<length/2;i++){ // forward mid Node up till half of length
            mid = mid.next;
        }
        return mid;
    }

    public Node middleNodeFANDS(Node head) {
        Node fast = head;
        Node slow  = head;

// Here is one tricky part, while giving condition of loop
// For list with even length, fast pointer is going to reach end i.e. null
// For off length, fast pointer is going to be at the tail
// so we have to terminate the loop
// if fast becomes null && fast.next becomes null

        while( fast!=null && fast.next!=null){
            fast = fast.next.next; // moving fast by 2 step
            slow = slow.next;
        }
        return slow;
    }

    public Node getNodeFromEnd(Node head, int n){
        Node fast = head;
        Node slow = head;

//moving fast ahead by n, to make gap
        for(int i=0;i<n;i++){
            fast = fast.next;
        }

// when the fast reaches end, slow will be the nth node from end
        while(fast.next!=null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }


    public Node removeNthFromEnd(Node head, int n) {
        Node fast = head;
        Node slow = head;

        // if there is only one node in list, then we can only delete that
        if(head.next==null) return null;

        //move fast ptr forward by n
        for(int i=0;i<n;i++){
            fast = fast.next;
        }

        // if fast becomes null, means we want to delete head
        if(fast == null) return head.next;

        while(fast.next!=null){
            fast = fast.next;
            slow = slow.next;
        }

        // break link from next
        slow.next = slow.next.next;

        // return head
        return head;
    }

    public boolean hasCycle(Node head) {
        Node slow  = head;
        Node fast  = head;

// if there is cycle, fast is never going to be null
// if there is no cycle, fast or fast.next whichever becomes null,return false

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow==fast)return true;
        }
        return false;
    }
}