package stacks;

public class ThreeStacks {
    private int[] buffer;
    private int[] pointers = {-1,-1,-1};
    private int stackSize;

    public  ThreeStacks(int stackSize){
        this.buffer = new int[stackSize*3];
        this.stackSize = stackSize;
    }

    public void push(int stackNum, int value){
        if(pointers[stackNum]+1 >= stackSize){
            System.out.println("stack"+stackNum+" is full");
            System.exit(1);
        }
        pointers[stackNum]++;
        buffer[absOfStack(stackNum)] = value;
    }

    public int pop(int stackNum){
        if(isEmpty(stackNum)){
            System.out.println("stack"+stackNum+" is empty");
            System.exit(1);
        }
        int value = buffer[absOfStack(stackNum)];
        buffer[absOfStack(stackNum)] = 0;//clearing the value
        pointers[stackNum]--;
        return  value;
    }

    public  int peek(int stackNum){
        if(isEmpty(stackNum)){
            System.out.println("stack"+stackNum+" is empty");
            System.exit(1);
        }

        return buffer[absOfStack(stackNum)];
    }


public  boolean isEmpty(int stackNum){
        return pointers[stackNum] ==-1;
}

    public  int absOfStack(int stackNum){
        return stackNum*stackSize + pointers[stackNum];
    }

    public static void main(String[] args) {
        ThreeStacks stacks = new ThreeStacks(5);
        stacks.push(0, 10);
        stacks.push(0, 10);
        stacks.push(1, 20);
        stacks.push(2, 30);

        System.out.println(stacks.peek(0)); // Output: 10
        System.out.println(stacks.peek(1)); // Output: 20
        System.out.println(stacks.peek(2)); // Output: 30

        stacks.pop(0);
        stacks.pop(1);
        stacks.pop(2);

        System.out.println(stacks.isEmpty(0)); // Output: true
        System.out.println(stacks.isEmpty(1)); // Output: true
        System.out.println(stacks.isEmpty(2));
    }

}
