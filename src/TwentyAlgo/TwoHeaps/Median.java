package TwentyAlgo.TwoHeaps;

import java.util.PriorityQueue;

public class Median {
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
    PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> a - b);

    public double[] medianSlidingWindow(int[] nums, int k){

        //result array would contain length - k + 1 elements
        double[] result = new double[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {

            insert(nums[i]);

            //if we have at least k elements
            if ((i - k + 1) >= 0) {
                result[i - k + 1] = findMedian();
                int elementToBeRemoved = nums[i - k + 1];
                remove(elementToBeRemoved);
            }
        }
        return result;
    }
    public void insert(int x){
        if (maxHeap.isEmpty() || maxHeap.peek() >= x)
            maxHeap.add(x);
        else
            minHeap.add(x);

        balanceHeaps();
    }

    //Copy-paste function from the pattern
    public double findMedian(){
        if(maxHeap.size() == minHeap.size())
            return ((double) maxHeap.peek() + minHeap.peek())/2;
        else
            return maxHeap.peek();
    }
    public void remove(int x){
//element exists in maxHeap
        if (x <= maxHeap.peek())
            maxHeap.remove(x);

// element exists in MinHeap
        else
            minHeap.remove(x);

        balanceHeaps();
    }
    //Copy-paste function from the pattern
    public void balanceHeaps(){
        if (maxHeap.size() > minHeap.size() + 1)
            minHeap.add(maxHeap.poll());
        else if (maxHeap.size() < minHeap.size())
            maxHeap.add(minHeap.poll());
    }
}
