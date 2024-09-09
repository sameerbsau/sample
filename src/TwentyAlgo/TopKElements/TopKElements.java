package TwentyAlgo.TopKElements;
//https://www.youtube.com/watch?v=bXbiLwGSZHU


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class  Number implements Comparable<Number>{
    int element;
    int freq;
    Number(int element, int freq){
        this.element= element;
        this.freq = freq;
    }


    @Override
    public int compareTo(Number that) {
        //max heap
        return that.freq -this.freq; // desc
        //min heap
        // return this.freq-that.freq;// asec
    }
}

public class TopKElements {
    public static void main(String[] args) {
        int [] nums = {1,1,1,2,2,3};
        int k = 2;
        int [] res = topKFrequent(nums,k);
        System.out.println(Arrays.toString(res));

    }

    private static int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Number> pq = new PriorityQueue<>();
        HashMap<Integer,Integer> freqMap = new HashMap<>();

        for(int element: nums){
            freqMap.put(element, freqMap.getOrDefault(element,0)+1);
        }
        for(Map.Entry<Integer,Integer> entry: freqMap.entrySet()){
            Number number = new Number(entry.getKey(), entry.getValue());
            pq.offer(number);
            //min heap
//            if(pq.size()>k){
//                pq.poll();
//            }
        }

        int res[] = new int[k];
        int index = 0;
        while (index< k){
            Number number = pq.poll();
            res[index] = number.element;
            index++;
        }
        return res;
    }
}
