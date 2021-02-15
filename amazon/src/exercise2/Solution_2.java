package exercise2;

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
}
