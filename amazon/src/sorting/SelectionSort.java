package sorting;

import java.util.Arrays;

public class SelectionSort {

    public int[] sortArray(int[] nums) {
        if(nums == null || nums.length <= 1){
            return nums;
        }
        int swappedIndex = 0;
        int smallestNumber = Integer.MAX_VALUE;

        for(int i = 0; i < nums.length; i++){
            for(int j = i; j < nums.length; j++){
                if(nums[j] < smallestNumber){
                    smallestNumber = nums[j];
                    swappedIndex = j;
                }
            }

            int temp = nums[i];
            nums[i] = smallestNumber;
            nums[swappedIndex] = temp;
            smallestNumber = Integer.MAX_VALUE;
        }

        return nums;
    }

    public static void main(String[] args) {
        SelectionSort selectionSort = new SelectionSort();
        System.out.println(Arrays.toString(selectionSort.sortArray(new int[]{5, 2, 3, 1})));
    }
}
