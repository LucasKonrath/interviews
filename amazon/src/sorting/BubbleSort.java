package sorting;

import java.util.Arrays;

public class BubbleSort {

    public int[] sortArray(int[] nums) {

        boolean allMatch = false;

        while (!allMatch) {
            allMatch = true;
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] > nums[i + 1]) {
                    int temp = nums[i];
                    nums[i] = nums[i + 1];
                    nums[i + 1] = temp;
                    allMatch = false;
                }
            }
        }

        return nums;
    }

    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        System.out.println(Arrays.toString(bubbleSort.sortArray(new int[]{5, 2, 3, 1})));
    }
}
