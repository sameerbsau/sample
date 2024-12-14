package UdemyCourse;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class BinarySearchTree {
    Node root;

    class Node {
        int value;
        Node left;
        Node right;

        private Node(int value) {
            this.value = value;
        }
    }

    public boolean insert(int value) {
        Node newNode = new Node(value);
        if (root == null) {
            root = newNode;
            return true;
        }
        Node temp = root;

        while (true) {
            if (newNode.value == temp.value) return false;
            if (newNode.value < temp.value) {
                if (temp.left == null) {
                    temp.left = newNode;
                    return true;
                }
                temp = temp.left;
            } else {
                if (temp.right == null) {
                    temp.right = newNode;
                    return true;
                }
                temp = temp.right;
            }
        }
    }

    public boolean contains(int value) {
        Node temp = root;
        while (temp != null) {
            if (value < temp.value) {
                temp = temp.left;
            } else if (value > temp.value) {
                temp = temp.right;
            } else {
                return true;
            }
        }
        return false;
    }

    public boolean rContains(Node currentNode,int value){
        if (currentNode == null) return false;

        if(currentNode.value == value) return true;

        if(value< currentNode.value){
            return rContains(currentNode.left, value);
        }else {
            return rContains(currentNode.right, value);
        }
    }

    public boolean rContains(int value){
        return rContains(root, value);
    }

    private Node rInsert(Node currentNode, int value){
        if(currentNode == null) return new Node(value);

        if(value < currentNode.value){
            currentNode.left = rInsert(currentNode.left, value);
        } else if (value > currentNode.value) {
            currentNode.right = rInsert(currentNode.right, value);
        }
        return currentNode;
    }
    public void rInsert(int value){
        if (root==null) root = new Node(value);
        rInsert( root,  value);
    }

    private Node deleteNode(Node currentNode, int value){
        if(currentNode == null) return  null;

        if(value < currentNode.value){
            currentNode.left = deleteNode(currentNode.left, value);
        } else if (value > currentNode.value) {
            currentNode.right = deleteNode(currentNode.right, value);
        }else {
            if(currentNode.left == null && currentNode.right == null){
                currentNode = null;
            } else if (currentNode.left == null) {
                currentNode = currentNode.right;
            } else if (currentNode.right == null) {
                currentNode = currentNode.left;
            }else {
                int subTreeMin = minValue(currentNode.right);
                currentNode.value = subTreeMin;
                currentNode.right = deleteNode(currentNode.right, subTreeMin);
            }
        }
        return currentNode;
    }
    public void deleteNode(int value){
            deleteNode(root,value);
    }
    private int minValue(Node currentNode) {
        while (currentNode.left!=null){
            currentNode = currentNode.left;
        }
        return currentNode.value;
    }

    private Node sortedArrayToBST(int[] nums, int left, int right){
        if(left > right) return null;
        int mid = left+(right-left)/2;

        Node node = new Node(nums[mid]);
        node.left = sortedArrayToBST(nums, left, mid - 1);
        node.right = sortedArrayToBST(nums, mid+1, right);

        return node;

    }

    private Node invertTree(Node node){
        if(node == null) return null;

        Node temp = node.left;
        node.left = invertTree(node.right);
        node.right = invertTree(temp);

        return node;
    }

    public ArrayList<Integer> BFS(){
        Node currentNode = root;
        Queue<Node> queue = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();
        queue.add(currentNode);

        while (queue.size()>0){
            currentNode = queue.remove();
            result.add(currentNode.value);
            if (currentNode.left!=null){
                queue.add(currentNode.left);
            }
            if (currentNode.right!=null){
                queue.add(currentNode.right);
            }
        }
        return result;
    }

    public ArrayList<Integer> DFSPreOrder(){
        ArrayList<Integer> results = new ArrayList<>();
        class Traverse{
            Traverse(Node currentNode){
                results.add(currentNode.value);
                if (currentNode.left!=null){
                    new Traverse(currentNode.left);
                }
                if (currentNode.right!=null){
                    new Traverse(currentNode.right);
                }
            }
        }
        new Traverse(root);
        return results;
    }

    public ArrayList<Integer> DFSPostOrder(){
        ArrayList<Integer> results = new ArrayList<>();
        class Traverse{
            Traverse(Node currentNode){

                if (currentNode.left!=null){
                    new Traverse(currentNode.left);
                }
                if (currentNode.right!=null){
                    new Traverse(currentNode.right);
                }
                results.add(currentNode.value);
            }
        }
        new Traverse(root);
        return results;
    }

    public ArrayList<Integer> DFSInOrder(){
        ArrayList<Integer> results = new ArrayList<>();
        class Traverse{
            Traverse(Node currentNode){

                if (currentNode.left!=null){
                    new Traverse(currentNode.left);
                }
                results.add(currentNode.value);
                if (currentNode.right!=null){
                    new Traverse(currentNode.right);
                }

            }
        }
        new Traverse(root);
        return results;
    }

    public boolean isValidBST(){
        ArrayList<Integer> inorder =  DFSInOrder();
// If the current value is less than or equal to the previous
        // value, it means the list is not in ascending order. Thus,
        // the tree is not a valid BST. Return false in this case.
        for(int i = 1; i< inorder.size(); i++){
            if(inorder.get(i)<=inorder.get(i-1))
            {
                return false;
            }
        }

        return true;

    }
    public Integer kthSmallest(int k) {
        java.util.Stack<Node> stack = new java.util.Stack<>();
        Node node = root;

        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            k -= 1;
            if (k == 0) {
                return node.value;
            }
            node = node.right;
        }
        return null;
    }
}

public class TreeExample {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(47);
        bst.insert(21);
        bst.insert(76);
        bst.insert(18);
        bst.insert(52);
        bst.insert(82);
        bst.insert(27);
        System.out.println(bst.root.left.right.value);
        System.out.println(bst.contains(27));
        System.out.println(bst.DFSPreOrder());
        System.out.println(bst.DFSInOrder());
        System.out.println(bst.DFSPostOrder());


    }
}