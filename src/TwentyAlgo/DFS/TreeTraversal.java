package TwentyAlgo.DFS;



class Node{
    int data;
    Node left, right;
    Node(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }

}

public class TreeTraversal {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        inOrderTraversal(root);
        preOrderTraversal(root);
        postOrderTraversal(root);
    }

    private static void inOrderTraversal(Node root) {
        if(root == null){
            return;
        }
        inOrderTraversal(root.left);
        System.out.print(" "+ root.data);
        inOrderTraversal(root.right);

    }
    private static void preOrderTraversal(Node root) {
        if(root == null){
            return;
        }
        System.out.print(" "+ root.data);
        preOrderTraversal(root.left);

        preOrderTraversal(root.right);
    }
    private static void postOrderTraversal(Node root) {
        if(root == null){
            return;
        }

        postOrderTraversal(root.left);

        postOrderTraversal(root.right);
        System.out.print(" "+ root.data);
    }
}
