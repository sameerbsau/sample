package series.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IterativeInorder {
    public static void main(String[] args) {
        Node<Integer> root = new Node<>(1);
        root.left = new Node<>(2);
        root.right = new Node<>(3);
        root.left.left = new Node<>(4);
        root.left.right = new Node<>(5);
        List result = iterativeInOrder(root);
        System.out.println(result);
        
    }

    private static List iterativeInOrder(Node<Integer> root) {
        List res = new ArrayList<>();
        if (root == null){
            return res;
        }
        Stack<Node> stack = new Stack<>();
        Node node = root;
        while (node!=null || !stack.isEmpty()){
            while (node!=null){
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            res.add(node.data);
            node = node.right;
        }

        return  res;
    }
}
