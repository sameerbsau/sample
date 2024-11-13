package series.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Node<E>{
    E data;
    Node left;
    Node right;
    Node(E data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

}
public class Traversal {
    public static void main(String[] args) {
        Node<Integer> root = new Node<>(1);
        root.left = new Node<>(2);
        root.right = new Node<>(3);
        root.left.left = new Node<>(4);
        root.left.right = new Node<>(5);
        printLevelOrder(root);
    }

    private static void printLevelOrder(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        Queue<Node<Integer>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
           Node curr = queue.poll();
            System.out.print(" "+ curr.data);
            result.add((Integer) curr.data);
            if(curr.left!=null){
                queue.add(curr.left);
            }
            if(curr.right!=null){
                queue.add(curr.right);
            }
        }
    }
}
