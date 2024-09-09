package TwentyAlgo.BFS;


import java.util.LinkedList;
import java.util.Queue;

class Node{
    int data;
    Node left;
    Node right;
     Node(int data) {
         this.data = data;
         this.left = null;
         this.right = null;
     }

}

public class TreeBFS {
    public static void main(String[] args) {
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(4);
    root.left.right = new Node(5);
    printLevelOrder(root);
    }

    private static void printLevelOrder(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            Node curr = queue.poll();
            System.out.print(" "+ curr.data);

            if(curr.left!=null){
                queue.add(curr.left);
            }
            if(curr.right!=null){
                queue.add(curr.right);
            }
        }
    }
}
