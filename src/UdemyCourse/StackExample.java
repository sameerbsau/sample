package UdemyCourse;
import java.util.*;
class Stack{

    private Node top;
    private  int height;

    public Stack(int value){
        Node node = new Node(value);
        top = node;
        height = 1;
    }

    class Node{
         int value;
         Node next;

        public Node(int value){
            this.value = value;
        }
    }

    public void printStack(){
        Node temp = top;
        while (temp!=null){
            System.out.println("data "+ temp.value);
            temp = temp.next;
        }
    }
    public void getTop(){
        System.out.println("top value-- "+ top.value);

    }

    public void getHeight(){
        System.out.println("height-- "+ height);
    }

    public void push(int value){
        Node newNode = new Node(value);
        if(height ==0){
            top = newNode;
        }else{
            newNode.next = top;
            top = newNode;
        }
        height++;
    }

    public Node pop(){
        if (height ==0) return null;
        Node temp = top;
        top = top.next;
        temp.next=null;
        height--;
        return temp;
    }

    public static String reverseString(String myString){
        char [] chars = myString.toCharArray();
        java.util.Stack<Character> stack = new java.util.Stack<>();
        for (char chari: chars){
            stack.push(chari);
        }

        String finals = "";
        while(!stack.isEmpty()){
            char c = stack.pop();
            finals=  finals+c;
        }

        return finals;
    }

    public static boolean isBalancedParentheses(String testStr){

        char [] chars = testStr.toCharArray();
        java.util.Stack<Character> stack = new java.util.Stack<>();
        for(char c : chars){
            if(c=='('){
                stack.push(c);
            }else if(c==')'){
                if(stack.isEmpty() || stack.pop() != '('){
                    return false;
                }
            }

        }
        return stack.isEmpty();
    }

    public static void sortStack(java.util.Stack<Integer> stack) {
        java.util.Stack<Integer> additionalStack = new java.util.Stack<>();

        while (!stack.isEmpty()) {
            int temp = stack.pop();

            while (!additionalStack.isEmpty() && additionalStack.peek() > temp) {
                stack.push(additionalStack.pop());
            }

            additionalStack.push(temp);
        }

        while (!additionalStack.isEmpty()) {
            stack.push(additionalStack.pop());
        }
    }
}

public class StackExample {
    public static void main(String[] args) {
        Stack myStack = new Stack(4);
        myStack.getTop();
    }
}