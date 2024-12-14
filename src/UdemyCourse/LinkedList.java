package UdemyCourse;

import java.util.HashSet;
import java.util.Set;

public class LinkedList {

   private Node head;
   private Node tail;
  private   int length;

    public LinkedList(int data){
        Node newNode = new Node(data);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
        }
    }

    //utility methods

    public void printList(){
        Node temp = head;
        while (temp!=null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public Node getHead(){
        if(head == null) return null;
        return head;
    }

    public Node getTail(){
        if (tail == null) return null;
        return tail;
    }

    public int getLength(){
        return length;
    }

    public void append(int data){
        Node newNode = new Node(data);
        if (length == 0){
            head = newNode;
            tail = newNode;
        }else {
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    public void prePend(int data){
        Node newNode = new Node(data);
        if (length == 0){
            head = newNode;
            tail = newNode;
        }
        else {
            newNode.next = head;
            head = newNode;
        }
        length++;
    }

    public Node removeLast(){
        if (length == 0) return null;
        Node temp = head;
        Node pre = head;
        while (temp.next!=null){
            pre = temp;
            temp = temp.next;
        }
        tail = pre;
        tail.next = null;
        length--;
        if (length == 0){
            head = null;
            tail = null;
        }
        return temp;
    }

    public Node removeFirst(){
        if (length==0) return  null;
        Node temp = head;
        head = head.next;
        temp.next = null;
        length--;
        if (length == 0) {
            tail=null;
        }
        return temp;
    }

    public Node get(int index){
        if (index < 0 || index>= length) return null;
        Node temp = head;
        for (int i = 0; i< index; i++){
            temp = temp.next;
        }
        return temp;
    }

    public boolean set(int index, int value){
        Node temp = get(index);
        if (temp!=null){
            temp.data = value;
            return true;
        }
        return false;
    }

    public boolean insert(int index, int value){
        if (index<0 || index >= length) return false;
        if (index == 0){
            prePend(value);
            return true;
        }
        if (index ==length){
            append(value);
            return true;
        }
        Node newNode = new Node(value);
        Node temp = get(index-1);
        newNode.next = temp.next;
        temp.next = newNode;

        length++;
        return true;
    }

    public Node remove(int index){
        if (index < 0 || index >= length) return null;
        if (index == 0){
            return removeFirst();
        }
        if (index == length-1){
            return removeLast();
        }
        Node prev = get(index-1);
        Node temp = prev.next;

        prev.next = temp.next;
        temp.next = null;
        length--;
        return temp;
    }

    public   void reverseLinkedList() {
    Node temp = head;
    head = tail;
    tail = temp;
    Node after = temp.next;
    Node before = null;

    for (int i =0; i< length; i++){
        after = temp.next;
        temp.next = before;
        before = temp;
        temp = after;
    }

    }
    public Node findMiddleNode(){
        if(head == null) return null;
        Node slow = head;
        Node fast = head;
        while(fast!=null&&fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public boolean hasLoop(){
        Node slow = head;
        Node fast = head;

        while(fast!=null && fast.next != null){

            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) return true;
        }
        return false;
    }

    public Node findKthFromEnd(int k){
        Node temp = head;
        Node newTemp = head;
        int counter = 0;
        while(temp!=null){
            counter++;
            temp = temp.next;
        }

        if(k > counter) return null;

        for(int i=0; i< counter-k; i++){
            newTemp = newTemp.next;
        }

        return newTemp;

    }

    public Node findKthFromEnd2(int k){
       Node slow = head;
       Node fast = head;
       for (int i = 0; i< k; i++){
           if(fast == null){
               return null;
           }
           fast = fast.next;
       }

       while (fast != null){
           slow = slow.next;
           fast = fast.next;
       }

       return slow;
    }
    public void partitionList(int x){
        if(head == null) return ;
        Node dummy1 = new Node(0);
        Node dummy2 = new Node(0);
        Node prev1 = dummy1;
        Node prev2 = dummy2;
        Node current = head;
        while(current!=null){
            if(current.data < x){
                prev1.next = current;
                prev1 = current;
            }else{
                prev2.next = current;
                prev2 = current;
            }

            current = current.next;
        }

        prev2.next = null;
        prev1.next = dummy2.next;
        head = dummy1.next;

    }

    public void removeDuplicates(){
        if(head == null) return;
        Node temp = head;
        Node previous = null;

        Set<Integer> unique = new HashSet();

        while(temp!=null){

            if(unique.contains(temp.data)){
                previous.next = temp.next;
                length -= 1;

            }else{
                unique.add(temp.data);
                previous = temp;
            }

            temp = temp.next;
        }
    }

    public void removeDuplicates2() {
        Node current = head;
        while (current != null) {
            Node runner = current;
            while (runner.next != null) {
                if (runner.next.data == current.data) {
                    runner.next = runner.next.next;
                    length -= 1;
                } else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
    }

    public int binaryToDecimal(){
        Node current = head;
        int nums = 0;

        while(current!=null){
            nums = 2*nums+current.data;

            current = current.next;
        }

        return nums;
    }

    //need to  check later
    public void reverseBetween(int startIndex, int endIndex) {
        if (head == null) return;

        Node dummyNode = new Node(0);
        dummyNode.next = head;
        Node previousNode = dummyNode;

        for (int i = 0; i < startIndex; i++) {
            previousNode = previousNode.next;
        }

        Node currentNode = previousNode.next;

        for (int i = 0; i < endIndex - startIndex; i++) {
            Node nodeToMove = currentNode.next;
            currentNode.next = nodeToMove.next;
            nodeToMove.next = previousNode.next;
            previousNode.next = nodeToMove;
        }

        head = dummyNode.next;
    }
// sorting examples
    void bubbleSort() {
        if (this.length < 2)
            return;

        Node sortedUntil = null;
        while (sortedUntil != this.head.next) {
            Node current = this.head;
            while (current.next != sortedUntil) {
                Node nextNode = current.next;
                if (current.data > nextNode.data) {
                    int temp = current.data;
                    current.data = nextNode.data;
                    nextNode.data = temp;
                }
                current = current.next;
            }
            sortedUntil = current;
        }
    }

    void selectionSort() {
        if (this.length < 2)
            return;
        Node current = this.head;
        while (current.next != null) {
            Node smallest = current;
            Node innerCurrent = current.next;
            while (innerCurrent != null) {
                if (innerCurrent.data < smallest.data) {
                    smallest = innerCurrent;
                }
                innerCurrent = innerCurrent.next;
            }
            if (smallest != current) {
                int temp = current.data;
                current.data = smallest.data;
                smallest.data = temp;
            }
            current = current.next;
        }
    }

    public void insertionSort() {
        if (length < 2) {
            return; // List is already sorted
        }

        Node sortedListHead = head;
        Node unsortedListHead = head.next;
        sortedListHead.next = null;

        while (unsortedListHead != null) {
            Node current = unsortedListHead;
            unsortedListHead = unsortedListHead.next;

            if (current.data < sortedListHead.data) {
                current.next = sortedListHead;
                sortedListHead = current;
            } else {
                Node searchPointer = sortedListHead;
                while (searchPointer.next != null && current.data > searchPointer.next.data) {
                    searchPointer = searchPointer.next;
                }
                current.next = searchPointer.next;
                searchPointer.next = current;
            }
        }

        head = sortedListHead;
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        tail = temp;
    }

    public void merge(LinkedList otherList) {
        Node otherHead = otherList.getHead();
        Node dummy = new Node(0);
        Node current = dummy;

        while (head != null && otherHead != null) {
            if (head.data < otherHead.data) {
                current.next = head;
                head = head.next;
            } else {
                current.next = otherHead;
                otherHead = otherHead.next;
            }
            current = current.next;
        }

        if (head != null) {
            current.next = head;
        } else {
            current.next = otherHead;
            tail = otherList.getTail();
        }

        head = dummy.next;
        length += otherList.getLength();
    }
}

class LinkedListDriver{
    public static void main(String[] args) {
        LinkedList myLinkedList = new LinkedList(1);
        myLinkedList.append(2);
        myLinkedList.append(3);
        myLinkedList.append(4);
        myLinkedList.append(5);
        System.out.println("LL before remove():");
        myLinkedList.printList();


//        System.out.println("\nRemoved node:");
//        System.out.println(myLinkedList.remove(2).data);
//        System.out.println("LL after remove() in middle:");
//        myLinkedList.printList();
//
//        System.out.println("\nRemoved node:");
//        System.out.println(myLinkedList.remove(0).data);
//        System.out.println("LL after remove() of first node:");
//        myLinkedList.printList();
//
//        System.out.println("\nRemoved node:");
//        System.out.println(myLinkedList.remove(2).data);
//        System.out.println("LL after remove() of last node:");
//        myLinkedList.printList();

        myLinkedList.reverseLinkedList();
        myLinkedList.printList();

    }


}