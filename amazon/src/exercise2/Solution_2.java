package exercise2;

import java.util.Collections;
import java.util.HashSet;

public class Solution_2 {

    /**
     * Given an array of integers and a value, determine if there are any two integers in the array whose sum is equal
     * to the given value. Return true if the sum exists and return false if it does not. Consider this array and the
     * target sums:
     *
     * @return true if the sum exists and return false if it does not. Consider this array and the target sums: 5 7 1 2
     * 8 4 3 Target Sum 10 7+3=10, 2+8=10
     */
    public static boolean areThereTwoSums(int[] integerArray, int targetValue) {

        if (integerArray == null || integerArray.length < 2) {
            return false;
        }

        HashSet<Integer> integerSet = new HashSet<>();

        for (int i = 0; i < integerArray.length; i++) {
            if (integerSet.contains(targetValue - integerArray[i])) {
                return true;
            } else {
                integerSet.add(integerArray[i]);
            }
        }

        return false;
    }

    /**
     * Given an array of integers and a value, determine if there are any two integers in the array whose sum is equal
     * to the given value. Return true if the sum exists and return false if it does not. Consider this array and the
     * target sums:
     *
     * @return true if the sum exists and return false if it does not. Consider this array and the target sums: 5 7 1 2
     * 8 4 3 Target Sum 10 7+3=10, 2+8=10
     */
    public static boolean areThereTwoSumsWithTwoPointerApproach(int[] integerArray, int targetValue) {

        if (integerArray == null || integerArray.length < 2) {
            return false;
        }

        int startIndex = 0;
        int endIndex = integerArray.length - 1;

        while(startIndex < endIndex){
            if(integerArray[endIndex] > targetValue){
                endIndex--;
            } else if (integerArray[startIndex] + integerArray[endIndex] == targetValue){
                return true;
            } else if (startIndex < endIndex - 1){
                startIndex++;
            } else {
                startIndex = 0;
                endIndex--;
            }
        }

        return false;
    }

    public int[] twoSum(int[] nums, int target) {

        if (nums == null || nums.length < 2) {
            return new int[]{};
        }

        int startIndex = 0;
        int endIndex = nums.length - 1;

        while(startIndex < endIndex){
            if(nums[endIndex] > target){
                endIndex--;
            } else if (nums[startIndex] + nums[endIndex] == target){
                return new int[]{startIndex, endIndex};
            } else if (startIndex < endIndex - 1){
                startIndex++;
            } else {
                startIndex = 0;
                endIndex--;
            }
        }

        return new int[]{};
    }

    public static void main(String[] args) {
        System.out.println(Solution_2.areThereTwoSumsWithTwoPointerApproach(new int[]{1, 2, 3, 5, 9, 11, 13}, 7));
        System.out.println(Solution_2.areThereTwoSumsWithTwoPointerApproach(new int[]{1, 2, 3, 5, 9, 11, 13}, 20));
        System.out.println(Solution_2.areThereTwoSumsWithTwoPointerApproach(new int[]{1, 2, 3, 5, 9, 11, 13}, 21));
    }
}
