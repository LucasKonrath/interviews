package sorting;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;

public class FirstKElements {

    public int[] findFirstKSorted(int[] nums, int k) {
        if (nums == null || k == 0) {
            return new int[]{};
        }

        if (nums.length <= k) {
            return nums;
        }

        // Default Java PriorityQueue is Min Heap, here we want a Max Heap
        Queue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0; i < nums.length; i++) {
            if (priorityQueue.size() < k) {
                priorityQueue.add(nums[i]);
            } else {
                if (nums[i] < priorityQueue.peek()) {
                    priorityQueue.poll();
                    priorityQueue.add(nums[i]);
                }
            }
        }

        int[] results = new int[priorityQueue.size()];
        int index = 0;
        while(!priorityQueue.isEmpty()){
            results[index] = priorityQueue.poll();
            index++;
        }

        return results;
    }

    public static void main(String[] args) {
        FirstKElements firstKElements = new FirstKElements();
        firstKElements.findFirstKSorted(new int[]{5, 6, 9, 12, 3, 12, 2}, 3);
    }
}
