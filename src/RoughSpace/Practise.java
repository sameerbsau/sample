package RoughSpace;

import java.util.*;

class Node{

    int data;
    Node left;
    Node right;

    public Node(int data){
        this.data = data;
    }

}



class Element {
    int data;
    int arrayIndex;
    int elementIndex;

    public Element(int data, int arrayIndex, int elementIndex) {
        this.data = data;
        this.arrayIndex = arrayIndex;
        this.elementIndex = elementIndex;
    }
}

class Number implements Comparable<Number> {
    int element;
    int freq;

    public Number(int element, int freq) {
        this.element = element;
        this.freq = freq;
    }

    @Override
    public int compareTo(Number that) {
        return that.freq - this.freq;
    }
}

public class Practise {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        int result = findDiff(root);
        System.out.println(result);
    }

    public static int findDiff(Node root){

        int oddSum  =0;
        int evenSum = 0;

        int currentLevel = 1;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            int size = queue.size();

            for(int i =0; i< size; i++){
                Node myNode = queue.poll();

                if(currentLevel%2 ==0){
                    evenSum += myNode.data;
                }else{
                    oddSum += myNode.data;
                }

                if(myNode.left!=null){
                    queue.add(myNode.left);
                }

                if(myNode.right!=null){
                    queue.add(myNode.right);
                }

            }

            currentLevel++;
        }

        return Math.abs(evenSum-oddSum);
    }

}