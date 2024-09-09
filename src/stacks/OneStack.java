package stacks;

public class OneStack {
    private  int[] arr;
    private int top;
    private  int capacity;

    public OneStack(int value){
        this.arr = new int[value];
        this.capacity = value;
        this.top = -1;
    }

    public  boolean isFull(){
        return  top == capacity-1;
    };

    public boolean isEmpty(){
        return  top == -1;
    };

    public void push(int value){
        if(isFull()){
            System.out.println("stack is full");
            System.exit(1);
        }
        arr[++top]= value;
    }

    public int pop(){
        if(isEmpty()){
            System.out.println("stack is empty");
            System.exit(1);
        }
        return arr[top--];
    }

    public int peek(){
        if(isEmpty()){
            System.out.println("stack is empty");
            System.exit(1);
        }
        return arr[top];
    }


    public  void print(){

        for(int i =0; i <= top; ++i){
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) {
        OneStack stack = new OneStack(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println("test"+stack.peek());
        stack.print();

        stack.pop();
        stack.pop();
        System.out.println("test"+stack.peek());

        stack.print();
    }




}
