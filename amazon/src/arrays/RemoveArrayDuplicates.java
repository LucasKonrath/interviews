package arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class RemoveArrayDuplicates {

    public static int[] removeDuplicates(int[] nums){

        final ArrayList<Integer> newNums = new ArrayList<>();

        final HashSet<Integer> savedInts = new HashSet<>();

        for(int i = 0; i < nums.length; i++){
            if(!savedInts.contains(nums[i])){
                savedInts.add(nums[i]);
                newNums.add(nums[i]);
            }
        }

        return newNums.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        removeDuplicates(new int[]{1, 1, 3, 5, 5, 5, 5, 7, 9, 10, 10, 11, 10, 12});
    }

}
