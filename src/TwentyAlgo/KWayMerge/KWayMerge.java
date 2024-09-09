package TwentyAlgo.KWayMerge;
import java.util.*;

class Element {
    int value;
    int arrayIndex;  // Index of the array from which the element is taken
    int elementIndex; // Index of the element in the array

    public Element(int value, int arrayIndex, int elementIndex) {
        this.value = value;
        this.arrayIndex = arrayIndex;
        this.elementIndex = elementIndex;
    }
}

public class KWayMerge {

    public static List<Integer> mergeKSortedArrays(List<List<Integer>> arrays) {
        // Resultant merged list
        List<Integer> result = new ArrayList<>();

        // Priority queue (min-heap) to store the smallest elements
        PriorityQueue<Element> minHeap = new PriorityQueue<>(Comparator.comparingInt(e -> e.value));

        // Initialize the heap with the first element from each array
        for (int i = 0; i < arrays.size(); i++) {
            if (!arrays.get(i).isEmpty()) {
                minHeap.add(new Element(arrays.get(i).get(0), i, 0));
            }
        }

        // Extract the smallest element and add the next element from the same array to the heap
        while (!minHeap.isEmpty()) {
            Element minElement = minHeap.poll();
            result.add(minElement.value);

            int nextElementIndex = minElement.elementIndex + 1;
            if (nextElementIndex < arrays.get(minElement.arrayIndex).size()) {
                minHeap.add(new Element(arrays.get(minElement.arrayIndex).get(nextElementIndex), minElement.arrayIndex, nextElementIndex));
            }
        }

        return result;
    }

    public static void main(String[] args) {
        // Example usage
        List<List<Integer>> arrays = new ArrayList<>();
        arrays.add(Arrays.asList(1, 4, 7));
        arrays.add(Arrays.asList(2, 5, 8));
        arrays.add(Arrays.asList(3, 6, 9));

        List<Integer> mergedList = mergeKSortedArrays(arrays);

        System.out.println("Merged array: " + mergedList);
    }
}

