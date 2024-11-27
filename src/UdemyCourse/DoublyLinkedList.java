package UdemyCourse;

public class DoublyLinkedList {
    public static void main(String[] args) {
        System.out.println("Hello World");
        DLL dll = new DLL(2);
        dll.append(3);

        dll.prepend(1);
        dll.removeFirst();

        dll.set(1, 10);
        dll.insert(2,12);
        dll.printList();
        System.out.println(dll.get(1).data);

        //System.out.println(dll.removeLast().data);
        //dll.getHead();
        //dll.getTail();
        //dll.getLength();

    }
}


class   DLL {

    class Node {

        int data;
        Node next;
        Node prev;

        public Node(int data) {
            this.data = data;
        }

    }

    private Node head;
    private Node tail;
    private int length;

    public DLL(int data) {
        Node node = new Node(data);
        tail = node;
        head = node;
        length = 1;


    }

    public void append(int data) {
        Node newNode = new Node(data);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;

        }
        length++;
    }

    public void prepend(int data) {
        Node newNode = new Node(data);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
        }
        length++;
    }

    public Node removeLast() {
        if (length == 0) {
            return null;
        }
        Node temp = tail;
        if (length == 1) {
            head = null;
            tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
            temp.prev = null;
        }
        length--;
        return temp;
    }

    public Node removeFirst() {
        if (length == 0) {
            return null;
        }

        Node temp = head;

        if (length == 1) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.prev = null;
            temp.next = null;

        }

        length--;
        return temp;
    }

    public Node get(int index) {
        if (index < 0 || index >= length) {
            return null;
        }
        Node temp = head;
        if (index < length / 2) {
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
        } else {
            temp = tail;
            for (int i = length - 1; i > index; i--) {
                temp = temp.prev;
            }

        }
        return temp;
    }

    public boolean set(int index, int value) {
        if (index < 0) return false;
        Node temp = get(index);
        if (temp != null) {
            temp.data = value;
            return true;
        }
        return false;
    }

    public boolean insert(int index, int value) {
        if (index <= 0 || index > length) return false;
        if (index == 0) {
            prepend(value);
            return true;
        }
        if (index == length) {
            append(value);
            return true;
        }

        Node newNode = new Node(value);
        Node before = get(index-1);
        Node after = before.next;
        before.next = newNode;
        after.prev = newNode;
        newNode.prev = before;
        newNode.next = after;
        length++;
        return true;

    }

    public Node remove(int index){
        if(index < 0 || index>= length) return null;
        if(index == 0){
            return removeFirst();
        }
        if(index == length-1){
            return removeLast();
        }
        Node temp = get(index);

        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
        temp.next = null;
        temp.prev =null;
        length--;
        return temp;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public void getHead() {
        System.out.println("head :" + head.data);
    }

    public void getTail() {
        System.out.println("tail :" + tail.data);
    }

    public void getLength() {
        System.out.println("length :" + length);
    }

    public void swapFirstLast(){
        if(length<2) return;

        int temp = head.data;
        head.data = tail.data;
        tail.data= temp;
    }

    public void reverse() {
        Node current = head;
        Node temp = null;

        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }

        temp = head;
        head = tail;
        tail = temp;
    }

    public boolean isPalindrome(){

        Node startTemp = head;
        Node endTemp = tail;
        while(startTemp != endTemp){

            if(startTemp.data == endTemp.data){
                startTemp = startTemp.next;
                endTemp = endTemp.prev;
            }else{
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome2() {
        if (length <= 1) return true;

        Node forwardNode = head;
        Node backwardNode = tail;
        for (int i = 0; i < length / 2; i++) {
            if (forwardNode.data != backwardNode.data) return false;
            forwardNode = forwardNode.next;
            backwardNode = backwardNode.prev;
        }
        return true;
    }

    public void swapPairs() {
        Node dummyNode = new Node(0);
        dummyNode.next = head;
        Node previousNode = dummyNode;

        while (head != null && head.next != null) {
            Node firstNode = head;
            Node secondNode = head.next;

            previousNode.next = secondNode;
            firstNode.next = secondNode.next;
            secondNode.next = firstNode;

            secondNode.prev = previousNode;
            firstNode.prev = secondNode;

            if (firstNode.next != null) {
                firstNode.next.prev = firstNode;
            }

            head = firstNode.next;
            previousNode = firstNode;
        }

        head = dummyNode.next;
        if (head != null) head.prev = null;
    }
}